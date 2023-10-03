package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL24 extends Tile
{
    public FantanaL24(int id)
    {
        super(Assets.fantanaL24, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
