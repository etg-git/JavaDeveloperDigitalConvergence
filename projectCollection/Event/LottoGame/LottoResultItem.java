package kr.ac.green;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LottoResultItem extends JPanel {

	private JLabel lblG;
	private JPanel pnlNumber;
	private JLabel[] lottoNumbers;
	private JPanel pnlWest;
	private JPanel pnlEast;
	private JLabel pnlResult;
	public JPanel getPnlNumber() {
		return pnlNumber;
	}

	public void setPnlNumber(JPanel pnlNumber) {
		this.pnlNumber = pnlNumber;
	}

	public JLabel[] getLottoNumbers() {
		return lottoNumbers;
	}

	public void setLottoNumbers(JLabel[] lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public JLabel getPnlResult() {
		return pnlResult;
	}

	public void setPnlResult(JLabel pnlResult) {
		this.pnlResult = pnlResult;
	}

	public LottoResultItem(int i) {
		init();
		setDisplay(i);
	}

	private void init() {
		lblG = new JLabel();
		pnlNumber = new JPanel();
		pnlEast = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		pnlWest = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		pnlResult = new JLabel();
		lottoNumbers = new JLabel[6];
	}

	private void setDisplay(int i) {
		setLayout(new GridLayout(0, 3));
		lblG.setText("GAME " + i);
		lblG.setBackground(Color.BLACK);
		lblG.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
	
		for (int j = 0; j < lottoNumbers.length; j++) {
			lottoNumbers[j] = new JLabel("", JLabel.CENTER);
			lottoNumbers[j].setForeground(Color.BLACK);
			lottoNumbers[j].setOpaque(true);
			lottoNumbers[j].setPreferredSize(new Dimension(40, 40));
			lottoNumbers[j].setFont(new Font(Font.SERIF, Font.BOLD, 20));
			
			pnlNumber.add(lottoNumbers[j]);
		}
		pnlResult.setBorder(new LineBorder(Color.BLACK, 2));
		pnlResult.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
		pnlWest.add(lblG);
		pnlEast.add(pnlResult);
		add(pnlWest);
		add(pnlNumber);
		add(pnlEast);
	}
}