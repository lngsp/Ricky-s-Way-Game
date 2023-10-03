package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa8  extends Tile
{
    public Casa8(int id)
    {
        super(Assets.casa8, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
