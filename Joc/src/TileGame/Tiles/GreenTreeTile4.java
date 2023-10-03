package TileGame.Tiles;

import TileGame.gfx.Assets;

public class GreenTreeTile4 extends Tile
{
    public GreenTreeTile4(int id)
    {
        super(Assets.green_tree4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}