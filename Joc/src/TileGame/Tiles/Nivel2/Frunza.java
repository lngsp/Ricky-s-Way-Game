package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Frunza extends Tile
{
    public Frunza(int id)
    {
        super(Assets.frunza, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
