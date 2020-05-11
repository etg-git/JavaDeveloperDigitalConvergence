package 국비;

import java.awt.*;
import javax.swing.*;
/*
	(400, 300) 크기를 가지는 창을 화면 중앙에 위치시키시오.
*/
class JFrameEx3 {
	public static void main(String[] args)	{
		JFrame f = new JFrame("정중앙");
		f.setSize(400, 300);
		// 크기지정 후 이동
		MyUtils.goCenter(f);
		// 전체화면 -> 크기를 설정하고 적용
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
