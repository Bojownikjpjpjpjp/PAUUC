import java.io.FileNotFoundException;

//to ma odczytywać uzytkownika
public class GameManager {

    //public static Fight f;
    public Fight fight;
    public Hand hand;
    public static void main(String[] args){
        FileWritter.addToFile("!!!New fight started!!!");
        Fight fight = new Fight();
        Hand hand = new Hand();
        UI ui = new UI(new GameManager(), fight, hand);
        if(fight.isRunning==false){
            System.exit(0);
        }
    }
    GameManager(){
        fight = new Fight();
    }


}
