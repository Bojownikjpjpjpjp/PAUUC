import java.util.Random;
import AttackCards.*;
import SpellCardsDefensive.ForceField;
import SpellCardsOffensive.*;

public class Hand {
    //public HashMap <Integer, cardVector> cardVectors = new HashMap<Integer, cardVector>();
    public cardVector[] cardVectors = new cardVector[4];

    public Hand(){
        cardVectors[0] = new cardVector();
        cardVectors[1] = new cardVector();
        cardVectors[2] = new cardVector();
        cardVectors[3] = new cardVector();
        setCardVectors(randomizeHand(getCardVectors()));
        //setCardVectors(randomizeHand(getCardVectors()));
    }

    // TODO: 26.05.2022 z jakiegoś powodu pokazuje, że jest problem, ale działa. dziwne
    public cardVector[] getCardVectors() {
        return cardVectors;
    }

    public void setCardVectors(cardVector[] cardVectorsSent) {
        cardVectors = cardVectorsSent;
    }
    public cardVector[] randomizeHand(cardVector[] hand){
        Random randomizer = new Random();
        int rand;
        for(int i=0;i<4;i++){
            rand=randomizer.nextInt(4);//random int od 0 do bound-1
            switch (rand){
                case 0:
                    Punch p = new Punch();
                    hand[i].setAttackCardValues(p);
/*                    hand[i].setIntValues(p.getEnergyCost(),p.getProvision(),p.getTarget(),p.getDamage());
                    hand[i].setDoubleValues(0.0);
                    hand[i].setStrings(p.getDescription(),p.getImageLocalization());
                    hand[i].setBools(true,true,false,false,false);*/
                    break;
                case 1:
                    IceSpear ice = new IceSpear();
                    hand[i].setOffensiveSpellCardValues(ice);
                    /*hand[i].setIntValues(ice.getEnergyCost(),ice.getProvision(),ice.getTarget(),ice.getDamage());
                    hand[i].setDoubleValues(ice.getManaCost());
                    hand[i].setStrings(ice.getDescription(),ice.getImageLocalization());
                    hand[i].setBools(true,true,false,false,false);*/
                    break;
                case 2:
                    Fireball fire = new Fireball();
                    hand[i].setOffensiveSpellCardValues(fire);
/*                    hand[i].setIntValues(fire.getEnergyCost(),fire.getProvision(),fire.getTarget(),fire.getDamage());
                    hand[i].setDoubleValues(fire.getManaCost());
                    hand[i].setStrings(fire.getDescription(),fire.getImageLocalization());
                    hand[i].setBools(true,true,false,false,false);*/
                    break;
                    case 3:
                    ForceField force = new ForceField();
                    hand[i].setDefensiveSpellCardValues(force);
/*                    hand[i].setIntValues(fire.getEnergyCost(),fire.getProvision(),fire.getTarget(),fire.getDamage());
                    hand[i].setDoubleValues(fire.getManaCost());
                    hand[i].setStrings(fire.getDescription(),fire.getImageLocalization());
                    hand[i].setBools(true,true,false,false,false);*/
                    break;
                default:
                    System.out.println("it shouldn't happen");
                    break;
            }
        }
        return hand;
    }


}
