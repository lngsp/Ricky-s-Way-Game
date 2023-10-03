package TileGame.Tiles;

import TileGame.Tiles.Nivel2.*;
import TileGame.Tiles.Nivel2.Casa.*;
import TileGame.Tiles.Nivel2.CopacGalben.CopacGalben1;
import TileGame.Tiles.Nivel2.CopacGalben.CopacGalben2;
import TileGame.Tiles.Nivel2.CopacGalben.CopacGalben3;
import TileGame.Tiles.Nivel2.CopacGalben.CopacGalben4;
import TileGame.Tiles.Nivel2.CopacGol.CopacGol1;
import TileGame.Tiles.Nivel2.CopacGol.CopacGol2;
import TileGame.Tiles.Nivel2.CopacGol.CopacGol3;
import TileGame.Tiles.Nivel2.CopacGol.CopacGol4;
import TileGame.Tiles.Nivel2.CopacPortocaliu.CopacPortocaliu1;
import TileGame.Tiles.Nivel2.CopacPortocaliu.CopacPortocaliu2;
import TileGame.Tiles.Nivel2.CopacPortocaliu.CopacPortocaliu3;
import TileGame.Tiles.Nivel2.CopacPortocaliu.CopacPortocaliu4;
import TileGame.Tiles.Nivel2.CopacVerde.CopacVerde1;
import TileGame.Tiles.Nivel2.CopacVerde.CopacVerde2;
import TileGame.Tiles.Nivel2.CopacVerde.CopacVerde3;
import TileGame.Tiles.Nivel2.CopacVerde.CopacVerde4;
import TileGame.Tiles.Nivel2.CopacelGalben.CopacelGalben1;
import TileGame.Tiles.Nivel2.CopacelGalben.CopacelGalben2;
import TileGame.Tiles.Nivel2.CopacelGalben.CopacelGalben3;
import TileGame.Tiles.Nivel2.CopacelGalben.CopacelGalben4;
import TileGame.Tiles.Nivel2.FantanaL2.*;

import java.awt.*;
import java.awt.image.BufferedImage;


/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */

public class Tile {

    //STATIC STUFF HERE

    public static Tile[] tiles = new Tile[256];     // Vector de referinte de tipuri de dale.

    /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
    /// o singura data in memorie

    // NIVEL 1
    public static Tile grassTile        = new GrassTile(0);
    public static Tile soilTile         = new SoilTile(1);
    public static Tile pink1Tile = new PinkTreeTile1(2);
    public static Tile pink2Tile = new PinkTreeTile2(3);
    public static Tile pink3Tile = new PinkTreeTile3(4);
    public static Tile pink4Tile = new PinkTreeTile4(5);
    public static Tile bushTile         = new BushTile(6);      /*!< Dala de tip tufis*/
    public static Tile green1Tile = new GreenTreeTile1(7);
    public static Tile green2Tile = new GreenTreeTile2(8);
    public static Tile green3Tile = new GreenTreeTile3(9);
    public static Tile green4Tile = new GreenTreeTile4(10);
    public static Tile buturugaTile = new ButurugaTile(11);      /*!< Dala de tip copac taiat / buturuga */
    public static Tile flowersTile = new FlowersTile(12);      /*!< Dala de tip flori*/
    public static Tile arrowTile         = new ArrowTile(15);      /*!< Dala de tip sageata*/
    public static Tile fantana1Tile = new Fantana1Tile(16);
    public static Tile fantana2Tile = new Fantana2Tile(17);
    public static Tile fantana3Tile  = new Fantana3Tile(18);
    public static Tile fantana4Tile  = new Fantana4Tile(19);
    public static Tile copacelTile = new CopacelTile(20);

    // NIVEL 2
    public static Tile soil2 = new Soil2(21);
    public static Tile grass2 = new Grass2(22);
    public static Tile buturuga2 = new Buturuga2(23);
    public static Tile bush2 = new Bush2(24);
    public static Tile copacPortocaliu1 = new CopacPortocaliu1(25);
    public static Tile copacPortocaliu2 = new CopacPortocaliu2(26);
    public static Tile copacPortocaliu3 = new CopacPortocaliu3(27);
    public static Tile copacPortocaliu4 = new CopacPortocaliu4(28);
    public static Tile copacGalben1 = new CopacGalben1(29);
    public static Tile copacGalben2 = new CopacGalben2(30);
    public static Tile copacGalben3 = new CopacGalben3(31);
    public static Tile copacGalben4 = new CopacGalben4(32);
    public static Tile copacGol1 = new CopacGol1(33);
    public static Tile copacGol2 = new CopacGol2(34);
    public static Tile copacGol3 = new CopacGol3(35);
    public static Tile copacGol4 = new CopacGol4(36);
    public static Tile copacelGalben1 = new CopacelGalben1(37);
    public static Tile copacelGalben2 = new CopacelGalben2(38);
    public static Tile copacelGalben3 = new CopacelGalben3(39);
    public static Tile copacelGalben4 = new CopacelGalben4(40);
    public static Tile copacVerde1 = new CopacVerde1(41);
    public static Tile copacVerde2 = new CopacVerde2(42);
    public static Tile copacVerde3 = new CopacVerde3(43);
    public static Tile copacVerde4 = new CopacVerde4(44);
    public static Tile fantanaL21 = new FantanaL21(45);
    public static Tile fantanaL22 = new FantanaL22(46);
    public static Tile fantanaL23 = new FantanaL23(47);
    public static Tile fantanaL24 = new FantanaL24(48);
    public static Tile fantanaL25 = new FantanaL25(49);
    public static Tile fantanaL26 = new FantanaL26(50);
    public static Tile casa1 = new Casa1(51);
    public static Tile casa2 = new Casa2(52);
    public static Tile casa3 = new Casa3(53);
    public static Tile casa4 = new Casa4(54);
    public static Tile casa5 = new Casa5(55);
    public static Tile casa6 = new Casa6(56);
    public static Tile casa7 = new Casa7(57);
    public static Tile casa8 = new Casa8(58);
    public static Tile casa9 = new Casa9(59);
    public static Tile bushGalben = new BushGalben(60);
    public static Tile bushPortocaliu = new BushPortocaliu(61);
    public static Tile frunza = new Frunza(62);



    //CLASS
    public static final int TILEWIDTH = 41, TILEHEIGHT = 41;
    // Latimea unei dale și înălțimea unei dale.

    protected BufferedImage texture;        // Imaginea aferentă tipului de dală.
    protected final int id;                 // ID-ul aferent tipului de dală.

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){
        // Actualizeaza proprietatile dalei.
    }

    public void render(Graphics g, int x, int y){
        //  Deseneaza in fereastra dala.
        g.drawImage(texture, x, y,TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        // Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
        return false;
    }

    public int getId(){
        return id;
    }
}
