package Spell.excluded;

import Cards.cardbase.CardBase;

public class LaserEyes extends CardBase {
    public int manaCost;
    public int damage;

    LaserEyes(){
        provision=15;
        energyCost=2;
        manaCost=200;
        damage=200;
    }

    @Override
    public void use() {

    }

    @Override
    public void description() {

    }
}
