import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

import javax.swing.*;

public class RecipeNote extends JPanel implements ActionListener {

    static final int width = 200;
    static final int height = 200;

    ImageIcon backgroundIcon = new ImageIcon("images/piece_of_paper.png");
    JLabel backgroundLabel = new JLabel();

    ImageIcon textIcon = new ImageIcon("images/coins_sketch.png");
    JLabel textLabel = new JLabel();

    CircleButton closeButton;

    JLayeredPane layeredPane = new JLayeredPane();

    RecipeNote() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(false);

        layeredPane.setBounds(0, 0, width, height);

        Image image = backgroundIcon.getImage();
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(newImg);
        this.backgroundLabel.setIcon(backgroundIcon);

        this.backgroundLabel.setBackground(new Color(0, 0, 0, 0));
        this.backgroundLabel.setBounds(0, 0, width, height);
        this.backgroundLabel.setOpaque(true);

        this.textLabel.setText("Not enough");
        image = textIcon.getImage();
        newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        textIcon = new ImageIcon(newImg);
        this.textLabel.setIcon(textIcon);
        this.textLabel.setForeground(new Color(0, 32, 96));
        this.textLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 32));

        this.textLabel.setBackground(new Color(5, 0, 0, 0));
        this.textLabel.setBounds(1, 1, width - 1, height - 1);
        this.textLabel.setHorizontalAlignment(JLabel.CENTER);
        this.textLabel.setVerticalAlignment(JLabel.CENTER);
        this.textLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.textLabel.setVerticalTextPosition(JLabel.TOP);

        this.textLabel.setOpaque(true);

        this.closeButton = new CircleButton("X");
        this.closeButton.setFont(new Font("Bougher", Font.BOLD, 32));

        this.closeButton.setBounds(20, 15, 40, 40);
        this.closeButton.setOpaque(true);
        this.closeButton.addActionListener(this);

        layeredPane.add(backgroundLabel, Integer.valueOf(1));
        layeredPane.add(textLabel, Integer.valueOf(2));
        layeredPane.add(closeButton, Integer.valueOf(3));

        this.add(layeredPane);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            this.setVisible(false);
        }
    }

    public class CircleButton extends JButton {

        private boolean mouseOver = false;
        private boolean mousePressed = false;

        public CircleButton(String text) {

            super(text);
            setOpaque(false);
            setFocusPainted(false);
            setBorderPainted(false);

            MouseAdapter mouseListener = new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent me) {
                    if (contains(me.getX(), me.getY())) {
                        mousePressed = true;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                    mousePressed = false;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    mouseOver = false;
                    mousePressed = false;
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                    mouseOver = contains(me.getX(), me.getY());
                    repaint();
                }
            };

            addMouseListener(mouseListener);
            addMouseMotionListener(mouseListener);
        }

        private int getDiameter() {
            int diameter = Math.min(getWidth(), getHeight());
            return diameter;
        }

        @Override
        public Dimension getPreferredSize() {
            FontMetrics metrics = getGraphics().getFontMetrics(getFont());
            int minDiameter = 10 + Math.max(metrics.stringWidth(getText()), metrics.getHeight());
            return new Dimension(minDiameter, minDiameter);
        }

        @Override
        public boolean contains(int x, int y) {
            int radius = getDiameter() / 2;
            return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
        }

        @Override
        public void paintComponent(Graphics g) {

            int diameter = getDiameter();
            int radius = diameter / 2;

            if (mousePressed) {
                g.setColor(new Color(0, 0, 0, 20));
            } else {
                g.setColor(new Color(0, 0, 0, 0));
            }

            g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);

            if (mouseOver) {
                g.setColor(new Color(160, 50, 50, 75));
            } else {
                g.setColor(new Color(0, 0, 0, 0));
            }

            g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);

            g.setColor(new Color(160, 50, 50));
            g.setFont(getFont());
            FontMetrics metrics = g.getFontMetrics(getFont());
            int stringWidth = metrics.stringWidth(getText());
            int stringHeight = metrics.getHeight();
            g.drawString(getText(), getWidth() / 2 - stringWidth / 2, getHeight() / 2 + stringHeight / 4);
        }
    }
}
