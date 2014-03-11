package colin.kata;

import static colin.kata.TennisPoint.DEUCE;
import static colin.kata.TennisPoint.FOURTY;
import static colin.kata.TennisPoint.LOVE;

public class TennisGame {

	private TennisPoint playerOnePoint = LOVE;
	private TennisPoint playerTwoPoint = LOVE;

	public Score getScore() {
		return new Score(playerOnePoint, playerTwoPoint);
	}

	public TennisGame playerOneWinBall() {
		playerOnePoint = playerOnePoint.increment();
		checkIfDeuce();
		return this;
	}

	public TennisGame playerTwoWinBall() {
		playerTwoPoint = playerTwoPoint.increment();
		checkIfDeuce();
		return this;
	}

	private void checkIfDeuce() {
		if (isDeuce()) {
			playerOnePoint = DEUCE;
			playerTwoPoint = DEUCE;
		}
	}

	private boolean isDeuce() {
		return playerOnePoint.equals(FOURTY) && playerTwoPoint.equals(FOURTY);
	}
}
