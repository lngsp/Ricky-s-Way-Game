package TileGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*! \class public class KeyManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de tastatura.

    Clasa citeste daca au fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei de interes. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata si false nu a fost apasata.
 */

public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPress;     // Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]
    public boolean up, down, left, right;   // Flag pentru tasta sus/joc/stanga/dreapta apasata.
    public boolean space;

    public KeyManager(){
        ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void tick(){         // Update

        for(int i = 0; i< keys.length;i++){
            if(cantPress[i] && !keys[i]){
                cantPress[i]=false;
            }
            else if(justPressed[i]){
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }


        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        space = keys[KeyEvent.VK_SPACE];
    }


       /*! \fn public void keyTyped(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
        Momentan aceasta functie nu este utila in program.
     */

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }


    /*! \fn public void keyPressed(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //se retine in vectorul de flaguri ca o tasta a fost apasata.
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;
    }


    /*! \fn public void keyReleased(KeyEvent e)
     \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

      \param e obiectul eveniment de tastatura.
  */
    @Override
    public void keyReleased(KeyEvent e) {
        //se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }
}
