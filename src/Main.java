import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;

public class Main {

    public static void createAndShowGUI(){
        ImageIcon img = new ImageIcon();
        //Creating and setting up window
        JFrame frame = new JFrame("Screen Test");
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

        JLabel topLabel = new JLabel();
        blueLabel.add(topLabel);
        topLabel.setPreferredSize(new Dimension(360,240));
        topLabel.setVisible(true);
        blueLabel.add(topLabel);
        frame.getContentPane().add(topLabel, BorderLayout.CENTER);
        //setting blueLabels contents alignment
        blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        blueLabel.setVerticalAlignment(SwingConstants.CENTER);
        //Create button
        JButton button = new JButton("Dont Press Me");
        button.setBounds(290, 240, 150, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage(img);
                topLabel.setIcon(img);
            }
        });
        blueLabel.add(button);

        frame.setLayout(new FlowLayout());
//        JScrollPane scrollPane = new JScrollPane(label);
//        frame.add(label);

        //display window
        frame.pack();
        frame.setVisible(true);

    }
    public static void loadImage(ImageIcon img){
        try{
            BufferedImage loadedImage = null;
            loadedImage = ImageIO.read(new FileInputStream("C:\\Users\\lmunn\\Desktop\\miniProjects\\screenTest\\image\\pic.png"));
            img.setImage(loadedImage);
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