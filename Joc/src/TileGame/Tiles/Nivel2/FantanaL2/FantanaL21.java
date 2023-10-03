package TileGame.Tiles.Nivel2.FantanaL2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class FantanaL21 extends Tile
{
    public FantanaL21(int id)
    {
        super(Assets.fantanaL21, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
