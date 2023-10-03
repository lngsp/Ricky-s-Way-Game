package TileGame.Tiles;

import TileGame.gfx.Assets;

public class PinkTreeTile3 extends Tile
{
    public PinkTreeTile3(int id)
    {
        super(Assets.pink_tree3, id);
    }


    @Override
    public boolean isSolid(){
        return true;
    }
}
