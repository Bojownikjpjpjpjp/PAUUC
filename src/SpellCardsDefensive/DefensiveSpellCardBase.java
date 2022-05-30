package SpellCardsDefensive;

import Hero.Hero;
import Wizard.Wizard;

public abstract class DefensiveSpellCardBase extends cardbase.CardBase{
    public int manaCost;
    public int armor;

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    public int getManaCost() {
        return manaCost;
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
