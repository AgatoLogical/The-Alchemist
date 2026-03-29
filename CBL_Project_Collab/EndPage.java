import java.awt.event.*;
import javax.swing.*;

public class EndPage extends Message{
    ImageIcon confetti;
    String text;

    EndPage(Workshop mainPage){
        super(mainPage);
        text = "<html><br><center>Congratulations!<br>You have discovered all 30 items!</center></html>";
        confetti = new ImageIcon("images/confetti.png");

        adjustText(text);
        setGap(10);
        adjustIcon(confetti);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            mainPage.removeEndPage();
            this.setVisible(false);
        }
    }

}
