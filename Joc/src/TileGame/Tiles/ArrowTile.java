package TileGame.Tiles;

import TileGame.gfx.Assets;

public class ArrowTile extends Tile
{
    public ArrowTile(int id)
    {
        super(Assets.arrow, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}