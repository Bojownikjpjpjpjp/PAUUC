package AttackCards;

public class Punch extends AttackCardBase {
     public Punch(){
        setProvision(7);
        setDamage(40);
        setEnergyCost(1);
        setTarget(1);
        setCardName("punch");
        setDescription("Punch your   opponent for " + getDamage() + " dmg");
        setImageLocalization("/cardsImages/attackCards/punch.png");
    }
   /* @Override
    public void use(Fight fight){
        //using hero number set
        int heroN;//hero turn (1,2), plater[0,1]
        int opponent;
        if (fight.getHeroTurn()==1){
            heroN = 0;
            opponent = 1;
        }
        else {
            heroN = 1;
            opponent = 0;
        }
        //action points check
        if(fight.player[heroN].getActionPoints()==0){
            System.out.println("you can not play any cards this turn, you have no action points left");
            return;
        }
        //energy check
        if(fight.player[heroN].getEnergy()<getEnergyCost()){
            System.out.println("you can not play any cards this turn, you have not enough energy left");
            return;
        }
        //mana cost check
        if(fight.player[heroN].getMana()<card.doubleValues[0]){
            System.out.println("you can not play any cards this turn, you have not enough mana left");
            return;
        }
        //setting target hero
        int target = card.intValues[2];
        if(target==1){
            target = opponent;
        }
        else {
            target = heroN;
        }
        //dealing damage
        int damage = (int)((card.intValues[3] * (int)player[target].getDamageModifier())/100);
        damage = (damage - ((int)(damage * (int)player[target].getArmorModifier())/100));
        player[target].setHealthPoint(player[target].getHealthPoint() - damage);

        //setting hero values
        player[heroN].setActionPoints(-1);
        player[heroN].setEnergy(-card.intValues[0]);
        player[heroN].setMana(-(card.doubleValues[0]));

        //checking if any hero's hp is already 0
        if(player[0].getHealthPoint()==0 ||player[1].getHealthPoint()==0){
            System.out.println("fight ended " + finishFight());
            System.exit(0);
        }

    }*/
}
