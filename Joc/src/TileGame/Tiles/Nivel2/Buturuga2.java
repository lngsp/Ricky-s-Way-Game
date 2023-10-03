package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Buturuga2  extends Tile
{
    public Buturuga2(int id)
    {
        super(Assets.buturuga2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
