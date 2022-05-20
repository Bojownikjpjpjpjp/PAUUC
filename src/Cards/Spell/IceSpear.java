package Cards.Spell;

import Cards.cardbase.Card;

public class IceSpear extends Card {
    public int damage;
    public int manaCost;

    IceSpear(){
        provision=9;
        manaCost=60;
        energyCost=1;
        damage=80;
    }
}
