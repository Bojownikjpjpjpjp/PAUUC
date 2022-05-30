package Tests;
import Wizard.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardManaSetterTest {
//setter takes a difference, adding that to mana and check if it is below mana limit or lesser than 0, then sets it to borders
    @Test
    public void manaSetterTest(){
        Wizard wizard = new Wizard();
        wizard.setMana(44);
        assertEquals(wizard.getManaLimit(),350);
        assertEquals(wizard.getManaLimit(),wizard.getMana());
        wizard.setMana(-5000);
        assertEquals(0,wizard.getMana());
        wizard.setMana(80);
        assertEquals(80,wizard.getMana());
    }
}

