package kc.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MukZziBba extends JFrame {
	private String[] rockPaperScissors = { "¹¬", "Âî", "ºü" };
	private JRadioButton[] rbtnRPS;
	private JButton start;
	private JTextArea output;
	
	private JPanel pnlNorth;
	private JPanel pnlCenter;
	private JPanel pnlSouth;
	
	private String info;
	
	public static final int MUK = 0;
	public static final int ZZI = 1;
	public static final int BBA = 2;
	public MukZziBba() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		pnlNorth = new JPanel();
		pnlCenter = new JPanel();
		pnlSouth = new JPanel();
		
		rbtnRPS = new JRadioButton[rockPaperScissors.length];
		ButtonGroup group = new ButtonGroup(); 
		for (int i = 0; i < rockPaperScissors.length; i++) {
			rbtnRPS[i] = new JRadioButton(rockPaperScissors[i]);
			pnlNorth.add(rbtnRPS[i]);
			rbtnRPS[i].setBorder(new EmptyBorder(0, 30, 0, 30));
			group.add(rbtnRPS[i]);
		}
		start = new JButton("½ÃÀÛ");
		output = new JTextArea(6, 30);
		
	}

	private void setDisplay() {
		
		pnlCenter.add(start);
		JScrollPane scroll = new JScrollPane(output);
		pnlSouth.add(scroll);
		
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void addListeners() {
		ActionListener listener = (ie) -> {
				JRadioButton src = (JRadioButton)ie.getSource();
				if(src == rbtnRPS[MUK]) {
					winAndLose(rbtnRPS[MUK].getActionCommand());
				} else if(src == rbtnRPS[ZZI]) {
					winAndLose(rbtnRPS[ZZI].getActionCommand());
				} else {
					winAndLose(rbtnRPS[BBA].getActionCommand());
				}
				System.out.println(src.getText());
				
		};
		
		rbtnRPS[MUK].addActionListener(listener);
		rbtnRPS[ZZI].addActionListener(listener);
		rbtnRPS[BBA].addActionListener(listener);
		
		start.addActionListener((ae) -> {
			output.setText(info);
		});
		
	}
	private void winAndLose(String me) {
		int random = (int)(Math.random()*3);
		System.out.println(random);
		String computer = rockPaperScissors[random];
		
		String str = "ºñ°å¾î¿ä";
		if(me.equals("¹¬")) {
			if(computer.equals("Âî")) {
				str = "ÀÌ°å¾î¿ä~";
			} else if(computer.equals("ºü")) {
				str = "Á³¾î¿ä~";
			}
		} else if(me.equals("Âî")) {
			if(computer.equals("¹¬")) {
				str = "Á³¾î¿ä~";
			} else if(computer.equals("ºü")) {
				str = "ÀÌ°å¾î¿ä~";
			}
		} else {
			if(computer.equals("¹¬")) {
				str = "ÀÌ°å¾î¿ä~";
			} else if(computer.equals("Âî")) {
				str = "Á³¾î¿ä~";
			}
		}
		info = "ÄÄÇ»ÅÍ:" + computer +"\n";
		info += "´ç½Å:"+me  +"\n";
		info += "´ç½ÅÀÌ " + str  +"\n";
	}
	private void showFrame() {
		setTitle("MJBGame");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MukZziBba();
	}

}
