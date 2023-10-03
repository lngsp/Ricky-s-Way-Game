package TileGame.Tiles.Nivel2;

import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class Grass2 extends Tile
{
    public Grass2(int id)
    {
        super(Assets.grass2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}