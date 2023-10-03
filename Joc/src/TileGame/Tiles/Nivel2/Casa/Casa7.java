package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa7  extends Tile
{
    public Casa7(int id)
    {
        super(Assets.casa7, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

