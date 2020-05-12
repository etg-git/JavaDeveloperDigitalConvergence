package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Answer4 extends JFrame {
	Dimension max_textSize = new Dimension(20, 18);
	public Answer4() {
		//BorderLayout West
		JPanel pnlWest = new JPanel(new GridLayout(0,1));
		JPanel pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlRePassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
		
		JLabel lblId = new JLabel("ID", JLabel.LEFT);
		JButton butOver = new JButton("중복체크");
		butOver.setPreferredSize(new Dimension(86, 22));
		lblId.setPreferredSize(max_textSize);
		JPanel total1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField tfId = new JTextField(12);
		pnlId.add(lblId);
		total1.add(tfId);
		total1.add(butOver);
		pnlId.add(total1);
		JLabel lblPassword = new JLabel("PW", JLabel.LEFT);
		JPasswordField tfPassword = new JPasswordField();
		JPanel total2 = new JPanel();
		tfPassword.setPreferredSize(new Dimension(228, 22));
		total2.add(tfPassword);
		pnlPassword.add(lblPassword);
		pnlPassword.add(total2);
		
		JLabel lblRePassword = new JLabel("Re", JLabel.LEFT);
		lblRePassword.setPreferredSize(max_textSize);
		JPasswordField tfRePassword = new JPasswordField();
		JPanel total3 = new JPanel();
		tfRePassword.setPreferredSize(new Dimension(228, 22));
		pnlRePassword.add(lblRePassword);
		total3.add(tfRePassword);
		pnlRePassword.add(total3);
		
		String[] gender = {"남자", "여자"};
		JLabel lblGender = new JLabel("성별", JLabel.LEFT);
		lblGender.setPreferredSize(max_textSize);
		JRadioButton[] rbGender = new JRadioButton[gender.length];
		ButtonGroup gb = new ButtonGroup();
		for (int i = 0; i < rbGender.length; i++) {
			rbGender[i] = new JRadioButton(gender[i]);
			
			pnlGender.add(rbGender[i]);
			gb.add(rbGender[i]);
		}
		String[] hobby = {"독서", "낮잠", "여행", "서핑", "게임", "지각"};
		JCheckBox[] cbHobby = new JCheckBox[hobby.length];
		JLabel lblHobby = new JLabel("취미", JLabel.LEFT);
		lblRePassword.setPreferredSize(max_textSize);
		JPanel pnlHobby = new JPanel(new GridLayout(2,3));
		for (int i = 0; i < cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(hobby[i]);
			
			pnlHobby.add(cbHobby[i]);
		}
	
		pnlWest.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlWest.add(pnlId);
		pnlWest.add(pnlPassword);
		pnlWest.add(pnlRePassword);
		pnlWest.add(lblGender);
		pnlWest.add(pnlGender);
		pnlWest.add(lblHobby);
		pnlWest.add(pnlHobby);
		//BorderLayout Center
		JPanel pnlCenter = new JPanel(new BorderLayout());
		JTextArea taIntro = new JTextArea(2, 40);
		JScrollPane scroll = new JScrollPane(taIntro);
		pnlCenter.add(new JLabel("자기소개"), BorderLayout.NORTH);
		pnlCenter.add(scroll, BorderLayout.CENTER);
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		//BorderLayout South
		JPanel pnlBut = new JPanel();
		pnlBut.add(new JButton("확인"));
		pnlBut.add(new JButton("취소"));
		
		add(pnlWest, BorderLayout.WEST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlBut, BorderLayout.SOUTH);
		
		setFrame();
		System.out.println(total1.getSize());
		System.out.println(butOver.getSize());
	}
	
	public void setFrame() {
		setTitle("InformationForm");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Answer4();
	}

}
