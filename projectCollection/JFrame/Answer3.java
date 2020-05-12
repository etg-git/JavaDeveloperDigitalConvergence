package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Answer3 extends JFrame {
	
	public Answer3() {
		//BorderLayout North
		Dimension textSize = new Dimension(52, 28);
		JPanel pnlNorth = new JPanel(new GridLayout(0, 1));
		JPanel pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlRePassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblId = new JLabel("아이디", JLabel.LEFT);
		JTextField tfId = new JTextField(10);
		pnlId.add(lblId);
		lblId.setPreferredSize(textSize);
		pnlId.add(tfId);
		pnlId.add(new JButton("중복검사"));
		
		JLabel lblName = new JLabel("이름", JLabel.LEFT);
		JTextField tfName = new JTextField(10);
		pnlName.add(lblName);
	
		lblName.setPreferredSize(textSize);
		pnlName.add(tfName);
		
		JLabel lblPassword = new JLabel("비밀번호", JLabel.LEFT);
		JPasswordField tfPassword = new JPasswordField(10);
		pnlPassword.add(lblPassword);
		pnlPassword.add(tfPassword);
		
		JLabel lblRePassword = new JLabel("재입력", JLabel.LEFT);
		JPasswordField tfRePassword = new JPasswordField(10);
		pnlRePassword.add(lblRePassword);
		lblRePassword.setPreferredSize(textSize);
		pnlRePassword.add(tfRePassword);
		
		String[] gender = {"남자", "여자"};
		JLabel lblGender = new JLabel("성별", JLabel.LEFT);
		pnlGender.add(lblGender);
		JRadioButton[] rbGender = new JRadioButton[gender.length];
		ButtonGroup gb = new ButtonGroup();
		for (int i = 0; i < rbGender.length; i++) {
			rbGender[i] = new JRadioButton(gender[i]);
			
			pnlGender.add(rbGender[i]);
			gb.add(rbGender[i]);
		}
		
		pnlNorth.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlId.setBorder(new EmptyBorder(0, 0, 10, 0));
		pnlNorth.add(pnlId);
		pnlNorth.add(pnlName);
		pnlNorth.add(pnlPassword);
		pnlNorth.add(pnlRePassword);
		pnlNorth.add(pnlGender);
		pnlNorth.add(new JLabel("자기소개"));
		//BorderLayout CENTER
		JPanel pnlCenter = new JPanel();
		
		pnlCenter.setBorder(new EmptyBorder(10, 15, 10, 15));
		JTextArea taIntroduction = new JTextArea(5, 30);
		
		JScrollPane scroll = new JScrollPane(taIntroduction);
		
		pnlCenter.add(scroll);
		
		
		//BorderLayout South
		JPanel pnlBut = new JPanel();
		pnlBut.add(new JButton("가입"));
		pnlBut.add(new JButton("취소"));
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlBut, BorderLayout.SOUTH);
		
		setFrame();
		
	}
	
	
	
	
	public void setFrame() {
		setTitle("회원가입");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
			new Answer3();
	}

}
