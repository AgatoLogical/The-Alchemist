import java.awt.event.*;

public class DiscoveryMessage extends Message{
    Item item;
    String text;

    DiscoveryMessage(Item item, Workshop mainPage){
        super(mainPage);
        text = "<html><br><center>New Item Discovered:<br>" + item.name + "</center></html>";
        adjustText(text);
        setGap(15);
        adjustIcon(item.image);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            mainPage.removeMessage();
            this.setVisible(false);
            
        }
    }
}
