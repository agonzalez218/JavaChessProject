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
    JButton concede = new JButton();
    JButton restartGame = new JButton();
    static JButton bKing = new JButton();
    static JButton whKing = new JButton();
    static JButton[][] squares = new JButton[8][8];
    static List<JButton> availableTiles = new ArrayList<>();
    static List<JButton> availableEnemyTiles = new ArrayList<>();
    static JButton currentTile = new JButton();
    static String s = "src\\ChessPieces\\";
    static String movingPiece;
    static String originalLocation;
    static Boolean pieceSelected = false;
    static Boolean whiteTurn = true;
    static Boolean blackTurn = false;
    static Boolean whiteCheck = false;
    static Boolean blackCheck = false;
    static Boolean teamMoved = false;

    public Board(){
        whiteTurn = true;
        blackTurn = false;
        whiteCheck = false;
        blackCheck = false;
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
        bKing = squares[4][0];
        whKing = squares[4][7];
        this.add(this.middlePanel);
        this.add(this.form);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setLocations(){
        this.setSize(400,420);
        this.middlePanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
        this.middlePanel.setBounds(0,0,385,340);
        this.exitGame.setBounds(260,345,120,30);
        this.restartGame.setBounds(10,345,120,30);
        this.concede.setBounds(140,345,110,30);
    }

    private void setText(){
        this.setTitle("Chess Game");
        this.exitGame.setText("Exit Game");
        this.restartGame.setText("Restart Game");
        this.concede.setText("Concede");
    }

    private void addComponents(){
        this.add(exitGame);
        this.add(restartGame);
        this.add(concede);
        exitGame.addActionListener(this);
        restartGame.addActionListener(this);
        concede.addActionListener(this);
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
        if(j == 7 && i == 4)
        {
            str = s+"whKing.png";
            tempSquare.setActionCommand(tileLocation+"whKing");
        }
        if(j == 7 && i == 3)
        {
            str = s+"whQueen.png";
            tempSquare.setActionCommand(tileLocation+"whQueen");
        }
        return str;
    }

    public static void addIconToButton(String str, JButton button)
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

    // Ends current game and resets board if user desires
    public void endGame()
    {
        Object[] options = { "OK", "CANCEL" };
        Object result = null;
        if(blackTurn)
        {
            // Create dialog message allowing user to decide to restart game or continue
            result = JOptionPane.showOptionDialog(null, "White has won! Press OK to restart!", "Checkmate",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        }
        if(whiteTurn)
        {
            // Create dialog message allowing user to decide to restart game or continue
            result = JOptionPane.showOptionDialog(null, "Black has won! Press OK to restart!", "Checkmate",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        }

        // If user selects OK restart game
        if( result != null && (int)result == 0)
        {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);
        }
    }

    public static void savePiece(String chessPiece)
    {
        String[] arrOfStr = chessPiece.split(",");
        originalLocation = arrOfStr[0];
        movingPiece = arrOfStr[1];
        pieceSelected = true;
        teamMoved = true;

        // Convert to matrix location
        int yO = (Character.getNumericValue(originalLocation.charAt(0))-8)*-1;
        int xO = originalLocation.charAt(1)-65;
        PieceMovement.checkKing();
        PieceMovement.determinePossibleMoves(movingPiece, yO, xO);
        currentTile = squares[xO][yO];
        currentTile.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.blue));
    }

    public static void movePiece(String chessPiece, int xN, int yN)
    {
        int yO = (Character.getNumericValue(originalLocation.charAt(0))-8)*-1;
        int xO = originalLocation.charAt(1)-65;

        // Clear action command to just contain location and no image
        squares[xO][yO].setActionCommand(originalLocation);


        // Get Chess Board location from button
        String[] arrOfStr = chessPiece.split(",");
        String newLocation = arrOfStr[0];

        // Set new button to contain chess piece and location
        squares[xN][yN].setActionCommand(newLocation+','+movingPiece);

        // If moving king, update global king variable
        if (movingPiece.contains("King") && whiteTurn) {
            whKing = squares[xN][yN];
        }

        // If moving king, update global king variable
        if (movingPiece.contains("King") && blackTurn) {
            bKing = squares[xN][yN];
        }

        PieceMovement.checkKing();
        if(whiteTurn) {
            // Check if white piece can freely move
            if (whiteCheck) {
                // Undo piece move as king in check
                if (movingPiece.contains("King")) {
                    whKing = squares[xO][yO];
                }
                squares[xO][yO].setActionCommand(originalLocation + ',' + movingPiece);
                squares[xN][yN].setActionCommand(newLocation);
                PieceMovement.checkKing();
            } else {
                // Keep track of king
                if (movingPiece.contains("King")) {
                    whKing = squares[xN][yN];
                }
                // Confirm piece move
                squares[xO][yO].setIcon(null);
                addIconToButton(s + movingPiece + ".png", squares[xN][yN]);
                blackTurn = !blackTurn;
                whiteTurn = !whiteTurn;
            }
        }
        else if(blackTurn) {
            // Check if black piece can freely move
            if ( blackCheck) {
                // Undo piece move as king in check
                if (movingPiece.contains("King")) {
                    bKing = squares[xO][yO];
                }
                squares[xO][yO].setActionCommand(originalLocation + ',' + movingPiece);
                squares[xN][yN].setActionCommand(newLocation);
                PieceMovement.checkKing();
            } else {
                // Keep track of king
                if (movingPiece.contains("King")) {
                    bKing = squares[xN][yN];
                }
                // Confirm piece move
                squares[xO][yO].setIcon(null);
                addIconToButton(s + movingPiece + ".png", squares[xN][yN]);
                blackTurn = !blackTurn;
                whiteTurn = !whiteTurn;
            }
        }

        // Reset buffer and condition variables
        originalLocation = "";
        movingPiece = "";
        pieceSelected = false;
        teamMoved = false;
        PieceMovement.checkKing();
        HighlightTiles.highlightSquareEmpty(availableTiles, availableEnemyTiles);
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
        if( str.equals("Concede"))
        {
            endGame();
        }

        // Select original piece
        if( str.length() > 2 && !pieceSelected && ((blackTurn && str.contains("b")) || whiteTurn && str.contains("wh")))
        {
            savePiece(str);
        }

        // Move piece
        else if( teamMoved && pieceSelected && (availableTiles.contains(squares[xN][yN]) || availableEnemyTiles.contains(squares[xN][yN])))
        {
            // Convert to matrix location
            movePiece(str, xN, yN);
            //ChessAI.moveAIPiece();
        }
        // add reset buffers if no new piece selected
        else
        {
            originalLocation = "";
            movingPiece = "";
            pieceSelected = false;
            teamMoved = false;
            HighlightTiles.highlightSquareEmpty(availableTiles, availableEnemyTiles);
        }
    }
}
