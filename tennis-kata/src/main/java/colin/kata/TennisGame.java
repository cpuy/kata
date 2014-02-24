package colin.kata;

import static colin.kata.TennisPoint.FIFTEEN;
import static colin.kata.TennisPoint.LOVE;


public class TennisGame {

	private Score score = new Score(LOVE, LOVE);
	
	public Score getScore() {
		return score;
	}

	public void playerOneWinBall() {
		score = new Score(FIFTEEN, LOVE);
	}

}
