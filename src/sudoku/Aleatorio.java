/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;
import java.util.Random;
/**
 *
 * @author Maria Gabriela
 */
public class Aleatorio extends SudokuGenerator {

    private static Random random = new Random();

    // Implementación del método abstracto para generar un Sudoku
    @Override
    public void generateSudoku(int[][] board) {
        // Intentamos llenar el tablero de Sudoku
        llenarTab(board);
        // Después de generar el tablero, eliminamos algunos números aleatoriamente
        removerNum(board, 40 ); // Aumentamos el número de celdas vacías (ajustable)
    
    }

    // Llenar el tablero con números aleatorios sin violar las reglas del Sudoku
    private boolean llenarTab(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    // Intentar colocar un número aleatorio
                    int[] validNumbers = getValidNumbers(board, row, col);
                    if (validNumbers.length == 0) {
                        return false; // Si no hay números válidos, fallamos y revertimos
                    }

                    // Elegir un número aleatorio válido
                    int num = validNumbers[random.nextInt(validNumbers.length)];
                    board[row][col] = num;

                    // Recursivamente intentamos llenar el siguiente número
                    if (llenarTab(board)) {
                        return true;
                    }

                    // Si fallamos, revertimos el número y tratamos de otra opción
                    board[row][col] = 0;
                }
            }
        }
        return true; // Si hemos llenado todas las celdas correctamente, devolvemos true
    }
    
    // Eliminar números aleatorios para dejar espacios vacíos en el tablero
    private void removerNum (int[][] board, int numbersToRemove) {
        int count = 0;
        while (count < numbersToRemove) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (board[row][col] != 0) {
                board[row][col] = 0; // Eliminamos el número
                count++;
            }
        }
    }
}
