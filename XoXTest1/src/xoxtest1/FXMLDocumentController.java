/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoxtest1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author prof9
 */
public class FXMLDocumentController implements Initializable {
    
 public Button upperLeft;
 public Button up;
 public Button upperRight;
 public Button left;                                    //all buttons declared here
 public Button middle;
 public Button right;
 public Button bottomLeft;
 public Button down;
 public Button bottomRight;
 public Label  turnXOX;
 public Label  xWins;
 public Label  oWins;
 
 
 XoXTest1 main = new XoXTest1();                         //to access our main class and methods
 int i=1;                                                // i is an TURN counter
 int space = 9;                                         // We have a variable named SPACE to calculate DRAW
 playing ply = new playing();
 Board   board= new Board();
 winningConditions winC = new winningConditions();
 int result=1;
 int xW = 0;                                   //Win Counter for X
 int oW = 0;                                  // Win Counter for O
 
 public void unacceptableMove(){                              //A Warning message if clicked place is not empty
     
     int um = JOptionPane.showConfirmDialog(null,"Place is already filled","Unacceptable Move",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE ,null); 
     
 }
 
 public void draw(){                                           //Our DRAW calculator method
     if (space==0){   
         int winner = JOptionPane.showConfirmDialog(null,   " DRAW ! ", "DRAW ! ", JOptionPane.DEFAULT_OPTION);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
     }
 }
 public void reset(){                           //Our RESET method if User's wants to play again
     
            turnXOX.setText("X");
            i=0;
            space =9;
                  upperLeft.setText(null);
                  up.setText(null);
                  upperRight.setText(null);
                  left.setText(null);
                  middle.setText(null);
                  right.setText(null);
                  bottomLeft.setText(null);
                  down.setText(null);
                  bottomRight.setText(null);
               
                  
                  board.reset();
 
                  
 }
    
    
      public void buttonUpperLeft(ActionEvent event) {                                     //START of an button. all other buttons are same with this.
         
       
        
        if(i%2==1)                                                                         //Setting "x" if its odd , "0" if its even
           {
              if("_X_ ".equals(board.board[0][0]) || "_O_ ".equals(board.board[0][0])){    //Checking if place is OCCUPIED or not
               unacceptableMove();                                                         //If it isnt EMPTY here is our WARNING Method
        } 
              else{      
        ply.setBoard(board, 1,1, i);                                                       //if its avaiable BUTTON sends info to PLAYING method about it's place
        upperLeft.setText("X");                                                            //Setting BUTTON text
        board.printBoard();                                                                //Printing on console to see what happened behind
        result =winC.check(i, board);                                                      //Checking if its WINNING move or not
        turnXOX.setText("0");                                                              //Showing who is playing
                                                                              
        if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);    //If there is a WINNER. SHOW WINNER
         xW++;                     //Win Counter
         xWins.setText(""+xW);
         
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);                                                         //After ASK FOR ANOTHER MATCH ?
             if(input==0){
             
                 reset();                                                                                                           //If they want another match RESET the BOARD
                 
             }
             else{
                 System.exit(0);                                                                                                    //If they DON'T WANT , Exit the game.
             }
                
         }
        space--;                                                                               //Deleting and empty SPACE
        draw(); //Checking if its DRAW
        i++;                                                                               //If everything is OKAY passing next TURN
           }
        }
        else                                                                                                                        //This else IF IT ISNT X TURN
        {
            if(board.board[0][0] == "_X_ " || board.board[0][0] == "_O_ "){
               unacceptableMove();
            
        }
            else{                                                                                                                    //SAME BUTTON but playing for O
        ply.setBoard(board, 1,1, i);
        upperLeft.setText("0");
        board.printBoard();
        result =winC.check(i, board); 
        turnXOX.setText("X");
        
        if(result==0){
              
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;                  //Win Counter for O
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++;
        }
        }
         //Counting the turn
        
        
             
        
             }
      public void buttonUp(ActionEvent event) {
           
        if(i%2==1)
           {
               if(board.board[0][1] == "_X_ " || board.board[0][1] == "_O_ "){
               unacceptableMove();
            
        }
               else{
          ply.setBoard(board, 1,2, i);       
        up.setText("X");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("0");
      
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++;
        
           }
           }
        else
        {
            if(board.board[0][1] == "_X_ " || board.board[0][1] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 1,2, i);
        up.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++;
        }
        }
        
        
    }
       public void buttonUpperRight(ActionEvent event) {
       
           if(i%2==1)
           {
               if(board.board[0][2] == "_X_ " || board.board[0][2] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 1,3, i);
        upperRight.setText("X"); 
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[0][2] == "_X_ " || board.board[0][2] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 1,3, i);
        upperRight.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X"); 
        
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++; 
        }
        }
        
    }
       public void buttonLeft(ActionEvent event) {
           
  if(i%2==1)
           {
               if(board.board[1][0] == "_X_ " || board.board[1][0] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 2,1, i);
        left.setText("X");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("0"); 
      
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }  
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[1][0] == "_X_ " || board.board[1][0] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 2,1, i);
        left.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
        }
        }
        
        
    }
       public void buttonMiddle(ActionEvent event) {
           
       if(i%2==1)
           {
               if(board.board[1][1] == "_X_ " || board.board[1][1] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 2,2, i);
        middle.setText("X");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[1][1] == "_X_ " || board.board[1][1] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 2,2, i);
        middle.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
        }
        }
        
        
    }
       public void buttonRight(ActionEvent event) {
           
      if(i%2==1)
           {
               if(board.board[1][2] == "_X_ " || board.board[1][2] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 2,3, i);
        right.setText("X");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[1][2] == "_X_ " || board.board[1][2] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 2,3, i);
        right.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++; 
        }
        }
        
        
    }
      public void buttonBottomLeft(ActionEvent event) {
           
       if(i%2==1)
           {
               if(board.board[2][0] == "_X_ " || board.board[2][0] == "_O_ "){
               unacceptableMove();
            
        }
               else{
        ply.setBoard(board, 3,1, i);
        bottomLeft.setText("X");
        board.printBoard();
       result =winC.check(i, board); 
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[2][0] == "_X_ " || board.board[2][0] == "_O_ "){
               unacceptableMove();
            
        }
            else{
        ply.setBoard(board, 3,1, i);
        bottomLeft.setText("0");
        board.printBoard();
       result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
        }
        }
        
        
    }
       public void buttonDown(ActionEvent event) {
           
        if(i%2==1)
           {
               if(board.board[2][1] == "_X_ " || board.board[2][1] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 3,2, i);
        down.setText("X");
         board.printBoard();
       result =winC.check(i, board);
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
           }
           }
        else
        {
            if(board.board[2][1] == "_X_ " || board.board[2][1] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 3,2, i);
        down.setText("0");
         board.printBoard();
       result =winC.check(i, board);
        turnXOX.setText("X");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         } 
        space--;
        draw();
        i++; 
        }
        }
        
    }
       public void buttonBottomRight(ActionEvent event) {
           
         if(i%2==1)
           {
               if(board.board[2][2] == "_X_ " || board.board[2][2] == "_O_ "){
               unacceptableMove();
            
        }
               else{
                 ply.setBoard(board, 3,3, i);
        bottomRight.setText("X");
         board.printBoard();
      result =winC.check(i, board);
        turnXOX.setText("0");
                if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " X just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          xW++;
         xWins.setText(""+xW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }  
        space--;
        draw();
        i++;
           }
           }
        else
        {
            if(board.board[2][2] == "_X_ " || board.board[2][2] == "_O_ "){
               unacceptableMove();
            
        }
            else{
              ply.setBoard(board, 3,3, i);
        bottomRight.setText("0");
         board.printBoard();
        result =winC.check(i, board);
        turnXOX.setText("X"); 
        if(result==0){
                
         int winner = JOptionPane.showConfirmDialog(null,   " 0 just WON the match ! ", "WINNER ! ", JOptionPane.DEFAULT_OPTION);
          oW++;
         oWins.setText(""+oW);
         int input = JOptionPane.showConfirmDialog(null, 
                "Again ? ", "Another match ... ",JOptionPane.YES_NO_OPTION);
             if(input==0){
             
                 reset();
                 
             }
             else{
                 System.exit(0);
             }
                
         }
        space--;
        draw();
        i++;
               
        }
        }
        
        
    }
  
        
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
