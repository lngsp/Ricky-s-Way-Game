package TileGame.Tiles.Nivel2.CopacPortocaliu;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacPortocaliu3 extends Tile
{
    public CopacPortocaliu3(int id)
    {
        super(Assets.copacPortocaliu3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
