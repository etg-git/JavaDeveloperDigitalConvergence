package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


//로또슬롯에 대한 JPanel
public class LottoSlotItem extends JPanel {
	
	
	//borderlayout -center :수동,자동 버튼
	private JRadioButton rbAuto;
	private JRadioButton rbManual;
	private ButtonGroup group;
	private JPanel pnlAutoAndManual;
	
	//borderlayout - west : 1000원 체크버튼
	private JCheckBox cbCheck;
	private JPanel pnlCheck;
	
	//borderlayout - east // 로또번호 확인
	private JLabel[] numbers;
	private JPanel pnlNumbers;

	
	public LottoSlotItem() {
		init();
		setDisplay();
		
	}
	public JLabel[] getNumbers() {
		return numbers;
	}

	public JPanel getPnlNumbers() {
		return pnlNumbers;
	}
	public void setPnlNumbers(JPanel pnlNumbers) {
		this.pnlNumbers = pnlNumbers;
	}
	public void setNumbers(JLabel[] numbers) {
		this.numbers = numbers;
	}
	public JCheckBox getCbCheck() {
		return cbCheck;
	}

	public void setCbCheck(JCheckBox cbCheck) {
		this.cbCheck = cbCheck;
	}
	public JPanel getPnlAutoAndManual() {
		return pnlAutoAndManual;
	}

	public void setPnlAutoAndManual(JPanel pnlAutoAndManual) {
		this.pnlAutoAndManual = pnlAutoAndManual;
	}

	public JRadioButton getRbAuto() {
		return rbAuto;
	}

	public void setRbAuto(JRadioButton rbAuto) {
		this.rbAuto = rbAuto;
	}

	public JRadioButton getRbManual() {
		return rbManual;
	}

	public void setRbManual(JRadioButton rbManual) {
		this.rbManual = rbManual;
	}

	private void init() {
		rbAuto = new JRadioButton();
		rbManual = new JRadioButton();
		pnlAutoAndManual = new JPanel();
		group = new ButtonGroup();
		cbCheck = new JCheckBox("1000원");
		pnlCheck = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNumbers = new JPanel();
	}

	private void setDisplay() {
		//center
		rbAuto = new JRadioButton("자동");
		rbManual = new JRadioButton("수동");

		group = new ButtonGroup();
		group.add(rbAuto);
		group.add(rbManual);

		pnlAutoAndManual = new JPanel();
		pnlAutoAndManual.add(rbAuto);
		pnlAutoAndManual.add(rbManual);

		pnlAutoAndManual.setVisible(false);
		
		
		//west
		pnlCheck.add(cbCheck);
		
		
		//east
		numbers = new JLabel[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new JLabel("");
			numbers[i].setPreferredSize(new Dimension(36, 36));
			numbers[i].setBackground(new Color(0xF0F8FF));
			numbers[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			pnlNumbers.add(numbers[i]);
			
		}
		
		add(pnlCheck, BorderLayout.WEST);
		add(pnlAutoAndManual, BorderLayout.CENTER);
		add(pnlNumbers, BorderLayout.EAST);
	}
}