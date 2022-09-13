import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Author: Abel Gonzalez
Project Title: Chess Project in Java
Date: September 2022
Description of File: This file holds the necessary functions and variables responsible for the AI.
    It contains the functions and variables necessary to get available moves, select one, and finalize
    the move on the board.
 */

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

    /*
    Parameters:
        N/A
    Return Value:
        Return: returns an array containing the Matrix location of New Tile Location
    Description:
        Returns an array containing the Matrix location of New Tile Location ( 0 being Y and 1 being X )
     */
    public static int[] getNewTileArr(){
        int[] arrLocation = new int[2];
        arrLocation[1] = (Character.getNumericValue(newTile.charAt(0))-8)*-1 ;
        arrLocation[0] = newTile.charAt(1)-65;
        return arrLocation;
    }

    /*
    Parameters:
        Board board: Passed to function in case AI is out of moves and must concede
    Return Value:
        Return: returns move selected by function
    Description:
        First the function generates and fills the Available moves list with moves,
        then it iterates through the list to find the highest point value move. It
        returns the highest value, or a random move if no move points value higher than 0.
        If the AI runs out of moves, it ends the game.
     */
    public static Move selectMove(Board board){
        int max = 0, index = 0;
        generateAllMoves();
        int random_int = (int) ((Math.random() * (getAvailableMoves().size()-1)));

        // End game if no moves left
        if( getAvailableMoves().size() == 0 )
        {
            board.endGame();
            return null;
        }

        // Iterate through available moves to find best move
        for( Move move : getAvailableMoves() )
        {
            if( move.pointValue > max )
            {
                max = move.pointValue;
                index = getAvailableMoves().indexOf(move);
            }
        }

        // If no good moves found, return random one
        if( max == 0 )
        {
            return availableMoves.get(random_int);
        }
        return availableMoves.get(index);
    }

    /*
    Parameters:
        Board board: Passed to function in case AI is out of moves and must concede
    Return Value:
        Return: Void
    Description:
        Primary function of AI that uses all functions to accumulate moves, select a given move,
        then execute and finalize the move. Once done, it resets the variables and lists.
     */
    public static void moveAIPiece(Board board)
    {
        if(getCurrentTurn().equals(getAIColor()))
        {
            Move chosenMove = selectMove(board);
            if(chosenMove == null)
            {
                return;
            }
            setOriginalTile(chosenMove.SourceLocation +','+chosenMove.movingChessPiece);
            setNewTile(chosenMove.DestinationLocation);
            //writeToDebugFile("AI Chosen Move: " + getOriginalTile() + " > " + getNewTile());
            String movingTile = getOriginalTile();

            // Select original piece
            if( movingTile.length() > 2 && !getPieceSelected() && ((getCurrentTurn().equals(getAIColor()) && movingTile.contains(getAIColor())) ))
            {
                PieceMovement.savePiece(movingTile);
                int[] newPieceLocation = getNewTileArr();
                // Move piece
                if( getPieceSelected() && (getAvailableTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1])) || getAvailableEnemyTiles().contains(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]))))
                {
                    // If moving king, update location
                    if( chosenMove.movingChessPiece.contains("King"))
                    {
                        if(Objects.equals(getAIColor(), "b"))
                        {
                            setbKing(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]));
                        }
                        else
                        {
                            setwhKing(getChessBoardTile(newPieceLocation[0],newPieceLocation[1]));
                        }
                    }
                    PieceMovement.movePiece(getNewTile(), newPieceLocation[0], newPieceLocation[1]);

                    // Reset variables and list
                    setAvailableMoves(new ArrayList<>());
                    setOriginalTile("");
                    setNewTile("");
                }
            }
        }
    }

    /*
   Parameters:
       N/A
   Return Value:
       Return: Void
   Description:
       Generates all possible moves by iterating through all tiles in the chess board and
       determining all possible moves with AI's team color. If moves are possible, they are
       added to available moves with the Move type that contains source, destination,
       moving piece and point value.
    */
    public static void generateAllMoves(){
        for (JButton[] jButtonRow : getChessBoard()) {
            for (JButton jButton: jButtonRow){
                if( jButton.getActionCommand().contains(getAIColor()))
                {
                    String[] firstTileInfo = jButton.getActionCommand().split(",");
                    int yO = (Character.getNumericValue(firstTileInfo[0].charAt(0))-8)*-1;
                    int xO = firstTileInfo[0].charAt(1)-65;

                    // Determine all possible moves from source piece
                    PieceMovement.determinePossibleMoves(firstTileInfo[1], yO, xO);
                    for(JButton tile : getAvailableTiles())
                    {
                        // Create new move based on parameters
                        Move possibleMove = new Move();
                        possibleMove.SourceLocation = firstTileInfo[0];
                        possibleMove.movingChessPiece = firstTileInfo[1];
                        possibleMove.DestinationLocation = tile.getActionCommand();
                        possibleMove.pointValue = 0;
                        if( PieceMovement.isValidMove(possibleMove.SourceLocation, possibleMove.DestinationLocation, possibleMove.movingChessPiece) )
                        {
                            // Add move to list if valid
                            getAvailableMoves().add(possibleMove);
                        }
                    }
                    for( JButton tile : getAvailableEnemyTiles() )
                    {
                        Move possibleMove = new Move();
                        possibleMove.SourceLocation = firstTileInfo[0];
                        possibleMove.movingChessPiece = firstTileInfo[1];
                        possibleMove.DestinationLocation = tile.getActionCommand();
                        if( PieceMovement.isValidMove(possibleMove.SourceLocation, possibleMove.DestinationLocation, possibleMove.movingChessPiece))
                        {
                            // Assigns point value based on piece taken
                            if(possibleMove.DestinationLocation.contains("Pawn")){possibleMove.pointValue = 10;}
                            else if(possibleMove.DestinationLocation.contains("Knight")||possibleMove.DestinationLocation.contains("Bishop")){possibleMove.pointValue = 30;}
                            else if(possibleMove.DestinationLocation.contains("Rook")){possibleMove.pointValue = 50;}
                            else if(possibleMove.DestinationLocation.contains("Queen")){possibleMove.pointValue = 90;}
                            else if(possibleMove.DestinationLocation.contains("King")){possibleMove.pointValue = 900;}
                            else{possibleMove.pointValue = 0;}
                            // Add move to list if valid
                            getAvailableMoves().add(possibleMove);
                        }
                    }

                    // Reset lists after every move
                    setAvailableTiles(new ArrayList<>());
                    setAvailableEnemyTiles(new ArrayList<>());
                }
            }
        }
    }
}
