package chapter5.lab;

import javax.swing.*;

public class Dealer {
	
	public void dealDiceGame(Player p1, Player p2, GameBoard b, Registrar r) {		
		// 차례 정하기 
		// 누적 점수가 낮은 쪽이 선공 
		Player first, second;
		if (p1.points() < p2.points()) {
			first = p1; second = p2;
		}
		else if (p1.points() > p2.points()) {
			first = p2; second = p1;
		}
		// 동점이면 동전 던지기
		else if ((int)(Math.random() * 2) == 0) {
			first = p1; second = p2;
		}
		else {
			first = p2; second = p1;
		}
		// JOptionPane.showMessageDialog(null, first.name()+" 먼저 굴립니다.");
		// 주사위 굴리기 
		first.play(new Dice());
		second.play(new Dice());
		// 승패 결정, 디스프레이 
		Dice d1 = first.rolled();
		Dice d2 = second.rolled();
		if (d1.twin() && d2.twin()) {
			if (d1.sum() > d2.sum())
				beats(first, second, b);
			else if (d1.sum() < d2.sum())
				beats(second, first, b);
			else
				b.repaint();
		}
		else if (d1.twin())
			beats(first, second, b);
		else if (d2.twin())
			beats(second, first, b);
		else {
			if (d1.sum() > d2.sum())
				beats(first, second, b);
			else if (d1.sum() < d2.sum())
				beats(second, first, b);
			else if (d1.difference() < d2.difference())
				beats(first, second, b);
			else if (d1.difference() > d2.difference())
				beats(second, first, b);
			else
				b.repaint();
		}

		if (r.wantToContnue() == 0) {
			p1.reset(); 
			p2.reset();
			this.dealDiceGame(p1, p2, b, r);
		}
		else
			System.exit(0);

	}
	
	private void beats(Player p1, Player p2, GameBoard b)  {
		p1.receivePoint();
		b.repaint();
	}

}
