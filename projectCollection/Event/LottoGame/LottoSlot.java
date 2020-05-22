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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LottoSlot extends JFrame {
	private LottoOpening opening;
	// BorderLayout - South
	private JButton confirm;
	private JButton cancel;
	private JButton reset;
	private JPanel pnlSouth;

	// BorderLayout.west
	private JPanel pnlWest;
	private CheckCountItem[] cItem;

	// BorderLayout.Center
	private JPanel pnlCenter;
	private AutoManualItem[] amItem;


	// BorderLayout.East
	private JPanel pnlEast;
	private LottoNumbersListItem[] numsItem;
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
	public AutoManualItem[] getAmItem() {
		return amItem;
	}

	public void setAmItem(AutoManualItem[] amItem) {
		this.amItem = amItem;
	}
	public LottoNumbersListItem[] getNumsItem() {
		return numsItem;
	}

	public void setNumsItem(LottoNumbersListItem[] numsItem) {
		this.numsItem = numsItem;
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
		cancel = new JButton("취소");
		reset = new JButton("초기화");
		pnlSouth = new JPanel();

		// west
		pnlWest = new JPanel(new GridLayout(0, 1));
		cItem = new CheckCountItem[5];

		// center
		pnlCenter = new JPanel(new GridLayout(0, 1));
		amItem = new AutoManualItem[5];

		// east
		pnlEast = new JPanel(new GridLayout(0, 1));
		numsItem = new LottoNumbersListItem[5];

		manualDialog = new ManualDialog[5];

		lottoLists = new ArrayList<>();
	}

	private void setDisplay() {
		getButtonSouth();
		// center
		for (int i = 0; i < 5; i++) {
			amItem[i] = new AutoManualItem();
			pnlCenter.add(amItem[i]);

			cItem[i] = new CheckCountItem(i);
			pnlWest.add(cItem[i]);

			numsItem[i] = new LottoNumbersListItem();
			pnlEast.add(numsItem[i]);
		}
		pnlSouth.add(confirm);
		pnlSouth.add(cancel);
		pnlSouth.add(reset);
		LineBorder line = new LineBorder(Color.BLACK);
		
		pnlWest.setBorder(line);
		pnlCenter.setBorder(line);
		pnlEast.setBorder(line);
		pnlSouth.setBorder(line);
		add(pnlWest, BorderLayout.WEST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlEast, BorderLayout.EAST);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	// 밑에 버튼 두개(확인, 취소)
	// 버튼(확인,취소,초기화)
	private void getButtonSouth() {
		// button
		confirm.setMargin(new Insets(2, 2, 2, 2));
		cancel.setMargin(new Insets(2, 2, 2, 2));
		reset.setMargin(new Insets(2, 2, 2, 2));
	}

	// 몇개사는지 체크(1~5번) 이벤트
	private void addCheckListeners(int i) {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == cItem[i].getCbCheck()) {
					if (cItem[i].getCbCheck().isSelected()) {
						amItem[i].getPnlAutoAndManual().setVisible(true);
					} else {
						amItem[i].getPnlAutoAndManual().setVisible(false);
					}
				}
			}
		};
		cItem[i].getCbCheck().addActionListener(listener);
	}

	// 라디오버튼 체크 이벤트
	private void addManualAutoListeners(int i) {
		ItemListener listener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object src = e.getSource();
					if (src == amItem[i].getRbManual()) { // 수동
						manualDialog[i] = new ManualDialog(LottoSlot.this, i);
						setSize(600,400);
					} else {// 자동
						new AutoDialog(LottoSlot.this, i);
					}
				}
			}
		};
		amItem[i].getRbManual().addItemListener(listener);
		amItem[i].getRbAuto().addItemListener(listener);
	}

	private void addBtnListeners() {
		cancel.addActionListener((ae) -> {
			LottoSlot.this.setVisible(false);
			new LottoOpening();
		});
		confirm.addActionListener((ae) -> {
			new LottoResult(LottoSlot.this);
		});
		reset.addActionListener((ae) -> {
			for (int i = 0; i < 5; i++) {
				cItem[i].getCbCheck().setSelected(false);
				amItem[i].getPnlAutoAndManual().setVisible(false);
				amItem[i].getRbManual().setEnabled(true);
				amItem[i].getRbAuto().setEnabled(true);
				amItem[i].getRbManual().setSelected(false);
				amItem[i].getRbAuto().setSelected(false);
				numsItem[i].setVisible(false);
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