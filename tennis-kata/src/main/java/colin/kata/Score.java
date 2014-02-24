package colin.kata;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Score {

	private int playerOnePoints;
	private int playerTwoPoints;

	public Score(int playerOnePoints, int playerTwoPoints) {
		this.playerOnePoints = playerOnePoints;
		this.playerTwoPoints = playerTwoPoints;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Score) {
			Score other = (Score) obj;
			return new EqualsBuilder()
					.append(playerOnePoints, other.playerOnePoints)
					.append(playerTwoPoints, other.playerTwoPoints).isEquals();
		} else {
			return false;
		}
	}
}
