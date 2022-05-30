import Wizard.Wizard;
import AttackCards.Punch;

public  class Fight {
    static {
        round=1;
    }
    static public int round;
    static public int heroTurn;
    static public boolean isRunning;
    public Wizard[] player = new Wizard[2];
    public void setHeroTurn(int heroTurn) {
        this.heroTurn = heroTurn;
    }
    public int getHeroTurn() {
        return heroTurn;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public int getRound() {
        return round;
    }
    public void setIsRunning(boolean isRunning) {
        Fight.isRunning = isRunning;
    }

    public Fight(){
        setIsRunning(true);
        setRound(1);
        setHeroTurn(1);

        player[0] = new Wizard();
        player[1] = new Wizard();

    }
    public void endTurn(){
        if (getHeroTurn()==1){
            setHeroTurn(2);
        }
        if(getHeroTurn()==2){
            setHeroTurn(1);
            setRound(getRound()+1);
        }
    }

    public void finishFight(){
        if(this.player[0].getHealthPoint()==0){
            setIsRunning(false);
            UI.consoleOutput("player 2 won");
            FileWritter.addToFile("player 2 won");
            FileWritter.shutUP();
            UI.finishPrompt("player 2");
        }
        if(this.player[1].getHealthPoint()==0){
            setIsRunning(false);
            UI.consoleOutput("player 1 won");
            FileWritter.addToFile("player 1 won");
            FileWritter.shutUP();
            UI.finishPrompt("player 1");
        }
        UI.consoleOutput("sth went wrong :(");
    }
    public void useCard(cardVector card){
        //using hero number set
        int heroN;//hero turn (1,2), plater[0,1]
        int opponent;
        if (getHeroTurn()==1){
            heroN = 0;
            opponent = 1;
        }
        else {
            heroN = 1;
            opponent = 0;
        }
        //action points check
        if(player[heroN].getActionPoints()==0){
            UI.consoleOutput("you can not play any cards this turn, you have no action points left");
            return;
        }
        //energy check
        if(player[heroN].getEnergy()<card.intValues[0]){
            UI.consoleOutput("you can not play any cards this turn, you have not enough energy left");
            return;
        }
        //mana cost check
        if(player[heroN].getMana()<card.doubleValues[0]){

            UI.consoleOutput("you can not play any cards this turn, you have not enough mana left");

            return;
        }
        //genering info output
        UI.consoleOutput("played the " + card.strings[2] + " card");
        FileWritter.addToFile("player "+ getHeroTurn()+" played the " + card.strings[2] + " card");
        //setting target hero
        int target = card.intValues[2];
        if(target==1){
            target = opponent;
        }
        else {
            target = heroN;
        }
        if(target==opponent) {
            //dealing damage
            int damage = (int) ((card.intValues[3] * (int) player[target].getDamageModifier()) / 100);
            damage = (damage - ((int) (damage * (int) player[target].getArmorModifier()) / 100));
            player[target].setHealthPoint(player[target].getHealthPoint() - damage);

            //setting hero values
            player[heroN].setActionPoints(-1);
            player[heroN].setEnergy(-card.intValues[0]);
            player[heroN].setMana(-(card.doubleValues[0]));

            //checking if any hero's hp is already 0
            if (player[0].getHealthPoint() == 0 || player[1].getHealthPoint() == 0) {
                finishFight();
            }
        }
        else if(target==heroN){
            //setting hero armor
            int armor = card.intValues[3];
            player[target].setArmorModifier(armor);

            //setting hero values
            player[heroN].setActionPoints(-1);
            player[heroN].setEnergy(-card.intValues[0]);
            player[heroN].setMana(-(card.doubleValues[0]));

            //checking if any hero's hp is already 0
            if (player[0].getHealthPoint() == 0 || player[1].getHealthPoint() == 0) {
                finishFight();
            }
        }
/*        UI.consoleOutput("played the " + card.strings[2] + " card");
        FileWritter.addToFile("player "+ getHeroTurn()+" played the " + card.strings[2] + " card");*/
    }


    public void triggerRegens(){
        int hero = getHeroTurn() - 1;//hero turn (1,2), plater[0,1]
        player[hero].setMana(player[hero].getManaRegen());
        player[hero].setActionPoints(player[hero].getActionPointsRegen());
        player[hero].setEnergy(player[hero].getEnergyRegen());
    }
}
