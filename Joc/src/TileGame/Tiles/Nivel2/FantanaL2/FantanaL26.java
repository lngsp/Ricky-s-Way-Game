package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL26 extends Tile
{
    public FantanaL26(int id)
    {
        super(Assets.fantanaL26, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

