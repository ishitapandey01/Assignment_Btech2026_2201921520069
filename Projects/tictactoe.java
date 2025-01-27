package Projects;
import java.util.*;
class tictactoe
{
public static void main(String[] args) {
    char[][] board=new char[3][3];
    for(int row=0;row<3;row++)
    {
        for(int col=0;col<3;col++)
        {
            board[row][col]=' ';
        }
    }
    char player='X';
    boolean gameover=false;
    Scanner sc=new Scanner(System.in);
    while(!gameover)
    {
        printboard(board); 
        System.out.println("player "+player+" enter: ");
        int r=sc.nextInt();
        int c=sc.nextInt();

        if(board[r][c]==' '){
        //place the element
        board[r][c]=player;
        gameover=haswon(board,player);
        if(gameover)
        {
            System.out.println("player "+player+ " has won ");
        }
        else{
            //switch player after move
            if (player=='X')
            {
               player='O'; 
            }
            else{
                player='X';
            }
        }
        }
        else
        {
            System.out.println("Invalid Move");
        }
    }
    printboard(board);
}

public static boolean haswon(char[][]board, char player)
{
  //check rows
  for(int row=0;row<3;row++)
    {
       if(board[row][0]==player &&board[row][1]==player && board[row][2]==player )
       return true;

    }
    //check column
    for(int col=0;col<board[0].length;col++)
    {
        if(board[0][col]==player &&board[1][col]==player && board[2][col]==player )
        return true;
     }
     //check diagonal
     if(board[0][0]==player && board[1][1]==player &&board[2][2]==player ){
     return true;
     }

     if(board[0][2]==player && board[1][1]==player &&board[2][0]==player ){
     return true;
     }

     return false;
        
}

public static void printboard(char[][]board)
{
    for(int row=0;row<3;row++)
    {
        for(int col=0;col<3;col++)
        {
            System.out.print(board[row][col]+ "  |  ");
        }
        System.out.println("");
    }
}
}