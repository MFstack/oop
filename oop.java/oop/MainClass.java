package oop;
import java.awt.FlowLayout;
//import java.text.ParseException;
//import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Arrays;
import uk.ac.leedsbeckett.oop.LBUGraphics;
import java.util.Scanner;
import java.awt.Color;

public class MainClass extends LBUGraphics
{
    Scanner scanner = new Scanner(System.in);
        private final String[] commandValid =
        {"forward", "backward", "left", "right", "point", "pendown", "penup", "red", "black", "green", "white", "reset", "clear"};
        public static void main(String[] args)
        {
                new MainClass();
        }

        public MainClass()
        {
                JFrame MainFrame = new JFrame();            
                MainFrame.setLayout(new FlowLayout());     
                MainFrame.add(this);                       
                MainFrame.setSize(850,450);                
                MainFrame.setVisible(true);                
                                                    
                about();                                                                    
        }

        
                

    
        @Override
    public void processCommand(String command) {
        Scanner scanner = new Scanner(command);
        if (scanner.hasNext()) {
            String cmd = scanner.next();
            switch (cmd.toLowerCase()) {
                case "penup":
                    penUp();
                    break;
                case "pendown":
                    penDown();
                    break;
                case "left":
                    if (scanner.hasNextInt()) {
                        int degrees = scanner.nextInt();
                        turnLeft(degrees);
                    } else {
                        displayMessage("Invalid parameter. Please provide an integer value.");
                    }
                    break;
                case "right":
                    if (scanner.hasNextInt()) {
                        int degrees = scanner.nextInt();
                        turnRight(degrees);
                    } else {
                        displayMessage("Invalid parameter. Please provide an integer value.");
                    }
                    break;
                case "forward":
                    if (scanner.hasNextInt()) {
                        int distance = scanner.nextInt();
                        forward(distance);
                    } else {
                        displayMessage("Invalid parameter. Please provide an integer value.");
                    }
                    break;
                case "backward":
                    if (scanner.hasNextInt()) {
                        int distance = scanner.nextInt();
                        forward(-distance); // Move in the opposite direction
                    } else {
                        displayMessage("Invalid parameter. Please provide an integer value.");
                    }
                    break;
                case "black":
                    setPenColour(Color.BLACK);
                    break;
                case "green":
                    setPenColour(Color.GREEN);
                    break;
                case "red":
                    setPenColour(Color.RED);
                    break;
                case "white":
                    setPenColour(Color.WHITE);
                    break;
                case "reset":
                    reset();
                    break;
                case "clear":
                    clear();
                    break;
                case "penstroke":
                    setStroke(100);
                    break;
                case "circle":
                    drawCircle(50);
                    break;
                case "square":
                    drawSquare(100);
                    break;
                case "rectangle":
                    drawRectangle(100, 50);
                    break;
                default:
                    displayMessage("Invalid command. Please try again.");
                    break;
            }
        } else {
            displayMessage("Please enter a command.");
        }
        scanner.close();
    }

    private boolean isValidCommand(String command) {
        return Arrays.stream(commandValid).anyMatch(command::equals);
    }

    private void drawCircle(int radius) {
        penDown();
        for (int i = 0; i < 360; i++) {
            forward(radius / 10);
            turnRight(1);
        }
        penUp();
    }

    private void drawSquare(int sideLength) {
        penDown();
        for (int i = 0; i < 4; i++) {
            forward(sideLength);
            turnRight(90);
        }
        penUp();
    }

    private void drawRectangle(int width, int height) {
        penDown();
        for (int i = 0; i < 2; i++) {
            forward(width);
            turnRight(90);
            forward(height);
            turnRight(90);
        }
        penUp();
    
     
    }
}