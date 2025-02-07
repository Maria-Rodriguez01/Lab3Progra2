import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class SudokuGUI {
    private JDialog dialog;
    private JPanel panelPrincipal;
    private JTextField[][] celdas;

    public SudokuGUI() {
        dialog = new JDialog();
        dialog.setTitle("Sudoku");
        dialog.setSize(400, 400);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        panelPrincipal = new JPanel(new GridLayout(9, 9));
        celdas = new JTextField[9][9];

        Border bordeGrueso = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
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

        dialog.setLayout(new BorderLayout());
        dialog.add(panelPrincipal, BorderLayout.CENTER);
        dialog.add(panelBoton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuGUI::new);
    }
}
