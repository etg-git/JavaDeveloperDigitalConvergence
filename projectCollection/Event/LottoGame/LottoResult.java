package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LottoResult extends JFrame {

	// borderLayout - south
	private JButton btnPercent;
	private JButton btnExit;
	private JPanel pnlSouth;

	private JPanel pnlMain;

	// BorderLayout - north
	private JPanel pnlNorth;
	private JLabel[] lblWinningNumber;

	// BorderLayout - center
	private LottoResultItem[] pnlCenter; // ��÷��ȣ, ���ǹ�ȣ ��
	private LottoNumberCreate lottoNumber;// �������� ��÷��ȣ�� ���ǹ�ȣ����

	private LottoSlot slot;
	private ArrayList<ArrayList<Integer>> lottoNumberLists;

	public final static int SLAP = 2;
	public final static int FIFTH = 3;
	public final static int FOURTH = 4;
	public final static int THIRTH = 5;
	public final static int FIRST = 6;
	public final static int SECOND = 6;

	private String winning;

	private ArrayList<Integer> sameLottoNumbers;
	private ArrayList<ArrayList<Integer>> sameLottoLists;

	private ArrayList<Integer> winningNumbers;

	public LottoResult(LottoSlot slot) {
		this.slot = slot;
		lottoNumberLists = slot.getLottoLists(); // slotâ���� ������ ��ȣ�� ��������

		init();
		setDisplay();
		result();
		addListener();
		showDialog();
	}

	private void init() {
		lottoNumber = new LottoNumberCreate();
		winningNumbers = lottoNumber.getWinningNumberList();
		lottoNumber.winningNumberCreate();

		btnPercent = new JButton("���� �����?");
		btnExit = new JButton("����");

		pnlMain = new JPanel(new GridLayout(0, 1));
		pnlSouth = new JPanel();
		pnlNorth = new JPanel();

		pnlCenter = new LottoResultItem[slot.getLottoLists().size()]; // ��÷��ȣ��
																	// �������ִ¸�ŭ
																	// ����

		lblWinningNumber = new JLabel[7];
	}

	private void setDisplay() {
		pnlNorth.setForeground(new Color(0xFFFFFF));
		pnlNorth.setBackground(new Color(0x123456));
		
		btnPercent.setMargin(new Insets(2,2,2,2));
		btnPercent.setBackground(Color.ORANGE);
		btnExit.setMargin(new Insets(2,2,2,2));
		
		// �ζǹ�ȣ���̺� ����
		for (int i = 0; i < pnlCenter.length; i++) {
			pnlCenter[i] = new LottoResultItem(i + 1);

			for (int j = 0; j < pnlCenter[i].getLottoNumbers().length; j++) {
				pnlCenter[i].getLottoNumbers()[j].setIcon(new ImageIcon("img/ball" + String.valueOf(lottoNumberLists.get(i).get(j)) + ".png"));
			}
			pnlMain.add(pnlCenter[i]);
		}

		// ��÷��ȣ���̺� ����
		for (int i = 0; i < lblWinningNumber.length; i++) {
			lblWinningNumber[i] = new JLabel();
			if (i == lblWinningNumber.length - 2) {
				lblWinningNumber[i].setText("          +         ");
				lblWinningNumber[i].setIcon(new ImageIcon("img/ball" + String.valueOf(lottoNumber.getWinningNumberList().get(i)) + ".png"));
				
			} else {
				lblWinningNumber[i].setIcon(new ImageIcon("img/ball" + String.valueOf(lottoNumber.getWinningNumberList().get(i)) + ".png"));
				lblWinningNumber[i].setText("     ");

			}
			lblWinningNumber[i].setForeground(Color.WHITE);
			lblWinningNumber[i].setFont(new Font(Font.SERIF, Font.BOLD, 20));
			pnlNorth.add(lblWinningNumber[i]);
		}

		pnlSouth.add(btnPercent);
		pnlSouth.add(btnExit);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlMain, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void addListener() {
		btnPercent.addActionListener((ae) -> {
			LottoNumberCreate ln = new LottoNumberCreate();
			JOptionPane.showMessageDialog(LottoResult.this, ln.count(),"���������?", JOptionPane.OK_OPTION);
		});
		btnExit.addActionListener((ae) -> {
			closeWindow();
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				closeWindow();
			}
		});
	}

	// ������̺� ����
	public void result() {
		sameLottoLists = new ArrayList<>();
		for (int i = 0; i < lottoNumberLists.size(); i++) {
			winning = "";
			sameLottoNumbers = new ArrayList<>(); // ��Ƚ����ŭ �ζǹ�ȣ�� ���ʴ�� �̱�
			
			for (int j = 0; j < 6; j++) {
				sameLottoNumbers.add(lottoNumberLists.get(i).get(j));
			}
			
			Integer[] array = sameLottoNumbers.toArray(new Integer[0]);
			sameLottoLists.add(sameLottoNumbers);
			
			sameLottoNumbers.retainAll(lottoNumber.getWinningNumberList()); // ��ġ��ȣ �̱�
			
			draw(i);//�����ֱ�
			
			int indexOfBonus = Arrays.binarySearch(array, lottoNumber.getWinningNumberList().get(6));
			if (sameLottoNumbers.size() <= SLAP) {
				winning += "��";
			} else if (sameLottoNumbers.size() == FIFTH) {
				winning += "5�� ��÷";

			} else if (sameLottoNumbers.size() == FOURTH) {
				winning += "4�� ��÷";

			} else if (sameLottoNumbers.size() == THIRTH) {
				winning += "3�� ��÷";

			} else if (sameLottoNumbers.size() == SECOND && indexOfBonus >= 0) {
				winning += "2�� ��÷";

			} else {
				winning += "1�� ��÷";
			}
			pnlCenter[i].getPnlResult().setText(winning);
		}
	}
	
	// �����ֱ�
	private void draw(int i) {
		Integer[] array = lottoNumberLists.get(i).toArray(new Integer[0]);
		for (int j = 0; j < sameLottoNumbers.size(); j++) {
			
			int findIndex = Arrays.binarySearch(array, sameLottoNumbers.get(j));
			System.out.println(findIndex);
			pnlCenter[i].getLottoNumbers()[findIndex].setBackground(new Color(0xF0F8FF));
			pnlCenter[i].getLottoNumbers()[findIndex].setBorder(new LineBorder(Color.YELLOW, 2));
		}
	}

	private void closeWindow() {
		JOptionPane.showMessageDialog(this, "������ �����մϴ�", "EXIT", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private void showDialog() {
		setTitle("���");
		setSize(900, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}