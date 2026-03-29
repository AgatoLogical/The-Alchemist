import java.awt.Image;

import javax.swing.*;

public class Recipe extends Item {

    public boolean locked;
    private ImageIcon lockIcon = new ImageIcon("images/lock.png");
    public String name = "";

    public Recipe(ImageIcon compIcon, int category) {
        super(compIcon, category);
        super.image = changeSize(compIcon, 55);
        this.name = compIcon.getDescription();
        lockIcon = changeSize(lockIcon, 55);
        this.setIcon(lockIcon);
        this.setVisible(false);
        locked = true;
    }

    public void unlock() {
        this.setIcon(super.image);
        locked = false;
    }

    public ImageIcon changeSize(ImageIcon imageIcon, int length) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(length, length, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }
}
