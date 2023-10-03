package TileGame.States;

import TileGame.Handler;
import TileGame.UI.ClickListener;
import TileGame.UI.UIManager;
import TileGame.UI.UIimageButton;
import TileGame.gfx.Assets;

import java.awt.*;

public class GameOver extends State{

    private UIManager uiManager;

    public GameOver(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gameOver, 0, 0, 800, 690, null);
        // deseneaza pe ecran imaginea game over

    }
}
