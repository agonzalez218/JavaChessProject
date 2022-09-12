import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChessAI extends Board{

    static List<Move> availableMoves = new ArrayList<>();
    static String originalTile;
    static String newTile;

    // Setters and Getters of Variables
    public static void setAvailableMoves(List<Move> list){ availableMoves = list; }
    public static List<Move> getAvailableMoves(){ return availableMoves; }
    public static void setOriginalTile(String selectedChessPiece){ originalTile = selectedChessPiece; }
    public static void setNewTile(String selectedNewLocation){ newTile = selectedNewLocation; }
    public static String getOriginalTile(){ return originalTile; }
    public static String getNewTile(){ return newTile; }

    // Return New Tile Matrix Location
    public static int[] getNewTileArr(){
        int[] arrLocation = new int[2];
        arrLocation[1] = (Character.getNumericValue(newTile.charAt(0))-8)*-1 ;
        arrLocation[0] = newTile.charAt(1)-65;
        return arrLocation;
    }

    // Select next move to be made by AI
    public static Move selectMove(Board board){
        generateAllMoves();
        int random_int = (int) ((Math.random() * (getAvailableMoves().size()-1)));
        //writeToDebugFile("Available Moves: " + getAvailableMoves().size());
        if( getAvailableMoves().size() == 0 )
        {
            board.endGame();
            return null;
        }
        return getAvailableMoves().get(random_int);
    }

    // If passes game conditions, make game move
    public static void moveAIPiece(Board board)
    {
        if(getCurrentTurn().equals("b"))
        {
            Move chosenMove = selectMove(board);
            if(chosenMove == null)
            {
                return;
            }
            setOriginalTile(chosenMove.OriginalLocation+','+chosenMove.movingChessPiece);
            setNewTile(chosenMove.NewLocation);
            //writeToDebugFile("AI Chosen Move: " + getOriginalTile() + " > " + getNewTile());
            String movingTile = getOriginalTile();

            // Select original piece
            if( movingTile.length() > 2 && !getPieceSelected() && ((getCurrentTurn().equals("b") && movingTile.contains("b")) ))
            {
                PieceMovement.savePiece(movingTile);
                int[] newPieceLocation = getNewTileArr();
                // Move piece
                if( getTeamMoved() && getPieceSelected() && (getAvailableTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1])) || getAvailableEnemyTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]))))
                {
                    // Convert to matrix location
                    if( chosenMove.movingChessPiece.contains("King"))
                    {
                        setbKing(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]));
                    }
                    PieceMovement.movePiece(getNewTile(), newPieceLocation[0], newPieceLocation[1]);
                    setAvailableMoves(new ArrayList<>());
                    setOriginalTile("");
                    setNewTile("");
                }
            }
        }
    }

    public static void generateAllMoves(){
        for (JButton[] jButtonRow : getChessBoard()) {
            for (JButton jButton: jButtonRow){
                if( jButton.getActionCommand().contains("b"))
                {
                    String[] firstTileInfo = jButton.getActionCommand().split(",");
                    int yO = (Character.getNumericValue(firstTileInfo[0].charAt(0))-8)*-1;
                    int xO = firstTileInfo[0].charAt(1)-65;
                    PieceMovement.determinePossibleMoves(firstTileInfo[1], yO, xO);
                    for(JButton tile : getAvailableTiles())
                    {
                        Move possibleMove = new Move();
                        possibleMove.OriginalLocation = firstTileInfo[0];
                        possibleMove.movingChessPiece = firstTileInfo[1];
                        possibleMove.NewLocation = tile.getActionCommand();
                        possibleMove.pointValue = 0;
                        if( PieceMovement.isValidMove(possibleMove.OriginalLocation, possibleMove.NewLocation, possibleMove.movingChessPiece) )
                        {
                            getAvailableMoves().add(possibleMove);
                        }
                    }
                    for( JButton tile : getAvailableEnemyTiles() )
                    {
                        Move possibleMove = new Move();
                        possibleMove.OriginalLocation = firstTileInfo[0];
                        possibleMove.movingChessPiece = firstTileInfo[1];
                        possibleMove.NewLocation = tile.getActionCommand();
                        possibleMove.pointValue = 0;
                        if( PieceMovement.isValidMove(possibleMove.OriginalLocation, possibleMove.NewLocation, possibleMove.movingChessPiece))
                        {
                            getAvailableMoves().add(possibleMove);
                        }
                    }
                    setAvailableTiles(new ArrayList<>());
                    setAvailableEnemyTiles(new ArrayList<>());
                }
            }
        }
    }
}
