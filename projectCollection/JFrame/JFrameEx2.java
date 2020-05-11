package 국비;

/*
	아래조건을 만족하는 창을 만드시오.
	1. 창의 타이틀은 "자바좋아" 로 한다.
	2. 창의 크기는 400, 300으로 결정한다.
	3. 창의 위치는 200, 200으로 결정한다.
	4. 창 종료시 현재창만 종료한다.
	5. 창에 아이콘을 설정한다.	
*/
import java.awt.*;
import javax.swing.*;
class JFrameEx2 {
	public static void main(String[] args)	{
		JFrame f = new JFrame("자바좋아");
		f.setIconImage(
			Toolkit.getDefaultToolkit().getImage("icon.png")	
		);
		// x, y, width, height

		// Rectangle r = new Rectangle(200, 200, 400, 300);
		Rectangle r = new Rectangle(
			new Point(200, 200), 
			new Dimension(400, 300)
		);
		f.setBounds(r);
		//f.setSize(400, 300);
		//f.setLocation(200, 200);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
}
