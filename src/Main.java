import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void createAndShowGUI(){
        //Creating and setting up window
        JFrame frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating and setting up menu bar. blue background
        JMenuBar blueMenuBar = new JMenuBar();
        blueMenuBar.setOpaque(true);
        blueMenuBar.setBackground(Const.headerBlue);
        blueMenuBar.setPreferredSize(new Dimension(720, 25));
        blueMenuBar.setBorderPainted(false);

        //Creating and setting up dark blue label to put in the content pane
        JLabel blueLabel = new JLabel();
        blueLabel.setOpaque(true);
        blueLabel.setBackground(Const.lightBlue);
        blueLabel.setPreferredSize(new Dimension(720,480));
        frame.setJMenuBar(blueMenuBar);
        frame.getContentPane().add(blueLabel, BorderLayout.CENTER);
        ImageIcon image = new ImageIcon("pic.png");
        JLabel label = new JLabel(image);
        label.setVisible(true);
        label.setBounds(10, 10, 400, 400);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setLayout(new FlowLayout());
//        JScrollPane scrollPane = new JScrollPane(label);
//        frame.add(label);

        //display window
        frame.pack();
        frame.setVisible(true);

    }
    public static void loadImage(){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("pic.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}