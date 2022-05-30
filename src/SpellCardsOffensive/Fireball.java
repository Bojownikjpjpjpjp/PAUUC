package SpellCardsOffensive;

import Wizard.Wizard;

public class Fireball extends OffensiveSpellCardBase {


    public Fireball(){
        setProvision(14);
        setDamage(170);
        setEnergyCost(2);
        setTarget(1);
        setManaCost(150);
        setCardName("fireball");
        setDescription("Mighty fireball for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/spellCards/fireBall.png");
    }


}
