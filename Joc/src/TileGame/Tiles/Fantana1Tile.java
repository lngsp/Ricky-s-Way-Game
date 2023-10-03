package TileGame.Tiles;

import TileGame.gfx.Assets;

public class Fantana1Tile extends Tile
{
    public Fantana1Tile(int id)
    {
        super(Assets.fantana1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}