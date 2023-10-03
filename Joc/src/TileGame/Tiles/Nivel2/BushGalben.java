package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class BushGalben extends Tile
{
    public BushGalben(int id)
    {
        super(Assets.bushGalben, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
