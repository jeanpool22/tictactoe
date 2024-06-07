import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

// Clase que extiende JButton para crear un botón circular personalizado
public class CircularButton extends JButton {
    // Variables para almacenar el color de fondo, el color del borde y el grosor del borde
    private Color backgroundColor;
    private Color borderColor;
    private int borderThickness;

    public CircularButton() {
        // Configura el botón para que no pinte el área de contenido, el foco ni el borde
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        // Inicializa los colores de fondo y borde con los colores predeterminados del botón
        this.backgroundColor = getBackground();
        this.borderColor = getForeground();

        // Establece el grosor del borde
        this.borderThickness = 3;
    }

    // Método para pintar el componente
    @Override
    protected void paintComponent(Graphics g) {
        // Crea una copia del contexto gráfico
        Graphics2D g2 = (Graphics2D) g.create();

        // Activa el antialiasing para suavizar los bordes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Pinta el fondo del botón como un círculo
        g2.setColor(backgroundColor);
        g2.fill(new Ellipse2D.Float(0, 0, getWidth(), getHeight()));

        // Pinta el borde del botón como un círculo
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.draw(new Ellipse2D.Float(borderThickness / 2, borderThickness / 2, getWidth() - borderThickness, getHeight() - borderThickness));

        // Libera los recursos gráficos
        g2.dispose();

        // Llama al método de la superclase para pintar el contenido del botón
        super.paintComponent(g);
    }

    // Método para establecer el color del borde
    public void setBorderColor(Color color) {
        this.borderColor = color;

        // Vuelve a pintar el botón para reflejar el cambio
        repaint();
    }

    // Método para establecer el grosor del borde
    public void setBorderThickness(int thickness) {
        this.borderThickness = thickness;

        // Vuelve a pintar el botón para reflejar el cambio
        repaint();
    }
}
