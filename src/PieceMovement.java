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
                    if( y < 7 && !(squares[x][y+1].getActionCommand().contains("b")) && !(squares[x][y+1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 1) {
                            availableTiles.add(squares[x][y + 2]);
                        }
                        availableTiles.add(squares[x][y + 1]);
                        HighlightTiles.highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y < 7 )
                    {
                        if( squares[x+1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(squares[x+1][y+1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y < 7 )
                    {
                        if( squares[x-1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(squares[x-1][y+1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                }
                else if(teamColor.equals("wh")) {
                    // If end of board, or enemy/ally no more movement allowed
                    if( y > 0 && !(squares[x][y-1].getActionCommand().contains("b")) && !(squares[x][y-1].getActionCommand().contains("wh")))
                    {
                        // First move can be two tiles up
                        if (y == 6) {
                            availableTiles.add(squares[x][y - 2]);
                        }
                        availableTiles.add(squares[x][y - 1]);
                        HighlightTiles.highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y > 0)
                    {
                        if( squares[x-1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(squares[x-1][y-1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y > 0)
                    {
                        if( squares[x+1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(squares[x+1][y-1]);
                            HighlightTiles.highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                }
                break;
        }
    }

    public static void knightMovement(int x, int y, String enemy, String ally)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || squares[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( squares[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(squares[x][y]);
            return;
        }
        availableTiles.add(squares[x][y]);
    }

    public static void diagonalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || squares[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( squares[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(squares[x][y]);
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7 || isKing)
        {
            availableTiles.add(squares[x][y]);
            return;
        }
        switch (dir) {
            case 1 -> {
                availableTiles.add(squares[x][y]);
                diagonalMovement(x+1, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                availableTiles.add(squares[x][y]);
                diagonalMovement(x-1, y+1, dir, enemy, ally, false);
            }
            case 3 -> {
                availableTiles.add(squares[x][y]);
                diagonalMovement(x+1, y-1, dir, enemy, ally, false);
            }
            case 4 -> {
                availableTiles.add(squares[x][y]);
                diagonalMovement(x-1, y-1, dir, enemy, ally, false);
            }
        }
    }

    public static void verticalHorizontalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0 || squares[x][y].getActionCommand().contains(ally))
        {
            return;
        }
        if( squares[x][y].getActionCommand().contains(enemy))
        {
            availableEnemyTiles.add(squares[x][y]);
            return;
        }
        if( isKing )
        {
            availableTiles.add(squares[x][y]);
            return;
        }
        if( x == 0 || y == 0 || x == 7 || y == 7  )
        {
            availableTiles.add(squares[x][y]);
        }
        switch (dir) {
            case 1 -> {
                availableTiles.add(squares[x][y]);
                verticalHorizontalMovement(x, y+1, dir, enemy, ally, false);
            }
            case 2 -> {
                availableTiles.add(squares[x][y]);
                verticalHorizontalMovement(x, y-1, dir, enemy, ally, false);
            }
            case 3 -> {
                availableTiles.add(squares[x][y]);
                verticalHorizontalMovement(x+1, y, dir, enemy, ally, false);
            }
            case 4 -> {
                availableTiles.add(squares[x][y]);
                verticalHorizontalMovement(x-1, y, dir, enemy, ally, false);
            }
        }
    }
}
