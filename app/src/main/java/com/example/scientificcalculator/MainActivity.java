package com.example.scientificcalculator;

import android.net.http.UrlRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;//it is textViw which displays numbers with operators e.g( 5+3+2+1)on the screen
    // just like calculator actual
    private String currentInput = "";//currentinput is a variable of String type , which is taking the input
    //in a string e.g "7+1+2-3" , this input comes from clicking buttons.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //This method call "findviewbyid" is finding the view with id textView3 in the current layout
        // and assigning it to the variable displayTextView. The findViewById method is used to get a reference to the view object.
        //it returns the view if exist in layout xml file
        displayTextView = findViewById(R.id.textView3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    //this is a method name one which appends 1 in currentInput string
    public void one(View view) {
        // Append "1" to the current input
        currentInput += "1";
        //setting currentInput string as a text for displayTextView which displays text on screen
        //curentinput will be displayed onscreen
        displayTextView.setText(currentInput);
    }
    //this is a method name "two" which appends 2 in currentInput string
    public void two(View view) {
        // Append "2" to the current input
        currentInput += "2";
        //setting currentInput string as a text for displayTextView which displays text on screen
        //curentinput will be displayed onscreen
        displayTextView.setText(currentInput);
    }
    //this is a method name "three" which appends 3 in currentInput string
    public void three(View view) {
        // Append "3" to the current input
        currentInput += "3";
        //setting currentInput string as a text for displayTextView which displays text on screen
        //curentinput will be displayed onscreen
        displayTextView.setText(currentInput);
    }
    //this is a method name "four" which appends 4 in currentInput string
    public void four(View view) {
        // Append "4" to the current input
        currentInput += "4";
        //setting currentInput string as a text for displayTextView which displays text on screen
        //curentinput will be displayed onscreen
        displayTextView.setText(currentInput);
    }
    //this is a method name "five" which appends 5 in currentInput string
    public void five(View view) {
        // Append "5" to the current input
        currentInput += "5";
        //setting currentInput string as a text for displayTextView which displays text on screen
        //curentinput will be displayed onscreen
        displayTextView.setText(currentInput);
    }
    //this is a method name "six" which appends 6 in currentInput string
    public void six(View view) {
        // Append "6" to the current input
        currentInput += "6";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "seven" which appends 7 in currentInput string
    public void seven(View view) {
        // Append "7" to the current input
        currentInput += "7";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "eight" which appends 8 in currentInput string
    public void eight(View view) {
        // Append "8" to the current input
        currentInput += "8";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "nine" which appends 9 in currentInput string
    public void nine(View view) {
        // Append "9" to the current input
        currentInput += "9";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "multiply" which appends a "*" in currentInput string
    public void multiply(View view) {
        // Append "*" to the current input
        currentInput += " * ";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "divide" which appends a "/" in currentInput string
    public void divide(View view) {
        // Append "/" to the current input
        currentInput += " / ";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "plus" which appends a "+" in currentInput string
    public void plus(View view) {
        // Append "+" to the current input
        currentInput += " + ";
        //updates the display
        displayTextView.setText(currentInput);
    }
    public void appendNumber(View view) {
        // Get the number from the clicked button
        String number = ((TextView)view).getText().toString();
        // Append the number to the current input
        currentInput += number;
        // Update the display
        displayTextView.setText(currentInput);
    }

    public void appendOperator(String operator) {
        currentInput += " " + operator + " ";
        displayTextView.setText(currentInput);
    }
    //this is a method name "minus" which appends a "-" in currentInput string
    public void minus(View view){
        // Append "-" to the current input
        currentInput += " - ";
        //updates the display
        displayTextView.setText(currentInput);
    }
    //this is a method name "clear" which appends a "" in currentInput string
    public void clear(View view){
        // Append "" to the current input
        currentInput= "";
        //updates the display
        displayTextView.setText(currentInput);
    }

    // this ia method name "result" which displays the result after calculation for e.g 2+1 gives 3 whih is result
    //this method takes iew as a argument
    public void Result(View view) {
        //it is a try-catch block for the exceptions if occur
        try {
            // Split the input by operators and operands
            //split functions splits a string which here is "currentInput", split function create substrings of
            // a string, split method splits before an operator and after the operator(means around operators
            //+, -, *, /) and removes spaces around operators.
            // for e.g 2+3, {"2","+","3"}, the splitted string will be stored in "parts"
            //variable of string type
            String[] parts = currentInput.split("\\s*(?=[\\+\\-\\*\\/])|(?<=[\\+\\-\\*\\/])\\s*");
            double result = 0; //initializing a result variable to 0
            String operator = "+"; // Initialize operator with + to handle the first number correctly
            //(default sign with a number is +)

            //this is for loop which iterates each element(substring) of parts
            for (String part : parts) {
                if (part.isEmpty()) {//it checks whether the substring is empty ""
                    continue; // Skip empty strings
                }
                if (part.matches("[\\+\\-\\*\\/]")) {//if part matches to +, *, /, _(these characters)
                    operator = part.trim(); // Update operator by trim(), which here will remove space around operator
                    //we have used trimhere again because the split method is creating extra spaces in substrings of the
                    //Currentinput string like this : currentInput: "2+5" after split: "2","","+","5"
                } else {
                    double operand = Double.parseDouble(part.trim());//trim method will remove spaces around part
                    //and parseDouble() will parse the part to double means part is string variable and
                    //by parsing it will be stored as a type double in operand variable e.g "5" after parse 5.0

                    // this switch statement takes an operator +, /,-,* , it checks if the operator matches any case
                    switch (operator) {
                        case "+":
                            result += operand;//updates the result variable by adding operand
                            break;
                        case "-":
                            result -= operand;//updates the result variable by subtracting operand
                            break;
                        case "*":
                            result *= operand;////updates the result variable by multiplying operand
                            break;
                        case "/":
                            result /= operand;////updates the result variable by dividing operand
                            break;
                    }
                }
            }
            //updating the display to result value(the result displays on screen)
            displayTextView.setText(String.valueOf(result));
            //these are the exceptions to handle errors
        } catch (NumberFormatException e) { //catching numberformat exception e.g if somebody enters a,b,""
            e.printStackTrace();
            displayTextView.setText("Error: Invalid input");//updates the display to invalid output
        } catch (ArithmeticException e) {// it handles arithmetic errors
            e.printStackTrace();
            displayTextView.setText("Error: Arithmetic error");
        } catch (Exception e) {//it cathes any other error if occurs
            e.printStackTrace();
            displayTextView.setText("Error: An unexpected error occurred");
        }



    }





}


