package TileGame.Entities;

import TileGame.Entities.Creature.Enemy;
import TileGame.Entities.Creature.Flag;
import TileGame.Entities.Creature.Player;
import TileGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities; //lista de entitati
    private static ArrayList<Enemy> enemies; // lista de inamici

    private static ArrayList<Flag> flags;

    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Player pLayer){ // constructor
        this.handler = handler;
        this.player = pLayer;
        entities = new ArrayList<Entity>();
        enemies = new ArrayList<Enemy>();
        flags = new ArrayList<Flag>();
        addEntity(player);
        startGame();
    }


    public void tick(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.tick();
            if(!e.isActive())
                it.remove();
        }
        entities.sort(renderSorter);
        for(int i =0; i< enemies.size();i++){
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.tick();
        }
        for(int i = 0; i< flags.size();i++){
            Flag tempFlags = flags.get(i);
            tempFlags.tick();
        }
    }

    public void render(Graphics g){ // randare entități
        for(Entity e : entities){
            e.render(g);
        }
        player.postRender(g);

        // deseneaza inamicii
        for(int i = 0; i <  enemies.size(); i++){
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.render(g);
        }


        for(int i = 0; i< flags.size();i++){
            Flag tempFlags = flags.get(i);
            tempFlags.render(g);
        }

        /*
        Enemy e = new Enemy(handler, 200, 400);
        e.render(g);*/
    }

    public void startGame(){
        // adaugare inamici
            addEnemy(new Enemy(handler,410, 181));
            addEnemy(new Enemy(handler,940, 500));
            addFlag(new Flag(handler, 1150, 700));
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void addEnemy(Enemy e){
        enemies.add(e);
    }

    public void addFlag(Flag e){
        flags.add(e);
    }

    public static void removeEnemy(Enemy e){
        enemies.remove(e);
    }

    // GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }


    public static ArrayList<Flag> getFlags() {
        return flags;
    }

    public static void setFlags(ArrayList<Flag> flags) {
        EntityManager.flags = flags;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
