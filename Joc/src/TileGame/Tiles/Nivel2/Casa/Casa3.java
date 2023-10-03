package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa3  extends Tile
{
    public Casa3(int id)
    {
        super(Assets.casa3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
