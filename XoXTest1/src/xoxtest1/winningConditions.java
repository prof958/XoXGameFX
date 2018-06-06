
package xoxtest1;

public class winningConditions {
    public int check(int sira,Board board){
        String middle = board.board[1][1];
        String up = board.board[0][1];
        String bottom = board.board[2][1];
        String right = board.board[1][2];
        String left = board.board[1][0];
        String upperRight = board.board[0][2];
        String upperLeft = board.board[0][0];
        String bottomRight = board.board[2][2];
        String bottomLeft = board.board[2][0];
        String x = "_X_ ";
        String o = "_O_ ";
        if (sira%2==1){
            if (x.equals(upperLeft) && x.equals(up) && x.equals(upperRight)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(upperRight) && x.equals(right) && x.equals(bottomRight)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(left) && x.equals(middle) && x.equals(right)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(upperRight) && x.equals(middle) && x.equals(bottomLeft)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(up) && x.equals(middle) && x.equals(bottom)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(bottomRight) && x.equals(bottom) && x.equals(bottomLeft)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(bottomLeft) && x.equals(left) && x.equals(upperLeft)){
                System.out.println("X WINS ");
                return 0;
            }
            else if (x.equals(bottomRight) && x.equals(middle) && x.equals(upperLeft)){
                System.out.println("X WINS ");
                return 0;
            }
            
            else{
              return 1;  
            }
        }
        else if (sira%2==0){
            if (o.equals(upperRight) && o.equals(up) && o.equals(upperLeft)){
                System.out.println("O WINS ");
                return 0;
            }
            else if (o.equals(upperRight) && o.equals(right) && o.equals(bottomRight)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(left) && o.equals(middle) && o.equals(right)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(upperRight) && o.equals(middle) && o.equals(bottomLeft)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(up) && o.equals(middle) && o.equals(bottom)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(bottomRight) && o.equals(bottom) && o.equals(bottomLeft)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(bottomLeft) && o.equals(left) && o.equals(upperLeft)){
                System.out.println("O WINS");
                return 0;
            }
            else if (o.equals(bottomRight) && o.equals(middle) && o.equals(upperLeft)){
                System.out.println("O WINS");
                return 0;
            }
            else{
                return 1;
            }
        }
         
       return 1;
   }
}

