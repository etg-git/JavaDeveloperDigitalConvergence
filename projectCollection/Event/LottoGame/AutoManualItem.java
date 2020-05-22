package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AutoManualItem extends JPanel {

	private JRadioButton rbAuto;
	private JRadioButton rbManual;
	private ButtonGroup group;
	private JPanel pnlAutoAndManual;
	
	public AutoManualItem() {
		init();
		setDisplay();
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
	}
	private void setDisplay() {
		rbAuto = new JRadioButton("자동");
		rbManual = new JRadioButton("수동");

		group = new ButtonGroup();
		group.add(rbAuto);
		group.add(rbManual);

		pnlAutoAndManual = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
		pnlAutoAndManual.add(rbAuto);
		pnlAutoAndManual.add(rbManual);

		pnlAutoAndManual.setVisible(false);
		
		
		add(pnlAutoAndManual, BorderLayout.CENTER);
	}
	

}
