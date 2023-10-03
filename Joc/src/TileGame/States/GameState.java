package TileGame.States;

import TileGame.Entities.Creature.Player;
import TileGame.Entities.Statics.Carrot;
import TileGame.Game;
import TileGame.Handler;
import TileGame.Tiles.Tile;
import TileGame.UI.ClickListener;
import TileGame.UI.UIManager;
import TileGame.UI.UIimageButton;
import TileGame.Worlds.World;
import TileGame.gfx.Assets;

import java.awt.*;

public class GameState extends State {      // Implementeaza/controleaza jocul.

    //private Player player;      // Referinta catre obiectul animat erou (controlat de utilizator).
    private World world;        // Referinta catre harta curenta

    public GameState(Handler handler)       // Constructorul de initializare al clasei
    {
        ///Apel al constructorului clasei de baza
        super(handler);

        ///Construieste harta jocului
        world = new World(handler, "res/worlds/world1.txt");
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        handler.setWorld(world);
        //Construiește eroul
        //player = new Player(handler, 40,735);

    }

    @Override
    public void tick() {
        // Actualizeaza starea curenta a jocului.
        world.tick();
        //player.tick();
    }

    @Override
    public void render(Graphics g) {
        // Deseneaza (randeaza) pe ecran starea curenta a jocului.
        world.render(g);
        //player.render(g);
    }
}
