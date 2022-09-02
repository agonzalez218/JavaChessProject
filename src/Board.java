import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    JPanel[][] squares = new JPanel[8][8];
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();

    public Board(){
        this.form.setLayout(null);
        this.setLocations();
        this.setText();
        this.addComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int i = 0, j = 0;
        String str = "";
        for(i=0; i<8;i++)
        {
            for(j=0; j<8;j++)
            {
                JPanel tempSquare = new JPanel();
                tempSquare.setBounds((385 / 8 * i), (340 / 8 * j),385/8,340/8);
                if( i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
                {
                    tempSquare.setBackground(Color.lightGray);
                }
                else
                {
                    tempSquare.setBackground(Color.white);
                }
                BufferedImage myPicture = null;
                if(j <= 1)
                {
                    str = addBlackPieceImages(i, j, s);
                }
                else
                {
                    str = addWhitePieceImages(i, j, s);
                }
                if( j <= 1 || j >= 6) {
                    try {
                        myPicture = ImageIO.read(new File(str));
                        Image scaledImage = myPicture.getScaledInstance(tempSquare.getWidth(), tempSquare.getHeight(), Image.SCALE_SMOOTH);
                        JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
                        tempSquare.add(picLabel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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

    private String addBlackPieceImages(int i, int j, String s){
        String str = "";
        if(j == 1)
        {
            str = s+"\\src\\ChessPieces\\bPawn.png";
        }
        if(j == 0 && i == 0 || j == 0 && i == 7)
        {
            str = s+"\\src\\ChessPieces\\bRook.png";
        }
        if(j == 0 && i == 1 || j == 0 && i == 6)
        {
            str = s+"\\src\\ChessPieces\\bKnight.png";
        }
        if(j == 0 && i == 2 || j == 0 && i == 5)
        {
            str = s+"\\src\\ChessPieces\\bBishop.png";
        }
        if(j == 0 && i == 4)
        {
            str = s+"\\src\\ChessPieces\\bKing.png";
        }
        if(j == 0 && i == 3)
        {
            str = s+"\\src\\ChessPieces\\bQueen.png";
        }
        return str;
    }

    private String addWhitePieceImages(int i, int j, String s){
        String str = "";
        if(j == 6)
        {
            str = s+"\\src\\ChessPieces\\wPawn.png";
        }
        if(j == 7 && i == 0 || j == 7 && i == 7)
        {
            str = s+"\\src\\ChessPieces\\wRook.png";
        }
        if(j == 7 && i == 1 || j == 7 && i == 6)
        {
            str = s+"\\src\\ChessPieces\\wKnight.png";
        }
        if(j == 7 && i == 2 || j == 7 && i == 5)
        {
            str = s+"\\src\\ChessPieces\\wBishop.png";
        }
        if(j == 7 && i == 3)
        {
            str = s+"\\src\\ChessPieces\\wKing.png";
        }
        if(j == 7 && i == 4)
        {
            str = s+"\\src\\ChessPieces\\wQueen.png";
        }
        return str;
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if( str.equals("Exit Game"))
        {
            System.exit(0);
        }
        if( str.equals("Restart Game"))
        {
            Board b = new Board();
            this.setVisible(false);
            b.setVisible(true);

        }
    }
}
