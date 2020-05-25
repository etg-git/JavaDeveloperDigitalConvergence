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

//�ζǽ���
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
		confirm = new JButton("Ȯ��");
		reset = new JButton("�ʱ�ȭ");
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

	// �ؿ� ��ư �ΰ�(Ȯ��, ���)
	// ��ư(Ȯ��,���,�ʱ�ȭ)
	private void getButtonSouth() {
		// button
		confirm.setMargin(new Insets(2, 2, 2, 2));
		reset.setMargin(new Insets(2, 2, 2, 2));
	}

	// ������ üũ(1~5��) �̺�Ʈ
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

	// ������ư üũ �̺�Ʈ
	private void addManualAutoListeners(int i) {
		ItemListener listener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object src = e.getSource();
					if (src == slotItem[i].getRbManual()) { // ����
						manualDialog[i] = new ManualDialog(LottoSlot.this, i);
						setSize(600, 400);
					} else {// �ڵ�
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
				JOptionPane.showMessageDialog(LottoSlot.this, "�ϳ��̻� �缼��", "�ȳѾ����", JOptionPane.WARNING_MESSAGE);
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
		setTitle("�ζ��ڵ�����");
		setSize(600, 400);
		setLocationRelativeTo(opening);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}