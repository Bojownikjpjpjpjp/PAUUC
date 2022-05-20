package Main;

import javax.swing.*;
import java.awt.*;

//to sie ma jakoś dogadywać z swingiem
public class UI {
    public GameManager gm;

    JFrame window;
    JPanel BGPanel;
    JLabel BGLabel;

    public JPanel[] heroLeftPanel = new JPanel[4];
    public JLabel[] heroLeftLabel = new JLabel[4];
    public JPanel[] heroRightPanel = new JPanel[4];
    public JLabel[] heroRightLabel = new JLabel[4];

    public JPanel cardsPanel = new JPanel();
    public JLabel cardsLabel = new JLabel();
    public JPanel[] cardP = new JPanel[4];
    public JLabel[] cardL = new JLabel[4];



    public UI(GameManager GM){
        gm = GM;// w argumencie konstruktora byłu GameManager gm

        createMainField();

        createHeroLeft();
        createHeroRiht();
        createCardsField();

        createBackground();
        window.setVisible(true);
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

    private void createHeroRiht() {
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
        window.setSize(1359,776);
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
    public void createCardsPlaceholders(){
        ImageIcon cardBase = new ImageIcon(UI.class.getResource("/cards/cardTemplate11.png"));

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
    }
}
