package Cards.Spell;
//import CardBase.
import CardBase.Card;
public class LaserEyes extends Card {
    public int manaCost;
    public int damage;

    LaserEyes(){
        provision=15;
        energyCost=2;
        manaCost=200;
        damage=200;
    }
}
