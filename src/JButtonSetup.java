import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Configura cada botón para que cambie de color cuando es presionado, actualiza el estado del juego y
    verifica si el jugador actual ha ganado. Si un jugador gana, muestra un mensaje de victoria y reinicia
    el estado del juego. La clase también maneja el cambio de turno entre los jugadores y resetea el
    jugador actual cuando se reinicia el juego.
*/
public class JButtonSetup {
    // Array de colores para los jugadores
    private static final Color[] playerColors = {Color.BLUE, Color.RED, Color.GREEN, new Color(128, 0, 128)};

    // Variable para rastrear al jugador actual
    private static int currentPlayer = 0;

    // Método para configurar un botón circular
    public static void setupButton(CircularButton button, int ringSize, int row, int col, int[][][] gameState) {
        // Configura el botón para que sea transparente
        button.setOpaque(false);

        // No llene el área de contenido
        button.setContentAreaFilled(false);

        // Establece el grosor del borde en 3 píxeles
        button.setBorderThickness(3);

        // Añadir un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el color del borde del botón al color del jugador actual
                button.setBorderColor(playerColors[currentPlayer]);

                // Actualizar el estado del juego con el jugador actual
                gameState[row][col][ringSize] = currentPlayer + 1;

                // Deshabilitar el botón
                button.setEnabled(false);

                // Verificar si el jugador actual ha ganado
                if (WinConditionOne.check(gameState, row, col, ringSize) ||
                    WinConditionTwo.check(gameState, currentPlayer + 1) ||
                    WinConditionThree.check(gameState, row, col, currentPlayer + 1)) {

                    // Mostrar un mensaje de victoria
                    JOptionPane.showMessageDialog(null, "¡Jugador " + (currentPlayer + 1) + " ha ganado!");

                    // Reiniciar el estado del juego
                    resetGameState(button);
                } else {
                    // Cambiar al siguiente jugador
                    currentPlayer = (currentPlayer + 1) % 4;
                }
            }
        });
    }

    // Método para reiniciar el estado del juego
    private static void resetGameState(JButton button) {
        // Obtener la ventana principal que contiene el botón
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button);

        // Si la ventana principal es una instancia de RingGameFrame, reiniciar el juego
        if (topFrame instanceof RingGameFrame) {
            ((RingGameFrame) topFrame).resetGame();
            resetCurrentPlayer();
        }
    }

    // Método para reiniciar el jugador actual al jugador 1
    public static void resetCurrentPlayer() {
        currentPlayer = 0;
    }
}
