package SpellCardsDefensive;

public class ForceField extends DefensiveSpellCardBase{
    public ForceField(){
        setProvision(25);
        setArmor(20);
        setEnergyCost(2);
        setTarget(0);
        setManaCost(250);
        setCardName("force field");
        setDescription("Provides you with " + getArmor() + " armor");
        setImageLocalization("/cardsImages/spellCards/forceField.png");
    }
}
