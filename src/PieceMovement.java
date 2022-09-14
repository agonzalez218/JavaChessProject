import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
Author: Abel Gonzalez
Project Title: Chess Project in Java
Date: September 2022
Description of File: This file holds the necessary functions and variables responsible for moving a piece
    as well as determining what moves are possible.
 */

public class PieceMovement extends Board{

    static String movingPiece, originalLocation;

    // Getters and Setters
    public static void setMovingPiece(String piece) { movingPiece = piece; }
    public static String getMovingPiece(){return movingPiece;}
    public static void setOriginalLocation(String location) { originalLocation = location; }
    public static String getOriginalLocation(){return originalLocation;}

    /*
   Parameters:
       String chessPieceOrig: Moving Chess Piece from source tile
       int x: Knight's x (row location) in Array Matrix
       int y: Knight's y (column location) in Array Matrix
   Return Value:
       Return: Void
   Description:
       Uses movement of piece to determine possible moves from current location.
       If movement found and no piece on tile, add to available tiles.
       If movement found and enemy piece on tile, add to available enemy tiles.
    */
    public static void determinePossibleMoves(String chessPieceOrig, int y, int x)
    {
        // Reset lists
        setAvailableTiles(new ArrayList<>());
        setAvailableEnemyTiles(new ArrayList<>());

        String teamColor, chessPiece;
        if( chessPieceOrig.contains("wh") )
        {
            teamColor = chessPieceOrig.substring(0,2);
            chessPiece = chessPieceOrig.substring(2);
        }
        else
        {
            teamColor = String.valueOf(chessPieceOrig.charAt(0));
            chessPiece = chessPieceOrig.substring(1);
        }
        // determine possible spaces based on chess piece and their rules
        switch (chessPiece)
        {
            case "King":
                if(teamColor.equals("b"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "wh", "b", true);
                    verticalHorizontalMovement(x, y-1, 2, "wh", "b", true);
                    verticalHorizontalMovement(x+1, y, 3, "wh", "b", true);
                    verticalHorizontalMovement(x-1, y, 4, "wh", "b", true);
                    diagonalMovement(x+1, y+1, 1, "wh", "b", true);
                    diagonalMovement(x-1, y+1, 2, "wh", "b", true);
                    diagonalMovement(x+1, y-1, 3, "wh", "b", true);
                    diagonalMovement(x-1, y-1, 4, "wh", "b", true);

                }
                else if(teamColor.equals("wh"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "b", "wh", true);
                    verticalHorizontalMovement(x, y-1, 2, "b", "wh", true);
                    verticalHorizontalMovement(x+1, y, 3, "b", "wh", true);
                    verticalHorizontalMovement(x-1, y, 4, "b", "wh", true);
                    diagonalMovement(x+1, y+1, 1, "b", "wh", true);
                    diagonalMovement(x-1, y+1, 2, "b", "wh", true);
                    diagonalMovement(x+1, y-1, 3, "b", "wh", true);
                    diagonalMovement(x-1, y-1, 4, "b", "wh", true);
                }
                break;
            case "Queen":
                if(teamColor.equals("b"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "wh", "b", false);
                    verticalHorizontalMovement(x, y-1, 2, "wh", "b", false);
                    verticalHorizontalMovement(x+1, y, 3, "wh", "b", false);
                    verticalHorizontalMovement(x-1, y, 4, "wh", "b", false);
                    diagonalMovement(x+1, y+1, 1, "wh", "b", false);
                    diagonalMovement(x-1, y+1, 2, "wh", "b", false);
                    diagonalMovement(x+1, y-1, 3, "wh", "b", false);
                    diagonalMovement(x-1, y-1, 4, "wh", "b", false);

                }
                else if(teamColor.equals("wh"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "b", "wh", false);
                    verticalHorizontalMovement(x, y-1, 2, "b", "wh", false);
                    verticalHorizontalMovement(x+1, y, 3, "b", "wh", false);
                    verticalHorizontalMovement(x-1, y, 4, "b", "wh", false);
                    diagonalMovement(x+1, y+1, 1, "b", "wh", false);
                    diagonalMovement(x-1, y+1, 2, "b", "wh", false);
                    diagonalMovement(x+1, y-1, 3, "b", "wh", false);
                    diagonalMovement(x-1, y-1, 4, "b", "wh", false);
                }
                break;
            case "Rook":
                if(teamColor.equals("b"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "wh", "b", false);
                    verticalHorizontalMovement(x, y-1, 2, "wh", "b", false);
                    verticalHorizontalMovement(x+1, y, 3, "wh", "b", false);
                    verticalHorizontalMovement(x-1, y, 4, "wh", "b", false);

                }
                else if(teamColor.equals("wh"))
                {
                    verticalHorizontalMovement(x, y+1, 1, "b", "wh", false);
                    verticalHorizontalMovement(x, y-1, 2, "b", "wh", false);
                    verticalHorizontalMovement(x+1, y, 3, "b", "wh", false);
                    verticalHorizontalMovement(x-1, y, 4, "b", "wh", false);
                }
                break;
            case "Bishop":
                if(teamColor.equals("b"))
                {
                    diagonalMovement(x+1, y+1, 1, "wh", "b", false);
                    diagonalMovement(x-1, y+1, 2, "wh", "b", false);
                    diagonalMovement(x+1, y-1, 3, "wh", "b", false);
                    diagonalMovement(x-1, y-1, 4, "wh", "b", false);
                }
                else if(teamColor.equals("wh"))
                {
                    diagonalMovement(x+1, y+1, 1, "b", "wh", false);
                    diagonalMovement(x-1, y+1, 2, "b", "wh", false);
                    diagonalMovement(x+1, y-1, 3, "b", "wh", false);
                    diagonalMovement(x-1, y-1, 4, "b", "wh", false);
                }
                break;
            case "Knight":
                if(teamColor.equals("b"))
                {
                    knightMovement(x+2, y+1, "wh", "b");
                    knightMovement(x+2, y-1, "wh", "b");
                    knightMovement(x-2, y+1, "wh", "b");
                    knightMovement(x-2, y-1, "wh", "b");
                    knightMovement(x+1, y+2, "wh", "b");
                    knightMovement(x+1, y-2, "wh", "b");
                    knightMovement(x-1, y+2, "wh", "b");
                    knightMovement(x-1, y-2, "wh", "b");
                }
                else if(teamColor.equals("wh"))
                {
                    knightMovement(x+2, y+1, "b", "wh");
                    knightMovement(x+2, y-1, "b", "wh");
                    knightMovement(x-2, y+1, "b", "wh");
                    knightMovement(x-2, y-1, "b", "wh");
                    knightMovement(x+1, y+2, "b", "wh");
                    knightMovement(x+1, y-2, "b", "wh");
                    knightMovement(x-1, y+2, "b", "wh");
                    knightMovement(x-1, y-2, "b", "wh");
                }
                break;
            case "Pawn":
                if(teamColor.equals("b")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y < 7 && (getChessBoard()[x][y+1].getActionCommand().length() == 2 ))
                    {
                        // First move can be two tiles up
                        if (y == 1 && (getChessBoardTile(x,y+2).getActionCommand().length() == 2)) {
                            getAvailableTiles().add(getChessBoardTile(x,y+2));
                        }
                        getAvailableTiles().add(getChessBoardTile(x,y+1));
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y < 7 )
                    {
                        if( getChessBoardTile(x+1,y+1).getActionCommand().contains("wh"))
                        {
                            getAvailableEnemyTiles().add(getChessBoardTile(x+1,y+1));
                        }
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y < 7 )
                    {
                        if( getChessBoardTile(x-1,y+1).getActionCommand().contains("wh"))
                        {
                            getAvailableEnemyTiles().add(getChessBoardTile(x-1,y+1));
                        }
                    }
                }
                else if(teamColor.equals("wh")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y > 0 && (getChessBoard()[x][y-1].getActionCommand().length() == 2 ))
                    {
                        // First move can be two tiles up
                        if (y == 6 && (getChessBoardTile(x,y-2).getActionCommand().length() == 2)) {
                            getAvailableTiles().add(getChessBoardTile(x,y-2));
                        }
                        getAvailableTiles().add(getChessBoardTile(x,y-1));
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y > 0)
                    {
                        if( getChessBoardTile(x-1,y-1).getActionCommand().contains("b"))
                        {
                            getAvailableEnemyTiles().add(getChessBoardTile(x-1,y-1));
                        }
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y > 0)
                    {
                        if( getChessBoardTile(x+1,y-1).getActionCommand().contains("b"))
                        {
                            getAvailableEnemyTiles().add(getChessBoardTile(x+1,y-1));
                        }
                    }
                }
                break;
        }
    }

    /*
   Parameters:
       int x: Knight's x (row location) in Array Matrix
       int y: Knight's y (column location) in Array Matrix
       String enemy: String containing enemy color
       String ally: String containing ally color
   Return Value:
       Return: Void
   Description:
       Checks knight movement from current tile to determine possible moves from current location.
       If movement found and no piece on tile, add to available tiles.
       If movement found and enemy piece on tile, add to available enemy tiles.
    */
    public static void knightMovement(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoardTile(x,y).getActionCommand().contains(ally))
        {
            return;
        }
        if( getChessBoardTile(x,y).getActionCommand().contains(enemy))
        {
            getAvailableEnemyTiles().add(getChessBoardTile(x,y));
            return;
        }
        getAvailableTiles().add(getChessBoardTile(x,y));
    }

    /*
    Parameters:
        int x: Piece's x (row location) in Array Matrix
        int y: Piece's y (column location) in Array Matrix
        int dir: Used for recursive function to continue searching in set direction
        String enemy: String containing enemy color
        String ally: String containing ally color
        Boolean isKing: Boolean value to change distance of available moves to 1 instead of full range
    Return Value:
        Return: Void
    Description:
        Checks diagonally from current tile to determine possible moves from current location.
        If movement found and no piece on tile, add to available tiles.
        If movement found and enemy piece on tile, add to available enemy tiles.
     */
    public static void diagonalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoardTile(x,y).getActionCommand().contains(ally))
        {
            return;
        }
        if( getChessBoardTile(x,y).getActionCommand().contains(enemy))
        {
            getAvailableEnemyTiles().add(getChessBoardTile(x,y));
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7 || isKing)
        {
            getAvailableTiles().add(getChessBoardTile(x,y));
            return;
        }
        switch (dir) {
            case 1 -> {
                getAvailableTiles().add(getChessBoardTile(x,y));
                diagonalMovement(x+1, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                getAvailableTiles().add(getChessBoardTile(x,y));
                diagonalMovement(x-1, y+1, dir, enemy, ally, false);
            }
            case 3 -> {
                getAvailableTiles().add(getChessBoardTile(x,y));
                diagonalMovement(x+1, y-1, dir, enemy, ally, false);
            }
            case 4 -> {
                getAvailableTiles().add(getChessBoardTile(x,y));
                diagonalMovement(x-1, y-1, dir, enemy, ally, false);
            }
        }
    }

    /*
    Parameters:
        int x: Piece's x (row location) in Array Matrix
        int y: Piece's y (column location) in Array Matrix
        int dir: Used for recursive function to continue searching in set direction
        String enemy: String containing enemy color
        String ally: String containing ally color
        Boolean isKing: Boolean value to change distance of available moves to 1 instead of full range
    Return Value:
        Return: Void
    Description:
        Checks vertically and horizontally from current tile to determine possible moves from current location.
        If movement found and no piece on tile, add to available tiles.
        If movement found and enemy piece on tile, add to available enemy tiles.
     */
    public static void verticalHorizontalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoard()[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy))
        {
            getAvailableEnemyTiles().add(getChessBoard()[x][y]);
            return;
        }
        if( isKing )
        {
            getAvailableTiles().add(getChessBoard()[x][y]);
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7  )
        {
            getAvailableTiles().add(getChessBoard()[x][y]);
        }
        switch (dir) {
            case 1 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                verticalHorizontalMovement(x, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                verticalHorizontalMovement(x, y-1, dir, enemy, ally, false);
            }
            case 3 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                verticalHorizontalMovement(x+1, y, dir, enemy, ally, false);
            }
            case 4 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                verticalHorizontalMovement(x-1, y, dir, enemy, ally, false);
            }
        }
    }

    /*
    Parameters:
        int x: Piece's x (row location) in Array Matrix
        int y: Piece's y (column location) in Array Matrix
        int dir: Used for recursive function to continue searching in set direction
        String enemy: String containing enemy color
        String ally: String containing ally color
        Boolean isKing: Boolean value to change distance of available moves to 1 instead of full range
    Return Value:
        Return: Void
    Description:
        Checks all spaces from King to determine if in check by enemy piece.
     */
    public static void checkSpaces(int x, int y, int dir, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoard()[x][y].getActionCommand().contains(ally) )
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && !((dir <= 4 && getChessBoard()[x][y].getActionCommand().contains("Rook")) || (dir > 4 && getChessBoard()[x][y].getActionCommand().contains("Bishop")) || getChessBoard()[x][y].getActionCommand().contains("Queen")))
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && ((dir <= 4 && getChessBoard()[x][y].getActionCommand().contains("Rook")) || (dir > 4 && getChessBoard()[x][y].getActionCommand().contains("Bishop")) || getChessBoard()[x][y].getActionCommand().contains("Queen")))
        {
            if(ally.equals("b"))
            {
                setBlackCheck(true);
            }
            else
            {
                setWhiteCheck(true);
            }
            return;
        }
        switch (dir) {
            case 1 -> checkSpaces(x, y+1, dir, enemy, ally);
            case 2 -> checkSpaces(x, y-1, dir, enemy, ally);
            case 3 -> checkSpaces(x+1, y, dir, enemy, ally);
            case 4 -> checkSpaces(x-1, y, dir, enemy, ally);
            case 5 -> checkSpaces(x+1, y+1, dir, enemy, ally);
            case 6 -> checkSpaces(x-1, y-1, dir, enemy, ally);
            case 7 -> checkSpaces(x+1, y-1, dir, enemy, ally);
            case 8 -> checkSpaces(x-1, y+1, dir, enemy, ally);
        }
    }

    /*
    Parameters:
        int x: Knight's x (row location) in Array Matrix
        int y: Knight's y (column location) in Array Matrix
        String enemy: String containing enemy color
        String ally: String containing ally color
    Return Value:
        Return: Void
    Description:
        Uses movement of knight to determine possible knights checking king from current location.
     */
    public static void checkForKnight(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoard()[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && getChessBoard()[x][y].getActionCommand().contains("Knight"))
        {
            if(ally.equals("b"))
            {
                setBlackCheck(true);
            }
            else
            {
                setWhiteCheck(true);
            }
        }
    }

    /*
    Parameters:
        int x: Knight's x (row location) in Array Matrix
        int y: Knight's y (column location) in Array Matrix
        String enemy: String containing enemy color
        String ally: String containing ally color
    Return Value:
        Return: Void
    Description:
        Uses movement of king to determine possible enemy king checking king from current location.
     */
    public static void checkForKing(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoard()[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && getChessBoard()[x][y].getActionCommand().contains("King"))
        {
            if(ally.equals("b"))
            {
                setBlackCheck(true);
            }
            else
            {
                setWhiteCheck(true);
            }
        }
    }

    /*
    Parameters:
        JButton whiteKing: current tile of White king
        JButton blackKing: current tile of Black king
    Return Value:
        Return: Void
    Description:
        Checks all spaces from King to determine if it is being put in check by an enemy piece.
        Checks for Pawns, Bishops, Knights, Rooks, and Queens.
        If King is found to be in check, call highlightKingCheck to set in check and highlight King red.
     */
    public static void checkKing(JButton whiteKing, JButton blackKing)
    {
        String blackLocation, whiteLocation;
        if( !whiteKing.getActionCommand().contains("whKing") || !blackKing.getActionCommand().contains("bKing"))
        {
            return;
        }
        whiteLocation = whiteKing.getActionCommand().substring(0,2);
        blackLocation = blackKing.getActionCommand().substring(0,2);

        int yOwh = (Character.getNumericValue(whiteLocation.charAt(0))-8)*-1;
        int xOwh = whiteLocation.charAt(1)-65;
        int yOb = (Character.getNumericValue(blackLocation.charAt(0))-8)*-1;
        int xOb = blackLocation.charAt(1)-65;

        // Check for pawn
        setBlackCheck(xOb < 7 && yOb < 7 && (getChessBoard()[xOb + 1][yOb + 1].getActionCommand().contains("whPawn") || xOb > 0 && getChessBoard()[xOb - 1][yOb + 1].getActionCommand().contains("whPawn")));

        // Check for enemy king
        checkForKing(xOb, yOb-1, "wh", "b");
        checkForKing(xOb, yOb+1, "wh", "b");
        checkForKing(xOb+1, yOb, "wh", "b");
        checkForKing(xOb-1, yOb, "wh", "b");
        checkForKing(xOb+1, yOb+1, "wh", "b");
        checkForKing(xOb-1, yOb+1, "wh", "b");
        checkForKing(xOb+1, yOb-1, "wh", "b");
        checkForKing(xOb-1, yOb-1, "wh", "b");

        // Check for other enemy pieces
        checkForKnight(xOb+2, yOb+1, "wh", "b");
        checkForKnight(xOb+2, yOb-1, "wh", "b");
        checkForKnight(xOb-2, yOb+1, "wh", "b");
        checkForKnight(xOb-2, yOb-1, "wh", "b");
        checkForKnight(xOb+1, yOb+2, "wh", "b");
        checkForKnight(xOb+1, yOb-2, "wh", "b");
        checkForKnight(xOb-1, yOb+2, "wh", "b");
        checkForKnight(xOb-1, yOb-2, "wh", "b");
        checkSpaces(xOb, yOb+1, 1, "wh", "b");
        checkSpaces(xOb, yOb-1, 2, "wh", "b");
        checkSpaces(xOb+1, yOb, 3, "wh", "b");
        checkSpaces(xOb-1, yOb, 4, "wh", "b");
        checkSpaces(xOb+1, yOb+1, 5, "wh", "b");
        checkSpaces(xOb-1, yOb-1, 6, "wh", "b");
        checkSpaces(xOb+1, yOb-1, 7, "wh", "b");
        checkSpaces(xOb-1, yOb+1, 8, "wh", "b");

        // Check for pawn
        setWhiteCheck(xOwh < 7 && yOwh > 0 && getChessBoard()[xOwh + 1][yOwh - 1].getActionCommand().contains("bPawn") || xOwh > 0 && yOwh > 0 && getChessBoard()[xOwh - 1][yOwh - 1].getActionCommand().contains("bPawn"));

        // Check for enemy king
        checkForKing(xOwh, yOwh-1, "b", "wh");
        checkForKing(xOwh, yOwh+1, "b", "wh");
        checkForKing(xOwh+1, yOwh, "b", "wh");
        checkForKing(xOwh-1, yOwh, "b", "wh");
        checkForKing(xOwh+1, yOwh+1, "b", "wh");
        checkForKing(xOwh-1, yOwh+1, "b", "wh");
        checkForKing(xOwh+1, yOwh-1, "b", "wh");
        checkForKing(xOwh-1, yOwh-1, "b", "wh");

        // Check for other enemy pieces
        checkForKnight(xOwh+2, yOwh+1, "b", "wh");
        checkForKnight(xOwh+2, yOwh-1, "b", "wh");
        checkForKnight(xOwh-2, yOwh+1, "b", "wh");
        checkForKnight(xOwh-2, yOwh-1, "b", "wh");
        checkForKnight(xOwh+1, yOwh+2, "b", "wh");
        checkForKnight(xOwh+1, yOwh-2, "b", "wh");
        checkForKnight(xOwh-1, yOwh+2, "b", "wh");
        checkForKnight(xOwh-1, yOwh-2, "b", "wh");
        checkSpaces(xOwh, yOwh+1, 1, "b", "wh");
        checkSpaces(xOwh, yOwh-1, 2, "b", "wh");
        checkSpaces(xOwh+1, yOwh, 3, "b", "wh");
        checkSpaces(xOwh-1, yOwh, 4, "b", "wh");
        checkSpaces(xOwh+1, yOwh+1, 5, "b", "wh");
        checkSpaces(xOwh-1, yOwh-1, 6, "b", "wh");
        checkSpaces(xOwh+1, yOwh-1, 7, "b", "wh");
        checkSpaces(xOwh-1, yOwh+1, 8, "b", "wh");

        HighlightTiles.highlightKingCheck();
    }

    /*
    Parameters:
        String sourceTile: Tile information of source tile
    Return Value:
        Return: Void
    Description:
        Starts by clearing temp variables then saves Piece to class variables
        to be used in move function if valid. In addition, selects piece by
        highlighting chosen piece Blue and by determining possible moves creates
        a list of available moves and a list of available enemies that can be taken.
     */
    public static void savePiece(String sourceTile)
    {
        setMovingPiece("");
        String[] arrOfStr = sourceTile.split(",");
        setOriginalLocation(arrOfStr[0]);
        setMovingPiece(arrOfStr[1]);
        setPieceSelected(true);

        // Convert to matrix location
        int yO = (Character.getNumericValue(getOriginalLocation().charAt(0))-8)*-1;
        int xO = getOriginalLocation().charAt(1)-65;

        PieceMovement.checkKing(getwhKing(), getbKing());
        PieceMovement.determinePossibleMoves(getMovingPiece(), yO, xO);

        setCurrentTile(getChessBoardTile(xO, yO));
        getCurrentTile().setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.blue));
    }

    /*
    Parameters:
        String newSelectedTile: Tile information of destination tile
        int xN: New tile x (row location) in Array Matrix
        int yN: New tile y (column location) in Array Matrix
    Return Value:
        Return: Void
    Description:
        Moves piece from saved source location to new destination location given in parameter
     */
    public static void movePiece(String newSelectedTile, int xN, int yN)
    {
        String[] arrOfStr = newSelectedTile.split(",");
        String newLocation = arrOfStr[0];

        int yO = (Character.getNumericValue(getOriginalLocation().charAt(0))-8)*-1;
        int xO = getOriginalLocation().charAt(1)-65;

        getChessBoardTile(xO,yO).setActionCommand(getOriginalLocation());
        getChessBoardTile(xN,yN).setActionCommand(newLocation+','+getMovingPiece());

        if (getMovingPiece().contains("whKing") && getCurrentTurn().equals("wh")) {
             getwhKing().setBorder(UIManager.getBorder("Button.border"));
             setwhKing(getChessBoardTile(xN,yN));
        }

            // If moving king, update global king variable
        if (getMovingPiece().contains("bKing") && getCurrentTurn().equals("b")) {
            getbKing().setBorder(UIManager.getBorder("Button.border"));
            setbKing(getChessBoardTile(xN,yN));
        }

        getChessBoardTile(xO,yO).setIcon(null);
        addIconToButton(s + getMovingPiece() + ".png", getChessBoardTile(xN,yN));

        if( movingPiece.contains("Pawn") && ( (getCurrentTurn().equals("wh") && newLocation.contains("8")) || getCurrentTurn().equals("b") && newLocation.contains("1") ) && !getCurrentTurn().equals(getAIColor()))
        {
            promotePawn(newLocation);
        }

        setOriginalLocation(null);
        setMovingPiece(null);
        setPieceSelected(false);
        PieceMovement.checkKing(getwhKing(), getbKing());
        HighlightTiles.highlightSquareEmpty(getAvailableTiles(), getAvailableEnemyTiles());

        if( getCurrentTurn().equals("b") ) { setCurrentTurn("wh"); }
        else { setCurrentTurn("b"); }
    }

    /*
    Parameters:
        String locationO: Original information on source tile
        String locationN: Original information on destination tile
        String piece: Moving piece located on source tile
    Return Value:
        Return: Boolean value to determine if given move is possible
    Description:
        Test to see if move from locationO to locationN with piece is a valid move that can be made  if in check
     */
    public static boolean isValidMove(String locationO, String locationN, String piece)
    {
        int yO = (Character.getNumericValue(locationO.charAt(0))-8)*-1;
        int xO = locationO.charAt(1)-65;
        int yN = (Character.getNumericValue(locationN.charAt(0))-8)*-1;
        int xN = locationN.charAt(1)-65;
        String originalPieceAction = getChessBoardTile(xO,yO).getActionCommand();
        String newPieceAction = getChessBoardTile(xN,yN).getActionCommand();

        // Clear action command to just contain location and no image
        getChessBoardTile(xO,yO).setActionCommand(locationO);

        // Set new button to contain chess piece and location
        getChessBoardTile(xN,yN).setActionCommand(locationN+','+piece);

        // If moving black king, check for check in new location of king
        if(originalPieceAction.contains("bKing") )
        {
            PieceMovement.checkKing(getwhKing(), getChessBoardTile(xN, yN));
        }

        // If moving white king, check for check in new location of king
        else if(originalPieceAction.contains("whKing") )
        {
            PieceMovement.checkKing(getChessBoardTile(xN, yN), getbKing());
        }

        // Check for check after moving piece to new location
        else
        {
            PieceMovement.checkKing(getwhKing(), getbKing());
        }

        if(getCurrentTurn().equals("wh")) {
            // Check if white piece can freely move
            if (getWhiteCheck()) {
                // White king still in check; not a valid move
                resetVars( originalPieceAction, newPieceAction);
                return false;
            } else {
                // White king no longer in check; a valid move
                resetVars( originalPieceAction, newPieceAction);
                return true;
            }
        }
        else if(getCurrentTurn().equals("b")) {
            // Check if black piece can freely move
            if ( getBlackCheck() ) {
                // Black king still in check; not a valid move
                resetVars( originalPieceAction, newPieceAction);
                return false;
            } else {
                // Black king no longer in check; a valid move
                resetVars( originalPieceAction, newPieceAction);
                return true;
            }
        }

        resetVars( originalPieceAction, newPieceAction);
        return false;
    }

    /*
    Parameters:
        String locationO: Original information on source tile
        String locationN: Original information on destination tile
    Return Value:
        Return: Void
    Description:
        Resets source and destination tile to be original information
     */
    public static void resetVars(String locationO, String locationN)
    {
        int yO = (Character.getNumericValue(locationO.charAt(0))-8)*-1;
        int xO = locationO.charAt(1)-65;
        int yN = (Character.getNumericValue(locationN.charAt(0))-8)*-1;
        int xN = locationN.charAt(1)-65;
        getChessBoardTile(xO,yO).setActionCommand(locationO);
        getChessBoardTile(xN,yN).setActionCommand(locationN);
        PieceMovement.checkKing(getwhKing(), getbKing());
    }

    /*
    Parameters:
        String sourceLocation: Location of source tile
    Return Value:
        Return: Void
    Description:
        Creates dialog box to allow user to choose what the pawn will be upgraded to.
        Once chosen, the pawn is replaced with new piece.
     */
    public static void promotePawn(String sourceLocation)
    {
        int[] sourceArrLoc = getTileArr(sourceLocation);
        Object[] options = {"Bishop",
                "Knight", "Rook", "Queen"};
        int n = JOptionPane.showOptionDialog(null,
                "Which piece would you like to promote pawn to?",
                "Pawn Promotion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,  //the titles of buttons
                options[0]); //default button title
        System.out.println(n);

        // Set pawn to different piece based on choice
        switch(n)
        {
            case 0 -> {
                getChessBoardTile(sourceArrLoc[0], sourceArrLoc[1]).setActionCommand(sourceLocation + "," + getCurrentTurn() + "Bishop");
                addIconToButton(s + getCurrentTurn() + "Bishop" + ".png", getChessBoardTile(sourceArrLoc[0],sourceArrLoc[1]));
            }
            case 1 -> {
                getChessBoardTile(sourceArrLoc[0], sourceArrLoc[1]).setActionCommand(sourceLocation + "," + getCurrentTurn() + "Knight");
                addIconToButton(s + getCurrentTurn() + "Knight" + ".png", getChessBoardTile(sourceArrLoc[0],sourceArrLoc[1]));
            }
            case 2 -> {
                getChessBoardTile(sourceArrLoc[0], sourceArrLoc[1]).setActionCommand(sourceLocation + "," + getCurrentTurn() + "Rook");
                addIconToButton(s + getCurrentTurn() + "Rook" + ".png", getChessBoardTile(sourceArrLoc[0],sourceArrLoc[1]));
            }
            case 3 -> {
                getChessBoardTile(sourceArrLoc[0], sourceArrLoc[1]).setActionCommand(sourceLocation + "," + getCurrentTurn() + "Queen");
                addIconToButton(s + getCurrentTurn() + "Queen" + ".png", getChessBoardTile(sourceArrLoc[0],sourceArrLoc[1]));
            }
        }
    }
}