package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL25 extends Tile
{
    public FantanaL25(int id)
    {
        super(Assets.fantanaL25, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

