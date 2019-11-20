package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

public class normalMonster extends Monster{
    public normalMonster(Point pos) {
        super(pos);
        this.imR        = MonsterImage.ghost2R;
        this.imL        = MonsterImage.ghost2L;
        this.im         = imR;
        this.HP         = 1000;
        this.speed      = 2;
        this.armor      = 10;
        this.reward     = 30;
        this.maxHP      = HP;
    }

}
