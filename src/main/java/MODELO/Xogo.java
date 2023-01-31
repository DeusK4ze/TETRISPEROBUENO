/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author a22hugorp
 */
public class Xogo {
    
    // dimensions of the board
    private int width;
    private int height;

    // 2D array to hold the board state
    private int[][] board;

    // current piece and its position
    private Ficha currentPiece;
    private int currentX;
    private int currentY;
    public Xogo(){
    
    }
    
   public void moverFichaDereita(){
        if (canMoveRight()) {
            currentX++;
            repaint();
        }
    }
   
   private boolean canMoveRight() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (currentPiece.isFilled(row, col)) {
                    if (currentX + col >= width - 1) {
                        return false;
                    }
                    if (board[currentY + row][currentX + col + 1] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void moverFichaEsquerda(){
        if (pudesMoverIzquierda()) {
            currentX--;
            repaint();
        }
    }
    
    private boolean pudesMoverIzquierda() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (currentPiece.isFilled(row, col)) {
                    if (currentX + col <= 0) {
                        return false;
                    }
                    if (board[currentY + row][currentX + col - 1] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void RotarFicha(){
        int prevRotation = currentPiece.getRotation();
        int prevX = currentX;
        int prevY = currentY;

        // rotate the piece
        currentPiece.rotate();

        // check if the new position is valid
        if (!isValidPosition()) {
            // if the position is not valid, revert the rotation and position
            currentPiece.setRotation(prevRotation);
            currentX = prevX;
            currentY = prevY;
        }

        repaint();
    }
    
     private boolean isValidPosition() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (currentPiece.isFilled(row, col)) {
                    // check if the piece is within the boundaries of the board
                    if (currentX + col < 0 || currentX + col >= width || currentY + row >= height) {
                        return false;
                    }
                    // check if the piece is not colliding with any other pieces
                    if (board[currentY + row][currentX + col] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void moverFichaAbaixo(){
         if (canMoveDown()) {
            currentY++;
            repaint();
        } else {
            // if the piece can't move down, lock the piece
            lockPiece();
        }
    }
    
    private boolean canMoveDown() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (currentPiece.isFilled(row, col)) {
                    if (currentY + row >= height - 1) {
                        return false;
                    }
                    if (board[currentY + row + 1][currentX + col] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void lockPiece() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (currentPiece.isFilled(row, col)) {
                    board[currentY + row][currentX + col] = currentPiece.getType();
                }
            }
        }

        checkCompletedLines();
        createNewPiece();
    }
    
    private void checkCompletedLines() {
        for (int row = 0; row < height; row++) {
            if (isLineCompleted(row)) {
                clearLine(row);
                shiftBoardDown(row);
            }
        }
    }
    
        private boolean isLineCompleted(int row) {
        // check if all the cells in the given row are filled
        
    }
    
//    public void ePosicionValida(){
//    
//    }
//    
//    public void xenerarNovaFicha{}(
//    
//    )
//            
//    public void engadirFichaAoChan(){
//    
//    }
//    
//    public void borrarLinasCompletas(){
//    
//    }
//    
//    public void borrarLina(){
//    
//    }
//    
//    public void chocaFichaCoChan(){
//    
//    }
//    
//    private boolean isLineCompleted(int row) {
//        // check if all the cells in the given row are filled
//    }
//
//    private void clearLine(int row) {
//        // clear all the cells in the given row
//    }
//
//    private void shiftBoardDown(int row) {
//        // shift all the rows above the given row down by one
//    }
//
//    private void createNewPiece() {
//        // create a new piece for the player to move
//    }
//
//    public void dropDown() {
//        // move the piece down as far as it can go
//        // update the board state and repaint the board
//    }
//
//    public void checkLines() {
//        // check for complete lines
//        // remove complete lines and shift the board down
//        // repaint the board
//    }
//
    
            
    
    
    
    
}
