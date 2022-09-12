import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PieceMovement extends Board{

    static String movingPiece, tempPiece, originalLocation;

    // Getters and Setters
    public static void setMovingPiece(String piece) { movingPiece = piece; }
    public static String getMovingPiece(){return movingPiece;}
    public static void setTempPiece(String piece) { tempPiece = piece; }
    public static String getTempPiece(){return tempPiece;}
    public static void setOriginalLocation(String location) { originalLocation = location; }
    public static String getOriginalLocation(){return originalLocation;}

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
                    if( y < 7 && !(getChessBoard()[x][y+1].getActionCommand().contains("b")) && !(getChessBoard()[x][y+1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 1 && !(getChessBoard()[x][y+2].getActionCommand().contains("wh"))) {
                            getAvailableTiles().add(getChessBoard()[x][y + 2]);
                        }
                        getAvailableTiles().add(getChessBoard()[x][y + 1]);
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y < 7 )
                    {
                        if( getChessBoard()[x+1][y+1].getActionCommand().contains("wh"))
                        {
                            getAvailableEnemyTiles().add(getChessBoard()[x+1][y+1]);
                        }
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y < 7 )
                    {
                        if( getChessBoard()[x-1][y+1].getActionCommand().contains("wh"))
                        {
                            getAvailableEnemyTiles().add(getChessBoard()[x-1][y+1]);
                        }
                    }
                }
                else if(teamColor.equals("wh")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y > 0 && !(getChessBoard()[x][y-1].getActionCommand().contains("b")) && !(getChessBoard()[x][y-1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 6 && !(getChessBoard()[x][y-2].getActionCommand().contains("b"))) {
                            getAvailableTiles().add(getChessBoard()[x][y - 2]);
                        }
                        getAvailableTiles().add(getChessBoard()[x][y - 1]);
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y > 0)
                    {
                        if( getChessBoard()[x-1][y-1].getActionCommand().contains("b"))
                        {
                            getAvailableEnemyTiles().add(getChessBoard()[x-1][y-1]);
                        }
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y > 0)
                    {
                        if( getChessBoard()[x+1][y-1].getActionCommand().contains("b"))
                        {
                            getAvailableEnemyTiles().add(getChessBoard()[x+1][y-1]);
                        }
                    }
                }
                break;
        }
    }

    // Determine if given space is available for knight
    public static void knightMovement(int x, int y, String enemy, String ally)
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
        getAvailableTiles().add(getChessBoard()[x][y]);
    }

    // Recursively find next diagonal movement available
    public static void diagonalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
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
        if( x == 0 || y == 0 || x == 7 || y == 7 || isKing)
        {
            getAvailableTiles().add(getChessBoard()[x][y]);
            return;
        }
        switch (dir) {
            case 1 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                diagonalMovement(x+1, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                diagonalMovement(x-1, y+1, dir, enemy, ally, false);
            }
            case 3 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                diagonalMovement(x+1, y-1, dir, enemy, ally, false);
            }
            case 4 -> {
                getAvailableTiles().add(getChessBoard()[x][y]);
                diagonalMovement(x-1, y-1, dir, enemy, ally, false);
            }
        }
    }

    // Recursively find next vertical and/or horizontal movement available
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

    // Checks for enemy bishops, queens, and rooks in check spots
    public static void checkSpaces(int x, int y, int dir, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || getChessBoard()[x][y].getActionCommand().contains(ally) )
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && !((dir < 4 && getChessBoard()[x][y].getActionCommand().contains("Rook")) || (dir > 4 && getChessBoard()[x][y].getActionCommand().contains("Bishop")) || getChessBoard()[x][y].getActionCommand().contains("Queen")))
        {
            return;
        }
        if( getChessBoard()[x][y].getActionCommand().contains(enemy) && ((dir < 4 && getChessBoard()[x][y].getActionCommand().contains("Rook")) || (dir > 4 && getChessBoard()[x][y].getActionCommand().contains("Bishop")) || getChessBoard()[x][y].getActionCommand().contains("Queen")))
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

    // Checks for enemy knights in check spots
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

    public static void savePiece(String chessPiece)
    {
        String[] arrOfStr = chessPiece.split(",");
        setOriginalLocation(arrOfStr[0]);
        setMovingPiece(arrOfStr[1]);
        setPieceSelected(true);
        setTeamMoved(true);

        // Convert to matrix location
        int yO = (Character.getNumericValue(getOriginalLocation().charAt(0))-8)*-1;
        int xO = getOriginalLocation().charAt(1)-65;
        PieceMovement.checkKing(getwhKing(), getbKing());
        PieceMovement.determinePossibleMoves(getMovingPiece(), yO, xO);
        setCurrentTile(getChessBoardTile(xO, yO));
        getCurrentTile().setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.blue));
    }

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

        setOriginalLocation("");
        setMovingPiece("");
        setTempPiece("");
        setPieceSelected(false);
        setTeamMoved(false);
        PieceMovement.checkKing(getwhKing(), getbKing());
        HighlightTiles.highlightSquareEmpty(getAvailableTiles(), getAvailableEnemyTiles());

        if( getCurrentTurn().equals("b") ) { setCurrentTurn("wh"); }
        else { setCurrentTurn("b"); }
    }

    public static boolean isValidMove(String locationO, String locationN, String piece)
    {
        int yO = (Character.getNumericValue(locationO.charAt(0))-8)*-1;
        int xO = locationO.charAt(1)-65;
        int yN = (Character.getNumericValue(locationN.charAt(0))-8)*-1;
        int xN = locationN.charAt(1)-65;
        JButton locationNTile = getChessBoardTile(xN, yN);

        // Clear action command to just contain location and no image
        getChessBoardTile(xO,yO).setActionCommand(locationO);

        if(getChessBoardTile(xN,yN).getActionCommand().length() > 2)
        {
            setTempPiece(getChessBoardTile(xN,yN).getActionCommand().substring(2));
        }

        // Set new button to contain chess piece and location
        getChessBoardTile(xN,yN).setActionCommand(locationN+','+piece);

        if(getChessBoardTile(xN,yN).getActionCommand().contains("bKing") )
        {
            PieceMovement.checkKing(getwhKing(), getChessBoardTile(xN, yN));
        }

        if(getChessBoardTile(xN,yN).getActionCommand().contains("whKing") )
        {
            PieceMovement.checkKing(getChessBoardTile(xN, yN), getbKing());
        }


        if(getCurrentTurn().equals("wh")) {
            // Check if white piece can freely move
            if (getWhiteCheck()) {
                // Undo piece move as king in check
                getChessBoardTile(xO,yO).setActionCommand(locationO + ',' + piece);
                if(!Objects.equals(getTempPiece(), ""))
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN+','+getTempPiece());
                }
                else
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN);
                }
                resetVars(locationNTile);
                return false;
            } else {
                // Undo piece move as king in check
                getChessBoardTile(xO,yO).setActionCommand(locationO + ',' + piece);
                if(!Objects.equals(getTempPiece(), ""))
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN+','+getTempPiece());
                }
                else
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN);
                }
                resetVars(locationNTile);
                return true;
            }
        }
        else if(getCurrentTurn().equals("b")) {
            // Check if black piece can freely move
            if ( getBlackCheck() ) {
                // Undo piece move as king in check
                getChessBoardTile(xO,yO).setActionCommand(locationO + ',' + piece);
                if(!Objects.equals(getTempPiece(), ""))
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN+getTempPiece());
                }
                else
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN);
                }
                resetVars(locationNTile);
                return false;
            } else {
                getChessBoardTile(xO,yO).setActionCommand(locationO + ',' + piece);
                if(!Objects.equals(getTempPiece(), ""))
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN+getTempPiece());
                }
                else
                {
                    getChessBoardTile(xN,yN).setActionCommand(locationN);
                }
                resetVars(locationNTile);
                return true;
            }
        }
        resetVars(locationNTile);
        return false;
    }

    public static void resetVars(JButton locationNTile)
    {
        // Reset buffer and condition variables
        setTempPiece("");
        locationNTile.setBorder(UIManager.getBorder("Button.border"));
        PieceMovement.checkKing(getwhKing(), getbKing());
    }
}