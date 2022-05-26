package spellCards;

import Hero.Hero;
import Wizard.Wizard;

public abstract class spellCardBase extends cardbase.CardBase {
    public int manaCost;
    public int damage;

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getManaCost() {
        return manaCost;
    }
    public int getDamage() {
        return damage;
    }
    public boolean checkManaCost(double heroMana){//returning true if hero mana> required mana
        if (heroMana<this.manaCost) return false;
        return true;
    }
    @Override
    public boolean checkCost(Wizard hero){
        if (!super.checkCost(hero)) return false;
        if (checkManaCost(hero.getMana())) return true;
        return false;
    }
}
