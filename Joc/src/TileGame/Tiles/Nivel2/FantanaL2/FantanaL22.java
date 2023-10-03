package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL22 extends Tile
{
    public FantanaL22(int id)
    {
        super(Assets.fantanaL22, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
