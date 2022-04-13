package chapter6.movingball;

/** BounceController - 상자 안에서 움직이는 두개의 공 제어 */
public class BounceControllers { 
	private MovingBall ball1;  // 공 객체 1 (Model)
	private MovingBall ball2;  // 공 객체 2 (Model)
	private AnimationWriters writer; // 애니메이션 객체 (Output-View)

	/** Constructor BounceController 컨트롤러 초기화 
	 * @param b1 - 공 객체 1 (Model)
	 * @param b2 - 공 객체 2 (Model)
	 * @param w - 애니메이션 객체 (Output-View)  */
	public BounceControllers(MovingBall b1, MovingBall b2, AnimationWriters w) { 
		ball1 = b1;
		ball2 = b2;
		writer = w;
	}

	/** runAnimation - 내부 시계를 활용하여 애니메이션 구동 */
	public void runAnimation() { 
		int time_unit = 1;    // 애니메이션 스텝의 시간 단위 
		int painting_delay = 20;  // 다시 그리기 사이의 지연 시간 간격
		while (true) { 
			delay(painting_delay);
            ball1.move(time_unit);
            ball2.move(time_unit);
            double d =
            	Math.sqrt(Math.pow(ball1.xPosition() - ball2.xPosition(), 2) +
            			Math.pow(ball1.yPosition() - ball2.yPosition(), 2));
            int sum_of_radius = ball1.radiusOf() + ball2.radiusOf();
            if (d <= sum_of_radius) {
    			System.out.println("Boom!");
    			System.exit(1);
    		}
            System.out.println(ball1.xPosition() + ", " + ball1.yPosition());
            System.out.println(ball2.xPosition() + ", " + ball2.yPosition());
            writer.repaint();
        }
	}

	/** delay - how_long millisecond 동안 실행 정지  */
	private void delay(int how_long) { 
		try { Thread.sleep(how_long); }
		catch (InterruptedException e) { }
	}
}

