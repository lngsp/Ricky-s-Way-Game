package TileGame.Tiles.Nivel2.CopacGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGalben4 extends Tile
{
    public CopacGalben4(int id)
    {
        super(Assets.copacGalben4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}