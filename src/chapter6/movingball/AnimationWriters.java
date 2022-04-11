package chapter6.movingball;

import java.awt.*;
import javax.swing.*;

/** AnimationWriters - 상자와 두 공의 애니메이션 디스플레이 */
public class AnimationWriters extends JPanel { 
	private BoxWriter box_writer;     // 상자 그리는 객체
	private BallWriter ball_writer1;  // 첫째 공 그리는 객체
	private BallWriter ball_writer2;  // 둘째 공 그리는 객체

	/** Constructor AnimationWriters - 상자와 공을 그리는 View 객체를 생성
	 * @param b - 상자 그리는 객체 
	 * @param l1 - 첫째 공 그리는 객체
	 * @param l2 - 둘째 공 그리는 객체
	 * @param size - 프레임의 크기 */
	public AnimationWriters(BoxWriter b, BallWriter l1, BallWriter l2, int size) { 
		box_writer = b;
		ball_writer1 = l1;
		ball_writer2 = l2;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Bounce");
		f.setSize(size, size+22);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/** paintComponent - 공과 상자 그리기 
	 * @param g - 그래픽스 펜 */
	public void paintComponent(Graphics g) { 
		box_writer.paintComponent(g);
		ball_writer1.paintComponent(g);
		ball_writer2.paintComponent(g);
	}
}

