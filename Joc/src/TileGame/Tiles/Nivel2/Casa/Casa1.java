package TileGame.Tiles.Nivel2.Casa;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Casa1 extends Tile
{
    public Casa1(int id)
    {
        super(Assets.casa1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

