/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author Maria Gabriela
 */
public abstract class SudokuGenerator {
     
    protected static final int SIZE = 9; // Tamaño del tablero
    protected static final int BLOCK_SIZE = 3; // Tamaño de cada bloque 3x3

    // Método abstracto para generar un tablero de Sudoku
    public abstract void generateSudoku(int[][] board);

    // Método para obtener los números válidos en una posición específica
    protected int[] getValidNumbers(int[][] board, int row, int col) {
        boolean[] valid = new boolean[SIZE + 1]; // Los números válidos son del 1 al 9

        // Marcar todos los números como válidos inicialmente
        for (int i = 1; i <= SIZE; i++) {
            valid[i] = true;
        }

        // Eliminar números que ya están en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] != 0) {
                valid[board[row][i]] = false;
            }
        }

        // Eliminar números que ya están en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] != 0) {
                valid[board[i][col]] = false;
            }
        }

        // Eliminar números que ya están en el bloque 3x3
        int blockRowStart = (row / BLOCK_SIZE) * BLOCK_SIZE;
        int blockColStart = (col / BLOCK_SIZE) * BLOCK_SIZE;
        for (int i = 0; i < BLOCK_SIZE; i++) {
            for (int j = 0; j < BLOCK_SIZE; j++) {
                if (board[blockRowStart + i][blockColStart + j] != 0) {
                    valid[board[blockRowStart + i][blockColStart + j]] = false;
                }
            }
        }

        // Contar cuántos números válidos hay
        int count = 0;
        for (int i = 1; i <= SIZE; i++) {
            if (valid[i]) {
                count++;
            }
        }

        // Crear un arreglo de los números válidos
        int[] validNumbers = new int[count];
        int index = 0;
        for (int i = 1; i <= SIZE; i++) {
            if (valid[i]) {
                validNumbers[index++] = i;
            }
        }
        return validNumbers;
    }

    // Método para imprimir el tablero de Sudoku
    public static void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
}

