package colin.kata;

import static colin.kata.TennisPoint.DEUCE;
import static colin.kata.TennisPoint.FOURTY;
import static colin.kata.TennisPoint.LOVE;


public class TennisGame {

	private TennisPoint playerOnePoint = LOVE;
	private TennisPoint playerTwoPoint = LOVE;
	
	public Score getScore() {
		if (isDeuce()) {
			return new Score(DEUCE, DEUCE);
		}
		return new Score(playerOnePoint, playerTwoPoint);
	}

	private boolean isDeuce() {
		return playerOnePoint.equals(FOURTY) && playerTwoPoint.equals(FOURTY);
	}

	public TennisGame playerOneWinBall() {
		playerOnePoint = playerOnePoint.increment();
		return this;
	}

	public TennisGame playerTwoWinBall() {
		playerTwoPoint = playerTwoPoint.increment();
		return this;
	}
	
}
