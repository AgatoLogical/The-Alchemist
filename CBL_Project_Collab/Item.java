import javax.swing.*;

public class Item extends JLabel {
    public String name;
    public ImageIcon image;
    int slotNumber;
    Boolean isDicovered = false;
    private int valueOfItem = 0;
    private static final int valueIncrease = 100;

    public Item(ImageIcon icon, int category) {
        name = icon.getDescription();
        image = icon;
        this.setIcon(icon);
        this.setVisible(false);
        this.valueOfItem = valueIncrease * category;
    }

    public int getValue() {
        return valueOfItem;
    }
}