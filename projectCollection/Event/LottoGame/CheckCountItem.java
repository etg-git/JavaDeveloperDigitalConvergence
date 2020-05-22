package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckCountItem extends JPanel{
	private JCheckBox cbCheck;
	
	public JCheckBox getCbCheck() {
		return cbCheck;
	}

	public void setCbCheck(JCheckBox cbCheck) {
		this.cbCheck = cbCheck;
	}

	public CheckCountItem(int i) {
		cbCheck = new JCheckBox("1000¿ø");
		add(cbCheck, BorderLayout.CENTER);
	}
}
