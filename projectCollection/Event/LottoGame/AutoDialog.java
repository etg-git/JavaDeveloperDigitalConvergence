package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutoDialog extends JDialog {

	private JPanel pnlMain;
	private JLabel[] lblNums;

	private JPanel pnlSouth;

	private JButton btnConfirm;
	private JButton btnChurn;

	private LottoSlot lottoSlot;
	private LottoNumberCreate picker;

	private final static Dimension sizeBtn = new Dimension(50, 30);

	private Color[] colors = { new Color(0xFFF000), new Color(0x69FD38), new Color(0x47AEF7), new Color(0x455EF1),
			new Color(0xB92EFA), new Color(0xFA9C32), new Color(0xFC3D33), new Color(0xB9FC2C), new Color(0x1FF9B0),
			new Color(0x7FFFD4), new Color(0xF0F8FF), new Color(0xFFE4C4), new Color(0xADFF2F), new Color(0xFFE4B5)};

	public AutoDialog(LottoSlot owner, int j) {
		super(owner, "자동선택", true);
		this.lottoSlot = owner;
		picker = new LottoNumberCreate();
		picker.lottoNumberCreate();
		init();
		setDisplay();
		addListener(j);
		showDialog();
	}

	private void init() {
		pnlMain = new JPanel();

		lblNums = new JLabel[6];

		pnlSouth = new JPanel();

		btnConfirm = new JButton("확인");
		btnChurn = new JButton("굴리기");
	}
	private void setDisplay() {
		pnlMain.setLayout(new GridLayout(1, 6));
		for (int i = 0; i < lblNums.length; i++) {
			
			Random r = new Random();
			int rNum = r.nextInt(14);

			lblNums[i] = new JLabel(new ImageIcon("img/ball" +String.valueOf(picker.getLottoNumberList().get(i)) + ".png"));
			lblNums[i].setOpaque(true);
			lblNums[i].setBackground(colors[rNum]);
			lblNums[i].setForeground(Color.BLACK);
			lblNums[i].setFont(new Font("Typo_Storm B", Font.BOLD, 40));

			lblNums[i].setHorizontalTextPosition(2);
			pnlMain.add(lblNums[i]);
		}

		btnChurn.setPreferredSize(sizeBtn);
		btnConfirm.setPreferredSize(sizeBtn);
		btnConfirm.setMargin(new Insets(2, 2, 2, 2));
		btnChurn.setMargin(new Insets(2, 2, 2, 2));

		pnlSouth.add(btnChurn);
		pnlSouth.add(btnConfirm);

		add(pnlMain, BorderLayout.CENTER);

		add(pnlSouth, BorderLayout.SOUTH);

	}
	private void addListener(int j) {
		btnConfirm.addActionListener((ae) -> {
			for (int i = 0; i < 6; i++) {
				lottoSlot.getNumsItem()[j].getNumbers()[i].setIcon(
						new ImageIcon("img/ball" + String.valueOf(picker.getLottoNumberList().get(i) + ".png")));
			}
			lottoSlot.getAmItem()[j].getRbAuto().setEnabled(false);
			lottoSlot.getAmItem()[j].getRbManual().setEnabled(false);
			lottoSlot.getNumsItem()[j].setVisible(true);
			lottoSlot.getLottoLists().add(picker.getLottoNumberList());
			dispose();
		});

		btnChurn.addActionListener((ae) -> {
			picker.lottoNumberCreate();
			for (int i = 0; i < lblNums.length; i++) {
				Random r = new Random();
				int rNum = r.nextInt(9);
				
				lblNums[i].setIcon(new ImageIcon("img/ball" + String.valueOf(picker.getLottoNumberList().get(i) + ".png")));
				
//				lblNums[i].setBackground(colors[rNum]);
			}
		});

	}

	private void showDialog() {
		setTitle("자동");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}