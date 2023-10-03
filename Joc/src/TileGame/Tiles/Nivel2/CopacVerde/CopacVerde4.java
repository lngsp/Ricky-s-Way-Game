package TileGame.Tiles.Nivel2.CopacVerde;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacVerde4 extends Tile
{
    public CopacVerde4(int id)
    {
        super(Assets.copacVerde4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
