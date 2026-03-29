import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    GameFrame(){
        this.add(new Workshop());
        this.setTitle("Alchemist");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
