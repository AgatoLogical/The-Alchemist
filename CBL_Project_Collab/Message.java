import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Message extends JPanel implements ActionListener{
    JLabel textLabel;
    JButton closeButton;
    JPanel buttonPanel;
    Workshop mainPage;

    Message(Workshop mainPage){
        this.mainPage = mainPage;

        this.setBounds(425, 185, 350, 255);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(69, 37, 12));

        textLabel = new JLabel();
		textLabel.setHorizontalTextPosition(JLabel.CENTER);
		textLabel.setVerticalTextPosition(JLabel.TOP);
		textLabel.setForeground(new Color(250, 219, 195));
		textLabel.setFont(new Font("Courier New", Font.PLAIN, 19));
		textLabel.setOpaque(false);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setHorizontalAlignment(JLabel.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(350, 70));
        buttonPanel.setOpaque(false);

        closeButton = new JButton();
        closeButton.setPreferredSize(new Dimension(60, 40));
        closeButton.setVisible(true);
		closeButton.addActionListener(this);
		closeButton.setFocusable(false);
        closeButton.setBackground(new Color(150, 119, 89));
        closeButton.setBorder(BorderFactory.createEtchedBorder());
        closeButton.setIcon(new ImageIcon("images/close.png"));
        buttonPanel.add(closeButton);

        this.add(textLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }

    public void adjustText(String text){
        textLabel.setText(text);
    }

    public void setGap(int gap){
        textLabel.setIconTextGap(gap);
    }

    public void adjustIcon(ImageIcon icon){
        textLabel.setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            mainPage.removeInstructions();
            this.setVisible(false);
        }
    }
}