# JavaChessProject | September 2022
This project is my own game of Chess made in Java. This project was done to test my ability as well as give me more experience with larger projects. I obtained the images from Wikipedia: <a href="https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent"> link to page</a>. The rest of the code and formatting is my own done with a week of work through my personal time. Sample gameplay can be found below with section links and other game information. <br/>

## Section Links
[Game Rules](#game-rules)<br/>
[Chess Piece Rules](#chess-piece-rules)<br/>
[Tile Highlight Colors](#tile-highlight-colors)<br/>
[Chess Board Options](#chess-board-options)<br/>
[AI Options](#ai-options)<br/>
[Key Mnemonics](#key-mnemonics)<br/>
[Demo Images](#demo-images)<br/>
<a href="https://github.com/agonzalez218/JavaChessProject/blob/master/ChessGameDemoImages/ChessGameplay.mp4"> Sample Gameplay </a>


## Game Rules
The Chess Game I created follows normal standard game rules:<br/>
- White Team moves first and only one piece can be moved per turn
- If a piece is blocking another, it can not move through it (Except a Knight which moves over pieces)
- If the Team's King is in Check, the player can not move unless it is to block or stop the Check on their King
- If a Pawn reaches the end of the board, it can be promoted to Knight, Bishop, Rook, or Queen

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

## AI Options
- Black Team Default
  - By Default, Black team is chosen as enemy AI
- White Team
  - If White team is chosen as enemy AI, they move first 
- Auto
  - Runs simulation of game until first check is found
- None
  - Does not use any AI and allows two player game

## Key Mnemonics
- ALT + A
  - Opens AI Menu
- ALT + B
  - Selects Black Team as AI
- ALT + C
  - Concedes Defeat
- ALT + D
  - Sets Default Chess Board Color
- ALT + E
  - Exit Game
- ALT + H
  - Opens Chess Board Options
- ALT + N
  - Disabes AI
- ALT + R
  - Restart Game
- ALT + T
  - Sets Tan Brown / Dark Brown Chess Board Color
- ALT + U
  - Selects Auto Play
- ALT + W
  - Selects White Team as AI

## Demo Images
If you would like to see gameplay, please visit this link for <a href="https://github.com/agonzalez218/JavaChessProject/blob/master/ChessGameDemoImages/ChessGameplay.mp4"> Sample Gameplay! </a> <br/>

The following image is the main playing screen<br/>
![MainMenu](https://user-images.githubusercontent.com/60588691/190166156-afb5c7e1-274a-4a6b-a577-d5e4a822a06d.png)

The following image is the result of selecting a piece on your turn (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
![AvailableMoves](https://user-images.githubusercontent.com/60588691/190166182-c8f87ce5-1ca4-4b56-968e-781b5deee960.png)

The following image is the result of putting a king in check (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
![KingInCheck](https://user-images.githubusercontent.com/60588691/190166210-435462d4-3b4a-4a68-8e21-8a7666912bfc.png)

The following image shows when the current selected Chess Piece is able to take an enemy piece the tile will be highlighted red (<a href="#tile-highlight-colors"> link to Tile Color legend </a> ):<br/>
In this scenario, the Pawn will not be allowed to take the piece however, as the team's King is in Check (<a href="#game-rules"> link to Game Rules </a> ).<br/>
![AvailableEnemyTiles](https://user-images.githubusercontent.com/60588691/190166239-0d7e304e-edcf-46d5-9a55-e2a95e721264.png)

The following gif is the result of the AI promoting a pawn, and choosing an additional Queen (<a href="#game-rules"> link to Game Rules </a> ):<br/>
![PawnPromotion](https://user-images.githubusercontent.com/60588691/190166966-dee6c303-a576-4e09-848e-9b04f4b2764f.gif)

The following image is the result of pressing the concede button:<br/>
![Concede](https://user-images.githubusercontent.com/60588691/190166263-40750a8f-d82f-4fdf-9df1-5bc182aa9876.png)

The following image is the menu option that allows user to change Chess Board Color:<br/>
The board maintains this color while the game window is open, even if reset or during gameplay.<br/>
![MenuOption](https://user-images.githubusercontent.com/60588691/190166296-ddc37e17-2d3c-490c-9624-9b8d6da0cb3c.png)

The following image is the menu option that allows user to change AI Options:<br/>
If Auto is chosen, it will run until a King is in check.<br/>
![AIMenuOption](https://user-images.githubusercontent.com/60588691/190166356-4dd6a6e3-a807-40ad-bf7a-8a01685c259b.png)

The following image is the second option of the Chess Board (<a href="#chess-board-options"> link to Chess Board Options </a> ):<br/>
![SecondChessBoardColorOption](https://user-images.githubusercontent.com/60588691/190166391-1240ffc9-f12a-46f3-9086-0c744ec1d4dc.png)

The following gif is the result of using Mnemonics of the Menu options to switch between board colors (<a href="#key-mnemonics"> link to Key Mnemonics </a> ):<br/>
![BoardColorChange](https://user-images.githubusercontent.com/60588691/190166413-72293d93-bdc1-4ef8-9055-a046e763d9a1.gif)

