package TileGame.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;


    /*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */

public class Assets {

    /// Referinte catre elementele grafice (dale) utilizate in joc.

    // NIVEL 1
    public static BufferedImage grass;
    public static BufferedImage soil;
    public static BufferedImage pink_tree1;
    public static BufferedImage pink_tree2;
    public static BufferedImage pink_tree3;
    public static BufferedImage pink_tree4;

    public static BufferedImage green_tree1;
    public static BufferedImage green_tree2;
    public static BufferedImage green_tree3;
    public static BufferedImage green_tree4;

    public static BufferedImage buturuga;
    public static BufferedImage bush;
    public static BufferedImage copacel;
    public static BufferedImage arrow;
    public static BufferedImage flowers;
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerDownUp;
    public static BufferedImage enemy;
    public static BufferedImage fantana1;
    public static BufferedImage fantana2;
    public static BufferedImage fantana3;
    public static BufferedImage fantana4;

    public static BufferedImage carrot;
    public static BufferedImage banana;
    public static BufferedImage cirese;
    public static BufferedImage ardel;
    public static BufferedImage rosie;
    public static BufferedImage capsuna;
    public static BufferedImage porumb;

    // NIVEL 2
    public static BufferedImage soil2;
    public static BufferedImage grass2;
    public static BufferedImage bush2;
    public static BufferedImage copacPortocaliu1;
    public static BufferedImage copacPortocaliu2;
    public static BufferedImage copacPortocaliu3;
    public static BufferedImage copacPortocaliu4;
    public static BufferedImage copacVerde1;
    public static BufferedImage copacVerde2;
    public static BufferedImage copacVerde3;
    public static BufferedImage copacVerde4;
    public static BufferedImage copacGalben1;
    public static BufferedImage copacGalben2;
    public static BufferedImage copacGalben3;
    public static BufferedImage copacGalben4;
    public static BufferedImage copacelGalben1;
    public static BufferedImage copacelGalben2;
    public static BufferedImage copacelGalben3;
    public static BufferedImage copacelGalben4;
    public static BufferedImage copacGol1;
    public static BufferedImage copacGol2;
    public static BufferedImage copacGol3;
    public static BufferedImage copacGol4;
    public static BufferedImage fantanaL21;
    public static BufferedImage fantanaL22;
    public static BufferedImage fantanaL23;
    public static BufferedImage fantanaL24;
    public static BufferedImage fantanaL25;
    public static BufferedImage fantanaL26;
    public static BufferedImage casa1;
    public static BufferedImage casa2;
    public static BufferedImage casa3;
    public static BufferedImage casa4;
    public static BufferedImage casa5;
    public static BufferedImage casa6;
    public static BufferedImage casa7;
    public static BufferedImage casa8;
    public static BufferedImage casa9;
    public static BufferedImage buturuga2;
    public static BufferedImage bushGalben;
    public static BufferedImage bushPortocaliu;
    public static BufferedImage frunza;

    // Butoane + Poze
    public static BufferedImage start_button;
    public static BufferedImage quit_button;
    public static BufferedImage help_button;
    public static BufferedImage helpImage;
    public static BufferedImage menuImage;
    public static BufferedImage gameOver;
    public static BufferedImage flag;
    public static BufferedImage inventoryScreen;
    public static Font fontText;

