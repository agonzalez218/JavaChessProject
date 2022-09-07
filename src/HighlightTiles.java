import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HighlightTiles extends Board {

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
}
