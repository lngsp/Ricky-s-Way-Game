package TileGame.States;

import TileGame.Game;
import TileGame.Handler;
import TileGame.UI.ClickListener;
import TileGame.UI.UIManager;
import TileGame.UI.UIimageButton;
import TileGame.gfx.Assets;

import java.awt.*;

public class MenuState extends State{
    //Implementeaza notiunea de menu pentru joc.

    private UIManager uiManager;

    public MenuState(Handler handler) {
        //Constructorul de initializare al clasei.

        super(handler);     // //Apel al constructorului clasei de baza.
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIimageButton(300, 200, 150, 77, Assets.start_button, new ClickListener() {
            // butonul de start care porneste jocul
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));


        uiManager.addObject(new UIimageButton(750, 10, 40, 40, Assets.quit_button, new ClickListener() {
            // butonul pentru a inchide jocul
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(0);
            }
        }));

        uiManager.addObject(new UIimageButton(300, 300, 150, 60, Assets.help_button, new ClickListener() {
            // butonul pentru informatii
            @Override
            public void onClick() {
                State.setState(handler.getGame().helpState);
            }
        }));


    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        //Deseneaza (randeaza) pe ecran starea curenta a meniului.
        g.drawImage(Assets.menuImage, 0, 0, 800, 690, null);
        uiManager.render(g);
    }
}
