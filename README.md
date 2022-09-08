# JavaChessProject | September 2022
This project is my own game of Chess made in Java. This project was done to test my ability as well as give me more experience with larger projects. I obtained the images from Wikipedia: <a href="https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent"> link to page</a>. The rest of the code and formatting is my own done with a week of work through my personal time. <br/>

## Section Links
[Game Rules](#game-rules)<br/>
[Chess Piece Rules](#chess-piece-rules)<br/>
[Tile Highlight Colors](#tile-highlight-colors)<br/>
[Chess Board Options](#chess-board-options)<br/>
[Key Mnemonics](#key-mnemonics)<br/>
[Demo Images](#demo-images)<br/>


## Game Rules
The Chess Game I created follows normal standard game rules:<br/>
- White Team moves first and only one piece can be moved per turn
- If a piece is blocking another, it can not move through it (Except a Knight which moves over pieces)
- If the Team's King is in Check, the player can not move unless it is to block or stop the Check on their King

## Chess Piece Rules
Individual Piece Moves:<br/>
- Pawn 
  - Move two spaces for their first turn
  - Move one tile forward for each turn after
  - Attack one tile up and left or right of position
- Bishop
  - Move or Attack diagonally
- Rook
  - Move or Attack vertically and horizontally
- Knight
  - Move or Attack two tiles up or down and one tile left or right
  - Move or Attack one tile up or down and two tiles left or right
- Queen
  - Move or Attack horizontally, vertically, diagonally, and one tile in any direction
- King
  - Move or Attack one tile in any direction
  
## Tile Highlight Colors
- Blue:
  - Current selected Chess Piece/Tile<br/>
- Red:
  - If Chess Piece/Tile selected and red tile in Piece's Path, shows enemy tile that can be taken
  - If King Piece is highlighted red and NO piece is selected, the King shown is in Check
- Yellow:
  - Shows the current selected Chess Piece's available moves

## Chess Board Options
- Default Light Grey / White
- Tan Brown / Dark Brown

## Key Mnemonics
- ALT + C
  - Concede
- ALT + D
  - Default Chess Board Color
- ALT + E
  - Exit Game
 - ALT + H
  - Chess Board Options
- ALT + R
  - Restart Game
- ALT + T
  - Tan Brown / Dark Brown Chess Board Color

## Demo Images
The following image is the main playing screen<br/>
![MainMenu](https://user-images.githubusercontent.com/60588691/188952400-ca1dc875-1b9f-43c1-aa19-0bf0c45b3548.png)

The following image is the result of selecting a piece on your turn (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
![AvailableMoves](https://user-images.githubusercontent.com/60588691/188952464-f84e277a-a31a-47c2-bf06-c76f3bf1f1dd.png)

The following image is the result of putting a king in check (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
![KingInCheck](https://user-images.githubusercontent.com/60588691/188952646-b36e0d50-00b3-46bb-a5c2-461804ed3855.png)

The following image shows when the current selected Chess Piece is able to take an enemy piece the tile will be highlighted red (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
In this scenario, the Pawn will not be allowed to take the piece however, as the team's King is in Check (<a href="#game-rules"> link to Game Rules </a> ).<br/>
![AvailableEnemyTiles](https://user-images.githubusercontent.com/60588691/189136923-c40069c8-a348-4f25-a1e2-47b1b35dcc97.png)

The following image is the result of pressing the concede button:<br/>
![Concede](https://user-images.githubusercontent.com/60588691/188952941-6f633640-c5c5-44ae-928e-83d56ba10c29.png)

The following image is the menu option that allows user to change Chess Board Color:<br/>
The board maintains this color while the game window is open, even if reset or during gameplay.<br/>
![MenuOption](https://user-images.githubusercontent.com/60588691/189186643-ec52a0f3-0fa2-4253-b62b-432374673209.png)

The following image is the second option of the Chess Board (<a href="#chess-board-options"> link to Chess Board Options </a> ):<br/>
![SecondChessBoardColorOption](https://user-images.githubusercontent.com/60588691/189186844-33129b33-2c25-44cf-a124-76a78a8f8ff6.png)

The following gif is the result of using Mnemonics of the Menu options to switch between board colors (<a href="#key-mnemonics"> link to Key Mnemonics </a> ):<br/>
![BoardColorChange](https://user-images.githubusercontent.com/60588691/189195210-cc281e16-62fa-4262-9dd2-585e71991bf3.gif)
