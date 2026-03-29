import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class RecipeBook extends JFrame implements ActionListener {

    RecipeButton[][] recipeButtons = new RecipeButton[6][5];
    private static List<Recipe> recipes = new ArrayList<>();
    RecipePage recipePage = new RecipePage();

    Fortune fortune = new Fortune();

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;

    JLayeredPane layeredPane = new JLayeredPane();

    ImageIcon book = new ImageIcon("images/book_background.png");
    JLabel background = new JLabel();
    JPanel backgroundPanel = new JPanel();
    JLabel titleLabel = new JLabel("Recipes");

    public RecipeBook() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setTitle("RecipeBook");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        Image image = book.getImage();
        Image newimg = image.getScaledInstance(SCREEN_WIDTH - 50, SCREEN_HEIGHT - 50, java.awt.Image.SCALE_SMOOTH);
        book = new ImageIcon(newimg);
        background.setIcon(book);
        background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setBackground(new Color(224, 157, 112));
        background.setVerticalAlignment(JLabel.CENTER);
        background.setHorizontalAlignment(JLabel.CENTER);
        background.setOpaque(true);

        backgroundPanel.add(background);
        backgroundPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        backgroundPanel.setVisible(true);

        titleLabel.setBounds(250, 65, 200, 100);
        titleLabel.setBackground(new Color(0, 0, 0, 0));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.CENTER);
        titleLabel.setForeground(new Color(0, 32, 96));
        titleLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 60));

        layeredPane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        fortune.setBounds(720, 600, 250, 100);
        recipePage.setBounds(600, 150, 485, 510);

        int i;
        int j;
        int x = 155;
        int y = 170;

        Border lightBorder = BorderFactory.createDashedBorder(new Color(199, 163, 121),
                (float) 2.5, (float) 1, (float) 1, true);

        for (i = 0; i <= 5; i++) {
            x = 150;
            for (j = 0; j <= 4; j++) {
                recipeButtons[i][j] = new RecipeButton();
                recipeButtons[i][j].setBounds(x, y, 70, 70);
                recipeButtons[i][j].setFocusable(false);
                // recipeButtons[i][j].setBackground(new Color(199, 163, 121));
                recipeButtons[i][j].setBackground(new Color(247, 236, 212, 0));
                recipeButtons[i][j].setBorder(lightBorder);
                recipeButtons[i][j].addActionListener(this);
                layeredPane.add(recipeButtons[i][j], Integer.valueOf(1));
                x += 85;
            }
            y += 85;

        }

        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(titleLabel, Integer.valueOf(1));
        layeredPane.add(fortune, Integer.valueOf(1));
        layeredPane.add(recipePage, Integer.valueOf(2));
        this.add(layeredPane);

        this.pack();
    }

    void init() {
        int x = 4;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                recipeButtons[i][j].setName(recipes.get(x).name);
                if (recipes.get(x).getValue() < 200) {
                    recipes.get(x).unlock();
                }
                recipeButtons[i][j].setIcon(recipes.get(x).getIcon());
                x++;
            }
        }
        fortune.paintFortune();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (e.getSource() == recipeButtons[i][j]) {
                    recipePage.openPage(getRecipe(recipeButtons[i][j].getName()));
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.init();
        revalidate();
        repaint();
    }

    public void openBook() {
        this.setVisible(true);
        this.init();
    }

    public static void addRecipe(Recipe recip) {
        recipes.add(recip);
    }

    public static Recipe getRecipe(String name) {
        for (Recipe recipe : recipes) {
            if (name.equals(recipe.name)) {
                return recipe;
            }
        }
        return null;
    }
}
