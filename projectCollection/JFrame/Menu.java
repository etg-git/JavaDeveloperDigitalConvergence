package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Menu extends JFrame {
	private String[] arrKinds = { "�޺�", "��������", "�Ұ��" };
	private String[] arrToppings = { "�Ǹ�", "ġ��", "����δ�", "������" };
	private String[] arrSizes = { "small", "medium", "large" };

	private JCheckBox[] kinds;
	private JRadioButton[] toppings;
	private JCheckBox[] sizes;

	private JButton btnOrder;
	private JButton btnCancel;

	private JLabel lblInfo;

	public Menu() {
		init();
		setDisplay();
		showFrame();
	}

	private void init() {
		kinds = new JCheckBox[arrKinds.length];
		for (int idx = 0; idx < kinds.length; idx++) {
			kinds[idx] = new JCheckBox(arrKinds[idx]);
		}
		toppings = new JRadioButton[arrToppings.length];
		ButtonGroup group = new ButtonGroup();
		for (int idx = 0; idx < toppings.length; idx++) {
			toppings[idx] = new JRadioButton(arrToppings[idx]);
			group.add(toppings[idx]);
		}
		sizes = new JCheckBox[arrSizes.length];
		for (int idx = 0; idx < sizes.length; idx++) {
			sizes[idx] = new JCheckBox(arrSizes[idx]);
		}
		btnOrder = new JButton("�ֹ�");
		btnCancel = new JButton("���");

		lblInfo = new JLabel("�ڹ����ڿ� ���Ű��� ȯ���մϴ�.", JLabel.CENTER);
	}

	private void setDisplay() {
		JPanel pnlKinds = getPanel("����", kinds);
		JPanel pnlToppings = getPanel("����", toppings);
		JPanel pnlSizes = getPanel("ũ��", sizes);
		JPanel pnlCenter = new JPanel(new GridLayout(1, 0));
		pnlCenter.add(pnlKinds);
		pnlCenter.add(pnlToppings);
		pnlCenter.add(pnlSizes);
		pnlCenter.setBorder(new EmptyBorder(0, 10, 0, 10));

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnOrder);
		pnlSouth.add(btnCancel);

		add(lblInfo, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private JPanel getPanel(String title, JToggleButton... btns) {
		JPanel pnl = new JPanel(new GridLayout(0, 1));
		for (JToggleButton btn : btns) {
			pnl.add(btn);
		}
		pnl.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), title));
		return pnl;
	}

	private void showFrame() {
		setTitle("�����ֹ�");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Menu();
	}

}
