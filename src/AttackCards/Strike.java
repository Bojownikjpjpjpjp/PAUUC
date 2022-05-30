package AttackCards;

public class Strike extends AttackCardBase {
    public Strike(){
        setProvision(10);
        setDamage(70);
        setEnergyCost(1);
        setTarget(1);
        setDescription("Strike your opponent for " + getDamage() + " dmg");
    }


}
