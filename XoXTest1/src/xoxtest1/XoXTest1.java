/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoxtest1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author prof9
 */
public class XoXTest1 extends Application {
 
   XoXConsole xoxC = new XoXConsole(); 
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Image windowicon = new Image("file:///C:/Users/prof9/Documents/NetBeansProjects/XoXTest1/src/xoxtest1/tic-tac-toe-hand-drawn-game.png");
        stage.getIcons().add(windowicon);
        Scene scene = new Scene(root);
      
        stage.setTitle("XOX GAME");
        
        
        stage.setScene(scene);
        
        stage.show();
        


stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
               stage.setMaximized(false);
        });


        xoxC.start();
   
              

     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                  
        launch(args);
    }
    
}
