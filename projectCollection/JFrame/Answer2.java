package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Answer2 extends JFrame {
	private JPanel pnlMenu;
	private static final Dimension MENU_SIZE= new Dimension(87, 129);
	public Answer2() {
		JLabel lblIntroduction = new JLabel("자바피자에 오신것을 환영합니다.", JLabel.CENTER);
		
		JPanel pnlCheck = new JPanel();
		String kinds[] = {"콤보", "포테이토", "불고기"};
		String toppings[] = {"피망", "치즈", "페페로니", "베이컨"};
		String sizes[] = {"small", "medium", "large"};
		JCheckBox[] cbKind = new JCheckBox[kinds.length];
		JRadioButton[] rbTopping = new JRadioButton[toppings.length];
		JCheckBox[] cbSizes = new JCheckBox[sizes.length];
		LineBorder lb = new LineBorder(Color.BLACK, 1);
		
		//종류
		TitledBorder tbKinds = new TitledBorder(lb, "종류");
		pnlMenu = new JPanel(new GridLayout(0, 1));
		for(int i = 0; i<cbKind.length; i++) {
			cbKind[i] = new JCheckBox(kinds[i]);
			pnlMenu.add(cbKind[i]);
		}
		pnlMenu.setBorder(tbKinds);
		pnlMenu.setPreferredSize(MENU_SIZE);
		pnlCheck.add(pnlMenu);
		//토핑
		TitledBorder tbToppings = new TitledBorder(lb, "토핑");
		pnlMenu = new JPanel(new GridLayout(0, 1));
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i<rbTopping.length; i++) {
			rbTopping[i] = new JRadioButton(toppings[i]);
			pnlMenu.add(rbTopping[i]);
			
			bg.add(rbTopping[i]);
		}
		pnlMenu.setBorder(tbToppings);
		pnlCheck.add(pnlMenu);

		//크기
		TitledBorder tbSizes = new TitledBorder(lb, "크기");
		pnlMenu = new JPanel(new GridLayout(0, 1));
		for(int i = 0; i<cbSizes.length; i++) {
			cbSizes[i] = new JCheckBox(sizes[i]);
			pnlMenu.add(cbSizes[i]);
		}
		pnlMenu.setBorder(tbSizes);
		pnlMenu.setPreferredSize(MENU_SIZE);
		pnlCheck.add(pnlMenu);
		
		
		JPanel pnlBut = new JPanel();
		pnlBut.add(new JButton("주문"));
		pnlBut.add(new JButton("취소"));
		
			
		add(lblIntroduction, BorderLayout.NORTH);
		add(pnlCheck, BorderLayout.CENTER);
		add(pnlBut, BorderLayout.SOUTH);
		
		setFrame();		
	}
	
	public void setFrame() {
		setTitle("피자주문");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Answer2();
	}

}