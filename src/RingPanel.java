import javax.swing.*;
import java.awt.*;

// Clase que extiende JPanel y representa un panel individual en la cuadrícula del juego
public class RingPanel extends JPanel {
    // Variables para almacenar la fila y columna del panel en la cuadrícula
    private final int row;
    private final int col;

    // Referencia al estado del juego compartido
    private final int[][][] gameState;

    // Array de botones circulares que representan los anillos en el panel
    private final CircularButton[] buttons = new CircularButton[3];

    public RingPanel(int row, int col, int[][][] gameState) {
        // Inicializa las variables de fila, columna y estado del juego
        this.row = row;
        this.col = col;
        this.gameState = gameState;

        // Configura el diseño del panel y el tamaño preferido
        /*
        Se configura el diseño del panel como null, lo que significa que se utilizará un diseño absoluto.
        Esto permite colocar los componentes en posiciones específicas dentro del panel.
        */
        setLayout(null);
        setPreferredSize(new Dimension(100, 100));

        // Crear botones circulares para los anillos
        buttons[0] = new CircularButton();
        buttons[1] = new CircularButton();
        buttons[2] = new CircularButton();

        // Crear botones circulares para los anillos
        buttons[0].setBounds(30, 30, 40, 40);
        buttons[1].setBounds(20, 20, 60, 60);
        buttons[2].setBounds(10, 10, 80, 80);

        // Configurar botones usando una clase auxiliar JButtonSetup
        JButtonSetup.setupButton(buttons[0], 0, row, col, gameState);
        JButtonSetup.setupButton(buttons[1], 1, row, col, gameState);
        JButtonSetup.setupButton(buttons[2], 2, row, col, gameState);

        // Añadir botones al panel en orden inverso de tamaño
        add(buttons[0]);
        add(buttons[1]);
        add(buttons[2]);
    }

    // Método para reiniciar el panel
    public void resetPanel() {
        // Recorre todos los botones y los reinicia
        for (CircularButton button : buttons) {
            // Restablece el color del borde a negro
            button.setBorderColor(Color.BLACK);

            // Habilita el botón
            button.setEnabled(true);
        }
    }
}
