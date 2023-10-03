package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa9  extends Tile
{
    public Casa9(int id)
    {
        super(Assets.casa9, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
