package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class BushPortocaliu extends Tile
{
    public BushPortocaliu(int id)
    {
        super(Assets.bushPortocaliu, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

