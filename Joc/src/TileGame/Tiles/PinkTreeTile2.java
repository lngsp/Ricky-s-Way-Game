package TileGame.Tiles;

import TileGame.gfx.Assets;

public class PinkTreeTile2 extends Tile
{
    public PinkTreeTile2(int id)
    {
        super(Assets.pink_tree2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}