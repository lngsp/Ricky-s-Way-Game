package TileGame.Tiles;

import TileGame.gfx.Assets;

public class ButurugaTile extends Tile
{
    public ButurugaTile(int id)
    {
        super(Assets.buturuga, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}