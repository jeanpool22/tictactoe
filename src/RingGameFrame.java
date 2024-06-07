import javax.swing.*;
import java.awt.*;

/*
  La clase RingGameFrame es una ventana de juego que utiliza una cuadrícula de 3x3 para organizar paneles
  individuales (RingPanel). Estos paneles representan partes del juego y están ligados a un estado del
  juego almacenado en una matriz tridimensional. La clase proporciona funcionalidad para inicializar la
  cuadrícula del juego y para reiniciar el estado del juego y los paneles cuando sea necesario.
*/

public class RingGameFrame extends JFrame {
    // Estado del juego representado por una matriz tridimensional [fila][columna][tamaño]
    // gameState es una matriz tridimensional que almacena el estado del juego. Cada celda puede contener hasta tres valores (representados por la tercera dimensión)
    private final int[][][] gameState = new int[3][3][3]; // [row][col][size]

    // Matriz de paneles del juego, cada uno de los cuales es una instancia de RingPanel
    // panels es una matriz bidimensional que almacena instancias de RingPanel, que representan los paneles individuales del juego
    private final RingPanel[][] panels = new RingPanel[3][3];

    public RingGameFrame() {
        // Configura el título de la ventana
        setTitle("Ring Game");
        // Configura el tamaño de la ventana
        setSize(400, 400);
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Configura el diseño de la ventana como una cuadrícula de 3x3
        setLayout(new GridLayout(3, 3));
        // Inicializa la cuadrícula del juego
        initializeGameGrid();
    }

    // Método para inicializar la cuadrícula del juego
    // Para cada celda de la cuadrícula, crea una nueva instancia de RingPanel, pasando las coordenadas (i, j) y el estado del juego gameState
    private void initializeGameGrid() {
        // Recorre las filas y columnas de la cuadrícula
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Crea un nuevo panel de anillos para cada celda de la cuadrícula
                panels[i][j] = new RingPanel(i, j, gameState);
                // Añade el panel a la ventana
                add(panels[i][j]);
            }
        }
    }

    // Método para reiniciar el juego
    public void resetGame() {
        // Recorre el estado del juego y lo reinicia a 0
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    gameState[i][j][k] = 0;
                }
            }
        }

        // Recorre los paneles y los reinicia
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panels[i][j].resetPanel();
            }
        }
    }
}
