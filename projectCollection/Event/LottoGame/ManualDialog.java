package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ManualDialog extends JDialog {
	// BorderLayout.east
	private JPanel pnlEast;
	private JPanel pnl;
	private JButton save;
	private JCheckBox[] number;

	private LottoSlot slot;
	private Set<Integer> lottoList;
	private ArrayList<Integer> lottoNumberList;

	private int count = 0;
	private int lotto;

	public ManualDialog(LottoSlot slot, int j) {
		super(slot, "수동", true);
		this.slot = slot;
		init();
		setDisplay();
		addCheckBoxListeners();
		addSaveListeners(j);
		showFrame();

	}

	public ArrayList<Integer> getLottoNumberList() {
		return lottoNumberList;
	}

	public void setLottoNumberList(ArrayList<Integer> lottoNumberList) {
		this.lottoNumberList = lottoNumberList;
	}

	private void init() {
		lottoList = new HashSet<>();
		lottoNumberList = new ArrayList<>();
		pnlEast = new JPanel();
		pnl = new JPanel();
		save = new JButton("저장");

		number = new JCheckBox[45];
	}

	private void setDisplay() {
		getLottoNumber();

		for (int i = 0; i < number.length; i++) {
			getCheckBox(i);
		}
		add(pnl, BorderLayout.CENTER);
	}

	// (로또번호생성)
	private void getLottoNumber() {
		pnlEast = new JPanel(new GridLayout(0, 10));

		pnlEast.setBackground(getColor(1));

		pnl = new JPanel(new BorderLayout());

		pnl.add(pnlEast, BorderLayout.CENTER); 
		pnl.add(save, BorderLayout.SOUTH); 
		save.setMargin(new Insets(2, 2, 2, 2));
	}

	private void getCheckBox(int i) {
		number[i] = new JCheckBox(i + 1 + "");
		number[i].setFont(new Font(Font.SERIF, Font.BOLD, 0));
		number[i].setBackground(getColor(1));
		pnlEast.add(number[i]);
		pnlEast.add(new JLabel(new ImageIcon("img/circlebasic" + (i+1) + ".png")));
	}

	private void addCheckBoxListeners() {
		ItemListener listener = (ie) -> {
			JCheckBox src = (JCheckBox) ie.getSource();
			lotto = Integer.parseInt(src.getText());
			if (count <= 6 && ie.getStateChange() == ItemEvent.SELECTED) {
				src.setBackground(Color.YELLOW);
				count++;
				lottoManual(lotto);
			} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
				lottoList.remove(lotto);
				src.setBackground(null);
				count--;
			}
			if (count > 6) {
				JOptionPane.showMessageDialog(
						ManualDialog.this,
						"로또번호는 6개입니다",
						"6개",
						JOptionPane.WARNING_MESSAGE);
			}
		};

		for (JCheckBox cb : number) {
			cb.addItemListener(listener);
		}
	}

	private void addSaveListeners(int j) {
		save.addActionListener((ae) -> {
			if (count < 6) {
				JOptionPane.showMessageDialog(
						ManualDialog.this,
						"6개선택하세요",
						"로또",
						JOptionPane.WARNING_MESSAGE);
			} else {
				for (int i = 0; i < 6; i++) {
					slot.getSlotItem()[j].getNumbers()[i].setIcon(new ImageIcon(
							"img/ball" + String.valueOf(lottoNumberList.get(i)) + ".png"));
				}
				slot.getSlotItem()[j].getRbAuto().setEnabled(false);
				slot.getSlotItem()[j].getRbManual().setEnabled(false);
				slot.getSlotItem()[j].getPnlNumbers().setVisible(true);
				slot.getLottoLists().add(lottoNumberList);
				dispose();
			}
		});
	}

	private void lottoManual(int i) {
		if (lottoList.size() < 6) {
			lottoList.add(i);
			lottoNumberList = new ArrayList<Integer>(lottoList);
			Collections.sort(lottoNumberList);
		}
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(slot);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	};

	// 배경색깔
	private Color getColor(int i) {
		if (i == 0) {
			return new Color(0x7FFFD4);
		} else if (i == 1) {
			return new Color(0xF0F8FF);
		} else if (i == 2) {
			return new Color(0XFFE4C4);
		} else if (i == 3) {
			return new Color(0xADFF2F);
		} else {
			return new Color(0xFFE4B5);
		}
	}
}