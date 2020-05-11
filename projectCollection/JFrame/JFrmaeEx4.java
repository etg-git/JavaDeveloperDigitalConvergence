package 국비;

import java.awt.*;
import javax.swing.*;

class JFrameEx4 {
	public static void main(String[] args)	{
		JFrame f = new JFrame("메롱");
		f.setSize(300, 300);
		// 중앙에 온다....야매
		f.setLocationRelativeTo(null);
		// 크기변경 불가
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
