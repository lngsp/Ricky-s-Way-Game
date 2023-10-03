package TileGame;

import TileGame.Input.KeyManager;
import TileGame.Input.MouseManager;
import TileGame.Worlds.World;
import TileGame.Worlds.World2;
import TileGame.gfx.GameCamera;

/*! \class public class Handler
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.

    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */

public class Handler {

    private Game game;      // Referinta catre obiectul Game
    private World world;    // Referinta catre obiectul hartă / lume curentă
    private World2 world2;

    public Handler(Game game) {
        //Constructorul de initializare al clasei.
        this.game = game;
    }

    public GameCamera getGameCamera() {
        // Returneaza referinta catre managerul evenimentelor de cameră.
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        // Returneaza referinta catre managerul evenimentelor de tastatura.
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public int getWidth() {
        //Returneaza lățimea ferestrei jocului.
        return game.getWidth();
    }

    public int getHeight() {
        //Returneaza inaltimea ferestrei jocului.
        return game.getHeight();
    }

    public Game getGame() {
        //Intoarce referinta catre obiectul Game.
        return game;
    }

    public void setGame(Game game) {
        //Seteaza referinta catre un obiect Game
        this.game = game;
    }

    public void setWorld(World world) {
        //Seteaza referinta catre harta curenta.
        this.world = world;
    }

    public World getWorld() {
        //Intoarce referinta catre harta curenta.
        return world;
    }

    public World2 getWorld2() {
        return world2;
    }

    public void setWorld2(World2 world2) {
        this.world2 = world2;
    }

}