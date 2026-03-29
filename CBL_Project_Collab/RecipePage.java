import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class RecipePage extends JPanel implements ActionListener {

    static final int width = 490;
    static final int height = 510;

    ImageIcon coinsIcon = new ImageIcon("images/coins.png");
    JLabel costLabel = new JLabel();
    JButton unlockButton = new JButton();

    Recipe recipe;
    Recipe recipeParents[] = new Recipe[2];
    JLabel recipeLabel = new JLabel();
    JLabel recipeParentLabels[] = new JLabel[2];

    JLayeredPane layeredPane = new JLayeredPane();

    Fortune fortune = new Fortune();
    RecipeNote note = new RecipeNote();

    Border lightBorder = BorderFactory.createDashedBorder(new Color(199, 163, 121),
            (float) 2.5, (float) 1, (float) 1, true);

    RecipePage() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(false);

        unlockButton.setBounds((int) (width / 2) - 125, (int) (height / 2), 250, 100);
        unlockButton.setFocusable(false);
        unlockButton.setBackground(new Color(100, 100, 100, 0));
        unlockButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        unlockButton.setText("UNLOCK");
        unlockButton.setForeground(new Color(0, 32, 96));
        unlockButton.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
        unlockButton.setHorizontalTextPosition(JLabel.CENTER);
        unlockButton.setVerticalTextPosition(JLabel.CENTER);
        unlockButton.addActionListener(this);

        layeredPane.setBounds(0, 0, width, height);
        costLabel.setBounds((int) (width / 2) - 120, (int) (height / 2) + 100, 250, 50);
        note.setBounds((int) (width / 2) - 100, (int) (height / 2) - 25, 200, 200);

        recipeParentLabels[0] = new JLabel();
        recipeParentLabels[1] = new JLabel();

        this.recipeLabel.setBounds((int) (width / 2) - 75, 25, 150, 150);
        this.recipeLabel.setBorder(lightBorder);

        this.recipeParentLabels[0].setBounds((int) (width / 2) - 125, (int) (height / 2) + 25, 125, 100);
        this.recipeParentLabels[0].setBorder(lightBorder);

        this.recipeParentLabels[1].setBounds((int) (width / 2), (int) (height / 2) + 25, 125, 100);
        this.recipeParentLabels[1].setBorder(lightBorder);

        layeredPane.add(unlockButton, Integer.valueOf(2));
        layeredPane.add(costLabel, Integer.valueOf(2));

        layeredPane.add(recipeLabel, Integer.valueOf(1));
        layeredPane.add(recipeParentLabels[0], JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(recipeParentLabels[1], JLayeredPane.DEFAULT_LAYER);

        layeredPane.add(note, Integer.valueOf(3));
        this.add(layeredPane);
    }

    private void init(Recipe recip) {

        note.setVisible(false);

        this.recipe = recip;

        this.recipeLabel.setIcon(recipe.changeSize(recipe.image, 100));
        this.recipeLabel.setText(recipe.name);

        this.recipeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.recipeLabel.setVerticalAlignment(JLabel.CENTER);
        this.recipeLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.recipeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        this.recipeLabel.setForeground(new Color(0, 32, 96));
        this.recipeLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 28));
        this.recipeLabel.setVisible(true);

        if (recipe.locked) {

            this.unlockButton.setEnabled(true);
            this.unlockButton.setVisible(true);

            costLabel.setVisible(true);
            costLabel.setText("cost: " + recipe.getValue());
            Image image = coinsIcon.getImage();
            Image newImg = image.getScaledInstance(32, 34, java.awt.Image.SCALE_SMOOTH);
            coinsIcon = new ImageIcon(newImg);
            costLabel.setIcon(coinsIcon);
            costLabel.setHorizontalAlignment(JLabel.CENTER);
            costLabel.setVerticalAlignment(JLabel.CENTER);
            costLabel.setHorizontalTextPosition(JLabel.LEFT);
            costLabel.setVerticalTextPosition(JLabel.CENTER);
            costLabel.setForeground(new Color(199, 163, 121));
            costLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 30));

            this.recipeParentLabels[0].setVisible(false);
            this.recipeParentLabels[1].setVisible(false);
        }

        if (!recipe.locked) {

            this.unlockButton.setEnabled(false);
            this.unlockButton.setVisible(false);
            costLabel.setVisible(false);

            this.recipeParents[0] = (Recipe) RecipeBook.getRecipe(CombinationManager.getParent1(recip.name));
            this.recipeParentLabels[0].setIcon(recipeParents[0].changeSize(recipeParents[0].image, 60));
            this.recipeParentLabels[0].setText(recipeParents[0].name);
            this.recipeParentLabels[0].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParentLabels[0].setVerticalAlignment(JLabel.CENTER);
            this.recipeParentLabels[0].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParentLabels[0].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParentLabels[0].setForeground(new Color(0, 32, 96));
            this.recipeParentLabels[0].setFont(new Font("Blackadder ITC", Font.BOLD, 22));
            this.recipeParentLabels[0].setVisible(true);

            this.recipeParents[1] = RecipeBook.getRecipe(CombinationManager.getParent2(recip.name));
            this.recipeParentLabels[1].setIcon(recipeParents[1].changeSize(recipeParents[1].image, 60));
            this.recipeParentLabels[1].setText(recipeParents[1].name);
            this.recipeParentLabels[1].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParentLabels[1].setVerticalAlignment(JLabel.CENTER);
            this.recipeParentLabels[1].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParentLabels[1].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParentLabels[1].setForeground(new Color(0, 32, 96));
            this.recipeParentLabels[1].setFont(new Font("Blackadder ITC", Font.BOLD, 22));
            this.recipeParentLabels[1].setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            if (fortune.spendFortune(recipe)) {
                recipe.unlock();
                this.init(recipe);
                revalidate();
                repaint();
            } else {
                note.setVisible(true);
            }
        }
    }

    public void openPage(Recipe recip) {
        this.init(recip);
        this.setVisible(true);
        revalidate();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        revalidate();
        repaint();
    }
}