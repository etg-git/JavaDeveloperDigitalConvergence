package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Fruits extends JFrame {
	private JButton[] button;
	private Icon icon;
	private String[] imgName = {"apple", "asparagus", "banana", "broccoli",
			"cantaloupe", "carrot", "corn", "grapefruit", "grapes",
			"kiwi", "onion", "peach", "pear", "pepper", "pickle",
			"pineapple", "raspberry", "strawberry", "tomato", "watermelon"};
	private JPanel pnl;


	private Image[] img;

	public Fruits() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	public JButton[] getLbl() {
		return button;
	}

	public void setLbl(JButton[] button) {
		this.button = button;
	}
	public Image[] getImg() {
		return img;
	}

	public void setImg(Image[] img) {
		this.img = img;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	private void init() {
		pnl = new JPanel(new GridLayout(5,4));
		button = new JButton[imgName.length];
		img = new Image[imgName.length];
	}
	private void setDisplay() {
		for (int i = 0; i < button.length; i++) {
			img[i] = Toolkit.getDefaultToolkit().getImage(imgName[i] + ".jpg");

			button[i] = new JButton(new ImageIcon(imgName[i] + ".jpg"));
			button[i].setBorder(new LineBorder(Color.WHITE));
			pnl.add(button[i]);
		}
		add(pnl, BorderLayout.CENTER);
	}
	private void addListeners() {
			MouseAdapter listener = new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent me) {
					JButton src = (JButton)me.getSource();
					src.setBorder(new LineBorder(Color.GREEN));

					for (int i = 0; i < button.length; i++) {
						button[i].setToolTipText("click the " + imgName[i]);
					}
				}
				@Override
				public void mouseExited(MouseEvent me) {
					JButton src = (JButton)me.getSource();
						src.setBorder(new LineBorder(Color.WHITE));
				}
			};
			for (int i = 0; i < button.length; i++) {
				int num = i;
				button[i].addMouseListener(listener);

				button[i].addActionListener((ae)-> {
					new FruitsImage(Fruits.this, num);
				});
			}
		}

	private void showFrame() {
		setTitle("Viewer");
		setSize(370, 370);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String[] args) {
		new Fruits();
	}

}
