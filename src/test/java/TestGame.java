import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    Game game = new Game();
    Player player1 = new Player(17,"Elena",23);
    Player player2 = new Player(2, "Elina", 66);
    Player player3 = new Player(2, "John", 23);

    @BeforeEach
    public void setup(){
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }
    @Test
    public void testFirstWin(){
        int expected = 1;
        int actual = game.round("Elina", "John");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSecondWin(){
        int expected = 2;
        int actual = game.round("Elena", "Elina");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testEquals(){
        int expected = 0;
        int actual = game.round("Elena", "John");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testNoPlayer1(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Anya", "Elena");
        });
    }
    @Test
    public void testNoPlayer2(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Elena", "Nika");
        });
    }
    @Test
    public void testNoPlayers(){
        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Nika", "Lina");
        });
    }
}
