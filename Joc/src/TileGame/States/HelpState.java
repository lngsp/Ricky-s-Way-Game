package TileGame.States;

import TileGame.Handler;
import TileGame.UI.ClickListener;
import TileGame.UI.UIManager;
import TileGame.UI.UIimageButton;
import TileGame.gfx.Assets;

import java.awt.*;

public class HelpState extends State{

    private UIManager uiManager;

    public HelpState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);

        uiManager.addObject((new UIimageButton(300, 200, 150, 77, Assets.start_button, new ClickListener() {
            // butonul de start care porneste jocul
            @Override
            public void onClick() {
                State.setState(handler.getGame().menuState);
            }
        })));

        uiManager.addObject(new UIimageButton(750, 10, 40, 40, Assets.quit_button, new ClickListener() {
            // butonul pentru a inchide jocul
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(0);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.helpImage, 0, 0, 800, 690, null);

        uiManager.render(g);

    }
}
