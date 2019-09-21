/*[Toppings]
Name: [Chungsup lim]
Date: [Feb 26, 2019]

Description
[In this Class, set the properties as the checkbox style. According to the 
choosen boxes, it will generate the total cost of toppings.
]
    */

package a4_chungsup.lim;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * 
 * @Set the values of each size of toppings and etc.
 */
public class Toppings extends VBox{
        CheckBox cheese, pepperoni, mushrooms, olives;   
        private double CHEESE = 1.00;
        private double MUSHROOMS = 1.25;
        private double OLIVES = 1.50;
        private double PEPPERONI = 1.75;
        private double totalCost;
        

        
        // Set the properties of checkbox for toppings       
        public Toppings() {
            super(10);
            cheese = new CheckBox("Cheese");
            cheese.setOnAction(e -> getItem(e));
            pepperoni = new CheckBox("Pepperoni");
            pepperoni.setOnAction(e -> getItem(e));
            mushrooms = new CheckBox("Mushrooms");
            mushrooms.setOnAction(e -> getItem(e));
            olives = new CheckBox("Olives");
            olives.setOnAction(e -> getItem(e));

            this.getChildren().addAll(cheese, pepperoni, mushrooms, olives);
        }
        
        // adding the cost of toppings by adding selected topping options
        public void getItem(ActionEvent e){
 
        if (e.getSource() == cheese) 
            totalCost += CHEESE;
        
        if (e.getSource() == mushrooms)
            totalCost += MUSHROOMS;
        
        if (e.getSource() == pepperoni) 
            totalCost += PEPPERONI;
            
        if (e.getSource() == olives) 
            totalCost += OLIVES;


        getCost();
        
        //get the total cost of toppings
        }
        public double getCost() {
            return totalCost;
        }    

        @Override
        public String toString() {

            return String.format("Toppings:\t\t%.2f",totalCost) + "\n";

        }
        
        
    }

