package TileGame.Tiles.Nivel2.CopacGol;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGol3 extends Tile
{
    public CopacGol3(int id)
    {
        super(Assets.copacGol3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
