package TileGame.Tiles.Nivel2.CopacVerde;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacVerde1 extends Tile
{
    public CopacVerde1(int id)
    {
        super(Assets.copacVerde1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}