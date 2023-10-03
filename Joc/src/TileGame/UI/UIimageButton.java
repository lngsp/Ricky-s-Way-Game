package TileGame.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIimageButton extends UIObject{
    // clasa pentru a seta Imaginea butonului

    private BufferedImage images;
    private ClickListener clicker;

    public UIimageButton(float x, float y, int width, int height, BufferedImage images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
            g.drawImage(images,(int)x, (int)y, width, height, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
