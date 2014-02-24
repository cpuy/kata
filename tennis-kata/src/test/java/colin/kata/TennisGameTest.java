package colin.kata;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisGameTest {

	@Test public void 
	should_start_with_Love_Love_score() throws Exception {
		TennisGame game = new TennisGame();
		
		assertThat(game.getScore()).isEqualTo(new Score(0, 0));
	}
}
