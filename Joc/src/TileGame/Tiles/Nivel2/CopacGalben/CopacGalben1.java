package TileGame.Tiles.Nivel2.CopacGalben;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacGalben1 extends Tile
{
    public CopacGalben1(int id)
    {
        super(Assets.copacGalben1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}