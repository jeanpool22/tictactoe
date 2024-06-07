import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Utiliza SwingUtilities.invokeLater para asegurar que la creación y actualización de la GUI
        // se realice en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crea una instancia de la clase RingGameFrame, que representa la ventana principal del juego
            RingGameFrame frame = new RingGameFrame();
            // Hace visible la ventana del juego
            frame.setVisible(true);
        });
    }
}