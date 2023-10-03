package TileGame.States;

import TileGame.Handler;
import TileGame.Worlds.World2;

import java.awt.*;

public class GameState2 extends State {      // Implementeaza/controleaza jocul.

    private World2 world2;        // Referinta catre harta curenta

    public GameState2(Handler handler)       // Constructorul de initializare al clasei
    {
        ///Apel al constructorului clasei de baza
        super(handler);

        ///Construieste harta jocului
        world2 = new World2(handler, "res/worlds/world2.txt");
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        handler.setWorld2(world2);
        //Construiește eroul
        //player = new Player(handler, 40,735);

    }

    @Override
    public void tick() {
        // Actualizeaza starea curenta a jocului.
        world2.tick();
        //player.tick();
    }

    @Override
    public void render(Graphics g) {
        // Deseneaza (randeaza) pe ecran starea curenta a jocului.
        world2.render(g);
        //player.render(g);
    }
}
