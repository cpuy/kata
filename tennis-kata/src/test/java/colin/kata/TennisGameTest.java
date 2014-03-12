package colin.kata;

import static colin.kata.TennisPoint.ADVANTAGE;
import static colin.kata.TennisPoint.DEUCE;
import static colin.kata.TennisPoint.FIFTEEN;
import static colin.kata.TennisPoint.FOURTY;
import static colin.kata.TennisPoint.LOVE;
import static colin.kata.TennisPoint.THIRTY;
import static colin.kata.TennisPoint.WIN;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisGameTest {

	private TennisGame deuceGame() {
		TennisGame game = new TennisGame();
		game.playerOneWinBall().playerOneWinBall().playerOneWinBall();
		game.playerTwoWinBall().playerTwoWinBall().playerTwoWinBall();
		return game;
	}

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
		TennisGame game = deuceGame();
		
		assertThat(game.getScore()).isEqualTo(new Score(DEUCE, DEUCE));
	}

	@Test
	public void score_should_be_advantage_for_user_winning_ball_on_deuce() throws Exception {
		TennisGame game = deuceGame();
		
		game.playerOneWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(ADVANTAGE, DEUCE));
	}
	
	@Test
	public void score_should_be_deuce_if_user_which_has_not_advantage_win_ball() throws Exception {
		TennisGame game = deuceGame();
		
		game.playerTwoWinBall();
		game.playerOneWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(DEUCE, DEUCE));
	}
	
	@Test
	public void player_win_game_if_he_win_four_balls() throws Exception {
		TennisGame game = new TennisGame();
		
		game.playerOneWinBall().playerOneWinBall().playerOneWinBall().playerOneWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(WIN, LOVE));
	}
	
	@Test
	public void player_win_game_if_he_has_advantage_a_win_the_ball() throws Exception {
		TennisGame game = deuceGame();
		game.playerTwoWinBall();

		game.playerTwoWinBall();
		
		assertThat(game.getScore()).isEqualTo(new Score(DEUCE, WIN));
	}
}