    public static void init(){      // Functia initializaza referintele catre elementele grafice utilizate.

        // Nivel 1
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Nivel1/sprite.png"));
        SpriteSheet copaciiverzi_sheet = new SpriteSheet((ImageLoader.loadImage("/textures/Nivel1/copaciiverzi.png")));
        SpriteSheet copaciiroz_sheet = new SpriteSheet((ImageLoader.loadImage("/textures/Nivel1/copaciiroz.png")));
        SpriteSheet fantana_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Nivel1/fantana.png"));
        SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/Player/player.png"));
        SpriteSheet fruits = new SpriteSheet(ImageLoader.loadImage("/textures/Fructe/fructe.png"));
        SpriteSheet fruits2 = new SpriteSheet(ImageLoader.loadImage("/textures/Fructe/fructe2.png"));
        SpriteSheet enemySprite = new SpriteSheet(ImageLoader.loadImage("/textures/Enemy/enemy.png"));

        // Nivel 2
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Nivel2/spriteSheet.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/Nivel2/spriteSheet2.png"));

        // Butoane + Poze
        start_button = ImageLoader.loadImage("/textures/MenuState/startButton.png");
        quit_button = ImageLoader.loadImage("/textures/MenuState/quitButton.png");
        help_button = ImageLoader.loadImage("/textures/MenuState/helpButton.png");
        helpImage = ImageLoader.loadImage("/textures/MenuState/helpImage.png");
        menuImage = ImageLoader.loadImage("/textures/MenuState/menuImage.png");
        gameOver = ImageLoader.loadImage("/textures/MenuState/GameOver.png");
        flag = ImageLoader.loadImage("/textures/Flag/flag.png");
       inventoryScreen = ImageLoader.loadImage("/textures/MenuState/inventoryScreen.png");

       fontText = FontLoader.loadFont("res/fonts/LibreBaskerville-Bold.ttf", 15);

        /// Se obtin subimaginile corespunzatoare elementelor necesare.

        // NIVEL 1
        soil = sheet.crop(0,0);
        grass = sheet.crop(1,0);
        flowers = sheet.crop(2,0);
        buturuga = sheet.crop(0,1);
        arrow = sheet.crop(1, 1);
        bush = sheet.crop(2, 1);
        copacel = sheet.crop(0,2);

        playerRight = new BufferedImage[7];
        playerRight[0] = player.crop(0,0);
        playerRight[1] = player.crop(1,0);
        playerRight[2] = player.crop(2,0);
        playerRight[3] = player.crop(3,0);
        playerRight[4] = player.crop(0,1);
        playerRight[5] = player.crop(1,1);
        playerRight[6] = player.crop(2,1);

        playerLeft = new BufferedImage[7];
        playerLeft[0] = player.crop(3,1);
        playerLeft[1] = player.crop(0,2);
        playerLeft[2] = player.crop(1,2);
        playerLeft[3] = player.crop(2,2);
        playerLeft[4] = player.crop(3,2);
        playerLeft[5] = player.crop(0,3);
        playerLeft[6] = player.crop(1,3);

        playerDownUp = new BufferedImage[1];
        playerDownUp[0] = player.crop(2,3);

        enemy = enemySprite.crop(0,0);

        cirese = fruits.crop(0,0);
        carrot = fruits.crop(1,0);
        banana = fruits.crop(2,0);
        ardel = fruits.crop(3,0);
        capsuna = fruits.crop(0,1);
        rosie = fruits.crop(1,1);
        porumb = fruits2.crop(0,0);

        pink_tree1 = copaciiroz_sheet.crop(0,0);
        pink_tree2 = copaciiroz_sheet.crop(1,0);
        pink_tree3 = copaciiroz_sheet.crop(0,1);
        pink_tree4 = copaciiroz_sheet.crop(1,1);

        green_tree1 = copaciiverzi_sheet.crop(0,0);
        green_tree2 = copaciiverzi_sheet.crop(1,0);
        green_tree3 = copaciiverzi_sheet.crop(0,1);
        green_tree4 = copaciiverzi_sheet.crop(1,1);

        fantana1 = fantana_sheet.crop(0,0);
        fantana2 = fantana_sheet.crop(1, 0);
        fantana3 = fantana_sheet.crop(0, 1);
        fantana4 = fantana_sheet.crop(1, 1);


        // NIVEL 2
        grass2 = sheet2.crop(0,0);
        soil2 = sheet2.crop(1,0);
        bush2 = sheet2.crop(2,0);
        buturuga2 = sheet2.crop(3,0);

        copacPortocaliu1 = sheet2.crop(4,0);
        copacPortocaliu2 = sheet2.crop(5,0);
        copacPortocaliu3 = sheet2.crop(0,1);
        copacPortocaliu4= sheet2.crop(1,1);

        copacVerde1 = sheet2.crop(2,1);
        copacVerde2 = sheet2.crop(3,1);
        copacVerde3 = sheet2.crop(4,1);
        copacVerde4 = sheet2.crop(5,1);

        copacGol1 = sheet2.crop(0,2);
        copacGol2 = sheet2.crop(1,2);
        copacGol3 = sheet2.crop(2,2);
        copacGol4 = sheet2.crop(3,2);

        copacGalben1 = sheet2.crop(4,2);
        copacGalben2 = sheet2.crop(5,2);
        copacGalben3 = sheet2.crop(0,3);
        copacGalben4 = sheet2.crop(1,3);

        copacelGalben1 = sheet2.crop(2,3);
        copacelGalben2 = sheet2.crop(3,3);
        copacelGalben3 = sheet2.crop(4,3);
        copacelGalben4 = sheet2.crop(5,3);

        fantanaL21 = sheet2.crop(0,4);
        fantanaL22= sheet2.crop(1,4);
        fantanaL23 = sheet2.crop(2,4);
        fantanaL24 = sheet2.crop(3,4);
        fantanaL25 = sheet2.crop(4,4);
        fantanaL26= sheet2.crop(5,4);

        casa1 = sheet2.crop(0,5);
        casa2 = sheet2.crop(1,5);
        casa3 = sheet2.crop(2,5);
        casa4 = sheet2.crop(3,5);
        casa5 = sheet2.crop(4,5);
        casa6 = sheet2.crop(5,5);
        casa7 = sheet2.crop(0,6);
        casa8 = sheet2.crop(1,6);
        casa9 = sheet2.crop(2,6);

        bushGalben = sheet3.crop(0,0);
        bushPortocaliu = sheet3.crop(1,0);
        frunza = sheet3.crop(2,0);
    }
}
