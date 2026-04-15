package presentacion;

import controlador.Coordinador;
import dto.SolicitudDTO;
import dto.VehiculoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PantallaCatalogoVehiculos extends JFrame {

    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_CARD = Color.WHITE;
    private static final Color COLOR_TAG = new Color(241, 245, 249);

    private final NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));

    private List<VehiculoDTO> vehiculosDisponibles;
    private VehiculoDTO vehiculoSeleccionado;

    private JPanel panelGridVehiculos;
    private JLabel lblVehiculoSeleccionado;
    private JLabel lblPrecioSeleccionado;
    private JTextField txtEnganche;

    private JPanel tarjetaSeleccionadaActual;

    public PantallaCatalogoVehiculos(Coordinador coordinador) {
        this.coordinador = coordinador;
        this.vehiculosDisponibles = new ArrayList<>();

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

        panelGridVehiculos = new JPanel();
        panelGridVehiculos.setOpaque(false);
        panelGridVehiculos.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedorCentral.add(panelGridVehiculos);

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

        cargarVehiculos();
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

        lblVehiculoSeleccionado = new JLabel("Vehículo Seleccionado: Ninguno");
        lblVehiculoSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblVehiculoSeleccionado.setForeground(COLOR_TEXTO);
        lblVehiculoSeleccionado.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lblVehiculoSeleccionado);
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

        lblPrecioSeleccionado = new JLabel("$0.00 MXN");
        lblPrecioSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPrecioSeleccionado.setForeground(COLOR_TEXTO);

        panelPrecio.add(lblPrecio);
        panelPrecio.add(Box.createVerticalStrut(10));
        panelPrecio.add(lblPrecioSeleccionado);

        JPanel panelEnganche = new JPanel();
        panelEnganche.setOpaque(false);
        panelEnganche.setLayout(new BoxLayout(panelEnganche, BoxLayout.Y_AXIS));

        JLabel lblEnganche = new JLabel("Enganche (MXN) *");
        lblEnganche.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEnganche.setForeground(new Color(51, 65, 85));

        txtEnganche = new JTextField();
        txtEnganche.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtEnganche.setForeground(COLOR_TEXTO_SECUNDARIO);
        txtEnganche.setBackground(Color.WHITE);
        txtEnganche.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(203, 213, 225), 1, true),
                new EmptyBorder(8, 10, 8, 10)
        ));
        txtEnganche.setPreferredSize(new Dimension(360, 34));
        txtEnganche.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
        txtEnganche.setText("");

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

        btnAtras.addActionListener((ActionEvent e) -> {
            setVisible(false);
            coordinador.mostrarFormularioInformacionFinanciera();
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

        btnContinuar.addActionListener((ActionEvent e) -> {
            if (vehiculoSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo antes de continuar.");
                return;
            }

            if (txtEnganche.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el monto del enganche.");
                return;
            }
            
            SolicitudDTO soli = coordinador.obtenerSolicitud();
            soli.setEnganche(Double.parseDouble(txtEnganche.getText().trim()));
            coordinador.setSolicitud(soli);

            coordinador.asignarVehiculoSeleccionado(vehiculoSeleccionado);

            setVisible(false);
            coordinador.mostrarRevisionSolicitud();
        });

        panel.add(btnAtras, BorderLayout.WEST);
        panel.add(btnContinuar, BorderLayout.EAST);

        return panel;
    }

    private void cargarVehiculos() {
        try {
            List<VehiculoDTO> lista = coordinador.obtenerVehiculosDisponibles();

            if (lista != null) {
                vehiculosDisponibles = lista;
            } else {
                vehiculosDisponibles = new ArrayList<>();
            }

            reconstruirGridVehiculos();

        } catch (Exception ex) {
            vehiculosDisponibles = new ArrayList<>();
            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible cargar los vehículos disponibles.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            reconstruirGridVehiculos();
        }
    }

    private void reconstruirGridVehiculos() {
        panelGridVehiculos.removeAll();

        int total = vehiculosDisponibles.size();
        int columnas = 4;
        int filas = (int) Math.ceil(total / (double) columnas);
        filas = Math.max(filas, 1);

        panelGridVehiculos.setLayout(new GridLayout(filas, columnas, 12, 12));
        panelGridVehiculos.setPreferredSize(new Dimension(820, filas * 230 + ((filas - 1) * 12)));
        panelGridVehiculos.setMaximumSize(new Dimension(820, filas * 230 + ((filas - 1) * 12)));

        if (vehiculosDisponibles.isEmpty()) {
            JPanel vacio = new JPanel(new BorderLayout());
            vacio.setBackground(Color.WHITE);
            vacio.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(COLOR_BORDE, 1, true),
                    new EmptyBorder(20, 20, 20, 20)
            ));

            JLabel lbl = new JLabel("No hay vehículos disponibles por el momento.");
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            lbl.setForeground(COLOR_TEXTO_SECUNDARIO);

            vacio.add(lbl, BorderLayout.CENTER);
            panelGridVehiculos.setLayout(new BorderLayout());
            panelGridVehiculos.add(vacio, BorderLayout.CENTER);
        } else {
            for (VehiculoDTO vehiculo : vehiculosDisponibles) {
                panelGridVehiculos.add(crearCardVehiculo(vehiculo));
            }

            int celdasTotales = filas * columnas;
            int faltantes = celdasTotales - total;

            for (int i = 0; i < faltantes; i++) {
                JPanel empty = new JPanel();
                empty.setOpaque(false);
                panelGridVehiculos.add(empty);
            }

            if (!vehiculosDisponibles.isEmpty() && vehiculoSeleccionado == null) {
                seleccionarVehiculo(vehiculosDisponibles.get(0), (JPanel) panelGridVehiculos.getComponent(0));
            }
        }

        panelGridVehiculos.revalidate();
        panelGridVehiculos.repaint();
    }

    private JPanel crearCardVehiculo(VehiculoDTO vehiculo) {
        boolean seleccionada = vehiculoSeleccionado != null
                && vehiculoSeleccionado.getSerie().equals(vehiculo.getSerie());

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(COLOR_CARD);
        aplicarEstiloSeleccion(card, seleccionada);

        JPanel contenedorImagen = new JPanel();
        contenedorImagen.setLayout(new OverlayLayout(contenedorImagen));
        contenedorImagen.setOpaque(false);
        contenedorImagen.setPreferredSize(new Dimension(200, 128));
        contenedorImagen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 128));
        contenedorImagen.setMinimumSize(new Dimension(200, 128));

        JPanel imagen = new JPanel(new BorderLayout());
        imagen.setBackground(obtenerColorTarjeta(vehiculo));
        imagen.setPreferredSize(new Dimension(200, 128));
        imagen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 128));
        imagen.setMinimumSize(new Dimension(200, 128));

        JLabel year = new JLabel(String.valueOf(vehiculo.getAnio()));
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

        JPanel contenido = new JPanel(new GridLayout(0, 1, 0, 4));
        contenido.setOpaque(false);
        contenido.setBorder(new EmptyBorder(12, 12, 12, 12));

        JLabel lblNombre = new JLabel(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getAnio());
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNombre.setForeground(COLOR_TEXTO);

        JLabel lblSerie = new JLabel("Serie: " + vehiculo.getSerie());
        lblSerie.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblSerie.setForeground(COLOR_TEXTO_SECUNDARIO);

        JLabel lblEstado = new JLabel("Estado: " + vehiculo.getEstado());
        lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEstado.setForeground(new Color(51, 65, 85));

        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(226, 232, 240));

        JLabel lblPrecio = new JLabel(formatearMoneda(vehiculo.getPrecio()));
        lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPrecio.setForeground(COLOR_AZUL);

        contenido.add(lblNombre);
        contenido.add(lblSerie);
        contenido.add(lblEstado);
        contenido.add(separador);
        contenido.add(lblPrecio);

        card.add(contenedorImagen);
        card.add(contenido);

        agregarEventoSeleccion(card, vehiculo, card);

        return card;
    }

    private void agregarEventoSeleccion(Component componente, VehiculoDTO vehiculo, JPanel tarjetaRaiz) {
        componente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarVehiculo(vehiculo, tarjetaRaiz);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                componente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        if (componente instanceof Container) {
            for (Component hijo : ((Container) componente).getComponents()) {
                agregarEventoSeleccion(hijo, vehiculo, tarjetaRaiz);
            }
        }
    }

    private void seleccionarVehiculo(VehiculoDTO vehiculo, JPanel tarjetaSeleccionada) {
        vehiculoSeleccionado = vehiculo;

        if (tarjetaSeleccionadaActual != null) {
            aplicarEstiloSeleccion(tarjetaSeleccionadaActual, false);
            tarjetaSeleccionadaActual.repaint();
        }

        tarjetaSeleccionadaActual = tarjetaSeleccionada;
        aplicarEstiloSeleccion(tarjetaSeleccionadaActual, true);
        tarjetaSeleccionadaActual.repaint();

        lblVehiculoSeleccionado.setText(
                "Vehículo Seleccionado: "
                + vehiculo.getMarca() + " "
                + vehiculo.getModelo() + " "
                + vehiculo.getAnio()
        );

        lblPrecioSeleccionado.setText(formatearMoneda(vehiculo.getPrecio()));

        double minimoEnganche = vehiculo.getPrecio() * 0.10;
        txtEnganche.setText(String.format(Locale.US, "%.2f", minimoEnganche));
    }

    private void aplicarEstiloSeleccion(JPanel card, boolean seleccionada) {
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(seleccionada ? COLOR_AZUL : COLOR_BORDE, seleccionada ? 2 : 1, true),
                new EmptyBorder(0, 0, 0, 0)
        ));
    }

    private Color obtenerColorTarjeta(VehiculoDTO vehiculo) {
        int hash = Math.abs((vehiculo.getMarca() + vehiculo.getModelo()).hashCode());
        Color[] colores = new Color[]{
            new Color(224, 232, 255),
            new Color(255, 237, 213),
            new Color(219, 234, 254),
            new Color(254, 226, 226),
            new Color(229, 231, 235),
            new Color(224, 242, 254),
            new Color(236, 253, 245),
            new Color(240, 249, 255)
        };
        return colores[hash % colores.length];
    }

    private String formatearMoneda(double precio) {
        return formatoMoneda.format(precio);
    }

    public VehiculoDTO getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public String getMontoEngancheCapturado() {
        return txtEnganche.getText().trim();
    }
}