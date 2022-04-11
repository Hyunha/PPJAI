package chapter5.lab;

import java.awt.*;
import javax.swing.*;

public class GameBoard extends JPanel {
	
	private int size = 300;
	private Player player1, player2;
	
	public GameBoard(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
		JFrame f = new JFrame();
		f.setTitle("주사위 게임");
		f.setSize(size, size);
		f.getContentPane().add(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, size, size);
		g.setColor(Color.black);
		g.drawString(player1.name(), 80, 100);
		g.drawString(player2.name(), 200, 100);
		g.drawString(Integer.toString(player1.points()), 80, 130);
		g.drawString(Integer.toString(player2.points()), 200, 130);
		if (player1.wins())
			g.drawString("이겼다!", 80, 160);
		else if (player2.wins())
			g.drawString("이겼다!", 200, 160);
		else {
			g.drawString("비겼다!", 140, 160);
		}
		g.drawString(Integer.toString(player1.rolled().face1()), 80, 190);
		g.drawString(Integer.toString(player1.rolled().face2()), 110, 190);
		g.drawString(Integer.toString(player2.rolled().face1()), 200, 190);
		g.drawString(Integer.toString(player2.rolled().face2()), 230, 190);
	}
	
	/*
	public void display(Player winner, Player loser) {
		displayDice(winner);
		displayDice(loser);
		System.out.println("승자 = " + winner.name());
		System.out.println(winner.name() + " 누적 점수 = " + winner.points());
		System.out.println(loser.name() + " 누적 점수 = " + loser.points());
	}
	
	public void displayDraw(Player p1, Player p2) {
		displayDice(p1);
		displayDice(p2);
		System.out.println("비겼습니다.");
		System.out.println(p1.name() + " 누적 점수 = " + p1.points());
		System.out.println(p2.name() + " 누적 점수 = " + p2.points());
	}
	
	private void displayDice(Player p) {
		Dice dice_rolled;
		dice_rolled = p.rolled();
		System.out.println(dice_rolled.face1() + ", " + dice_rolled.face2());
	}
	*/


}
