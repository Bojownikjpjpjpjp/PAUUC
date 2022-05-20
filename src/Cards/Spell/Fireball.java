package Cards.Spell;

import Cards.cardbase.Card;

public class Fireball extends Card {
    public int manaCost;
    public int damage;

    Fireball(){
        provision=14;
        manaCost=120;
        energyCost=2;
        damage=170;
    }
}
