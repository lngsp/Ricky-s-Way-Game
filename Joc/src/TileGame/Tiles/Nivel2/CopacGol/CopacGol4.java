package TileGame.Tiles.Nivel2.CopacGol;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGol4 extends Tile
{
    public CopacGol4(int id)
    {
        super(Assets.copacGol4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}