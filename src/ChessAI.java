public class ChessAI extends Board{

    public static String chooseAIPiece(){
        String originalPiece = null;
        originalPiece = squares[1][1].getActionCommand();
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
                // Move piece
                if( teamMoved && pieceSelected && (availableTiles.contains(squares[newPieceLocation[0]][newPieceLocation[1]]) || availableEnemyTiles.contains(squares[newPieceLocation[0]][newPieceLocation[1]])))
                {
                    // Convert to matrix location
                    movePiece(movingPiece, newPieceLocation[0], newPieceLocation[1]);
                }
            }
        }

    }
}
