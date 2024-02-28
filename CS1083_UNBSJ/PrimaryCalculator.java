import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/***********************************************************************
 * Write a description of JavaFX class PrimaryCalculator here.
 *
 * @author NGUYEN THANH KHOI TRAN
 * @date Feb 10, 2024
 * @version Assgn_v1
 **********************************************************************/
public class PrimaryCalculator extends Application
{
    // Instance data to make 3 lines (Q3)
    private TextField input;
    private TextField output;
    private TextField result;
    
    // Instance data to make 3 radio buttons - grades (Q4)
    private RadioButton grade_4;
    private RadioButton grade_5;
    private RadioButton grade_6;
    
    // Instance data to support in problem-solving 
    private int firstNum = 0;
    private int secondNum = 0;
    private String currentNum = "";
    private String curNum2 = "";
    private static int count = 0;
    private String temp = "";
    
    @Override
    public void init () throws Exception {}
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Display a brand for calculator (Q2) 
        Label brand = new Label ("Nguyen's Calculator for Basic Level Math");
        brand.setStyle("-fx-font-size: 18; -fx-font-weight: bold;"); // -- CSS --
        
        // Display number on the first line (Q3)
        input = new TextField ();
        input.setEditable(false); // just use button to input only
        input.setAlignment (Pos.CENTER_RIGHT);
        
        // Display number on the second line (Q3)
        output = new TextField ();
        output.setEditable(false);
        output.setAlignment (Pos.CENTER_RIGHT);
        
        // Display number on the third line (Q3)
        result = new TextField ();
        result.setEditable(false); 
        result.setAlignment (Pos.CENTER);
        
        // Display all three lines (Q3)
        VBox lines = new VBox (5);
        lines.getChildren().addAll(input, output, result);
        lines.setAlignment (Pos.CENTER_RIGHT);
        
        // Radio button for grade (Q4)
        ToggleGroup tg = new ToggleGroup();
        grade_4 = new RadioButton("Grade 4 Math");
        grade_5 = new RadioButton("Grade 5 Math");
        grade_6 = new RadioButton("Grade 6 Math");
        grade_4.setToggleGroup (tg);
        grade_5.setToggleGroup (tg);
        grade_6.setToggleGroup (tg);
        
        // An set of number button for 0-9 with buttons (Q5)
        Button [] nums = new Button [10];
        for (int i = 0; i < 10; i++)
        {
            final String number = "" + i;
            nums [i] = new Button (number);
            nums [i].setOnAction (new EventHandler <ActionEvent>()
            {
                @Override
                public void handle (ActionEvent event)
                {
                    currentNum += number;
                    input.setText (currentNum);
                    if (count == 1) {
                        curNum2 += number;
                        input.setText (firstNum + " "+ temp + " " + curNum2);
                        secondNum = Integer.valueOf (curNum2);
                    }
                }
            });
        }
        HBox numbers = new HBox (5);
        numbers.getChildren().addAll (nums);
        numbers.setAlignment (Pos.CENTER);
        
        // Add operator buttons + - x ÷ = and calculation (Q6,8, 9, 10, 11, 12)        
        String [] operator = {"+", "-", "x", "÷", "="};
        Button [] sign = new Button [operator.length];
        for (int i = 0; i < (operator.length - 1); i++)
        {
            sign [i] = new Button (operator[i]);
            final String operatorInput = operator [i];
            
            // Make a sign button except '='
            sign [i].setOnAction (new EventHandler <ActionEvent>()
            {
                @Override
                public void handle (ActionEvent event)
                {
                    temp += operatorInput;
                    firstNum = Integer.valueOf(currentNum);
                    input.setText(firstNum + " "+ temp);
                    count++;
                }
            });
        }
        
        // For equal '=' sign (Q6, Q8)
        sign [4] = new Button (operator[4]);
        sign [4].setOnAction (new EventHandler <ActionEvent> ()
        {
            @Override
            public void handle (ActionEvent event)
            {
                double ans = 0;
                input.setText(firstNum + " "+ temp + " " + secondNum);
                if (grade_4.isSelected() || grade_5.isSelected() || grade_6.isSelected())
                {
                    switch (temp)
                    {
                    case "+":
                        ans += (int) (firstNum + secondNum);
                        output.setText (String.format("%.0f", ans));
                        result.clear();
                        break;
                        
                    case "-":
                        if (grade_4.isSelected() && firstNum < secondNum)
                        {
                            output.clear();
                            result.setText ("Grade 4 -> (first num > second num) only");
                        }
                        else 
                        {
                            ans += (int) (firstNum - secondNum);
                            output.setText (String.format("%.0f", ans));
                            result.clear();
                        }
                        break;
                        
                    case "x":
                        ans += (int) (firstNum * secondNum);
                        output.setText (String.format("%.0f", ans));
                        result.clear();
                        break;
                    
                    case "÷":
                        if (grade_4.isSelected() && firstNum % secondNum != 0)
                        {
                            output.clear();
                            result.setText ("Grade 4 -> No remainder only");
                        }
                        else if (grade_5.isSelected())
                        {
                            int remainder = firstNum % secondNum;
                            ans += (int) (firstNum / secondNum);
                            result.clear();
                            output.setText(String.format("%.0f", ans) + " R " + remainder);
                        }
                        else if (grade_6.isSelected())
                        {
                            ans += (double) firstNum / secondNum;
                            result.clear();
                            output.setText(String.format("%.4f", ans));
                        }
                        else
                        {
                            ans += (int) (firstNum / secondNum);
                            result.clear();
                            output.setText (String.format("%.0f", ans));
                        }
                        break;
                    
                    default:
                        result.setText ("Invaild input");
                    }
                }
                
                else 
                    result.setText ("Please choose which grade you want to make a calculation");
            }
        });

        // Clear button (Q7)
        Button clear = new Button ("CLEAR");
        clear.setOnAction (new EventHandler <ActionEvent>()
        {
            @Override
            public void handle (ActionEvent event)
            {
                input.clear();
                output.clear();
                result.clear();
                currentNum = "";
                curNum2 = "";
                temp = "";
                firstNum = 0;
                secondNum = 0;
                count = 0;
            }
        });
        
        // Display operator buttons
        FlowPane operators = new FlowPane (sign);
        operators.setAlignment (Pos.CENTER);
        
        // Display all the button, radio buttons and lines
        VBox root = new VBox (10, brand, lines, grade_4, grade_5, grade_6, numbers, operators, clear);
        root.setAlignment (Pos.CENTER);
        
        // JavaFX must have a Scene (window content) inside a Stage (window) - default
        Scene myScene = new Scene(root, 400, 400);
        primaryStage.setTitle("Nguyen's Calculator");
        primaryStage.setScene(myScene);

        // Show the Stage (window) - default
        primaryStage.show();
    }
    
    @Override public void stop () throws Exception {}
    
}
