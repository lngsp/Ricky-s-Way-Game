package TileGame.Tiles;

import TileGame.gfx.Assets;

public class GreenTreeTile3 extends Tile
{
    public GreenTreeTile3(int id)
    {
        super(Assets.green_tree3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
