package TileGame.Tiles.Nivel2.CopacPortocaliu;


import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

public class CopacPortocaliu1 extends Tile
{
    public CopacPortocaliu1(int id)
    {
        super(Assets.copacPortocaliu1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}