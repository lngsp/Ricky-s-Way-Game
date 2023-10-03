package TileGame.Tiles.Nivel2.CopacGol;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGol1 extends Tile
{
    public CopacGol1(int id)
    {
        super(Assets.copacGol1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}