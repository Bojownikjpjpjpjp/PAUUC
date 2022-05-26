package attackCards;

public class Strike extends attackCardBase {
    public Strike(){
        setProvision(10);
        setDamage(70);
        setEnergyCost(1);
        setTarget(1);
        setDescription("Strike your opponent for " + getDamage() + " dmg");
    }


}
