package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa4  extends Tile
{
    public Casa4(int id)
    {
        super(Assets.casa4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
