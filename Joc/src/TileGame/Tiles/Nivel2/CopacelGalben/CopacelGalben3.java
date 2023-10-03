package TileGame.Tiles.Nivel2.CopacelGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacelGalben3 extends Tile
{
    public CopacelGalben3(int id)
    {
        super(Assets.copacelGalben3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}