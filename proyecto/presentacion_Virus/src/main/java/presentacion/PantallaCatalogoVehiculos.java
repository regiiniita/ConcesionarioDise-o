package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCatalogoVehiculos extends JFrame {

    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_AZUL_OSCURO = new Color(20, 42, 92);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_CARD = Color.WHITE;
    private static final Color COLOR_TAG = new Color(241, 245, 249);

    public PantallaCatalogoVehiculos(Coordinador coordinador) {
        this.coordinador = coordinador;
        setTitle("Catálogo de Vehículos");
        setSize(900, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(COLOR_FONDO);
        fondo.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(fondo);

        JPanel centrador = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centrador.setOpaque(false);

        JPanel contenedorCentral = new JPanel();
        contenedorCentral.setOpaque(false);
        contenedorCentral.setLayout(new BoxLayout(contenedorCentral, BoxLayout.Y_AXIS));
        contenedorCentral.setPreferredSize(new Dimension(820, 950));
        contenedorCentral.setMaximumSize(new Dimension(820, 950));

        contenedorCentral.add(crearEncabezado());
        contenedorCentral.add(Box.createVerticalStrut(16));
        contenedorCentral.add(crearBarraInformativa());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearGridVehiculos());
        contenedorCentral.add(Box.createVerticalStrut(16));
        contenedorCentral.add(crearPanelSeleccion());
        contenedorCentral.add(Box.createVerticalStrut(16));
        contenedorCentral.add(crearPie());

        centrador.add(contenedorCentral);

        JScrollPane scrollPane = new JScrollPane(centrador);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getViewport().setBackground(COLOR_FONDO);

        fondo.add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel crearEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(820, 40));
        panel.setMaximumSize(new Dimension(820, 40));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        izquierda.setOpaque(false);

        JLabel titulo = new JLabel("Catálogo de Vehículos");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        titulo.setForeground(COLOR_TEXTO);

        izquierda.add(titulo);

        JLabel paso = new JLabel("Paso 3 de 4");
        paso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        paso.setForeground(new Color(71, 85, 105));

        panel.add(izquierda, BorderLayout.WEST);
        panel.add(paso, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearBarraInformativa() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 249, 255));
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(191, 219, 254), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));
        panel.setPreferredSize(new Dimension(820, 36));
        panel.setMaximumSize(new Dimension(820, 36));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel texto = new JLabel("Seleccione el vehículo que desea adquirir y proporcione el monto de enganche.");
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        texto.setForeground(new Color(30, 64, 175));

        panel.add(texto, BorderLayout.WEST);
        return panel;
    }

    private JPanel crearGridVehiculos() {
        JPanel grid = new JPanel(new GridLayout(2, 4, 12, 12));
        grid.setOpaque(false);
        grid.setPreferredSize(new Dimension(820, 605));
        grid.setMaximumSize(new Dimension(820, 605));
        grid.setAlignmentX(Component.CENTER_ALIGNMENT);

        grid.add(crearCardVehiculo("Honda CR-V", "EX-L", "Motor: 1.5L Turbo",
                new String[]{"AWD", "Apple CarPlay", "Cámara 360°"},
                "$589.000 MXN", true, new Color(224, 232, 255)));

        grid.add(crearCardVehiculo("Nissan Versa", "Advance", "Motor: 1.6L",
                new String[]{"Aire acondicionado", "Bluetooth", "Sensores de reversa"},
                "$289.000 MXN", false, new Color(255, 237, 213)));

        grid.add(crearCardVehiculo("Ford Lobo", "XLT 4x4", "Motor: 3.5L V6 EcoBoost",
                new String[]{"4x4", "Caja de 8 velocidades", "Control de tracción"},
                "$899.000 MXN", false, new Color(219, 234, 254)));

        grid.add(crearCardVehiculo("Mazda 3", "i Grand Touring", "Motor: 2.5L Skyactiv",
                new String[]{"Skyactiv", "Head-up display", "Sound Bose"},
                "$459.000 MXN", false, new Color(254, 226, 226)));

        grid.add(crearCardVehiculo("Toyota Corolla", "XLE", "Motor: 2.0L",
                new String[]{"Toyota Safety Sense", "Sunroof", "Asientos de piel"},
                "$429.000 MXN", false, new Color(229, 231, 235)));

        grid.add(crearCardVehiculo("Chevrolet Silverado", "LT Z71", "Motor: 5.3L V8",
                new String[]{"Suspensión Z71", "MyLink", "Cámara HD"},
                "$979.000 MXN", false, new Color(224, 242, 254)));

        grid.add(crearCardVehiculo("Volkswagen Jetta", "R-Line", "Motor: 1.4L TSI",
                new String[]{"Turbo", "Navegación", "Luces LED"},
                "$449.000 MXN", false, new Color(236, 253, 245)));

        grid.add(crearCardVehiculo("Hyundai Tucson", "Limited", "Motor: 2.5L",
                new String[]{"SmartSense", "Techo panorámico", "Carga inalámbrica"},
                "$569.000 MXN", false, new Color(240, 249, 255)));

        return grid;
    }

    private JPanel crearCardVehiculo(String nombre, String version, String detalle,
            String[] tags, String precio, boolean seleccionada, Color colorImagen) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(COLOR_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(seleccionada ? COLOR_AZUL : COLOR_BORDE, seleccionada ? 2 : 1, true),
                new EmptyBorder(0, 0, 0, 0)
        ));

        JPanel contenedorImagen = new JPanel();
        contenedorImagen.setLayout(new OverlayLayout(contenedorImagen));
        contenedorImagen.setOpaque(false);
        contenedorImagen.setPreferredSize(new Dimension(200, 128));
        contenedorImagen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 128));
        contenedorImagen.setMinimumSize(new Dimension(200, 128));

        JPanel imagen = new JPanel(new BorderLayout());
        imagen.setBackground(colorImagen);
        imagen.setPreferredSize(new Dimension(200, 128));
        imagen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 128));
        imagen.setMinimumSize(new Dimension(200, 128));

        JLabel year = new JLabel("2024");
        year.setOpaque(true);
        year.setBackground(new Color(15, 23, 42));
        year.setForeground(Color.WHITE);
        year.setFont(new Font("Segoe UI", Font.BOLD, 10));
        year.setBorder(new EmptyBorder(3, 7, 3, 7));

        JPanel topYear = new JPanel(new BorderLayout());
        topYear.setOpaque(false);
        topYear.setBorder(new EmptyBorder(10, 8, 0, 8));
        topYear.add(year, BorderLayout.WEST);

        imagen.add(topYear, BorderLayout.NORTH);

        contenedorImagen.add(imagen);

        if (seleccionada) {
            JLabel check = new JLabel("✓");
            check.setOpaque(true);
            check.setBackground(COLOR_AZUL);
            check.setForeground(Color.WHITE);
            check.setHorizontalAlignment(SwingConstants.CENTER);
            check.setPreferredSize(new Dimension(24, 24));
            check.setMaximumSize(new Dimension(24, 24));
            check.setMinimumSize(new Dimension(24, 24));
            check.setFont(new Font("Segoe UI", Font.BOLD, 13));

            JPanel panelCheck = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
            panelCheck.setOpaque(false);
            panelCheck.add(check);
            panelCheck.setAlignmentX(0.5f);
            panelCheck.setAlignmentY(0.5f);

            contenedorImagen.add(panelCheck);
        }

        JPanel contenido = new JPanel(new GridBagLayout());
        contenido.setOpaque(false);
        contenido.setBorder(new EmptyBorder(12, 12, 12, 12));

        GridBagConstraints gbcContenido = new GridBagConstraints();
        gbcContenido.gridx = 0;
        gbcContenido.weightx = 1.0;
        gbcContenido.anchor = GridBagConstraints.WEST;
        gbcContenido.fill = GridBagConstraints.HORIZONTAL;
        gbcContenido.insets = new Insets(0, 0, 0, 0);

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNombre.setForeground(COLOR_TEXTO);

        JLabel lblVersion = new JLabel(version);
        lblVersion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblVersion.setForeground(COLOR_TEXTO_SECUNDARIO);

        JLabel lblDetalle = new JLabel(detalle);
        lblDetalle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDetalle.setForeground(new Color(51, 65, 85));

        JPanel panelTags = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        panelTags.setOpaque(false);
        for (String tag : tags) {
            panelTags.add(crearTag(tag));
        }

        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(226, 232, 240));

        JLabel lblPrecio = new JLabel(precio);
        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPrecio.setForeground(COLOR_AZUL);

        gbcContenido.gridy = 0;
        contenido.add(lblNombre, gbcContenido);

        gbcContenido.gridy = 1;
        gbcContenido.insets = new Insets(2, 0, 0, 0);
        contenido.add(lblVersion, gbcContenido);

        gbcContenido.gridy = 2;
        gbcContenido.insets = new Insets(10, 0, 0, 0);
        contenido.add(lblDetalle, gbcContenido);

        gbcContenido.gridy = 3;
        gbcContenido.insets = new Insets(10, 0, 0, 0);
        contenido.add(panelTags, gbcContenido);

        gbcContenido.gridy = 4;
        gbcContenido.insets = new Insets(10, 0, 0, 0);
        contenido.add(separador, gbcContenido);

        gbcContenido.gridy = 5;
        gbcContenido.insets = new Insets(10, 0, 0, 0);
        contenido.add(lblPrecio, gbcContenido);

        card.add(contenedorImagen);
        card.add(contenido);

        return card;
    }

    private Component crearTag(String texto) {
        JLabel tag = new JLabel(texto);
        tag.setOpaque(true);
        tag.setBackground(COLOR_TAG);
        tag.setForeground(new Color(30, 41, 59));
        tag.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        tag.setBorder(new EmptyBorder(3, 6, 3, 6));
        return tag;
    }

    private JPanel crearPanelSeleccion() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(820, 135));
        panel.setMaximumSize(new Dimension(820, 135));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titulo = new JLabel("Vehículo Seleccionado: Honda CR-V EX-L");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titulo.setForeground(COLOR_TEXTO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(18));

        JPanel fila = new JPanel(new GridLayout(1, 2, 18, 0));
        fila.setOpaque(false);
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        fila.setPreferredSize(new Dimension(788, 58));
        fila.setMaximumSize(new Dimension(788, 58));

        JPanel panelPrecio = new JPanel();
        panelPrecio.setOpaque(false);
        panelPrecio.setLayout(new BoxLayout(panelPrecio, BoxLayout.Y_AXIS));

        JLabel lblPrecio = new JLabel("Precio del Vehículo");
        lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblPrecio.setForeground(new Color(51, 65, 85));

        JLabel precio = new JLabel("$589.000 MXN");
        precio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        precio.setForeground(COLOR_TEXTO);

        panelPrecio.add(lblPrecio);
        panelPrecio.add(Box.createVerticalStrut(10));
        panelPrecio.add(precio);

        JPanel panelEnganche = new JPanel();
        panelEnganche.setOpaque(false);
        panelEnganche.setLayout(new BoxLayout(panelEnganche, BoxLayout.Y_AXIS));

        JLabel lblEnganche = new JLabel("Enganche (MXN) *");
        lblEnganche.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEnganche.setForeground(new Color(51, 65, 85));

        JTextField txtEnganche = new JTextField("Mínimo 58.900");
        txtEnganche.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtEnganche.setForeground(COLOR_TEXTO_SECUNDARIO);
        txtEnganche.setBackground(Color.WHITE);
        txtEnganche.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(203, 213, 225), 1, true),
                new EmptyBorder(8, 10, 8, 10)
        ));
        txtEnganche.setPreferredSize(new Dimension(360, 34));
        txtEnganche.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        panelEnganche.add(lblEnganche);
        panelEnganche.add(Box.createVerticalStrut(6));
        panelEnganche.add(txtEnganche);

        fila.add(panelPrecio);
        fila.add(panelEnganche);

        panel.add(fila);

        return panel;
    }

    private JPanel crearPie() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(820, 50));
        panel.setMaximumSize(new Dimension(820, 50));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnAtras.setForeground(new Color(51, 65, 85));
        btnAtras.setBackground(new Color(250, 250, 250));
        btnAtras.setFocusPainted(false);
        btnAtras.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(214, 214, 214), 1, true),
                new EmptyBorder(6, 16, 6, 16)
        ));

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                coordinador.mostrarFormularioInformacionFinanciera();
            }
        });

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnContinuar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setBackground(COLOR_AZUL);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_AZUL, 1, true),
                new EmptyBorder(8, 16, 8, 16)
        ));

        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                coordinador.mostrarRevisionSolicitud();
            }
        });

        panel.add(btnAtras, BorderLayout.WEST);
        panel.add(btnContinuar, BorderLayout.EAST);

        return panel;
    }
}