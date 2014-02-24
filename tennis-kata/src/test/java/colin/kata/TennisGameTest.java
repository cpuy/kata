package colin.kata;

import static colin.kata.TennisPoint.FIFTEEN;
import static colin.kata.TennisPoint.LOVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

	@Test
	public void should_start_with_Love_Love_score() throws Exception {
		TennisGame game = new TennisGame();

		assertThat(game.getScore()).isEqualTo(new Score(LOVE, LOVE));
	}
	
	@Test
	public void score_should_be_Fifteen_Love_if_player_one_win_first_ball() throws Exception {
		TennisGame game = new TennisGame();

		game.playerOneWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(FIFTEEN, LOVE));
	}
}
