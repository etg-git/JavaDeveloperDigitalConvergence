package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Answer1 extends JFrame{
	private JLabel lblPrincipal;
	private JLabel lblInterest;
	private JTextField tfPrincipalInput;
	private JTextField tfInterestInput;
	private JPanel pnlPrincipal;
	private JPanel pnlPrincipalTextField;
	private JPanel pnlInterest;
	private JPanel pnlInterestTextField;
	private JPanel buttom;
	private JTextField tfOutput;
	public Answer1() {
		init();
		setDisplay();
		setFrame();
	}
	public void init() {
		 lblPrincipal = new JLabel("원금을 입력하시오");
		 lblInterest = new JLabel("이자율을 입력하시오");
		 tfPrincipalInput = new JTextField(5);
		 tfInterestInput = new JTextField(5);
		 buttom = new JPanel();
		 tfOutput = new JTextField(15);
	}
	public void setDisplay() {
		JPanel pnlPrincipal = new JPanel(new GridLayout(0,2)); //원금입력하시오, 텍스트필드 두개나누기
		JPanel pnlPrincipalText = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlPrincipalText.add(lblPrincipal);
		pnlPrincipal.add(pnlPrincipalText);
		JPanel pnlPrincipalTextField = new JPanel(); 
		pnlPrincipalTextField.add(tfPrincipalInput);
		pnlPrincipal.add(pnlPrincipalTextField);
		
		
		JPanel pnlInterest = new JPanel(new GridLayout(0,2));
		JPanel pnlInterestText = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlInterestText.add(lblInterest);
		pnlInterest.add(pnlInterestText);
		JPanel pnlInterestTextField = new JPanel();
		pnlInterestTextField.add(tfInterestInput);
		pnlInterest.add(pnlInterestTextField);
		
		JPanel pnlNorth = new JPanel(new GridLayout(2, 0));
		
		pnlNorth.add(pnlPrincipal);
		pnlNorth.add(pnlInterest);
		
		
		buttom.add(new JButton("변환"));
		
		
		tfOutput.setEditable(false);
		
		JPanel output = new JPanel();
		output.add(tfOutput);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(buttom, BorderLayout.CENTER);
		add(output, BorderLayout.SOUTH);
	}
	public void setFrame() {
		setTitle("이자 계산기");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new Answer1();
	}
}
