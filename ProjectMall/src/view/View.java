package view;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;
import javax.swing.border.Border;   

public class View {
	private static void MallGUI() {
	   Component someComponent = null,yellowLabel = null,anotherComponent = null;
	   Border someBorder = null;
       JMenuBar menuBar = null;
       
	   JFrame frame = new JFrame("Welcome to our Mall!");
	   JLabel label = new JLabel("Hello World");
	   JPanel contentPane = new JPanel(new BorderLayout());

	   contentPane.setBorder(someBorder);
	   contentPane.add(someComponent, BorderLayout.CENTER);
	   contentPane.add(anotherComponent, BorderLayout.PAGE_END);
	   
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.getContentPane().add(label);
	   frame.setBounds(100, 100, 100, 100);
	   frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
	   frame.setJMenuBar(menuBar);
	   frame.setContentPane(contentPane);
	   frame.pack();
	   frame.setVisible(true);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               MallGUI();
           }
       });
   }
}