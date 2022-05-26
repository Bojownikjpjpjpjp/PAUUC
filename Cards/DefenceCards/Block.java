package Cards.DefenceCards;


import Cards.cardbase.CardBase;

public class Block extends CardBase {
    public double damageReduction;
    Block(){
        provision=9;
        energyCost=1;
        damageReduction=5;//percentage value
    }

    @Override
    public int useSkill(energyCost) {

    }

    @Override
    public String description() {

    }
}
