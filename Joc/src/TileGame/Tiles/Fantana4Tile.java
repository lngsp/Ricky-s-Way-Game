package TileGame.Tiles;

import TileGame.gfx.Assets;

public class Fantana4Tile extends Tile
{
    public Fantana4Tile(int id)
    {
        super(Assets.fantana4, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}