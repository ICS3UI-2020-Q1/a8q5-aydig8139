import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel instructions;
  JLabel result;

  JTextField input;

  JButton submitButton;
  JButton newButton;

  //create a random number generator
  Random rand = new Random();

  //get the random number generator to get a number
  int randInt = rand.nextInt(100) + 1;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main JPanel
    mainPanel = new JPanel();

    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the labels
    instructions = new JLabel("Guess the number between 0 and 100:");
    result = new JLabel();

    //layout the labels by setting the coordinate and size 
    instructions.setBounds(20,20,300,20);
    result.setBounds(20,110,300,20);

    //initialize the input text field
    input = new JTextField();

    //set the size and location of the textfield
    input.setBounds(20, 50, 280, 20);

    //initialize the buttons
    submitButton = new JButton("Submit");
    newButton = new JButton("New Number");

    //set the size and location of the buttons
    submitButton.setBounds(20, 90, 100, 20);
    newButton.setBounds(150, 90, 150, 20);

    //add an action listener to the buttons
    submitButton.addActionListener(this);
    newButton.addActionListener(this);

    //set the action command on the buttons
    submitButton.setActionCommand("submit");
    newButton.setActionCommand("new");

    //add the buttons to the panel
    mainPanel.add(submitButton);
    mainPanel.add(newButton);

    //add the text field to the panel
    mainPanel.add(input);

    //add the labels to the main panel 
    mainPanel.add(instructions);
    mainPanel.add(result);
  
    //add the panel to the window
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();


    if(command.equals("submit")){

      //get text from input and change it into an integer
      String inputText = input.getText();
      int inputInt = Integer.parseInt(inputText);

      //check to see how the guess compares to the random integer
      if(inputInt == randInt){
        result.setText("You are correct! Good job!");
      }else if (inputInt < randInt){
        result.setText("Your guess of " + inputInt + " is too low!");
      }else if (inputInt > randInt){
        result.setText("Your guess of " + inputInt + " is too high!");
      }
    }else if(command.equals("new")){

      //clear the text in the text box
      input.setText("");

      //get the random number generator to get a number
      randInt = rand.nextInt(100) + 1;
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
