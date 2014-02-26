package colin.kata;

import static colin.kata.TennisPoint.LOVE;


public class TennisGame {

	private TennisPoint playerOnePoint = LOVE;
	private TennisPoint playerTwoPoint = LOVE;
	
	public Score getScore() {
		return new Score(playerOnePoint, playerTwoPoint);
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
