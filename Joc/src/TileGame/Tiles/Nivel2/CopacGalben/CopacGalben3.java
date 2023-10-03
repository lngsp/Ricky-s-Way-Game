package TileGame.Tiles.Nivel2.CopacGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGalben3 extends Tile
{
    public CopacGalben3(int id)
    {
        super(Assets.copacGalben3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}