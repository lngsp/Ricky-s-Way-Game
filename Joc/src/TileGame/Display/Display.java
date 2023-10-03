package TileGame.Display;

import javax.swing.*;
import java.awt.*;

public class Display {

    /*
    Clasa Display implementează noțiunea de fereastră a jocului.
    Membrul frame este un obiect de tip JFrame care va avea utilitatea unei
    ferestre grafice si totodata si cea a unui container (toate elementele
    grafice vor fi continute de fereastra).

     */

    private JFrame frame; // fereastra principală a jocului
    private Canvas canvas;  // „pânza / tabloul” în care se poate desena

    private String title;   // titlul jocului
    private int width, height; // width = latimea ferestrei in pixeli
                               // height = inaltimea ferestrei in pixeli

    public Display(String title, int width, int height)     // constrcutor cu parametrii ai clasei Display
    {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();

        /*

        Retine proprietatile ferestrei proprietatile (titlu, latime, inaltime)
            in variabilele membre deoarece vor fi necesare pe parcursul jocului.
            Crearea obiectului va trebui urmata de crearea ferestrei propriuzise
            prin apelul metodei createDisplay()


         */
    }


    private void createDisplay()
    {
        /// Daca fereastra a mai fost construita intr-un apel anterior
        /// se renunta la apel
        if(frame != null)
        {
            return;
        }

        // Aloca memorie pentru obiectul de tip fereastra si seteaza denumirea
        /// ce apare in bara de titlu
        frame = new JFrame(title);

        frame.setSize(width, height);       // setează dimensiunile ferestrei

        /// Operatia de inchidere (fereastra sa poata fi inchisa atunci cand
        /// este apasat butonul x din dreapta sus al ferestrei). Totodata acest
        /// lucru garanteaza ca nu doar fereastra va fi inchisa ci intregul
        /// program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);      // fereastra nu poate fi redimensionată

        frame.setLocationRelativeTo(null);  // fereastra apare în centrul ecranului

        /// Implicit o fereastra cand este creata nu este vizibila motiv pentru
        /// care trebuie setata aceasta proprietate
        frame.setVisible(true);

        canvas = new Canvas();      /// Creaza obiectul de tip canvas (panza) pe care se poate desena.

        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
