package TileGame;

import TileGame.Display.Display;

public class Launcher {

    public static void main (String[] args)
    {
        Game game = new Game("Ricky's Way", 800,600);
        game.start();
    }
}
