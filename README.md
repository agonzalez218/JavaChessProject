# JavaChessProject | September 2022
This project is my own game of Chess made in Java. This project was done to test my ability as well as give me more experience with larger projects. I obtained the images from Wikipedia: <a href="https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent"> link to page</a>. The rest of the code and formatting is my own done with a week of work through my personal time. <br/>

## Section Links
[Game Rules](#game-rules)<br/>
[Chess Piece Rules](#chess-piece-rules)<br/>
[Demo Rules](#demo-images)<br/>


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

## Demo Images
The following image is the main playing screen<br/>
![MainMenu](https://user-images.githubusercontent.com/60588691/188952400-ca1dc875-1b9f-43c1-aa19-0bf0c45b3548.png)

The following image is the result of selecting a piece on your turn:<br/>
Yellow Tiles: Available moves for current selected piece<br/>
Blue Tile: Current selected piece<br/>
![AvailableMoves](https://user-images.githubusercontent.com/60588691/188952464-f84e277a-a31a-47c2-bf06-c76f3bf1f1dd.png)

The following image is the result of putting a king in check:<br/>
Red Tile: If chess piece is selected, red tile over an enemy means the piece can be taken<br/>
If Tile with King is red and NO piece is selected, the King is in Check<br/>
![KingInCheck](https://user-images.githubusercontent.com/60588691/188952646-b36e0d50-00b3-46bb-a5c2-461804ed3855.png)

The following image is the result of pressing the concede button:<br/>
![Concede](https://user-images.githubusercontent.com/60588691/188952941-6f633640-c5c5-44ae-928e-83d56ba10c29.png)
