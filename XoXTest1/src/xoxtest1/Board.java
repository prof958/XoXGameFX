
package xoxtest1;

public class Board {
     String[][] board = new String[3][3];
     public Board(){
        board [0][0]= "___ ";
        board [0][1]= "___ ";
        board [0][2]= "___\n";
        board [1][0]= "___ ";
        board [1][1]= "___ ";
        board [1][2]= "___";
        board [2][0]= "___ ";
        board [2][1]= "___ ";
        board [2][2]= "___\n";
     }
     public void printBoard(){
        int i;
        i=0;
        while (i<3){
            int j=0;
            while (j<3){
                System.out.print(board[i][j]);
                j++;
            }
            System.out.print("\n");
            i++;
        }
     }
     public void reset(){
    
        board [0][0]= "___ ";
        board [0][1]= "___ ";
        board [0][2]= "___\n";
        board [1][0]= "___ ";
        board [1][1]= "___ ";
        board [1][2]= "___";
        board [2][0]= "___ ";
        board [2][1]= "___ ";
        board [2][2]= "___\n";
}
     
 
}
