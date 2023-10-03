package TileGame.Tiles.Nivel2.CopacVerde;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacVerde3 extends Tile
{
    public CopacVerde3(int id)
    {
        super(Assets.copacVerde3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
