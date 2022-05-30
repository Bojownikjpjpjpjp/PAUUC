package SpellCardsOffensive;

public class IceSpear extends OffensiveSpellCardBase {
    public IceSpear(){
        setProvision(9);
        setDamage(80);
        setEnergyCost(1);
        setTarget(1);
        setManaCost(60);
        setCardName("ice spear");
        setDescription("Piercing your opponent for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/spellCards/iceSpear.png");
    }
}
