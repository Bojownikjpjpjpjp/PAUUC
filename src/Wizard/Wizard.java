package Wizard;
import Hero.Hero;

public class Wizard extends Hero {
    public double mana;
    public double manaRegen;
    public double manaLimit;
    public int actionPoints;
    public int actionPointsLimit;
    public int actionPointsRegen;

    public void setMana(double difference) {
        this.mana += difference;
        if (getMana()<0){
            this.mana=0;
        }
        if (getMana()>getManaLimit()){
            this.mana=getManaLimit();
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
        return actionPoints;
    }
    public void setActionPoints(int addedActionPoints){
        this.actionPoints = this.actionPoints + addedActionPoints;
        if(this.getActionPoints()>this.getActionPointsLimit()){
            this.actionPoints = this.getActionPointsLimit();
        }
    }
    public void setActionPointsLimit(int limitModifier){
        this.actionPointsLimit += limitModifier;
    }
    public int getActionPointsLimit(){
        return actionPointsLimit;
    }
    public int getActionPointsRegen() {
        return actionPointsRegen;
    }
    public void setActionPointsRegen(int actionPointsRegen) {
        this.actionPointsRegen = actionPointsRegen;
    }

    public Wizard(){
        super(600, 5, 100, 0, 5, 2);
    setManaLimit(350);
    setManaRegen(100);
    setMana(getManaLimit());
    setActionPointsLimit(5);
    setActionPoints(getActionPointsLimit());
    setActionPointsRegen(2);

    int[] cards = new int[3];
    for (int i=0;i<3;i++) {
        cards[i] = i;
    }
    setHeroCards(cards);
 }

}