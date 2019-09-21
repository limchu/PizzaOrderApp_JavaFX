/* Name:  [Chungsup Lim]
Assignment:  [Assignment 4]
Program: [Pizza ordering program]
Date:  [Mar 26, 2019]

Description:
[This is a program that ordering pizza, toppings, and drinks.
]
    */
package a4_chungsup.lim;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @Class of main 
 */
public class Pizzeria extends Application {
    
        BorderPane root;
        MenuBar menuBar;
        Menu fileMenu, editMenu;
        MenuItem exitItem;
        TextArea txaDisplay;
        CheckBox chkBorder;
        private Button btnOK, btnCancel;
        private Pizza pizzaPane;
        private Drinks drinkPane;
        private Toppings toppings;
        private Drinks drinks;
        private Toppings toppingPane;
        private double TAX_RATE = 0.13;
        double subT;

        
    @Override
    /**
     * Main class 
     */
    public void start(Stage primaryStage) {
        
        //Creating menu bar
        root = new BorderPane();
        menuBar = new MenuBar();
        fileMenu = new Menu("_File");
        
        //Creating Menu item
        exitItem = new MenuItem("Exi_t");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.T ,
                KeyCombination.SHORTCUT_DOWN));
        exitItem.setOnAction(e-> getMenuAction(e));        
        fileMenu.getItems().add(exitItem);   
        menuBar.getMenus().add(fileMenu);
        
        //Creating panes and set styles 
        pizzaPane = new Pizza();        
        toppingPane = new Toppings();
        drinkPane = new Drinks();
        pizzaPane.setStyle("-fx-border-style: solid");
        toppingPane.setStyle("-fx-border-style: solid");
        drinkPane.setStyle("-fx-border-style: solid");

        HBox topSide = new HBox(5);
        topSide.setAlignment(Pos.CENTER);        
        topSide.getChildren().addAll(pizzaPane, toppingPane, drinkPane);
        
        
        //Creating buttons
        HBox pnlButton = new HBox(5);
        pnlButton.setAlignment(Pos.CENTER);
        btnOK = new Button("_OK");
        btnOK.setPrefWidth(70);
        btnOK.setMnemonicParsing(true);
        btnOK.setOnAction(e -> eventCode(e));
        btnCancel = new Button("_Cancel");
        btnCancel.setOnAction(e -> eventCode(e));
        btnCancel.setPrefWidth(70);
        btnCancel.setMnemonicParsing(true);
        pnlButton.getChildren().addAll(btnOK, btnCancel);
        
        // Creating text area
        txaDisplay = new TextArea();
        txaDisplay.setStyle("-fx-border-style: solid");
        
        
        VBox downSide = new VBox(5);
        downSide.getChildren().addAll(txaDisplay, pnlButton);
        
        root.setTop(menuBar);
        root.setCenter(topSide);
        root.setBottom(downSide);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("My Pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    // exit the program
    private void getMenuAction(ActionEvent e){
            Platform.exit();
        
    }
    
    // receive events
    private void eventCode(ActionEvent e) {
        if (e.getSource() == btnOK) {
            pizzaPane.getItem(e);
            toppingPane.getItem(e);       
            drinkPane.getItem(e);
            display();
        }
        if (e.getSource() == btnCancel) {
            reset();
        }

    }
    
    
    // Cancle button will clear the textarea
    private void reset() {
    txaDisplay.clear();
    }
    
    private double subTotal(){
        subT = toppingPane.getCost()+pizzaPane.getCost()+drinkPane.getCost();
        return subT;
    }
    

    @Override
    public String toString() {
        return String.format("===========================\nSubtotal: \t\t %.2f \nHST: %.2f \nTotal: %.2f",
                subTotal(), subTotal()*TAX_RATE, (subTotal() + subTotal()*TAX_RATE));
    }

    
    
    /**
     * Displays the results in the TextArea
     */
    private void display() {
        txaDisplay.setText(pizzaPane.toString() + toppingPane.toString()
                +drinkPane.toString()+ toString());

    }
}