package Cards.DefenceCards;

import Cards.cardbase.Card;

public class Block extends Card {
    public double damageReduction;
    Block(){
        provision=9;
        energyCost=1;
        damageReduction=5;//percentage value
    }
}
