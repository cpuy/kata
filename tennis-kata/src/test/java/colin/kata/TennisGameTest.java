package colin.kata;

import static colin.kata.TennisPoint.DEUCE;
import static colin.kata.TennisPoint.FIFTEEN;
import static colin.kata.TennisPoint.FOURTY;
import static colin.kata.TennisPoint.LOVE;
import static colin.kata.TennisPoint.THIRTY;
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
	
	@Test
	public void score_should_be_Love_Fifteen_if_player_two_win_first_ball() throws Exception {
		TennisGame game = new TennisGame();

		game.playerTwoWinBall();

		assertThat(game.getScore()).isEqualTo(new Score(LOVE, FIFTEEN));
	}
	
	@Test
	public void score_should_be_Thirty_when_player_wins_two_balls() throws Exception {
		TennisGame game = new TennisGame();

		game.playerTwoWinBall()
			.playerTwoWinBall();

		assertThat(game.getScore()).isEqualTo(new Score(LOVE, THIRTY));
	}
	
	@Test
	public void score_should_be_Fourty_when_player_wins_three_balls() throws Exception {
		TennisGame game = new TennisGame();

		game.playerOneWinBall()
			.playerOneWinBall()
			.playerOneWinBall();

		assertThat(game.getScore()).isEqualTo(new Score(FOURTY, LOVE));
	}
	
	@Test
	public void score_should_be_Deuce_if_players_have_both_Fourty() throws Exception {
		TennisGame game = new TennisGame();
		
		game.playerOneWinBall().playerOneWinBall().playerOneWinBall();
		game.playerTwoWinBall().playerTwoWinBall().playerTwoWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(DEUCE, DEUCE));
	}
}
