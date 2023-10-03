package TileGame.Worlds;

import TileGame.Entities.Creature.Player;
import TileGame.Entities.EntityManager;
import TileGame.Entities.Statics.*;
import TileGame.Handler;
import TileGame.Items.ItemManager;
import TileGame.Tiles.Tile;
import TileGame.UI.UIManager;
import TileGame.Utils.Utils;

import java.awt.*;

public class World2 {    // Implementeaza notiunea de harta a jocului.

    private Handler handler;    // O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
    private int width, height;
    private int spawnX, spawnY; // de unde porneste eroul
    private int[][] tiles;      // Referinta catre o matrice cu codurile dalelor ce vor construi harta

    //Entities
    private EntityManager entityManager;

    //Item
    private ItemManager itemManager;

    private UIManager uiManager;

    public World2(Handler handler, String path)
    {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 40,735));
        itemManager = new ItemManager(handler);

        entityManager.addEntity(new Carrot(handler, 55, 600));
        entityManager.addEntity(new Carrot(handler, 55, 320));
        entityManager.addEntity(new Carrot(handler, 45, 60));
        entityManager.addEntity(new Banana(handler, 200, 720));
        entityManager.addEntity(new Banana(handler, 610, 487));
        entityManager.addEntity(new Ardel(handler, 700, 76));
        entityManager.addEntity(new Ardel(handler, 955, 450));
        entityManager.addEntity(new Ardel(handler, 1000, 76));
        entityManager.addEntity(new Cirese(handler, 350, 550));
        entityManager.addEntity(new Cirese(handler, 1155, 220));
        entityManager.addEntity(new Rosie(handler, 315, 163));
        entityManager.addEntity(new Rosie(handler, 1155, 500));
        entityManager.addEntity(new Rosie(handler, 800, 250));
        entityManager.addEntity(new Capsuna(handler, 900, 730));
        entityManager.addEntity(new Capsuna(handler, 1250, 800));

        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void tick(){
        itemManager.tick();
        entityManager.tick();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() /Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);;


        for(int y = yStart;y < yEnd;y++){
            for(int x = xStart;x < xEnd;x++){
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Items
        itemManager.render(g);
        //Entities
        entityManager.render(g);
    }


    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height) // Daca eroul este in afara hartii
            return Tile.soilTile;                      // sta pe sol
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path){        // Functie de incarcare a hartii jocului.
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); //split every single letter
        width = Utils.parseInt(tokens[0]);  // lăţime
        height = Utils.parseInt(tokens[1]); // inaltimea
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);


        tiles = new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y*width + 4)]);    // primele 4 sunt initializate
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler2) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

}
