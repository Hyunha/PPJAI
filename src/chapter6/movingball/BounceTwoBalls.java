package chapter6.movingball;

import java.awt.*;

/** BounceTheBall - 애니메이션 객체를 생성하고 공 운동 시작 */
public class BounceTwoBalls { 
	public static void main(String[] args) { 
		// 모델 객체 생성 
		int box_size = 200;
		int balls_radius = 15;
		Box box = new Box(box_size);
		// 공을 상자의 적절한 위치에 둠 
		MovingBall ball1 = new MovingBall((int)(box_size / 3.0),
                                          (int)(box_size / 5.0),
                                          5, 2,
                                          balls_radius, box);
		MovingBall ball2 = new MovingBall((int)(box_size / 5.0),
                					 	  (int)(box_size / 2.0),
                					 	  2, 5,
                					 	  balls_radius, box);
		BallWriter ball_writer1 = new BallWriter(ball1, Color.red);
		BallWriter ball_writer2 = new BallWriter(ball2, Color.blue);
		BoxWriter box_writer  = new BoxWriter(box);
		AnimationWriters writer = new AnimationWriters(box_writer, ball_writer1, ball_writer2, box_size);
		// 컨트롤러 객체를 생성하고 애니메이션 시작 
		new BounceControllers(ball1, ball2, writer).runAnimation();
	}
}

