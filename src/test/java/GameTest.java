import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test
    public void testPlayerOneWin() throws NotRegisteredException {


        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 40);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("PlayerName1", "PlayerName2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerTwoWin() throws NotRegisteredException {

        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 60);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("PlayerName1", "PlayerName2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAllPlayerWin() throws NotRegisteredException {

        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("PlayerName1", "PlayerName2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerOneUnregistered() {

        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 50);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("PlayerName1", "PlayerName2");
        });
    }

    @Test
    public void testPlayerTwoUnregistered() {

        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 50);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("PlayerName1", "PlayerName2");
        });
    }

    @Test
    public void testAllPlayerUnregistered() {

        Player player1 = new Player(001, "PlayerName1", 50);
        Player player2 = new Player(002, "PlayerName2", 50);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("PlayerName1", "PlayerName2");
        });
    }

    @Test
    public void testGetIdPlayer() {

        Player player1 = new Player(001, "PlayerName1", 50);

        int actual = player1.getId();
        int expected = 001;
    }

}