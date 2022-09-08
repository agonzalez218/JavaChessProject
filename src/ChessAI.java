import javax.swing.*;

public class ChessAI extends Board{

    static JButton[][] tempChessBoard = new JButton[8][8];
    static String originalTile;
    static String newLocation;

    public static void setOriginalPiece(String selectedChessPiece){
        originalTile = selectedChessPiece;
    }

    public static void setNewLocation(String selectedNewLocation){
        newLocation = selectedNewLocation;
    }

    public static String getOriginalPiece(){

        String originalPiece;
        originalPiece = chessBoard[1][1].getActionCommand();
        return originalPiece;
    }

    public static int[] getNewLocationArr(){
        int[] arrLocation = new int[2];
        arrLocation[0] = (newLocation.charAt(0)-8)*-1;
        arrLocation[1] = newLocation.charAt(1)-65;
        return arrLocation;
    }

    public static void test(){
        setOriginalPiece("7B, bPawn");
        setNewLocation("5B");
    }

    public static void moveAIPiece()
    {
        if(blackTurn)
        {
            String movingTile = getOriginalPiece();

            // Select original piece
            if( movingTile.length() > 2 && !pieceSelected && ((blackTurn && movingTile.contains("b")) ))
            {
                savePiece(movingTile);
                int[] newPieceLocation = getNewLocationArr();
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
