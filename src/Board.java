import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Board extends JFrame implements ActionListener {
    JPanel form = new JPanel();
    JPanel middlePanel = new JPanel();
    JButton exitGame = new JButton();
    JButton restartGame = new JButton();
    JButton possibleMoves = new JButton();
    JButton[][] squares = new JButton[8][8];
    List<JButton> availableTiles = new ArrayList<>();
    List<JButton> availableEnemyTiles = new ArrayList<>();
    String s = "src\\ChessPieces\\";
    String movingPiece;
    String originalLocation;
    Boolean pieceSelected = false;
    Boolean whiteTurn = true;
    Boolean blackTurn = false;
    Boolean teamMoved = false;

    public Board(){
        this.form.setLayout(null);
        this.setLocations();
        this.setText();
        this.addComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int i, j;
        String str = "";
        for(i=0; i<8;i++)
        {
            for(j=0; j<8;j++)
            {
                JButton tempSquare = new JButton();

                // Allows equal size of squares to be created in board
                tempSquare.setBounds((385 / 8 * i), (340 / 8 * j),385/8,340/8);

                // Adds Checkerboard pattern to board
                if( i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
                {
                    tempSquare.setBackground(Color.lightGray);
                }
                else
                {
                    tempSquare.setBackground(Color.white);
                }

                // If tile is in first two rows, pieces all start black
                if(j <= 1)
                {
                    str = addBlackPieceImages(i, j, s, tempSquare);
                }

                // If tile is in last two rows, pieces all start white
                else if(j >= 6)
                {
                    str = addWhitePieceImages(i, j, s, tempSquare);
                }

                // if between , they are normal tiles and are just assigned chess board location
                else
                {
                    // Convert matrix location into chess board location then add to button
                    int x = (-1*j)+8;
                    char y = (char)(i+65);
                    String tileLocation = String.valueOf(x)+y;
                    tempSquare.setActionCommand(tileLocation);
                }
                if( j <= 1 || j >= 6) {
                    addIconToButton(str, tempSquare);
                }
                tempSquare.addActionListener(this);
                squares[i][j] = tempSquare;
                this.add(squares[i][j]);
            }
        }
        this.add(this.middlePanel);
        this.add(this.form);
        this.setVisible(true);
    }

    private void setLocations(){
        this.setSize(400,420);
        this.middlePanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
        this.middlePanel.setBounds(0,0,385,340);
        this.exitGame.setBounds(260,345,110,30);
        this.restartGame.setBounds(130,345,120,30);
        this.possibleMoves.setBounds(10,345,110,30);
    }

    private void setText(){
        this.setTitle("Chess Game");
        this.exitGame.setText("Exit Game");
        this.restartGame.setText("Restart Game");
        this.possibleMoves.setText("View Moves");
    }

    private void addComponents(){
        this.add(exitGame);
        this.add(restartGame);
        this.add(possibleMoves);
        exitGame.addActionListener(this);
        restartGame.addActionListener(this);
        possibleMoves.addActionListener(this);
    }

    // Adds Piece name, Piece Picture location, and Chess Board location to button
    private String addBlackPieceImages(int i, int j, String s, JButton tempSquare){
        String str = "";
        int x = (-1*j)+8;
        char y = (char)(i+65);
        String tileLocation = String.valueOf(x)+y+',';
        if(j == 1)
        {
            str = s+"bPawn.png";
            tempSquare.setActionCommand(tileLocation+"bPawn");
        }
        if(j == 0 && i == 0 || j == 0 && i == 7)
        {
            str = s+"bRook.png";
            tempSquare.setActionCommand(tileLocation+"bRook");
        }
        if(j == 0 && i == 1 || j == 0 && i == 6)
        {
            str = s+"bKnight.png";
            tempSquare.setActionCommand(tileLocation+"bKnight");
        }
        if(j == 0 && i == 2 || j == 0 && i == 5)
        {
            str = s+"bBishop.png";
            tempSquare.setActionCommand(tileLocation+"bBishop");
        }
        if(j == 0 && i == 4)
        {
            str = s+"bKing.png";
            tempSquare.setActionCommand(tileLocation+"bKing");
        }
        if(j == 0 && i == 3)
        {
            str = s+"bQueen.png";
            tempSquare.setActionCommand(tileLocation+"bQueen");
        }
        return str;
    }

    // Adds Piece name, Piece Picture location, and Chess Board location to button
    private String addWhitePieceImages(int i, int j, String s, JButton tempSquare){
        String str = "";
        int x = (-1*j)+8;
        char y = (char)(i+65);
        String tileLocation = String.valueOf(x)+y+',';
        if(j == 6)
        {
            str = s+"whPawn.png";
            tempSquare.setActionCommand(tileLocation+"whPawn");
        }
        if(j == 7 && i == 0 || j == 7 && i == 7)
        {
            str = s+"whRook.png";
            tempSquare.setActionCommand(tileLocation+"whRook");
        }
        if(j == 7 && i == 1 || j == 7 && i == 6)
        {
            str = s+"whKnight.png";
            tempSquare.setActionCommand(tileLocation+"whKnight");
        }
        if(j == 7 && i == 2 || j == 7 && i == 5)
        {
            str = s+"whBishop.png";
            tempSquare.setActionCommand(tileLocation+"whBishop");
        }
        if(j == 7 && i == 3)
        {
            str = s+"whKing.png";
            tempSquare.setActionCommand(tileLocation+"whKing");
        }
        if(j == 7 && i == 4)
        {
            str = s+"whQueen.png";
            tempSquare.setActionCommand(tileLocation+"whQueen");
        }
        return str;
    }

    public void addIconToButton(String str, JButton button)
    {
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File(str));
            Image scaledImage = myPicture.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void determinePossibleMoves(String chessPieceOrig, int y, int x)
    {
        System.out.println(chessPieceOrig);
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
                highlightSquareEnemy(availableEnemyTiles);
                highlightSquare(availableTiles);
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
                highlightSquareEnemy(availableEnemyTiles);
                highlightSquare(availableTiles);
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
                highlightSquareEnemy(availableEnemyTiles);
                highlightSquare(availableTiles);
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
                highlightSquareEnemy(availableEnemyTiles);
                highlightSquare(availableTiles);
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
                    highlightSquareEnemy(availableEnemyTiles);
                    highlightSquare(availableTiles);
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
                    highlightSquareEnemy(availableEnemyTiles);
                    highlightSquare(availableTiles);
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
                        highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y < 7 )
                    {
                        if( squares[x+1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(squares[x+1][y+1]);
                            highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y < 7 )
                    {
                        if( squares[x-1][y+1].getActionCommand().contains("wh"))
                        {
                            availableEnemyTiles.add(squares[x-1][y+1]);
                            highlightSquareEnemy(availableEnemyTiles);
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
                        highlightSquare(availableTiles);
                    }
                    // If there is an enemy tile to the left
                    if( x > 0 && y > 0)
                    {
                        if( squares[x-1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(squares[x-1][y-1]);
                            highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                    // If there is an enemy tile to the right
                    if( x < 7 && y > 0)
                    {
                        if( squares[x+1][y-1].getActionCommand().contains("b"))
                        {
                            availableEnemyTiles.add(squares[x+1][y-1]);
                            highlightSquareEnemy(availableEnemyTiles);
                        }
                    }
                }
                break;
        }
    }

    public void knightMovement(int x, int y, String enemy, String ally)
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

    public void diagonalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
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

    public void verticalHorizontalMovement(int x, int y, int dir, String enemy, String ally, Boolean isKing)
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

    public void highlightSquare(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.yellow));
        }
    }

    public void highlightSquareEmpty(List<JButton> tileList, List<JButton> tileEnemyList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        for (JButton jButton : tileEnemyList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        availableTiles = new ArrayList<>();
        availableEnemyTiles = new ArrayList<>();
    }

    public void highlightSquareEnemy(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        // Convert current (new) tile to matrix location
        int yN = (Character.getNumericValue(str.charAt(0))-8)*-1;
        int xN = str.charAt(1)-65;

        if( str.equals("Exit Game"))
        {
            System.exit(0);
        }
        if( str.equals("Restart Game"))
        {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);
            return;
        }

        // Select original piece
        if( str.length() > 2 && !pieceSelected && ((blackTurn && str.contains("b")) || whiteTurn && str.contains("wh")))
        {
            String[] arrOfStr = str.split(",");
            originalLocation = arrOfStr[0];
            movingPiece = arrOfStr[1];
            pieceSelected = true;
            teamMoved = true;

            // Convert to matrix location
            int yO = (Character.getNumericValue(originalLocation.charAt(0))-8)*-1;
            int xO = originalLocation.charAt(1)-65;
            determinePossibleMoves(movingPiece, yO, xO);
        }

        // Move piece
        else if( teamMoved && pieceSelected && (availableTiles.contains(squares[xN][yN]) || availableEnemyTiles.contains(squares[xN][yN])))
        {
            // Convert to matrix location
            int yO = (Character.getNumericValue(originalLocation.charAt(0))-8)*-1;
            int xO = originalLocation.charAt(1)-65;

            // Clear action command to just contain location and no image
            squares[xO][yO].setActionCommand(originalLocation);
            squares[xO][yO].setIcon(null);

            // Get Chess Board location from button
            String[] arrOfStr = str.split(",");
            originalLocation = arrOfStr[0];

            // Set new button to contain chess piece and location
            squares[xN][yN].setActionCommand(originalLocation+','+movingPiece);
            addIconToButton(s+movingPiece+".png", squares[xN][yN]);

            // Reset buffer and condition variables
            originalLocation = "";
            movingPiece = "";
            pieceSelected = false;
            teamMoved = false;
            blackTurn = !blackTurn;
            whiteTurn = !whiteTurn;
            highlightSquareEmpty(availableTiles, availableEnemyTiles);
        }
        // add reset buffers if no new piece selected
        else
        {
            originalLocation = "";
            movingPiece = "";
            pieceSelected = false;
            teamMoved = false;
            highlightSquareEmpty(availableTiles, availableEnemyTiles);
        }
    }
}
