package attackCards;

import Wizard.Wizard;

public abstract class attackCardBase extends cardbase.CardBase {
    public int damage;
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public boolean checkCost(Wizard hero){
            if (hero.getEnergy()<this.energyCost) return false;
        return true;
    }
}
