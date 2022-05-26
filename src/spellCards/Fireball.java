package spellCards;

import Wizard.Wizard;

public class Fireball extends spellCardBase {


    public Fireball(){
        setProvision(14);
        setDamage(170);
        setEnergyCost(2);
        setTarget(1);
        setManaCost(150);
        setDescription("Mighty fireball for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/spellCards/fireBall.png");
    }


}
