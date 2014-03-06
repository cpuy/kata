package colin.kata;

import static colin.kata.TennisPoint.DEUCE;
import static colin.kata.TennisPoint.FIFTEEN;
import static colin.kata.TennisPoint.FOURTY;
import static colin.kata.TennisPoint.LOVE;
import static colin.kata.TennisPoint.THIRTY;


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
		if (isDeuce()) {
			playerOnePoint = TennisPoint.ADVANTAGE;
			playerTwoPoint = TennisPoint.DEUCE;
		} else {
			playerOnePoint = playerOnePoint.increment();
		}
		return this;
	}

	public TennisGame playerTwoWinBall() {
		playerTwoPoint = compute(playerTwoPoint);
		return this;
	}
	
	private TennisPoint compute(TennisPoint tennisPoint) {
		if (tennisPoint.equals(FIFTEEN)) {
			return THIRTY;
		} else if (tennisPoint.equals(THIRTY)) {
			return FOURTY;
		} else {
			return FIFTEEN;
		}
	}
	
}
