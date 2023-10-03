package TileGame.Tiles.Nivel2.CopacGol;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGol2 extends Tile
{
    public CopacGol2(int id)
    {
        super(Assets.copacGol2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
