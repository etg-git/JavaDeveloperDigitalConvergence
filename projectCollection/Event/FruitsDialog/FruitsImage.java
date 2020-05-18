package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

public class FruitsImage extends JDialog {
	
	private Fruits fruits;
	private JLabel lbl;
	private JLabel lblPage;
	private JPanel pnlPage;
	
	private JPopupMenu pMenu;
	private JMenuItem miBack;
	private JMenuItem miAfter;
	private int num;
	
	private Image img;
	private Image newImage;
	public FruitsImage(Fruits fruits, int num) {
		super(fruits, "Do u see?", true);
		this.fruits = fruits;
		this.num = num +1;
		pMenu = new JPopupMenu();
		pnlPage = new JPanel();
		lblPage = new JLabel(this.num + "/20");
		miBack = new JMenuItem("뒤로");
		miAfter = new JMenuItem("앞으로");
		
		pnlPage.add(lblPage);
		pMenu.add(miBack);
		pMenu.add(miAfter);
		
		img = fruits.getImg()[num];
		newImage = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		
		lbl = new JLabel(new ImageIcon(newImage));
		
		add(pnlPage, BorderLayout.NORTH);
		add(lbl, BorderLayout.CENTER);
		
		addListeners();
		showFrame();
	}
	private void addListeners() {
		lbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent me) {
				lbl.setBorder(new LineBorder(Color.WHITE));
			}
			@Override
			public void mouseEntered(MouseEvent me) {
				lbl.setBorder(new LineBorder(Color.GREEN));
			}
			@Override
			public void mousePressed(MouseEvent me) {
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me) {
				showPopup(me);
			}
			@Override
			public void mouseClicked(MouseEvent me) {
				int x = lbl.getWidth() / 2;
				if(me.getX()>x) {
					try {
						num = num + 1;
						backAfter(num);
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(FruitsImage.this, "없어요", "사진이 없어요", JOptionPane.CANCEL_OPTION);
						num = 21;
					}
					
				} else {
					try {
						num = num -1;
						backAfter(num);
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(FruitsImage.this, "없어요", "사진이 없어요", JOptionPane.CANCEL_OPTION);
						num = 0;
					}
				}
			}
		});
		miBack.addActionListener((ae) -> {
				num = num -1;
				backAfter(num);
		});
		
		miAfter.addActionListener((ae) -> {
				num = num +1;
				backAfter(num);
		});
		
	}
	public void backAfter(int num) {
			lblPage.setText(num + "/20");
			img = fruits.getImg()[num-1];
			newImage = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			lbl.setIcon(new ImageIcon(newImage));
		
	}
	private void showPopup(MouseEvent me) {
		if(me.isPopupTrigger()) {
			pMenu.show(lbl, me.getX(), me.getY());
			pMenu.show(pnlPage, me.getX(), me.getY());
		}
	}
	private void showFrame() {
		setSize(500, 500);
		setLocationRelativeTo(fruits);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
