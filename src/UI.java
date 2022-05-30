import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class UI {
    final public GameManager gm;
    public Fight fight = new Fight();
    public Hand hand = new Hand();
    static JFrame window;
    JPanel BGPanel;
    JLabel BGLabel;

    //placeholder for hero icons
    public JPanel[] heroLeftPanel = new JPanel[4];
    public JLabel[] heroLeftLabel = new JLabel[4];
    public JPanel[] heroRightPanel = new JPanel[4];
    public JLabel[] heroRightLabel = new JLabel[4];

    //placeholder for cards
    public JPanel cardsPanel = new JPanel();
    public JLabel cardsLabel = new JLabel();
    public JPanel[] cardP = new JPanel[4];
    public JLabel[] cardL = new JLabel[4];

    //selected card stuff
    public JPanel selectCardP = new JPanel();
    public JLabel selectCardL = new JLabel();
    public JTextArea selectedEnergy = new JTextArea();
    public JTextArea selectedMana = new JTextArea();
    public JTextArea selectedDamage = new JTextArea();
    public JTextArea selectedDesciption = new JTextArea();

    //active buttons
    public JButton use = new JButton();
    public JButton endTurn = new JButton();
    public JButton surrender = new JButton();

    //left hero attribs
    public JTextArea h1HP = new JTextArea();
    public JTextArea h1mana = new JTextArea();
    public JTextArea h1AP = new JTextArea();
    public JTextArea h1Energy = new JTextArea();
    public JTextArea h1Armor = new JTextArea();

    //right hero attribs
    public JTextArea h2HP = new JTextArea();
    public JTextArea h2mana = new JTextArea();
    public JTextArea h2AP = new JTextArea();
    public JTextArea h2Energy = new JTextArea();
    public JTextArea h2Armor = new JTextArea();

    //fight info
    public JTextArea round = new JTextArea();
    public JTextArea turn = new JTextArea();
    public JTextArea finishScreen = new JTextArea();
    //console
    public static JTextArea console = new JTextArea();

    public UI(GameManager GM,Fight f, Hand h){
        gm = GM;// w argumencie konstruktora było GameManager gm
        fight = f;
        hand = h;

        createMainField();
        createConsole();

        createButtons();//navigation stuff
        setFightValues();//info about the fight

        createHeroLeft();//left hero icon
        createHeroRight();//right hero icon

        createHeroLeftInfo();//left hero stats
        createHeroRightInfo();//right hero stats

        createCardsField();//placeholder for cards
        createSelectInfo();//placeholder for selected card

        exposeHand(hand);

        createBackground();//noone excepts bacground
        window.setVisible(true);
    }


    private void createHeroLeftInfo() {
        h1HP.setText("HP "+ fight.player[0].getHealthPoint());
        h1HP.setLayout(null);
        h1HP.setBounds(20,40,100,20);
        h1HP.setMargin(new Insets(0, 3, 2, 3));
        h1HP.setEditable(false);
        window.add(h1HP);

        h1mana.setText("mana "+ fight.player[0].getMana());
        h1mana.setLayout(null);
        h1mana.setBounds(20,85,100,20);
        h1mana.setMargin(new Insets(0, 3, 2, 3));
        h1mana.setEditable(false);
        window.add(h1mana);

        h1AP.setText("action points "+ fight.player[0].getActionPoints());
        h1AP.setLayout(null);
        h1AP.setBounds(20,130,100,20);
        h1AP.setMargin(new Insets(0, 3, 2, 3));
        h1AP.setEditable(false);
        window.add(h1AP);

        h1Energy.setText("Energy "+ fight.player[0].getEnergy());
        h1Energy.setLayout(null);
        h1Energy.setBounds(20,175,100,20);
        h1Energy.setMargin(new Insets(0, 3, 2, 3));
        h1Energy.setEditable(false);
        window.add(h1Energy);

        h1Armor.setText("Armor "+ fight.player[0].getArmorModifier());
        h1Armor.setLayout(null);
        h1Armor.setBounds(20,220,100,20);
        h1Armor.setMargin(new Insets(0, 3, 2, 3));
        h1Armor.setEditable(false);
        window.add(h1Armor);
    }
    private void createHeroRightInfo() {
        h2HP.setText("HP "+ fight.player[1].getHealthPoint());
        h2HP.setLayout(null);
        h2HP.setBounds(1024,40,100,20);
        h2HP.setMargin(new Insets(0, 3, 2, 3));
        h2HP.setEditable(false);
        window.add(h2HP);

        h2mana.setText("mana "+ fight.player[1].getMana());
        h2mana.setLayout(null);
        h2mana.setBounds(1024,85,100,20);
        h2mana.setMargin(new Insets(0, 3, 2, 3));
        h2mana.setEditable(false);
        window.add(h2mana);

        h2AP.setText("action points "+ fight.player[1].getActionPoints());
        h2AP.setLayout(null);
        h2AP.setBounds(1024,130,100,20);
        h2AP.setMargin(new Insets(0, 3, 2, 3));
        h2AP.setEditable(false);
        window.add(h2AP);

        h2Energy.setText("Energy "+ fight.player[1].getArmorModifier());
        h2Energy.setLayout(null);
        h2Energy.setBounds(1024,175,100,20);
        h2Energy.setMargin(new Insets(0, 3, 2, 3));
        h2Energy.setEditable(false);
        window.add(h2Energy);

        h2Armor.setText("Armor "+ fight.player[1].getArmorModifier());
        h2Armor.setLayout(null);
        h2Armor.setBounds(1024,220,100,20);
        h2Armor.setMargin(new Insets(0, 3, 2, 3));
        h2Armor.setEditable(false);
        window.add(h2Armor);
    }
    private void createHeroLeft() {
        heroLeftPanel[1] = new JPanel();
        //poz poczatkowa
        heroLeftPanel[1].setBounds(20,270,300,400);
        heroLeftPanel[1].setBackground(null);
        heroLeftPanel[1].setLayout(null);
        window.add(heroLeftPanel[1]);

        heroLeftLabel[1]= new JLabel();
        //poz wzgledna
        heroLeftLabel[1].setBounds(0,0,300,400);

        /* stary import img
        java.net.URL heroLeftIconurl = UI.class.getResource("/heroes/wizard/hero.jpg");
        ImageIcon heroLeftIcon = new ImageIcon(heroLeftIconurl);*/
        ImageIcon heroLeftIcon = new ImageIcon(UI.class.getResource("/heroes/wizard/hero_normal1.png"));
        //BufferedImage heroLeftIcon = new BufferedImage(UI.class.getResource("heroes/wizard/hero_normal1.png"));
        //heroLeftIcon.TYPE_INT_ARGB();
        heroLeftLabel[1].setIcon(heroLeftIcon);
        heroLeftPanel[1].add(heroLeftLabel[1]);
    }
    private void createHeroRight() {
        heroRightPanel[1]= new JPanel();
        //poz poczatkowa
        heroRightPanel[1].setBounds(1024,270,300,400);
        heroRightPanel[1].setBackground(Color.blue);
        heroRightPanel[1].setLayout(null);
        window.add(heroRightPanel[1]);

        heroRightLabel[1]= new JLabel();
        //poz wzgledna
        heroRightLabel[1].setBounds(0,0,300,400);

        /*  stary import img
        java.net.URL heroRightIconurl = UI.class.getResource("/heroes/wizard/hero.jpg");
        ImageIcon heroRightIcon = new ImageIcon(heroRightIconurl);*/
        ImageIcon heroRightIcon = new ImageIcon(UI.class.getResource("/heroes/wizard/hero12.jpg"));
        heroRightLabel[1].setIcon(heroRightIcon);
        heroRightPanel[1].add(heroRightLabel[1]);
    }
    public void createButtons(){
        use.setText("use");
        use.setLayout(null);
        use.setBounds(597,460,120,40);
        use.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = findSelectedCard();
                if (i==5){
                    consoleOutput("none card selected, click one firstly");
                    return;
                }
                fight.useCard(hand.cardVectors[i]);
                updateValuesH1();
                updateValuesH2();
            }
        });
        window.add(use);

        endTurn.setText("endTurn");
        endTurn.setLayout(null);
        endTurn.setBounds(737,460,120,40);

        endTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fight.triggerRegens();
                if(fight.getHeroTurn()==2){
                fight.setRound(fight.getRound()+1);
                fight.setHeroTurn(1);
                }
                else if(fight.getHeroTurn()==1){
                    fight.setHeroTurn(2);
                }
                consoleOutput("Player "+fight.getHeroTurn() + " turn");
                updateFigtValues();
                updateValuesH1();
                updateValuesH2();
                clearExposeSelectedCard();
                hand.setCardVectors(hand.randomizeHand(hand.getCardVectors()));
                exposeHand(hand);
            }
        });
        window.add(endTurn);

        surrender.setText("surrender");
        surrender.setLayout(null);
        surrender.setBounds(1024,680,100,20);
        surrender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fight.getHeroTurn()==1){
                    fight.player[0].setHealthPoint(0);
                    updateValuesH1();
                }
                else if(fight.getHeroTurn()==2){
                    fight.player[1].setHealthPoint(0);
                    updateValuesH2();
                }
                FileWritter.addToFile(fight.getHeroTurn()+ " has surrendered");
                fight.finishFight();
            }
        });
        window.add(surrender);
    }
    public int findSelectedCard(){
        for(int i=0;i<4;i++){
            if(hand.cardVectors[i].bools[4]==true){return i;}
        }
        return 5;
    }
    public void createConsole(){
        console.setText("Fight Started !");
        console.setLayout(null);
        console.setMargin(new Insets(0, 5, 2, 5));
        console.setBounds(200,760,900,30);
        console.setForeground(Color.white);
        console.setBackground(Color.black);
        console.setSelectedTextColor(Color.white);
        console.setEditable(false);
        window.add(console);
    }
    public static void consoleOutput(String out){
        console.setText(out);
    }
    public static void finishPrompt(String winner){
        JOptionPane.showMessageDialog(window ,"Fight ended "+winner+ " won");
        System.exit(0);
    }
    public void createBackground(){

        BGPanel = new JPanel();
        BGPanel.setLayout(null);
        BGPanel.setBackground(Color.yellow);
        BGPanel.setBounds(0,0,1344,756);
        window.add(BGPanel);

        BGLabel = new JLabel();
        BGLabel.setBounds(0,0,1344,756);
        ImageIcon fightStage = new ImageIcon(UI.class.getResource("/bacgrounds/back_ground2.jpg"));
        BGLabel.setIcon(fightStage);
        BGPanel.add(BGLabel);
    }
    public void createMainField(){
        window = new JFrame();
        window.setSize(1359,816);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
    }
    public void createCardsField(){
        cardsPanel = new JPanel();
        cardsPanel.setLayout(null);
        cardsPanel.setBounds(357,526,630,200);
        window.add(cardsPanel);

        cardsLabel = new JLabel();
        cardsLabel.setBounds(0,0,630,200);
        cardsPanel.add(cardsLabel);

        createCardsPlaceholders();
    }
    public void exposeHand(Hand hand){
        ImageIcon imagePath;
        for (int i=0;i<4;i++) {
            imagePath = new ImageIcon(UI.class.getResource(hand.getCardVectors()[i].getStrings()[1]));
            cardL[i].setIcon(imagePath);
        }
    }
    public void exposeSelectedCard(){
        ImageIcon imagePath;
        int cardNo = findSelectedCard();
        imagePath = new ImageIcon(UI.class.getResource(hand.getCardVectors()[cardNo].getStrings()[1]));
        selectCardL.setIcon(imagePath);
        //tekst
        selectedEnergy.setText("Energy cost: "+ hand.getCardVectors()[cardNo].getIntValues()[0]);
        selectedMana.setText("Mana cost: "+ hand.getCardVectors()[cardNo].getDoubleValues()[0]);
        if(hand.getCardVectors()[cardNo].getIntValues()[2]==0){
            selectedDamage.setText("Armor: "+ hand.getCardVectors()[cardNo].getIntValues()[3]);
        }
        else {
            selectedDamage.setText("Damage: " + hand.getCardVectors()[cardNo].getIntValues()[3]);
        }
        selectedDesciption.setText("Description: "+ hand.getCardVectors()[cardNo].getStrings()[0]);
    }
    public void clearExposeSelectedCard(){
        ImageIcon imagePath = new ImageIcon(UI.class.getResource("/cardsImages/cardTemplate11.png"));
    /*    String path = new String();
        path = hand.getCardVectors()[cardNo].getStrings()[0];
        System.out.println(path);*/
        selectCardL.setIcon(imagePath);
        //tekst
        selectedEnergy.setText("Energy cost: ");
        selectedMana.setText("Mana cost: ");
        selectedDamage.setText("Damage: ");
        selectedDesciption.setText("Description: ");
    }
    public void createSelectInfo(){
        ImageIcon cardBase = new ImageIcon(UI.class.getResource("/cardsImages/cardTemplate11.png"));
        selectCardP = new JPanel();
        selectCardP.setLayout(null);
        selectCardP.setBounds(357, 270, 150, 200);
        window.add(selectCardP);

        selectCardL = new JLabel();
        selectCardL.setBounds(0, 0, 150, 200);
        selectCardL.setIcon(cardBase);
        selectCardP.add(selectCardL);

        selectedEnergy.setText("Energy cost: ");
        selectedEnergy.setLayout(null);
        selectedEnergy.setBounds(522,300,150,20);
        selectedEnergy.setMargin(new Insets(0, 2, 2, 3));
        selectedEnergy.setEditable(false);
        window.add(selectedEnergy);

        selectedMana.setText("Mana cost: ");
        selectedMana.setLayout(null);
        selectedMana.setBounds(522,325,150,20);
        selectedMana.setMargin(new Insets(0, 2, 2, 3));
        selectedMana.setEditable(false);
        window.add(selectedMana);

        selectedDamage.setText("Damage: ");
        selectedDamage.setLayout(null);
        selectedDamage.setBounds(522,350,150,20);
        selectedDamage.setMargin(new Insets(0, 2, 2, 3));
        selectedDamage.setEditable(false);
        window.add(selectedDamage);

        selectedDesciption.setText("Description: ");
        selectedDesciption.setLayout(null);
        selectedDesciption.setLineWrap(true);
        selectedDesciption.setBounds(522,375,150,60);
        selectedDesciption.setMargin(new Insets(0, 2, 2, 3));
        selectedDesciption.setEditable(false);
        window.add(selectedDesciption);

    }
    public void createCardsPlaceholders(){
        ImageIcon cardBase = new ImageIcon(UI.class.getResource("/cardsImages/cardTemplate11.png"));

        for (int i = 0; i<4; i++) {
            cardP[i] = new JPanel();
            cardP[i].setLayout(null);
            cardP[i].setBounds(160 * i, 0, 150, 200);
            cardsPanel.add(cardP[i]);

            cardL[i] = new JLabel();
            cardL[i].setBounds(0, 0, 150, 200);
            cardL[i].setIcon(cardBase);
            cardP[i].add(cardL[i]);
        }
        //ustalenie mouse listenerów (nie chciało przejść w pętli
        cardL[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setIsSelected(0);
                exposeSelectedCard();
            }
        });
        cardL[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setIsSelected(1);
                exposeSelectedCard();
            }
        });
        cardL[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setIsSelected(2);
                exposeSelectedCard();
            }
        });
        cardL[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setIsSelected(3);
                exposeSelectedCard();
            }
        });
    }
    public void setIsSelected(int i){
        //ustawienie isSelected na false dla kart zapewni isSelected true wyłącznie dla klikniętej karty
        hand.cardVectors[0].setBools(true,true,false,false,false);
        hand.cardVectors[1].setBools(true,true,false,false,false);
        hand.cardVectors[2].setBools(true,true,false,false,false);
        hand.cardVectors[3].setBools(true,true,false,false,false);
        hand.cardVectors[i].setBools(true,true,false,false,true);
        consoleOutput("you selected card " + (i+1));
    }
    public void setFightValues(){
        round.setText("round "+ fight.getRound());
        round.setLayout(null);
        round.setBounds(622,40,100,30);
        round.setMargin(new Insets(5, 4, 2, 3));
        round.setEditable(false);
        window.add(round);

        turn.setText("turn of player "+ fight.getHeroTurn());
        turn.setLayout(null);
        turn.setBounds(622,80,100,30);
        turn.setMargin(new Insets(5, 4, 2, 3));
        turn.setEditable(false);
        window.add(turn);

    }
    public void updateValuesH1(){
        h1HP.setText("HP "+ fight.player[0].getHealthPoint());
        h1mana.setText("mana "+ fight.player[0].getMana());
        h1AP.setText("action points "+ fight.player[0].getActionPoints());
        h1Energy.setText("Energy "+ fight.player[0].getEnergy());
        h1Armor.setText("Armor "+fight.player[0].getArmorModifier());
      }
    public void updateValuesH2(){
        h2HP.setText("HP "+ fight.player[1].getHealthPoint());
        h2mana.setText("mana "+ fight.player[1].getMana());
        h2AP.setText("action points "+ fight.player[1].getActionPoints());
        h2Energy.setText("Energy "+ fight.player[1].getEnergy());
        h2Armor.setText("Armor "+fight.player[1].getArmorModifier());
    }
    public void updateFigtValues() {
        round.setText("round "+ fight.getRound());
        turn.setText("turn of player "+ fight.getHeroTurn());
    }
}
