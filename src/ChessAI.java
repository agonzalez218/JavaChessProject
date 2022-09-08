import javax.swing.*;

public class ChessAI extends Board{

    static JButton[][] tempChessBoard = new JButton[8][8];
    static String originalTile;
    static String newTile;
    static int x = 7;

    // Setters and Getters of Variables
    public static void setOriginalTile(String selectedChessPiece){ originalTile = selectedChessPiece; }
    public static void setNewLocation(String selectedNewLocation){ newTile = selectedNewLocation; }
    public static String getOriginalTile(){ return originalTile; }
    public static String getNewTile(){ return newTile; }

    // Return New Tile Matrix Location
    public static int[] getNewTileArr(){
        int[] arrLocation = new int[2];
        arrLocation[1] = (Character.getNumericValue(newTile.charAt(0))-8)*-1 ;
        arrLocation[0] = newTile.charAt(1)-65;
        return arrLocation;
    }

    // Generate next move to be made by AI
    public static void generateMove(){
        setOriginalTile(x+"B,bPawn");
        setNewLocation(x-1+"B");
        x -= 1;
    }

    // If passes game conditions, make game move
    public static void moveAIPiece()
    {
        if(getCurrentTurn().equals("b"))
        {
            generateMove();
            String movingTile = getOriginalTile();

            // Select original piece
            if( movingTile.length() > 2 && !getPieceSelected() && ((getCurrentTurn().equals("b") && movingTile.contains("b")) ))
            {
                savePiece(movingTile);
                int[] newPieceLocation = getNewTileArr();
                // Move piece
                if( getTeamMoved() && getPieceSelected() && (getAvailableTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1])) || getAvailableEnemyTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]))))
                {
                    // Convert to matrix location
                    movePiece(getNewTile(), newPieceLocation[0], newPieceLocation[1]);
                }
            }
        }

    }
}
