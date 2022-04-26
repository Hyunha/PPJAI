package midterm.glassbead;

public class GameController {
	void playerTurn(Player p, Computer c, Registrar r) {
		System.out.println("* 당신의 공격!");
		int computerPick = c.pickForGuard();
		int playerChoice = r.chooseForAttack(Math.min(c.getBeads(), 5));
		System.out.println("당신은 " + playerChoice + "개의 구슬을 집었습니다.");
		boolean isEven = r.chooseEven();
		if (isEven) {
			System.out.println("당신은 짝을 선택했습니다.");
		} else {
			System.out.println("당신은 홀을 선택했습니다.");
		}
		System.out.println("컴퓨터가 손을 폅니다...");
		System.out.println(computerPick + "개의 구슬입니다!");

		if (isEven == (computerPick % 2 == 0)) {
			System.out.println("당신이 이겼습니다. 구슬 획득! : " + playerChoice);
			c.removeBeads(playerChoice);
			p.addBeads(playerChoice);
		} else {
			System.out.println("당신이 졌습니다. 구슬 제출! : " + playerChoice);
			p.removeBeads(playerChoice);
			c.addBeads(playerChoice);
		}
		System.out.println("당신의 구슬 : " + p.getBeads());
		System.out.println("컴퓨터의 구슬 : " + c.getBeads());
	}

	void computerTurn(Player p, Computer c, Registrar r) {
		System.out.println("* 컴퓨터의 공격!");
		int playerChoice = r.chooseForGuard(Math.min(c.getBeads(), 5));
		System.out.println("당신은 " + playerChoice + "개의 구슬을 집었습니다.");
		int computerPick = c.pickForAttack(p.getBeads());
		System.out.println("컴퓨터가 " + computerPick + "개의 구슬을 집어듭니다...");
		boolean isEven = c.pickEven();
		if (isEven) {
			System.out.println("컴퓨터가 짝을 선택합니다...");
		} else {
			System.out.println("컴퓨터가 홀을 선택합니다...");
		}

		if (isEven == (playerChoice % 2 == 0)) {
			System.out.println("당신이 졌습니다. 구슬 제출! : " + computerPick);
			p.removeBeads(computerPick);
			c.addBeads(computerPick); 
		} else {
			System.out.println("당신이 이겼습니다. 구슬 획득! : " + computerPick);
			c.removeBeads(computerPick);
			p.addBeads(computerPick);
		}
		System.out.println("당신의 구슬 : " + p.getBeads());
		System.out.println("컴퓨터의 구슬 : " + c.getBeads());
	}
	
	void play(Player p, Computer c, Registrar r) {
		System.out.println("* 게임을 시작합니다...");
		System.out.println("당신의 구슬 : " + p.getBeads());
		System.out.println("컴퓨터의 구슬 : " + c.getBeads());
		int counter = 0;
		while (!p.lose() && !c.lose()) {
			if (counter % 2 == 0) {
				playerTurn(p, c, r);
			} else {
				computerTurn(p, c, r);
			}
			counter = counter + 1;
		}
		if (p.lose()) {
			System.out.println("아쉽게도 당신의 패배입니다...");
		} else {
			System.out.println("축하합니다! 당신의 승리입니다!");
		}
	}
}







