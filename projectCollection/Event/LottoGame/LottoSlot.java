package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//로또슬롯
public class LottoSlot extends JFrame {
	private LottoOpening opening;
	// BorderLayout - South
	private JButton confirm;
	private JButton reset;
	private JPanel pnlSouth;

	// BorderLayout.Center
	private JPanel pnlCenter;
	private LottoSlotItem[] slotItem;

	private ArrayList<ArrayList<Integer>> lottoLists;
	private ManualDialog[] manualDialog;

	public LottoSlot() {
		init();
		setDisplay();
		for (int i = 0; i < 5; i++) {
			addManualAutoListeners(i);
			addCheckListeners(i);
		}
		addBtnListeners();
		showFrame();
	}

	public LottoSlotItem[] getSlotItem() {
		return slotItem;
	}

	public void setSlotItem(LottoSlotItem[] amItem) {
		this.slotItem = amItem;
	}

	public ArrayList<ArrayList<Integer>> getLottoLists() {
		return lottoLists;
	}

	public void setLottoLists(ArrayList<ArrayList<Integer>> lottoLists) {
		this.lottoLists = lottoLists;
	}

	public ManualDialog[] getManualDialog() {
		return manualDialog;
	}

	public void setManualDialog(ManualDialog[] manualDialog) {
		this.manualDialog = manualDialog;
	}

	private void init() {
		// south
		confirm = new JButton("확인");
		reset = new JButton("초기화");
		pnlSouth = new JPanel();

		// center
		pnlCenter = new JPanel(new GridLayout(0, 1));
		slotItem = new LottoSlotItem[5];

		manualDialog = new ManualDialog[5];

		lottoLists = new ArrayList<>();
	}

	LineBorder line = new LineBorder(Color.BLACK);

	private void setDisplay() {
		getButtonSouth();
		// center
		for (int i = 0; i < 5; i++) {
			slotItem[i] = new LottoSlotItem();
			slotItem[i].setBorder(line);
			pnlCenter.add(slotItem[i]);

		}
		pnlSouth.add(confirm);
		pnlSouth.add(reset);

		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	// 밑에 버튼 두개(확인, 취소)
	// 버튼(확인,취소,초기화)
	private void getButtonSouth() {
		// button
		confirm.setMargin(new Insets(2, 2, 2, 2));
		reset.setMargin(new Insets(2, 2, 2, 2));
	}

	// 몇개사는지 체크(1~5번) 이벤트
	private void addCheckListeners(int i) {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == slotItem[i].getCbCheck()) {
					if (slotItem[i].getCbCheck().isSelected()) {
						slotItem[i].getPnlAutoAndManual().setVisible(true);
					} else {
						slotItem[i].getPnlAutoAndManual().setVisible(false);
					}
				}
			}
		};
		slotItem[i].getCbCheck().addActionListener(listener);
	}

	// 라디오버튼 체크 이벤트
	private void addManualAutoListeners(int i) {
		ItemListener listener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object src = e.getSource();
					if (src == slotItem[i].getRbManual()) { // 수동
						manualDialog[i] = new ManualDialog(LottoSlot.this, i);
						setSize(600, 400);
					} else {// 자동
						new AutoDialog(LottoSlot.this, i);
					}
				}
			}
		};
		slotItem[i].getRbManual().addItemListener(listener);
		slotItem[i].getRbAuto().addItemListener(listener);
	}

	private void addBtnListeners() {
		confirm.addActionListener((ae) -> {
			if (lottoLists.size() == 0) {
				JOptionPane.showMessageDialog(LottoSlot.this, "하나이상 사세요", "안넘어갈거임", JOptionPane.WARNING_MESSAGE);
			} else {
				new LottoResult(LottoSlot.this);
				this.setVisible(false);
			}
		});
		reset.addActionListener((ae) -> {
			for (int i = 0; i < 5; i++) {
				slotItem[i].getCbCheck().setSelected(false);
				slotItem[i].getPnlAutoAndManual().setVisible(false);
				slotItem[i].getRbManual().setEnabled(true);
				slotItem[i].getRbAuto().setEnabled(true);
				slotItem[i].getRbManual().setSelected(false);
				slotItem[i].getRbAuto().setSelected(false);
				slotItem[i].getPnlAutoAndManual().setVisible(false);
				slotItem[i].getPnlNumbers().setVisible(false);
				lottoLists.clear();
			}
		});
	}

	public ArrayList<ArrayList<Integer>> lottoLists(int i) {
		lottoLists.add(manualDialog[i].getLottoNumberList());
		return lottoLists;
	}

	private void showFrame() {
		setTitle("로또자동수동");
		setSize(600, 400);
		setLocationRelativeTo(opening);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}