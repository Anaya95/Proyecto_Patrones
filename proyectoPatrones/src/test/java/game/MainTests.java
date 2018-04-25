package game;

import logic.Game;
import logic.Items;
import logic.DataManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Test
	public void currentGameTestingPlayerMovement() {
		Game currentGame = new Game(1);
		Assert.assertEquals(8,currentGame.getPlayer().getXCoord());
		Assert.assertEquals(12,currentGame.getPlayer().getYCoord());

		currentGame.movePlayer('w');

		Assert.assertEquals(7,currentGame.getPlayer().getXCoord());
		Assert.assertEquals(12,currentGame.getPlayer().getYCoord());

		currentGame.movePlayer('a');
		Assert.assertEquals(7,currentGame.getPlayer().getXCoord());
		Assert.assertEquals(11,currentGame.getPlayer().getYCoord());

		currentGame.movePlayer('s');
		Assert.assertEquals(8,currentGame.getPlayer().getXCoord());
		Assert.assertEquals(11,currentGame.getPlayer().getYCoord());

		currentGame.movePlayer('d');
		Assert.assertEquals(8,currentGame.getPlayer().getXCoord());
		Assert.assertEquals(12,currentGame.getPlayer().getYCoord());
	}

	@Test
	public void currentGameTestingPlayerBehavior() {
		Game currentGame = new Game(1);
		Assert.assertEquals(80,currentGame.getPlayer().getLife());

		currentGame.getPlayer().pickItem('♥');
		Assert.assertEquals(Items.LIFE,currentGame.getPlayer().getItems().get(0));

		currentGame.getPlayer().pickItem('ΰ');
		Assert.assertEquals(Items.BOAT,currentGame.getPlayer().getItems().get(1));

		currentGame.getPlayer().pickItem('φ');
		Assert.assertEquals(Items.SWORD,currentGame.getPlayer().getItems().get(2));

		currentGame.getPlayer().pickItem('Ų');
		Assert.assertEquals(Items.TORCH,currentGame.getPlayer().getItems().get(3));

	}

	@Test
	public void currentGameTestingLoadingData() {
		DataManager testingData = new DataManager();
		Assert.assertTrue(testingData.login("testnotEmpty","testPwdNotEmpty"));

		/*Este test no va a pasar porque en MultiUser.login no hay validacion para string vacios*/
		Assert.assertFalse(testingData.login("",""));

		/*Arreglado*/

	}

}
