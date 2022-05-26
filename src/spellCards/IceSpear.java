package spellCards;

public class IceSpear extends spellCardBase {
    public IceSpear(){
        setProvision(9);
        setDamage(80);
        setEnergyCost(1);
        setTarget(1);
        setManaCost(60);
        setDescription("Piercing your opponent for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/spellCards/iceSpear.png");
    }
}
