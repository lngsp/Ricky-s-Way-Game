package TileGame.Tiles.Nivel2.CopacPortocaliu;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacPortocaliu2 extends Tile
{
    public CopacPortocaliu2(int id)
    {
        super(Assets.copacPortocaliu2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}