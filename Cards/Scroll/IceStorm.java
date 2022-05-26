package Cards.Scroll;
import package Scroll;
import Scroll.ScrollBase;

public class IceStorm extends ScrollBase{
    public int damage;
    public int armorReduction;
    IceStorm(){
        damage=55;
        manaCost=40;
        energyCost=1;
        usagesRemaining=3;
        armorReduction=5;//percentage value
    }
}
