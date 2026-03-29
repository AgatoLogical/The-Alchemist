import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage extends JPanel implements ActionListener{
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    Image alchemistImage;
    JButton startButton;
    JPanel startPanel;
    ImageIcon alchemistTitle;
    JLabel titleLabel;
    JPanel titlePanel;
    Workshop mainPage;

    StartPage(Workshop workshop){
        mainPage = workshop;

        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setBackground(new Color(150, 119, 89));
        this.setLayout(new BorderLayout(0,0));

        titlePanel = new JPanel(new BorderLayout());
        alchemistImage = new ImageIcon("images/alchemist.png").getImage();
        alchemistTitle = new ImageIcon("images/AlchemistTitle.png");
        titleLabel = new JLabel();
        startPanel = new JPanel(new GridBagLayout());
        
        titlePanel.setOpaque(false);

        startPanel.setBackground(new Color(69, 37, 12));
        startPanel.setPreferredSize(new Dimension(400, 100));

        titleLabel.setIcon(alchemistTitle);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;

        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(300, 50));
        startButton.setVisible(true);
		startButton.addActionListener(this);
		startButton.setFocusable(false);
		startButton.setForeground(new Color(69, 37, 12));
		startButton.setBackground(new Color(150, 119, 89));
		startButton.setBorder(BorderFactory.createEtchedBorder());
        startButton.setIcon(new ImageIcon("images/buttonImg.png"));
        startButton.setHorizontalTextPosition(JButton.CENTER);
		startButton.setVerticalTextPosition(JButton.BOTTOM);

        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(startButton, BorderLayout.SOUTH);

        startPanel.add(titlePanel, constraints);
        this.add(startPanel, BorderLayout.EAST);
    }

    public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(alchemistImage, 0, 0, null);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            mainPage.removeStartPage();
            this.setVisible(false);
        }
    }

    
}
