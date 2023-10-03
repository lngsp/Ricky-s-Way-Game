package TileGame;

import TileGame.Display.Display;
import TileGame.Entities.Creature.Enemy;
import TileGame.Input.KeyManager;
import TileGame.Input.MouseManager;
import TileGame.States.*;
import TileGame.gfx.Assets;
import TileGame.gfx.GameCamera;
import TileGame.gfx.ImageLoader;
import TileGame.gfx.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game implements Runnable {
    private Display display;       // Fereastra in care se va desena tabla jocului
   private int width, height;
    public String title;

    private boolean running = false;    // Flag ce starea firului de executie.
    private Thread thread;           // Referinta catre thread-ul de update si draw al ferestrei

    private BufferStrategy bs;      //  Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/
    private Graphics g;         // Referinta catre un context grafic.

    //States
    public State gameState;       //Referinta catre joc
    public State menuState;        // Referinta catre menu
    public State helpState;
    public State gameOver;
    public State gameState2;

    //Input
    private KeyManager keyManager;      //Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului.
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;        //Referinta catre un obiect a carui sarcina este doar de a retine diverse referinte pentru a fi usor accesibile.

    public Game(String title, int width, int height) {

        /*

        Constructor de initializare al clasei Game.

        Acest constructor primeste ca parametri titlul ferestrei, latimea si inaltimea
        acesteia avand in vedere ca fereastra va fi construita/creata in cadrul clasei Game.

         */
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){
        //  Metoda construieste fereastra jocului, initializeaza aseturile, listenerul de tastatura etc.

        display = new Display(title, width, height);    // Este construita fereastra grafica.
        display.getFrame().addKeyListener(keyManager);  //Sa ataseaza ferestrei managerul de tastatura pentru a primi evenimentele furnizate de fereastra.
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();                                  //Se incarca toate elementele grafice (dale)

        handler = new Handler(this);               //Se construieste obiectul de tip shortcut ce va retine o serie de referinte catre elementele importante din program.
        gameCamera = new GameCamera(handler,0,0);

        ///Definirea starilor programului
        gameState = new GameState(handler);
        gameState2 = new GameState2(handler);
        menuState = new MenuState(handler);
        helpState=new HelpState(handler);
        gameOver = new GameOver(handler);
        ///Seteaza starea implicita cu care va fi lansat programul in executie
        //State.setState(gameState);
        State.setState(menuState);
    }

    private void tick()
    {
        keyManager.tick();

        if(State.getState()!=null)
            State.getState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0, 0, width, height);

        //Draw Here
        if(State.getState()!=null)
            State.getState().render(g);


        //End Drawing
        bs.show();
        g.dispose();
    }

    public void run() {     //Functia ce va rula in thread-ul creat.
        init();     // Initializeaza obiectul game

        /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
        /// sau mai bine spus de 60 ori pe secunda.

        int fps = 60;           //Constanta intreaga initializata cu numarul de frame-uri pe secunda
        double timePerTick = 1000000000/fps;        //Durata unui frame in nanosecunde
        double delta = 0;
        long now;           // Retine timpul curent de executie.
        long lastTime = System.nanoTime();      //Retine timpul in nanosecunde aferent frame-ului anterior
        long timer = 0;
        int ticks = 0;

        // Atat timp timp cat threadul este pornit Update() & Draw()
        while(running){
            now = System.nanoTime();            //   /// Se obtine timpul curent
            delta += (now-lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                ticks =0;
                timer =0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public synchronized void start()
    {
       // Creaza si starteaza firul separat de executie (thread).
        if(running)
            return;
        running=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        //Opreste executie thread-ului.
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





/*! \class Game
    \brief Clasa principala a intregului proiect. Implementeaza Game - Loop (Update -> Draw)

                ------------
                |           |
                |     ------------
    60 times/s  |     |  Update  |  -->{ actualizeaza variabile, stari, pozitii ale elementelor grafice etc.
        =       |     ------------
     16.7 ms    |           |
                |     ------------
                |     |   Draw   |  -->{ deseneaza totul pe ecran
                |     ------------
                |           |
                -------------
    Implementeaza interfata Runnable:

        public interface Runnable {
            public void run();
        }

    Interfata este utilizata pentru a crea un nou fir de executie avand ca argument clasa Game.
    Clasa Game trebuie sa aiba definita metoda "public void run()", metoda ce va fi apelata
    in noul thread(fir de executie). Mai multe explicatii veti primi la curs.

    In mod obisnuit aceasta clasa trebuie sa contina urmatoarele:
        - public Game();            //constructor
        - private void init();      //metoda privata de initializare
        - private void update();    //metoda privata de actualizare a elementelor jocului
        - private void draw();      //metoda privata de desenare a tablei de joc
        - public run();             //metoda publica ce va fi apelata de noul fir de executie
        - public synchronized void start(); //metoda publica de pornire a jocului
        - public synchronized void stop()   //metoda publica de oprire a jocului
 */