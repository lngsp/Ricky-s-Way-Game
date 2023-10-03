package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL23 extends Tile
{
    public FantanaL23(int id)
    {
        super(Assets.fantanaL23, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

