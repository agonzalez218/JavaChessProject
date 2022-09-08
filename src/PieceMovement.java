import javax.swing.*;
import java.awt.*;

public class PieceMovement extends Board{

    public static void determinePossibleMoves(String chessPieceOrig, int y, int x)
    {
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
                HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                HighlightTiles.highlightSquare(availableTiles);
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
                HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                HighlightTiles.highlightSquare(availableTiles);
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
                HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                HighlightTiles.highlightSquare(availableTiles);
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
                HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                HighlightTiles.highlightSquare(availableTiles);
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
                    HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                    HighlightTiles.highlightSquare(availableTiles);
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
                    HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                    HighlightTiles.highlightSquare(availableTiles);
                }
                break;
            case "Pawn":
                if(teamColor.equals("b")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y < 7 && !(chessBoard[x][y+1].getActionCommand().contains("b")) && !(chessBoard[x][y+1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 1 && !(chessBoard[x][y+2].getActionCommand().contains("wh"))) {
                            availableTiles.add(chessBoard[x][y + 2]);
                        }
                        availableTiles.add(chessBoard[x][y + 1]);
                        HighlightTiles.highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y < 7 )
                    {
                        if( chessBoard[x+1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(chessBoard[x+1][y+1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y < 7 )
                    {
                        if( chessBoard[x-1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(chessBoard[x-1][y+1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                }
                else if(teamColor.equals("wh")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y > 0 && !(chessBoard[x][y-1].getActionCommand().contains("b")) && !(chessBoard[x][y-1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 6 && !(chessBoard[x][y-2].getActionCommand().contains("b"))) {
                            availableTiles.add(chessBoard[x][y - 2]);
                        }
                        availableTiles.add(chessBoard[x][y - 1]);
                        HighlightTiles.highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y > 0)
                    {
                        if( chessBoard[x-1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(chessBoard[x-1][y-1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y > 0)
                    {
                        if( chessBoard[x+1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(chessBoard[x+1][y-1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                }
                break;
        }
    }

    // Determine if given space is available for knight
    public static void knightMovement(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || chessBoard[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(chessBoard[x][y]);
            return;
        }
        availableTiles.add(chessBoard[x][y]);
    }

    // Recursively find next diagonal movement available
    public static void diagonalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || chessBoard[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(chessBoard[x][y]);
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7 || isKing)
        {
            availableTiles.add(chessBoard[x][y]);
            return;
        }
        switch (dir) {
            case 1 -> {
                availableTiles.add(chessBoard[x][y]);
                diagonalMovement(x+1, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                availableTiles.add(chessBoard[x][y]);
                diagonalMovement(x-1, y+1, dir, enemy, ally, false);
            }
            case 3 -> {
                availableTiles.add(chessBoard[x][y]);
                diagonalMovement(x+1, y-1, dir, enemy, ally, false);
            }
            case 4 -> {
                availableTiles.add(chessBoard[x][y]);
                diagonalMovement(x-1, y-1, dir, enemy, ally, false);
            }
        }
    }

    // Recursively find next vertical and/or horizontal movement available
    public static void verticalHorizontalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || chessBoard[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(chessBoard[x][y]);
            return;
        }
        if( isKing )
        {
            availableTiles.add(chessBoard[x][y]);
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7  )
        {
            availableTiles.add(chessBoard[x][y]);
        }
        switch (dir) {
            case 1 -> {
                availableTiles.add(chessBoard[x][y]);
                verticalHorizontalMovement(x, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                availableTiles.add(chessBoard[x][y]);
                verticalHorizontalMovement(x, y-1, dir, enemy, ally, false);
            }
            case 3 -> {
                availableTiles.add(chessBoard[x][y]);
                verticalHorizontalMovement(x+1, y, dir, enemy, ally, false);
            }
            case 4 -> {
                availableTiles.add(chessBoard[x][y]);
                verticalHorizontalMovement(x-1, y, dir, enemy, ally, false);
            }
        }
    }

    // Checks for enemy bishops, queens, and rooks in check spots
    public static void checkSpaces(int x, int y, int dir, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || chessBoard[x][y].getActionCommand().contains(ally) )
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy) && !((dir < 4 && chessBoard[x][y].getActionCommand().contains("Rook")) || (dir > 4 && chessBoard[x][y].getActionCommand().contains("Bishop")) || chessBoard[x][y].getActionCommand().contains("Queen")))
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy) && ((dir < 4 && chessBoard[x][y].getActionCommand().contains("Rook")) || (dir > 4 && chessBoard[x][y].getActionCommand().contains("Bishop")) || chessBoard[x][y].getActionCommand().contains("Queen")))
        {
            if(ally.equals("b"))
            {
                blackCheck = true;
                bKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            }
            else
            {
                whiteCheck = true;
                whKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
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

    // Checks for enemy knights in check spots
    public static void checkForKnight(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || chessBoard[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( chessBoard[x][y].getActionCommand().contains(enemy) && chessBoard[x][y].getActionCommand().contains("Knight"))
        {
            if(ally.equals("b"))
            {
                blackCheck = true;
                bKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            }
            else
            {
                whiteCheck = true;
                whKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            }
        }
    }

    public static void checkKing()
    {
        String blackLocation, whiteLocation;
        whiteLocation = whKing.getActionCommand().substring(0,2);
        blackLocation = bKing.getActionCommand().substring(0,2);

        int yOwh = (Character.getNumericValue(whiteLocation.charAt(0))-8)*-1;
        int xOwh = whiteLocation.charAt(1)-65;
        int yOb = (Character.getNumericValue(blackLocation.charAt(0))-8)*-1;
        int xOb = blackLocation.charAt(1)-65;

        // Check for pawn
        if(xOb < 7 && yOb < 7 && (chessBoard[xOb+1][yOb+1].getActionCommand().contains("whPawn") ))
        {
            bKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            blackCheck = true;
        }
        else if(xOb > 0 && yOb < 7 && chessBoard[xOb-1][yOb+1].getActionCommand().contains("whPawn"))
        {
            bKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            blackCheck = true;
        }
        else
        {
            bKing.setBorder(UIManager.getBorder("Button.border"));
            blackCheck = false;
        }

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
        if(xOwh < 7 && yOwh > 0 && chessBoard[xOwh+1][yOwh-1].getActionCommand().contains("bPawn") )
        {
            whKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            whiteCheck = true;
        }
        else if( xOwh > 0 && yOwh > 0 && chessBoard[xOwh-1][yOwh-1].getActionCommand().contains("bPawn"))
        {
            whKing.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));
            whiteCheck = true;
        }
        else
        {
            whKing.setBorder(UIManager.getBorder("Button.border"));
            whiteCheck = false;
        }
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
    }
}
