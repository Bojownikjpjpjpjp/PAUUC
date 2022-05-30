package Tests;

import org.junit.jupiter.api.Test;
import AttackCards.Punch;
import static org.junit.jupiter.api.Assertions.*;

public class PunchTest {
    @Test
    public void setterTest(){
        Punch card = new Punch();
        card.setDamage(9001);
        assertEquals(card.getDamage(),9001);
    }

}