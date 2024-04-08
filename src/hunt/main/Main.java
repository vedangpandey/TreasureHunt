package hunt.main;

import javax.swing.*;
public class Main {

    Main(){

    }
    public static void main(String[] args) {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Treasure Hunt");
        GamePanel gp=new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.assetSetupGame();
        gp.startGameThread();
    }
}
