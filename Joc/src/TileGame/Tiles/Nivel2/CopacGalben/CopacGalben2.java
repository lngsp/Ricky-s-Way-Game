package TileGame.Tiles.Nivel2.CopacGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGalben2 extends Tile
{
    public CopacGalben2(int id)
    {
        super(Assets.copacGalben2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
