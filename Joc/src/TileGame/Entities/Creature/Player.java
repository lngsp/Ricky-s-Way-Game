package TileGame.Entities.Creature;

import TileGame.Entities.Entity;
import TileGame.Entities.EntityManager;
import TileGame.Handler;
import TileGame.Inventory.Inventory;
import TileGame.States.State;
import TileGame.gfx.Animation;
import TileGame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Player extends Creature
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */


public class Player extends Creature {

    //Animation
    private Animation animLeft; //Animations to Left
    private Animation animRight; //Animations to Right
    private Animation animDownUp; //Animations to Down

    //Attack timer
    private long lastAttackTimer, attackCooldown = 100,attackTimer = attackCooldown;

    protected boolean active = true;

    //Inventory
    private Inventory inventory;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 26;
        bounds.y = 41;
        bounds.height = 30;
        bounds.width = 30;

        //Animations
        animLeft = new Animation(500, Assets.playerLeft);
        animRight = new Animation(500, Assets.playerRight);
        animDownUp = new Animation(500, Assets.playerDownUp);

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {        // Actualizeaza pozitia si imaginea eroului.
        //Animations
        animLeft.tick();
        animRight.tick();
        animDownUp.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);   // centreaza camera pe eroul acesta

        //Attack
        checkAttacks();

        //Inventory
        inventory.tick();

        checkCollisions();

        checkFlag();
    }

    private void checkAttacks() {   // Atacul asupra fructelor + coleziuni
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        if (inventory.isActive())
            return;

        Rectangle cb = getCollisionBounds(0, 0);         //collision bounds
        Rectangle ar = new Rectangle();
        int arSize = 40;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().up && handler.getKeyManager().space) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().down && handler.getKeyManager().space) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().left && handler.getKeyManager().space) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().right && handler.getKeyManager().space) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else
            return;

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals((this)))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(ar)) {    // daca intersecteaza un fruct
                e.hurt(1);
                return;
            }
        }

    }

    public void hurt(int amt){
        health -= amt;
        if(health <= 0)
            active = false;
        die();
        State.setState(handler.getGame().gameOver);     // afisare Game Over
    }

    public void die(){
        System.out.println("You lose");
    }

    private void getInput() {       // Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
        xMove = 0;
        yMove = 0;

        if(inventory.isActive())    // daca inventprul este activ atunci playerul nu se poate muta !!
            return;
        if (handler.getKeyManager().up)
            yMove = -speed;
        if (handler.getKeyManager().down)
            yMove = speed;
        if (handler.getKeyManager().left)
            xMove = -speed;
        if (handler.getKeyManager().right)
            xMove = speed;
    }


    @Override
    public void render(Graphics g) {    //  Randeaza/deseneaza eroul in noua pozitie.

        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        /*
        g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
         */


    }

    public void postRender(Graphics g){

        //Inventory
        inventory.render(g);
    }


    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {   //MovingLeft
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {    // Moving up
            return animDownUp.getCurrentFrame();
        } else  {    // Moving up
            return animDownUp.getCurrentFrame();
        }
    }

    public void checkCollisions() {     //  verificare coleziuni cu inamicul
        ArrayList<Enemy> enemies = EntityManager.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            if (getBounds().intersects(tempEnemy.getBounds())) {
                //EntityManager.removeEnemy(tempEnemy);
                hurt(1);
                return;
            }
        }
    }

    public void checkFlag(){
        ArrayList<Flag> flags = EntityManager.getFlags();
        for (int i = 0; i < flags.size(); i++) {
            Flag tempFlag = flags.get(i);
            if (getBounds().intersects(tempFlag.getBounds())) {
                State.setState(handler.getGame().gameState2);   // trecere la nivelul 2 atunci cand ajunge la steag
            }
        }
    }

    public Rectangle getBounds(){
        return new Rectangle((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
    }


    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

}
