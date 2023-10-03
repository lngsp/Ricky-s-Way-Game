package TileGame.Items;

import TileGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;  // lista de itemi

    public ItemManager(Handler handler){
        this.handler= handler;
        items = new ArrayList<Item>();
    }

    public void tick(){
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {  // cat timp avem itemi
            Item i = it.next();
            i.tick();
            if (i.isPickedUp()) {
                it.remove();
            }
        }
    }

    public void render(Graphics g){
        for(Item i : items){
            i.render(g);
        }
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }


    // GETTERS AND SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
