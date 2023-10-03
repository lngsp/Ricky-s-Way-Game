package TileGame.Tiles;

import TileGame.gfx.Assets;

public class CopacelTile extends Tile
{
    public CopacelTile(int id)
    {
        super(Assets.copacel, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}