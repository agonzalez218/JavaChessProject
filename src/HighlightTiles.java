import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HighlightTiles extends Board {

    static int option = 68;

    public static void setOption(int newOption){
        option = newOption;
    }

    public static int getOption(){
        return option;
    }

    // Highlights an available spot to move
    public static void highlightSquare(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.yellow));
        }
    }

    // Empties all border highlights and resets to normal
    public static void highlightSquareEmpty(List<JButton> tileList, List<JButton> tileEnemyList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        for (JButton jButton : tileEnemyList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        currentTile.setBorder(UIManager.getBorder("Button.border"));
        availableTiles = new ArrayList<>();
        availableEnemyTiles = new ArrayList<>();
        currentTile = new JButton();
        PieceMovement.checkKing();
    }

    // Highlights an enemy that can be taken
    public static void highlightSquareEnemy(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        }
    }

    public static void changeChessBoardBackground()
    {
        int i, j;
        for( i = 0; i < 8; i++)
        {
            for( j = 0; j < 8; j++)
            {
                if( i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
                {
                    switch (option) {
                        case 68 -> chessBoard[i][j].setBackground(Color.lightGray);
                        case 84 -> chessBoard[i][j].setBackground(new Color(111, 78, 55));
                    }
                }
                else
                {
                    switch (option) {
                        case 68 -> chessBoard[i][j].setBackground(Color.white);
                        case 84 -> chessBoard[i][j].setBackground(new Color(245, 222, 179));
                    }
                }
            }
        }
    }
}
