package colin.kata;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Score {

	private TennisPoint playerOnePoints;
	private TennisPoint playerTwoPoints;

	public Score(TennisPoint playerOnePoints, TennisPoint playerTwoPoints) {
		this.playerOnePoints = playerOnePoints;
		this.playerTwoPoints = playerTwoPoints;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Score) {
			Score other = (Score) obj;
			return new EqualsBuilder().append(playerOnePoints, other.playerOnePoints)
					.append(playerTwoPoints, other.playerTwoPoints).isEquals();
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(playerOnePoints).append(playerTwoPoints)
				.toString();
	}
}
