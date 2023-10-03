package TileGame.Tiles;

import TileGame.gfx.Assets;

public class GreenTreeTile1 extends Tile
{
    public GreenTreeTile1(int id)
    {
        super(Assets.green_tree1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}