package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PwInputPanel extends JPanel {
	private JLabel lblName;
	private JPasswordField pwField;

	private JPanel pnlInput;

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JPasswordField getPwField() {
		return pwField;
	}

	public void setPwField(JPasswordField pwField) {
		this.pwField = pwField;
	}
	
	public PwInputPanel() {
		init();
		setDisplay();
	}

	private void init() {
		lblName = new JLabel("", JLabel.LEFT);
		lblName.setPreferredSize(new Dimension(70, 30));

		pnlInput = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		pwField = new JPasswordField(10);
		pwField.setText(null);
	}

	private void setDisplay() {
		pnlInput.add(lblName);
		pnlInput.add(pwField);
		add(pnlInput, BorderLayout.CENTER);
	}
}