package TileGame.Tiles.Nivel2.CopacelGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacelGalben1 extends Tile
{
    public CopacelGalben1(int id)
    {
        super(Assets.copacelGalben1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}