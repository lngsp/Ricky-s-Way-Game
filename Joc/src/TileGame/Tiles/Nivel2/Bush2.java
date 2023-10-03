package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Bush2  extends Tile
{
    public Bush2(int id)
    {
        super(Assets.bush2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}