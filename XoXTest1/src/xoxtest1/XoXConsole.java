
package xoxtest1;



public class XoXConsole {
    
    Board board = new Board();
    playing play = new playing ();
    winningConditions win = new winningConditions();
    int foo;
    int dab;
  
    public void start(){
        int a=1;
        int turn = 0;
       
           
         
            System.out.print(turn%2+1 + ". Player\n");
            a = win.check(turn, board);
            turn = turn+1;
            
        
    }
}