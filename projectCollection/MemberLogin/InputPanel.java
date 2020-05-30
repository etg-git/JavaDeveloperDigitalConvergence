package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	private JLabel lblName;
	private JTextField txtField;
	
	private JPanel pnlInput;
	
	public JLabel getLblName() {
		return lblName;
	}
	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}
	
	public JTextField getTxtField() {
		return txtField;
	}
	public void setTxtField(JTextField txtField) {
		this.txtField = txtField;
	}
	public InputPanel() {
		init();
		setDisplay();
	}
	private void init() {
		lblName = new JLabel("", JLabel.LEFT);
		lblName.setPreferredSize(new Dimension(70,30));
		txtField = new JTextField(10);
		
		pnlInput = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
	}
	private void setDisplay() {
		pnlInput.add(lblName);
		pnlInput.add(txtField);
		add(pnlInput, BorderLayout.CENTER);
	}
}