package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LottoNumbersListItem extends JPanel {

	private JLabel[] numbers;
	private JPanel pnl;

	
	public JLabel[] getNumbers() {
		return numbers;
	}

	public void setNumbers(JLabel[] numbers) {
		this.numbers = numbers;
	}

	public LottoNumbersListItem() {
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		numbers = new JLabel[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new JLabel("", JLabel.CENTER);
			numbers[i].setPreferredSize(new Dimension(36, 36));
			numbers[i].setBackground(new Color(0xF0F8FF));
			numbers[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			pnl.add(numbers[i]);
		}
		this.setVisible(false);
		
		add(pnl, BorderLayout.CENTER);

	}
}
