package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class SudokuGUI extends JFrame {
    private JPanel panelPrincipal;
    private JTextField[][] celdas;
    int[][] board = new int[SudokuGenerator.SIZE][SudokuGenerator.SIZE];
    
    SudokuGenerator generator = new Aleatorio();
    
    
    public SudokuGUI() {
        setTitle("Sudoku");
        setSize(400, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        panelPrincipal = new JPanel(new GridLayout(9, 9));
        celdas = new JTextField[9][9];

        Border bordeSuperior = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
        Border bordeIzquierdo = BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK);
        Border bordeDerecho = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK);

        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                celdas[fila][col] = new JTextField();
                celdas[fila][col].setHorizontalAlignment(JTextField.CENTER);

                Border borde = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);

                if (fila % 3 == 0) {
                    borde = BorderFactory.createCompoundBorder(bordeSuperior, borde);
                }
                if (fila % 3 == 2) {
                    borde = BorderFactory.createCompoundBorder(bordeInferior, borde);
                }
                if (col % 3 == 0) {
                    borde = BorderFactory.createCompoundBorder(bordeIzquierdo, borde);
                }
                if (col % 3 == 2) {
                    borde = BorderFactory.createCompoundBorder(bordeDerecho, borde);
                }

                celdas[fila][col].setBorder(borde);
                panelPrincipal.add(celdas[fila][col]);
            }
        }

        JPanel panelBoton = new JPanel();
        JButton botonSalir = new JButton("Salir");
        botonSalir.addActionListener(e -> System.exit(0));
        panelBoton.add(botonSalir);

        setLayout(new BorderLayout());
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        generator.generateSudoku(board);
        setNum();
        constante();
        refresh();
    }
    
    void setNum () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    celdas [i][j].setText(String.valueOf(board[i][j]));
                    celdas [i][j].disable();         
                    celdas[i][j].setBackground(Color.black);
                }
            }
        }
    }
    
    void constante() {
        while (true){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    
                    if (celdas[i][j].getText().equals("")){
                        celdas[i][j].setBackground(Color.WHITE);
                    } else { 
                        try {
                        board[i][j] = Integer.parseInt(celdas[i][j].getText());
                        }catch (NumberFormatException e) {celdas[i][j].setBackground(Color.red);}
                    }
                    
                }
            }
        }
    }
    
    void validar () {}
    
    void refresh () {
        revalidate();
        repaint();
    }
}
