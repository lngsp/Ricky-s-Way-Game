package TileGame.States;

import TileGame.Game;
import TileGame.Handler;

import java.awt.*;

public abstract class State {


    //Implementeaza notiunea abstracta de stare a jocului/programului.

    ////Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State currentState = null;   //Referinta catre starea curenta a jocului: game, meniu, settings, about etc.

    public static void setState(State state){
        currentState=state;
    }

    public static State getState(){
        return currentState;
    }

    //CLASS

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
