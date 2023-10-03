package TileGame.Tiles;

import TileGame.gfx.Assets;

public class PinkTreeTile4 extends Tile
{
    public PinkTreeTile4(int id)
    {
        super(Assets.pink_tree4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}