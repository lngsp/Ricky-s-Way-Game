package TileGame.Inventory;

import TileGame.Handler;
import TileGame.Items.Item;
import TileGame.gfx.Assets;
import TileGame.gfx.Text;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    // Inventar

    private Handler handler;    //  retine o serie de referinte ale unor elemente pentru a fi usor accesibile.
    private  boolean active = false;    // variabile folosita pentru a vedea daca este activ sau nu inventorul

    private ArrayList<Item> inventoryItems; // lista de itemi pentru inventar

    private int invX = 10, invY = 10, invWidth = 350, invHeight = 250;
    private int invListCenterX = invX + 120;        // centrul (unde se vede elementul selectat)
    private int invListCenterY = invY + invHeight / 2 + 5;
    private int invListSpacing = 19;
    private int invImageX = 280, invImageY = 35, invImageWidth = 41, invImageHeight = 41;   // dimensiune imagine pentru fructe
    private int invCountX = 295, invCountY = 90;
    private int selectedItem = 0;   // item-ul selectat de player


    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        //Test
        //addItem(Item.carrotItem.createNew(5));
        //addItem(Item.ardelItem.createNew(3));
    }

    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Z)){
            active = !active;       // daca este apasata tasta Z se activeaza, altfel se dezactiveaza. trece dintr-o stare in alta
        }
        if(!active){
            return;     // daca nu este activ inventorul nu trece mai departe
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP))
            selectedItem--;     // apasam tasta UP sau DOWN pentru a naviga in inventar
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN))
            selectedItem++;
        if(selectedItem < 0)
            selectedItem = inventoryItems.size() - 1;       // coleziuni
        else if(selectedItem >= inventoryItems.size())
            selectedItem = 0;
    }

    public void render (Graphics g){
        if(!active){
            return;
        }

        g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

        int len = inventoryItems.size();
        if(len == 0)
            return;

        for(int i = -5; i< 6; i++){     // avem 6 linii in inventar
            if(selectedItem + i < 0 || selectedItem + i >= len)
                continue;
            if(i==0){
                Text.drawString(g,"> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.BLUE, Assets.fontText);
            }
            else{
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
                        invListCenterY + i * invListSpacing, true, Color.BLACK, Assets.fontText);
            }
        }
        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.BLACK, Assets.fontText);
    }

    //Inventory methods
    public void addItem(Item item){

        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    //GETTERS AND SETTERS


    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Item> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
