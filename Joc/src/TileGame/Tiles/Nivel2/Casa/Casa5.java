package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa5  extends Tile
{
    public Casa5(int id)
    {
        super(Assets.casa5, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

