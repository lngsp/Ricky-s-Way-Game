package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa6  extends Tile
{
    public Casa6(int id)
    {
        super(Assets.casa6, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
