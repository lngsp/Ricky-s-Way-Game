package TileGame.Tiles.Nivel2.CopacelGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacelGalben4 extends Tile
{
    public CopacelGalben4(int id)
    {
        super(Assets.copacelGalben4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}