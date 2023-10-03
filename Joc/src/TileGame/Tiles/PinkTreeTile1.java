package TileGame.Tiles;

import TileGame.gfx.Assets;
public class PinkTreeTile1 extends Tile
{
    public PinkTreeTile1(int id)
    {
        super(Assets.pink_tree1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}