/*[Pizza]
Name: [Chungsup lim]
Date: [Feb 26, 2019]

Description
[In this Class, set the properties as the radio button style. According to the 
choosen raido button, it will generate the total cost of Pizza.
]
    */

package a4_chungsup.lim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.*;


/**
 * 
 * @Set the values of each size of pizza and etc.
 */
public class Pizza extends VBox{

    RadioButton small, medium, large;
    private double SMALL_PIZZA = 5.25;
    private double MEDIUM_PIZZA = 7.50;
    private double LARGE_PIZZA = 9.95; 
    private double typeOfPizza;
    private double totalCost;
    private int noPizza;
    private String size;
    TextField pizzaAmount;

    // Constructor
    public Pizza(double typeOfPizza, double totalCost, int noPizza, String size) {
        this.typeOfPizza = typeOfPizza;
        this.totalCost = totalCost;
        this.noPizza = noPizza;
        this.size = size;
    }
    
    // Set the properties of radio button for pizza
    public Pizza(){
        super(10);
        small = new RadioButton("Small");
        small.setOnAction(e -> getItem(e));
        medium = new RadioButton("Medium");
        medium.setOnAction(e -> getItem(e));
        large = new RadioButton("Large");
        large.setOnAction(e -> getItem(e));
        ToggleGroup toggle = new ToggleGroup();
        small.setToggleGroup(toggle);
        medium.setToggleGroup(toggle);
        large.setToggleGroup(toggle);
        pizzaAmount = new TextField();


        this.getChildren().addAll(small, medium, large, 
                new Label("Number of Pizzas:"), pizzaAmount);
    }


    // receive the data from pizza radio button and decide the size of pizza
    public void getItem(ActionEvent e){

        if (e.getSource() == small) {
            size = "Small";
            typeOfPizza = SMALL_PIZZA;
        }
        else if (e.getSource() == medium) {
            typeOfPizza = MEDIUM_PIZZA;
            size = "Medium";
        }
        else{
            typeOfPizza = LARGE_PIZZA;
            size = "Large";
        }
        
        try {
            noPizza = Integer.parseInt(pizzaAmount.getText());
        } catch (NumberFormatException e1){
            pizzaAmount.setPromptText("Invalid : Please type numbers");
        }
        getCost();
    }
 
    // receive the data from the getItem method and get the total cost by multiply
    // the amount of pizza
    public double getCost() {
  
        return totalCost = typeOfPizza*noPizza;
    }    

    // toString
    @Override
    public String toString() {
              
        return String.format("Pizza:\t\t%.2f",totalCost) + "\n" + "  " + noPizza +
              " " + size + "\t@  " + typeOfPizza + "\n";

    }

}
