package TileGame.Tiles;

import TileGame.gfx.Assets;

public class Fantana3Tile extends Tile
{
    public Fantana3Tile(int id)
    {
        super(Assets.fantana3, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}