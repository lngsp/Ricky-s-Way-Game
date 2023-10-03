package TileGame.Tiles.Nivel2.CopacelGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacelGalben2 extends Tile
{
    public CopacelGalben2(int id)
    {
        super(Assets.copacelGalben2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
