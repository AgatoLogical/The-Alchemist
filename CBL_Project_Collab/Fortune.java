import java.awt.*;
import javax.swing.*;

public class Fortune extends JPanel {

    public static int fortune = 0;
    private JLabel label = new JLabel();
    private ImageIcon fortuneIcon = new ImageIcon("images/fortune.png");
    private String fortuneText;

    public Fortune() {
        this.setOpaque(false);
        this.setBounds(975, 700, 250, 100);

        Image image = fortuneIcon.getImage();
        Image newImg = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
        fortuneIcon = new ImageIcon(newImg);
        label.setIcon(fortuneIcon);

        fortuneText = "" + fortune;
        label.setText(fortuneText);

        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.LEFT);

        label.setForeground(new Color(245, 245, 220));
        label.setFont(new Font("Algerian", Font.BOLD, 24));

        this.add(label);

    }

    public void gainFortune(Item item) {
        fortune += item.getValue();
        this.fortuneText = "" + fortune;
        this.label.setText(fortuneText);

        revalidate();
        repaint();
    }

    public boolean spendFortune(Item item) {
        if (fortune - item.getValue() >= 0) {
            fortune -= item.getValue();
            this.fortuneText = "" + fortune;
            this.label.setText(fortuneText);

            revalidate();
            repaint();
            return true;
        }
        return false;
    }

    public void paintFortune() {
        if (!fortuneText.equals("" + fortune)) {
            this.fortuneText = "" + fortune;
            this.label.setText(fortuneText);

            revalidate();
            repaint();
        }
    }
}