import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
Author: Abel Gonzalez
Project Title: Chess Project in Java
Date: September 2022
Description of File: This file holds the necessary functions and variables responsible for highlighting tiles.
    Tiles are highlighted to show the user available moves, identify a user in check as well as show selected tile.
 */

public class HighlightTiles extends Board {

    // Chess Board background default option
    static int option = 68;

    // Setters and Getters of Variables
    public static void setOption(int newOption){
        option = newOption;
    }
    public static int getOption(){
        return option;
    }

    /*
    Parameters:
        List<JButton> tileList: List of Chess Board tiles
    Return Value:
        Return: Void
    Description:
        Highlights tiles in list as yellow
     */
    public static void highlightSquare(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.yellow));
        }
    }

    /*
    Parameters:
        List<JButton> tileList: List of Chess Board tiles
        List<JButton> tileList: List of Chess Board tiles
    Return Value:
        Return: Void
    Description:
        Resets all highlights on tiles, checks for King to re-highlight if needed, then resets lists
     */
    public static void highlightSquareEmpty(List<JButton> tileList, List<JButton> tileEnemyList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        for (JButton jButton : tileEnemyList) {
            jButton.setBorder(UIManager.getBorder("Button.border"));
        }
        Board.getCurrentTile().setBorder(UIManager.getBorder("Button.border"));
        highlightKingCheck();

        setAvailableTiles(new ArrayList<>());
        setAvailableEnemyTiles(new ArrayList<>());
        setCurrentTile(new JButton());
    }

    /*
    Parameters:
        N/A
    Return Value:
        Return: Void
    Description:
        Highlights King tiles in Red if they are in check or resets them if no longer in check
     */
    public static void highlightKingCheck()
    {
        if( getWhiteCheck() ) {getwhKing().setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));}
        else {getwhKing().setBorder(UIManager.getBorder("Button.border"));}
        if( getBlackCheck() ) {getbKing().setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.red));}
        else {getbKing().setBorder(UIManager.getBorder("Button.border"));}
    }

    /*
    Parameters:
        List<JButton> tileList: List of Chess Board tiles
    Return Value:
        Return: Void
    Description:
        Highlights tiles in list as red
     */
    public static void highlightSquareEnemy(List<JButton> tileList)
    {
        for (JButton jButton : tileList) {
            jButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        }
    }

    /*
    Parameters:
        N/A
    Return Value:
        Return: Void
    Description:
        Changes background color of tiles on Chess Board to user preference
     */
    public static void changeChessBoardBackground()
    {
        int i, j;
        for( i = 0; i < 8; i++)
        {
            for( j = 0; j < 8; j++)
            {
                if( i % 2 == 0 && j % 2 == 1 || i % 2 == 1 && j % 2 == 0)
                {
                    switch (getOption()) {
                        case 68 -> getChessBoard()[i][j].setBackground(Color.lightGray);
                        case 84 -> getChessBoard()[i][j].setBackground(new Color(111, 78, 55));
                    }
                }
                else
                {
                    switch (getOption()) {
                        case 68 -> getChessBoard()[i][j].setBackground(Color.white);
                        case 84 -> getChessBoard()[i][j].setBackground(new Color(245, 222, 179));
                    }
                }
            }
        }
    }
}
