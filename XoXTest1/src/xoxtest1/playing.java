
package xoxtest1;

import java.util.Scanner;

public class playing {
    Scanner scan =new Scanner(System.in);
    public void setBoard(Board board,int foo,int dab,int a){
        
        if (a%2==1){
            board.board[foo-1][dab-1]="_X_ ";
        }
        else if (a%2 == 0 ){
            board.board[foo-1][dab-1]="_O_ ";  
        }
        }
        
           
    }

