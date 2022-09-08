import javax.swing.*;

public class ChessAI extends Board{

    static JButton[][] tempChessBoard = new JButton[8][8];

    public static String chooseAIPiece(){

        String originalPiece;
        originalPiece = chessBoard[1][1].getActionCommand();
        return originalPiece;
    }

    public static int[] chooseAIPieceLocation(){
        int[] arrLocation = new int[2];
        int x, y;
        x = 1;
        y = 3;
        arrLocation[0] = x;
        arrLocation[1] = y;
        return arrLocation;
    }

    public static void moveAIPiece()
    {
        if(blackTurn)
        {
            String movingPiece = chooseAIPiece();

            // Select original piece
            if( movingPiece.length() > 2 && !pieceSelected && ((blackTurn && movingPiece.contains("b")) ))
            {
                savePiece(movingPiece);
                int[] newPieceLocation = chooseAIPieceLocation();
                String newLocation = ((-1*newPieceLocation[1])+8) + String.valueOf((char)(newPieceLocation[0]+65));
                // Move piece
                if( teamMoved && pieceSelected && (availableTiles.contains(chessBoard[newPieceLocation[0]][newPieceLocation[1]]) || availableEnemyTiles.contains(chessBoard[newPieceLocation[0]][newPieceLocation[1]])))
                {
                    // Convert to matrix location
                    movePiece(newLocation, newPieceLocation[0], newPieceLocation[1]);
                }
            }
        }

    }
}
