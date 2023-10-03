package TileGame.Tiles;

import TileGame.gfx.Assets;

public class GreenTreeTile2 extends Tile
{
    public GreenTreeTile2(int id)
    {
        super(Assets.green_tree2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}