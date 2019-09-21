/*[Drinks]
Name: [Chungsup lim]
Date: [Feb 26, 2019]

Description
[In this Class, set the properties as the radio button style. According to the 
choosen raido button, it will generate the total cost of drinks.
]
    */
package a4_chungsup.lim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.*;


/**
 * 
 * @Set the values of each kind of drinks and etc.
 */
public class Drinks extends VBox{
    RadioButton coke, juice, milk;
    private double COKE = 1.25;
    private double JUICE = 1.95;
    private double MILK = 2.25;
    private double typeOfDrink;
    private double totalCost;
    private int noDrink;
    private String popType;
    TextField drinkAmount;

    // Constructor    
    public Drinks(double typeOfDrink, double totalCost, int noDrink, String popType, TextField pizzaAmount) {
        this.typeOfDrink = typeOfDrink;
        this.totalCost = totalCost;
        this.noDrink = noDrink;
        this.popType = popType;
    }
 
    // Set the properties of radio button for drinks    
    public Drinks(){
        super(10);
        coke = new RadioButton("Coke");
        coke.setOnAction(e -> getItem(e));
        juice = new RadioButton("Juice");
        juice.setOnAction(e -> getItem(e));
        milk = new RadioButton("Milk");
        milk.setOnAction(e -> getItem(e));
        ToggleGroup toggle1 = new ToggleGroup();
        coke.setToggleGroup(toggle1);
        juice.setToggleGroup(toggle1);
        milk.setToggleGroup(toggle1);
        drinkAmount = new TextField();

        this.getChildren().addAll(coke, juice, milk, 
                new Label("Number of Drinks:"), drinkAmount);      
    }
    
    // receive the data from drinks radio button and decide the kind of pizza
    public void getItem(ActionEvent e){

        if (e.getSource() == coke) {
            popType = "Coke";
            typeOfDrink = COKE;
        }
        else if (e.getSource() == juice) {
            typeOfDrink = JUICE;
            popType = "Juice";
        }
        else{
            typeOfDrink = MILK;
            popType = "Milk";
        }
        
        try{
        noDrink = Integer.parseInt(drinkAmount.getText());
        } catch (NumberFormatException e1){
            drinkAmount.setPromptText("Invalid : Please type numbers");
        }
        getCost();
    }
    
    // receive the data from the getItem method and get the total cost by multiply
    // the amount of drink
    public double getCost() {
  
        return totalCost = typeOfDrink*noDrink;
    }    

    // toString
    @Override
    public String toString() {
        return String.format("Drinks:\t\t%.2f",totalCost) + "\n" + "  " + 
                noDrink + " " +popType + "\t@  " + typeOfDrink + "\n";
    }


}
