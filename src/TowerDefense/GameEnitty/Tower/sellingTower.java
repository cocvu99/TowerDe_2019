package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.Map.Point;

public class sellingTower extends Tower {

    public sellingTower() {
        super(new Point(-10,-10), "res/Tile/coin.gif");
    }

    @Override
    public void fire() {
    }
}
