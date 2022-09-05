import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    String s = "src\\ChessPieces\\";
    String movingPiece;
    String originalLocation;
    Boolean pieceSelected = false;

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
                tempSquare.setBounds((385 / 8 * i), (340 / 8 * j),385/8,340/8);
                if( i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
                {
                    tempSquare.setBackground(Color.lightGray);
                }
                else
                {
                    tempSquare.setBackground(Color.white);
                }

                if(j <= 1)
                {
                    str = addBlackPieceImages(i, j, s, tempSquare);
                }
                else if(j >= 6)
                {
                    str = addWhitePieceImages(i, j, s, tempSquare);
                }
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
        this.middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Chess Board"));
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

    private String addWhitePieceImages(int i, int j, String s, JButton tempSquare){
        String str = "";
        int x = (-1*j)+8;
        char y = (char)(i+65);
        String tileLocation = String.valueOf(x)+y+',';
        if(j == 6)
        {
            str = s+"wPawn.png";
            tempSquare.setActionCommand(tileLocation+"wPawn");
        }
        if(j == 7 && i == 0 || j == 7 && i == 7)
        {
            str = s+"wRook.png";
            tempSquare.setActionCommand(tileLocation+"wRook");
        }
        if(j == 7 && i == 1 || j == 7 && i == 6)
        {
            str = s+"wKnight.png";
            tempSquare.setActionCommand(tileLocation+"wKnight");
        }
        if(j == 7 && i == 2 || j == 7 && i == 5)
        {
            str = s+"wBishop.png";
            tempSquare.setActionCommand(tileLocation+"wBishop");
        }
        if(j == 7 && i == 3)
        {
            str = s+"wKing.png";
            tempSquare.setActionCommand(tileLocation+"wKing");
        }
        if(j == 7 && i == 4)
        {
            str = s+"wQueen.png";
            tempSquare.setActionCommand(tileLocation+"wQueen");
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

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if( str.equals("Exit Game"))
        {
            System.exit(0);
        }
        else if( str.equals("Restart Game"))
        {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);
        }
        else if( str.length() > 2 && !pieceSelected)
        {
            String[] arrOfStr = str.split(",");
            originalLocation = arrOfStr[0];
            movingPiece = arrOfStr[1];
            pieceSelected = true;
        }
        else if( pieceSelected )
        {
            // Convert to matrix location
            int xO = (Character.getNumericValue(originalLocation.charAt(0))-8)*-1;
            int yO = originalLocation.charAt(1)-65;

            // Clear action command to just contain location and no image
            squares[yO][xO].setActionCommand(originalLocation);
            squares[yO][xO].setIcon(null);

            // Convert current (new) tile to matrix location
            int xN = (Character.getNumericValue(str.charAt(0))-8)*-1;
            int yN = str.charAt(1)-65;

            // Get Chess Board location from button
            String[] arrOfStr = str.split(",");
            originalLocation = arrOfStr[0];

            // Set new button to contain chess piece and location
            squares[yN][xN].setActionCommand(originalLocation+','+movingPiece);
            addIconToButton(s+movingPiece+".png", squares[yN][xN]);

            // Reset buffer and condition variables
            originalLocation = "";
            movingPiece = "";
            pieceSelected = false;
        }
    }
}
