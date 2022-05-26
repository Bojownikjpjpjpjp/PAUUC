package attackCards;

public class Punch extends attackCardBase {
     public Punch(){
        setProvision(7);
        setDamage(40);
        setEnergyCost(1);
        setTarget(1);
        setDescription("Punch your opponent for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/attackCards/punch.png");
    }

}
