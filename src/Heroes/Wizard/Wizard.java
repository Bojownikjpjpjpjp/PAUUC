package Heroes.Wizard;
// TODO: 07.04.2022 ogarnać linkowanie 

import Heroes.HeroBase.Hero;

public class Wizard extends Hero {
    public double mana;
    public double manaRegen;
    public double manaLimit;
    public int actionPoints;
    public int actionPointsLimit;
    public void setMana(double diff) {
        this.mana += diff;
        if (mana<0){
            this.mana=0;
        }
        if (mana>manaLimit){
            this.mana=manaLimit;
        }
    }

    public void setManaLimit(double newLimit) {
        this.manaLimit = newLimit;
    }

    public void setManaRegen(double newManaRegen) {
        this.manaRegen = newManaRegen;
    }

    public double getMana() {
        return mana;
    }

    public double getManaLimit() {
        return manaLimit;
    }

    public double getManaRegen() {
        return manaRegen;
    }
    public int getActionPoints(){
        return  actionPoints;
    }
    public void setActionPoints(int addedActionPoints){
        this.actionPoints = this.actionPoints + addedActionPoints;
    }
    public void setActionPointsLimit(int limitModifier){
        this.actionPointsLimit += limitModifier;
    }
    public int getActionPointsLimit(){
        return actionPoints;
    }
  public Wizard(){
    Hero.healthPoint=600;
    this.manaLimit=350;
    this.manaRegen=100;
    setMana(manaLimit);
    setActionPoints(actionPointsLimit);
 }

}