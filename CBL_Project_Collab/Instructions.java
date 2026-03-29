import java.awt.event.*;

public class Instructions extends Message{
    String text;

    Instructions(Workshop mainPage){
        super(mainPage);
        text = "<html><br><center>Welcome!<br>Mix Items together by dragging them onto the table and have fun discovering new combinations! For any tips checkout the recipe book!</center></html>";
        adjustText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            mainPage.removeInstructions();
            this.setVisible(false);
        }
    }
}