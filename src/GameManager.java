//to ma odczytywać uzytkownika
public class GameManager {

    //public static Fight f;
    public Fight fight;
    public Hand hand;
    public static void main(String[] args) {
        Fight fight = new Fight();
        Hand hand = new Hand();
        UI ui = new UI(new GameManager(), fight, hand);

    }
    GameManager(){
        fight = new Fight();
    }


}
