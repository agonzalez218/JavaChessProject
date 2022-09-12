import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Board extends JFrame implements ActionListener {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Chess Board Options");
    JRadioButtonMenuItem rbMenuItem;
    JPanel form = new JPanel();
    JPanel middlePanel = new JPanel();
    static JButton exitGame = new JButton();
    JButton concede = new JButton();
    JButton restartGame = new JButton();
    ButtonGroup group = new ButtonGroup();
    static JButton bKing = new JButton(), whKing = new JButton();
    static JButton[][] chessBoard = new JButton[8][8];
    static List<JButton> availableTiles = new ArrayList<>(), availableEnemyTiles = new ArrayList<>();
    static JButton currentTile = new JButton();
    static String s = "src\\ChessPieces\\";
    static String teamTurn;
    static Boolean pieceSelected = false;
    static Boolean whiteCheck = false, blackCheck = false, teamMoved = false;

    // Setters and Getters of Variables
    public static void setCurrentTile(JButton selectedTile) {
        currentTile = selectedTile;
    }

    public static JButton getCurrentTile() {
        return currentTile;
    }

    public static void setbKing(JButton king) {
        bKing = king;
    }

    public static JButton getbKing() {
        return bKing;
    }

    public static void setwhKing(JButton king) {
        whKing = king;
    }

    public static JButton getwhKing() {
        return whKing;
    }

    public static JButton[][] getChessBoard() {
        return chessBoard;
    }

    public static JButton getChessBoardTile(int x, int y) {
        return getChessBoard()[x][y];
    }

    public static void setChessBoardTile(int x, int y, JButton tile) {
        getChessBoard()[x][y] = tile;
    }

    public static void setAvailableTiles(List<JButton> list) {
        availableTiles = list;
    }

    public static List<JButton> getAvailableTiles() {
        return availableTiles;
    }

    public static void setAvailableEnemyTiles(List<JButton> list) {
        availableEnemyTiles = list;
    }

    public static List<JButton> getAvailableEnemyTiles() {
        return availableEnemyTiles;
    }

    public static void setCurrentTurn(String team) {
        teamTurn = team;
    }

    public static String getCurrentTurn() {
        return teamTurn;
    }

    public static void setWhiteCheck(Boolean check) {
        whiteCheck = check;
    }

    public static Boolean getWhiteCheck() {
        return whiteCheck;
    }

    public static void setBlackCheck(Boolean check) {
        blackCheck = check;
    }

    public static Boolean getBlackCheck() {
        return blackCheck;
    }

    public static void setPieceSelected(Boolean condition) {
        pieceSelected = condition;
    }

    public static Boolean getPieceSelected() {
        return pieceSelected;
    }

    public static void setTeamMoved(Boolean condition) {
        teamMoved = condition;
    }

    public static Boolean getTeamMoved() {
        return teamMoved;
    }

    public Board() {
        setCurrentTurn("wh");
        setWhiteCheck(false);
        setBlackCheck(false);

        this.form.setLayout(null);
        this.setLocations();
        this.setText();
        this.createMenu();
        this.addComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int i, j;
        String str = "";
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                JButton tempSquare = new JButton();

                // Allows equal size of squares to be created in board
                tempSquare.setBounds((385 / 8 * i), (340 / 8 * j), 385 / 8, 340 / 8);

                // Adds Checkerboard pattern to board
                if (i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0) {
                    switch (HighlightTiles.getOption()) {
                        case 68 -> tempSquare.setBackground(Color.lightGray);
                        case 84 -> tempSquare.setBackground(new Color(111, 78, 55));
                    }
                } else {
                    switch (HighlightTiles.getOption()) {
                        case 68 -> tempSquare.setBackground(Color.white);
                        case 84 -> tempSquare.setBackground(new Color(245, 222, 179));
                    }
                }

                // If tile is in first two rows, pieces all start black
                if (j <= 1) {
                    str = addBlackPieceImages(i, j, s, tempSquare);
                }

                // If tile is in last two rows, pieces all start white
                else if (j >= 6) {
                    str = addWhitePieceImages(i, j, s, tempSquare);
                }

                // if between , they are normal tiles and are just assigned chess board location
                else {
                    // Convert matrix location into chess board location then add to button
                    int x = (-1 * j) + 8;
                    char y = (char) (i + 65);
                    String tileLocation = String.valueOf(x) + y;
                    tempSquare.setActionCommand(tileLocation);
                }
                if (j <= 1 || j >= 6) {
                    addIconToButton(str, tempSquare);
                }
                tempSquare.addActionListener(this);
                setChessBoardTile(i, j, tempSquare);
                this.add(getChessBoardTile(i, j));
            }
        }
        setbKing(getChessBoardTile(4, 0));
        setwhKing(getChessBoardTile(4, 7));
        this.add(this.middlePanel);
        this.add(this.form);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setLocations() {
        this.setSize(400, 445);
        this.middlePanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
        this.middlePanel.setBounds(0, 0, 385, 340);
        exitGame.setBounds(260, 345, 120, 30);
        this.restartGame.setBounds(10, 345, 120, 30);
        this.concede.setBounds(140, 345, 110, 30);
    }

    private void setText() {
        this.setTitle("Chess Game");
        exitGame.setText("Exit Game");
        exitGame.setMnemonic(KeyEvent.VK_E);
        this.restartGame.setText("Restart Game");
        restartGame.setMnemonic(KeyEvent.VK_R);
        this.concede.setText("Concede");
        concede.setMnemonic(KeyEvent.VK_C);
    }

    public void createMenu() {
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);

        rbMenuItem = new JRadioButtonMenuItem("Default Board (Light Gray/White)");
        rbMenuItem.setMnemonic(KeyEvent.VK_D);
        rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, InputEvent.ALT_MASK));
        rbMenuItem.addActionListener(this);
        if (HighlightTiles.getOption() == 68) {
            rbMenuItem.setSelected(true);
        }

        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Tan Brown/Dark Brown");
        rbMenuItem.setMnemonic(KeyEvent.VK_T);
        rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_T, InputEvent.ALT_MASK));
        rbMenuItem.addActionListener(this);
        if (HighlightTiles.getOption() == 84) {
            rbMenuItem.setSelected(true);
        }
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
    }

    private void addComponents() {
        this.add(exitGame);
        this.add(restartGame);
        this.add(concede);
        exitGame.addActionListener(this);
        restartGame.addActionListener(this);
        concede.addActionListener(this);
        this.setJMenuBar(menuBar);
    }

    // Adds Piece name, Piece Picture location, and Chess Board location to button
    private String addBlackPieceImages(int i, int j, String s, JButton tempSquare) {
        String str = "";
        int x = (-1 * j) + 8;
        char y = (char) (i + 65);
        String tileLocation = String.valueOf(x) + y + ',';
        if (j == 1) {
            str = s + "bPawn.png";
            tempSquare.setActionCommand(tileLocation + "bPawn");
        }
        if (j == 0 && i == 0 || j == 0 && i == 7) {
            str = s + "bRook.png";
            tempSquare.setActionCommand(tileLocation + "bRook");
        }
        if (j == 0 && i == 1 || j == 0 && i == 6) {
            str = s + "bKnight.png";
            tempSquare.setActionCommand(tileLocation + "bKnight");
        }
        if (j == 0 && i == 2 || j == 0 && i == 5) {
            str = s + "bBishop.png";
            tempSquare.setActionCommand(tileLocation + "bBishop");
        }
        if (j == 0 && i == 4) {
            str = s + "bKing.png";
            tempSquare.setActionCommand(tileLocation + "bKing");
        }
        if (j == 0 && i == 3) {
            str = s + "bQueen.png";
            tempSquare.setActionCommand(tileLocation + "bQueen");
        }
        return str;
    }

    // Adds Piece name, Piece Picture location, and Chess Board location to button
    private String addWhitePieceImages(int i, int j, String s, JButton tempSquare) {
        String str = "";
        int x = (-1 * j) + 8;
        char y = (char) (i + 65);
        String tileLocation = String.valueOf(x) + y + ',';
        if (j == 6) {
            str = s + "whPawn.png";
            tempSquare.setActionCommand(tileLocation + "whPawn");
        }
        if (j == 7 && i == 0 || j == 7 && i == 7) {
            str = s + "whRook.png";
            tempSquare.setActionCommand(tileLocation + "whRook");
        }
        if (j == 7 && i == 1 || j == 7 && i == 6) {
            str = s + "whKnight.png";
            tempSquare.setActionCommand(tileLocation + "whKnight");
        }
        if (j == 7 && i == 2 || j == 7 && i == 5) {
            str = s + "whBishop.png";
            tempSquare.setActionCommand(tileLocation + "whBishop");
        }
        if (j == 7 && i == 4) {
            str = s + "whKing.png";
            tempSquare.setActionCommand(tileLocation + "whKing");
        }
        if (j == 7 && i == 3) {
            str = s + "whQueen.png";
            tempSquare.setActionCommand(tileLocation + "whQueen");
        }
        return str;
    }

    public static void addIconToButton(String str, JButton button) {
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
    public void endGame() {
        Object[] options = {"OK", "CANCEL"};
        Object result = null;
        if (getCurrentTurn().equals("b")) {
            // Create dialog message allowing user to decide to restart game or continue
            result = JOptionPane.showOptionDialog(null, "White has won! Press OK to restart!", "Checkmate",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        }
        if (getCurrentTurn().equals("wh")) {
            // Create dialog message allowing user to decide to restart game or continue
            result = JOptionPane.showOptionDialog(null, "Black has won! Press OK to restart!", "Checkmate",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        }

        // If user selects OK restart game
        if (result != null && (int) result == 0) {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        //writeToDebugFile("Selected Piece: " + str);
        //writeToDebugFile("Black King: " + getbKing().getActionCommand());
        //writeToDebugFile("White King: " + getwhKing().getActionCommand());
        // Convert current (new) tile to matrix location
        int yN = (Character.getNumericValue(str.charAt(0)) - 8) * -1;
        int xN = str.charAt(1) - 65;

        if (str.equals("Default Board (Light Gray/White)")) {
            HighlightTiles.setOption(68);
            HighlightTiles.changeChessBoardBackground();
        }
        if (str.equals("Tan Brown/Dark Brown")) {
            HighlightTiles.setOption(84);
            HighlightTiles.changeChessBoardBackground();
        }

        if (str.equals("Exit Game")) {
            System.exit(0);
        }
        if (str.equals("Restart Game")) {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);
            return;
        }
        if (str.equals("Concede")) {
            endGame();
        }

        // Select original piece
        if (str.length() > 2 && !getPieceSelected() && ((getCurrentTurn().equals("b") && str.contains("b")) || getCurrentTurn().equals("wh") && str.contains("wh"))) {
            HighlightTiles.highlightSquareEmpty(getAvailableTiles(), getAvailableEnemyTiles());
            PieceMovement.savePiece(str);
            HighlightTiles.highlightSquareEnemy(getAvailableEnemyTiles());
            HighlightTiles.highlightSquare(getAvailableTiles());
        }

        // Move piece
        else if (getTeamMoved() && getPieceSelected() && (getAvailableTiles().contains(getChessBoardTile(xN, yN)) || getAvailableEnemyTiles().contains(getChessBoardTile(xN, yN)))) {
            String[] arrOfStr = str.split(",");
            String newLocation = arrOfStr[0];
            // Convert to matrix location
            if (PieceMovement.isValidMove(PieceMovement.getOriginalLocation(), newLocation, PieceMovement.getMovingPiece())) {
                PieceMovement.movePiece(str, xN, yN);
            }
            else
            {
                PieceMovement.setOriginalLocation("");
                PieceMovement.setMovingPiece("");
                setPieceSelected(false);
                setTeamMoved(false);
                HighlightTiles.highlightSquareEmpty(getAvailableTiles(), getAvailableEnemyTiles());
            }

            if (Objects.equals(getCurrentTurn(), "b")) {
                ChessAI.moveAIPiece(this);
            }
        }
        // add reset buffers if no new piece selected
        else {
            PieceMovement.setOriginalLocation("");
            PieceMovement.setMovingPiece("");
            setPieceSelected(false);
            setTeamMoved(false);
            HighlightTiles.highlightSquareEmpty(getAvailableTiles(), getAvailableEnemyTiles());
        }
    }

    public static void writeToDebugFile(String line) {
        try {
            try(FileWriter fw = new FileWriter("debugFile.txt", true);
                BufferedWriter writer = new BufferedWriter(fw)) {
                writer.write(line+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
