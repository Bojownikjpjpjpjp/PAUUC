import AttackCards.AttackCardBase;
import SpellCardsOffensive.OffensiveSpellCardBase;
import SpellCardsDefensive.DefensiveSpellCardBase;

public class cardVector {
    int[] intValues = new int[4];
    double[] doubleValues = new double[1];
    String[] strings = new String[3];
    boolean[] bools = new boolean[5];

    public void setIntValues(int[] intValues) {
        this.intValues = intValues;
    }
    public void setIntValues(int energyCost, int provision, int target, int damage) {
        this.intValues[0] = energyCost;
        this.intValues[1] = provision;
        this.intValues[2] = target;
        this.intValues[3] = damage;
    }

    public void setDoubleValues(double[] doubleValues) {
        this.doubleValues = doubleValues;
    }
    public void setDoubleValues(double manaCost) {
        this.doubleValues[0] = manaCost;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
    public void setStrings(String description, String imageLocalization, String cardName) {
        this.strings[0] = description;
        this.strings[1] = imageLocalization;
        this.strings[2] = cardName;
    }

    public void setBools(boolean[] bools) {
        this.bools = bools;
    }
    public void setBools( boolean isInDeck, boolean isInHand, boolean isInUsedStack, boolean isInPlayStack, boolean isSelected) {
        this.bools[0] = isInDeck;
        this.bools[1] = isInHand;
        this.bools[2] = isInUsedStack;
        this.bools[3] = isInPlayStack;
        this.bools[4] = isSelected;
    }

    public void setAttackCardValues(AttackCardBase p){
        this.setIntValues(p.getEnergyCost(),p.getProvision(),p.getTarget(),p.getDamage());
        this.setDoubleValues(0.0);
        this.setStrings(p.getDescription(),p.getImageLocalization(), p.getCardName());
        this.setBools(true,true,false,false,false);
    }
    public void setOffensiveSpellCardValues(OffensiveSpellCardBase p){
        this.setIntValues(p.getEnergyCost(),p.getProvision(),p.getTarget(),p.getDamage());
        this.setDoubleValues(p.getManaCost());
        this.setStrings(p.getDescription(),p.getImageLocalization(), p.getCardName());
        this.setBools(true,true,false,false,false);
    }
    public void setDefensiveSpellCardValues(DefensiveSpellCardBase p){
        this.setIntValues(p.getEnergyCost(),p.getProvision(),p.getTarget(),p.getArmor());
        this.setDoubleValues(p.getManaCost());
        this.setStrings(p.getDescription(),p.getImageLocalization(), p.getCardName());
        this.setBools(true,true,false,false,false);
    }
    // TODO: 25.05.2022 można zmodyfikować getter, zęby zwracał tylko część tablicy 
    public int[] getIntValues() {
        return intValues;
    }

    public double[] getDoubleValues() {
        return doubleValues;
    }

    public String[] getStrings() {
        return strings;
    }

    public boolean[] getBools() {
        return bools;
    }

    public cardVector(int energyCost, int provision, int target, int damage, double manaCost, String description, String imageLocalization, boolean isInDeck, boolean isInHand, boolean isInUsedStack, boolean isInPlayStack, boolean isSelected){
    //target==0 self, target==1 enemy
        intValues[0] = energyCost;
        intValues[1] = provision;
        intValues[2] = target;
        intValues[3] = damage;
        doubleValues[0] = manaCost;
        strings[0] = description;
        strings[1] = imageLocalization;
        bools[0] = isInDeck;
        bools[1] = isInHand;
        bools[2] = isInUsedStack;
        bools[3] = isInPlayStack;
        bools[4] = isSelected;
}
    public cardVector(){
        intValues[0] = 0;
        intValues[1] = 0;
        intValues[2] = 0;
        intValues[3] = 0;
        doubleValues[0] = 0.0;
        strings[0] = "description";
        strings[1] = "imageLocalization";
        bools[0] = false;
        bools[1] = false;
        bools[2] = false;
        bools[3] = false;
        bools[4] = false;
    }
}
