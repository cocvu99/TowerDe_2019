package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class normalMonster extends Monster{
    public normalMonster(Point pos) {
        super(pos, "res/Monster/Monster1.png");
        this.HP     = 80;
        this.speed  = 2;
        this.armor  = 5;
        this.reward = 30;
    }
}
