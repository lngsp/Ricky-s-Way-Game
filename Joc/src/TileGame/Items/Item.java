package TileGame.Items;

import TileGame.Game;
import TileGame.Handler;
import TileGame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    public static Item[] items = new Item[256];     // itemi
    public static Item carrotItem = new Item(Assets.carrot, "Morcov", 0);
    public static Item rosieItem = new Item(Assets.rosie, "Rosie", 1);
    public static Item capsunaItem = new Item(Assets.capsuna, "Capsuna", 2);
    public static Item ardelItem = new Item(Assets.ardel, "Ardel", 3);
    public static Item cireseItem = new Item(Assets.cirese, "Cirese", 4);
    public static Item bananaItem = new Item(Assets.banana, "Banana", 5);

    //CLASS

    public static final int ITEMWIDTH = 41, ITEMHEIGHT = 41;    // dimensiuni itemi

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;


    protected Rectangle bounds;

    protected int x, y, count;

    protected boolean pickedUp = false;

    public Item(BufferedImage texture, String name, int id){
        this.texture =  texture;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);

        items[id] = this;
    }

    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

    public void render(Graphics g){
        if(handler == null)
            return;
        render(g,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
    }

    public Item createNew(int count){
        Item i = new Item(texture, name, id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }

    public Item createNew(int x, int y){
        Item i = new Item(texture, name, id);
        i.setPosition(x,y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    //GETTERS AND SETTERS


    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public BufferedImage getTexture() {
        return texture;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getId() {
        return id;
    }
    public boolean isPickedUp() {
        return pickedUp;
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
