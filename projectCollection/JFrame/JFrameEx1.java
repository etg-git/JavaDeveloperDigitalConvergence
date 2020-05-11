package 국비;
/*
	UI 구성요소 : Component
	창 : JFrame, JDialog ...(Swing)
			Frame, Dialog ...(AWT)
*/
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.JFrame;

// awt : 운영체제의 특징을 따라 화면구성. 운영체제에 따라 느낌이 다름
// swing : 자바영역에서 사용하는 look&feel을 적용받아 모든 운영체제에서 동일한 느낌을 제공 
class JFrameEx1 {
	public static void main(String[] args)	{
		JFrame f = new JFrame("이것도 창입니다.");
		
		// 유틸리티 클래스
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 이미지파일 -> Image
		Image img = kit.getImage("icon.png");
		// 이미지 설정
		f.setIconImage(img);
		// f.setTitle("이거슨 창입니다.");

		f.setSize(new Dimension(600, 300));
		// f.setSize(400, 300);
		Dimension size = f.getSize();
		System.out.println(size.width + ", " + size.height);
		// 단위 : 픽셀(해상도에 따라 영향을 받는다)
		Point p = new Point(400, 200);
		f.setLocation(p);
		// f.setLocation(200, 300);
		 Point location = f.getLocation();
		 System.out.println(location.x + ", " + location.y);
		// 종료버튼 동작 정의. 실행방식을 결정짓는 메소드
		/*
			종료버튼 정의 flag
			1. EXIT_ON_CLOSE : JVM종료
			2. DISPOSE_ON_CLOSE : 해당창만 종료(자원해제)
			3. HIDE_ON_CLOSE : 해당창의 가시성 제거(default)
			4. DO_NOTHING_ON_CLOSE : 아무것도 하지않는다.
		*/
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 가시성 부여
		f.setVisible(true);
	}
}
