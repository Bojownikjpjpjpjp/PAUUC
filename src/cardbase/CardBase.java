package cardbase;


import Hero.Hero;
import Wizard.Wizard;

public abstract class CardBase  {
    public String description;
    public String imageLocalization;
    public int energyCost;
    public int provision;
    public int target;     //target==0 self, target==1 enemy
    public boolean isInPlayStack;
    public boolean isInHand;
    public boolean isInUsedStack;
    public boolean isSelected;
    public boolean isInDeck;

    public CardBase(){//ustawia tylko boole, energia i prowizja jest indywidualna
        isInDeck=false;
        isInHand=false;
        isInPlayStack=false;
        isInUsedStack=false;
        isSelected=false;
    }
    boolean checkUsable(){
        if (this.isInDeck&&this.isInHand){
            return  true;
        }
        else{
            return false;
        }
    }
    public boolean checkCost(Wizard hero){
        if (hero.getEnergy()<this.getEnergyCost()) return false;
        return false;
    };
    void selectCard(Wizard hero){
        if(this.checkUsable()&&checkCost(hero)) {
            setSelected(true);
        }
        else {
            setSelected(false);
            System.out.println("Card cannot be used now");
        }
    }
    public void setInDeck(boolean inDeck) {
        isInDeck = inDeck;
    }
    public void setInHand(boolean inHand) {
        isInHand = inHand;
    }
    public void setInUsedStack(boolean inUsedStack) {
        isInUsedStack = inUsedStack;
    }
    public void setInPlayStack(boolean inPlayStack) {
        isInPlayStack = inPlayStack;
    }
    public  void setProvision(int provision) {
        this.provision = provision;
    }
    public  void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }
    public boolean isInUsedStack() {
        return isInUsedStack;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public boolean isInDeck() {
        return isInDeck;
    }
    public boolean isInHand() {
        return isInHand;
    }
    public boolean isInPlayStack() {
        return isInPlayStack;
    }
    public  int getProvision() {
        return provision;
    }
    public  int getEnergyCost() {
        return energyCost;
    }
    public String getDescription() {
        return description;
    }
    public int getTarget() {
        return target;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setImageLocalization(String imageLocalization) {
        this.imageLocalization = imageLocalization;
    }
    public String getImageLocalization() {
        return imageLocalization;
    }
}