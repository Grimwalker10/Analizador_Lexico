package Código;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class PanelConMarcaAgua extends javax.swing.JPanel {
    // Imagen cargada estáticamente (una sola vez para todas las instancias)
    private static final Image fondoEstatico;

    // Bloque estático para cargar la imagen al iniciar la clase
    static {
        try {
            URL url = PanelConMarcaAgua.class.getResource("/Imagenes/logoMarcaAgua.png");
            if (url == null) {
                throw new RuntimeException("No se encontró la imagen en /Imagenes/logoMarcaAgua.png");
            }
            System.out.println("URL de imagen (carga estática): " + url);
            fondoEstatico = ImageIO.read(url); // Usamos ImageIO (más confiable que ImageIcon)
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la imagen estática", e);
        }
    }

    // Constructor
    public PanelConMarcaAgua() {
        setLayout(new BorderLayout());
        // No necesitamos cargar la imagen aquí, ya está en fondoEstatico
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondoEstatico != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - fondoEstatico.getWidth(null)) / 2;
            int y = (getHeight() - fondoEstatico.getHeight(null)) / 2;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.08f));
            g2d.drawImage(fondoEstatico, x, y, this);
            g2d.dispose();
        }
    }
}
