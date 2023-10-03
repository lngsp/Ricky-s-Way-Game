package TileGame.Tiles.Nivel2.CopacPortocaliu;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacPortocaliu4 extends Tile
{
    public CopacPortocaliu4(int id)
    {
        super(Assets.copacPortocaliu4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
