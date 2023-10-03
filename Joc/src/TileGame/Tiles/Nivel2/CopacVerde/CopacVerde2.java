package TileGame.Tiles.Nivel2.CopacVerde;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacVerde2 extends Tile
{
    public CopacVerde2(int id)
    {
        super(Assets.copacVerde2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
