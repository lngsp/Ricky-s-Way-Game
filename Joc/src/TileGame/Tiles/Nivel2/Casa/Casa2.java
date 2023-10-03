package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa2  extends Tile
{
    public Casa2(int id)
    {
        super(Assets.casa2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

