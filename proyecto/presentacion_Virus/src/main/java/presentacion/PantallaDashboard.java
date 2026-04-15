package presentacion;

import controlador.Coordinador;
import dto.SolicitudDTO;
import dto.VehiculoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PantallaDashboard extends JFrame {

    private static final Color BG = new Color(239, 242, 247);
    private static final Color PRIMARY = new Color(37, 99, 235);
    private static final Color TEXT_DARK = new Color(25, 41, 65);
    private static final Color TEXT_MUTED = new Color(95, 112, 136);

    private final Coordinador coordinador;

    public PantallaDashboard(Coordinador coordinador) {
        this.coordinador = coordinador;

        setTitle("Dashboard - Solicitudes de Crédito");
        setSize(1500, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(BG);
        content.setBorder(new EmptyBorder(14, 14, 14, 14));
        setContentPane(content);

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(createHeader());
        mainPanel.add(Box.createVerticalStrut(16));
        mainPanel.add(createCardsSection());
        mainPanel.add(Box.createVerticalStrut(16));
        mainPanel.add(createBottomInfoCard());

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(BG);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        content.add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout(20, 0));
        header.setOpaque(false);
        header.setAlignmentX(LEFT_ALIGNMENT);
        header.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Mis Solicitudes de Crédito");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(TEXT_DARK);

        JLabel subtitle = new JLabel("Gestiona todas tus solicitudes de crédito automotriz");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(TEXT_MUTED);

        left.add(title);
        left.add(Box.createVerticalStrut(4));
        left.add(subtitle);

        JButton btnNueva = new JButton("+   Nueva Solicitud");
        btnNueva.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnNueva.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNueva.setForeground(Color.WHITE);
        btnNueva.setBackground(PRIMARY);
        btnNueva.setFocusPainted(false);
        btnNueva.setOpaque(true);
        btnNueva.setContentAreaFilled(true);
        btnNueva.setBorderPainted(true);
        btnNueva.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(PRIMARY, 1, true),
                new EmptyBorder(12, 18, 12, 18)
        ));
        btnNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNueva.setPreferredSize(new Dimension(190, 46));
        btnNueva.setMaximumSize(new Dimension(190, 46));
        btnNueva.setMinimumSize(new Dimension(190, 46));

        btnNueva.addActionListener(e -> {
            setVisible(false);
            coordinador.mostrarFormularioDatosPersonales();
        });

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        right.setOpaque(false);
        right.add(btnNueva);

        header.add(left, BorderLayout.CENTER);
        header.add(right, BorderLayout.EAST);

        return header;
    }

    private JPanel createCardsSection() {
        List<SolicitudDTO> solicitudes = obtenerSolicitudesSeguras();

        if (solicitudes.isEmpty()) {
            JPanel panelVacio = new JPanel(new BorderLayout());
            panelVacio.setOpaque(false);
            panelVacio.setAlignmentX(LEFT_ALIGNMENT);
            panelVacio.setPreferredSize(new Dimension(1120, 360));
            panelVacio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 360));

            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(220, 220, 220), 1, true),
                    new EmptyBorder(30, 30, 30, 30)
            ));

            JLabel lblVacio = new JLabel("No hay solicitudes registradas.");
            lblVacio.setHorizontalAlignment(SwingConstants.CENTER);
            lblVacio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            lblVacio.setForeground(TEXT_MUTED);

            card.add(lblVacio, BorderLayout.CENTER);
            panelVacio.add(card, BorderLayout.CENTER);

            return panelVacio;
        }

        int columnas = 2;
        int filas = (int) Math.ceil(solicitudes.size() / (double) columnas);

        JPanel cards = new JPanel(new GridLayout(filas, columnas, 14, 14));
        cards.setOpaque(false);
        cards.setAlignmentX(LEFT_ALIGNMENT);
        cards.setMaximumSize(new Dimension(Integer.MAX_VALUE, filas * 205));

        for (SolicitudDTO solicitud : solicitudes) {
            cards.add(createSolicitudCard(solicitud));
        }

        int totalCeldas = filas * columnas;
        int faltantes = totalCeldas - solicitudes.size();
        for (int i = 0; i < faltantes; i++) {
            JPanel empty = new JPanel();
            empty.setOpaque(false);
            cards.add(empty);
        }

        return cards;
    }

    private List<SolicitudDTO> obtenerSolicitudesSeguras() {
        try {
            List<SolicitudDTO> solicitudes = coordinador.obtenerSolicitudes();
            return solicitudes != null ? solicitudes : new ArrayList<>();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible cargar las solicitudes.\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return new ArrayList<>();
        }
    }

    private JPanel createSolicitudCard(SolicitudDTO solicitud) {
        EstadoVisual estadoVisual = resolverEstadoVisual(solicitud);

        String titulo = construirTituloVehiculo(solicitud.getVehiculo());
        String idText = "ID: " + valorSeguro(solicitud.getId());
        String dateText = "Fecha de envío: " + formatearFecha(solicitud.getFechaCreacion());

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(estadoVisual.bgColor);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(estadoVisual.borderColor, 1, true),
                new EmptyBorder(16, 18, 16, 18)
        ));
        card.setPreferredSize(new Dimension(540, 185));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);

        JLabel title = new JLabel(titulo);
        title.setFont(new Font("Segoe UI", Font.BOLD, 14));
        title.setForeground(estadoVisual.accent.darker());

        JLabel status = new JLabel(estadoVisual.statusText);
        status.setOpaque(true);
        status.setBackground(estadoVisual.accent);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Segoe UI", Font.BOLD, 10));
        status.setBorder(new EmptyBorder(4, 9, 4, 9));

        top.add(title, BorderLayout.WEST);
        top.add(status, BorderLayout.EAST);

        JLabel id = new JLabel(idText);
        id.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        id.setForeground(estadoVisual.accent);

        JLabel date = new JLabel(dateText);
        date.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        date.setForeground(estadoVisual.accent.darker());

        JSeparator separator = new JSeparator();
        separator.setForeground(estadoVisual.borderColor.darker());
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));

        card.add(top);
        card.add(Box.createVerticalStrut(8));
        card.add(id);
        card.add(Box.createVerticalStrut(28));
        card.add(date);
        card.add(Box.createVerticalStrut(24));
        card.add(separator);
        card.add(Box.createVerticalStrut(10));

        if (estadoVisual.showProcessingText) {
            JLabel processing = new JLabel("Su solicitud está siendo procesada...");
            processing.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            processing.setForeground(new Color(115, 92, 20));
            card.add(processing);
        } else {
            JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
            actions.setOpaque(false);

            for (String[] buttonData : estadoVisual.buttons) {
                JButton boton = createActionButton(buttonData[0], buttonData[1]);

                // TODO: Reemplaza este JOptionPane por la acción real de cada botón.
                boton.addActionListener(e -> {
                    JOptionPane.showMessageDialog(
                            this,
                            "Acción seleccionada para la solicitud " + valorSeguro(solicitud.getId()) + ": " + buttonData[0]
                    );
                });

                actions.add(boton);
            }
            card.add(actions);
        }

        return card;
    }

    private JButton createActionButton(String text, String style) {
        JButton button = new JButton(text);
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);

        switch (style) {
            case "filled-green" -> {
                button.setBackground(new Color(22, 163, 74));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(22, 163, 74), 1, true),
                        new EmptyBorder(8, 14, 8, 14)
                ));
            }
            case "filled-orange" -> {
                button.setBackground(new Color(249, 115, 22));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(249, 115, 22), 1, true),
                        new EmptyBorder(8, 14, 8, 14)
                ));
            }
            default -> {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(35, 35, 35));
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(212, 212, 212), 1, true),
                        new EmptyBorder(8, 14, 8, 14)
                ));
            }
        }

        return button;
    }

    private JPanel createBottomInfoCard() {
        JPanel panel = new JPanel(new BorderLayout(14, 0));
        panel.setBackground(PRIMARY);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(53, 119, 241), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));
        panel.setAlignmentX(LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));

        JPanel iconPanel = new JPanel(new java.awt.GridBagLayout());
        iconPanel.setPreferredSize(new Dimension(36, 36));
        iconPanel.setBackground(new Color(89, 140, 246));
        iconPanel.setBorder(new LineBorder(new Color(89, 140, 246), 1, true));

        JLabel icon = new JLabel("📄");
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        icon.setForeground(Color.WHITE);
        iconPanel.add(icon);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Centro de Control de Solicitudes");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        JLabel description = new JLabel("<html>Desde este panel puedes gestionar todas tus solicitudes de crédito. "
                + "Edita solicitudes enviadas, cancela solicitudes que ya no necesitas, o sube información adicional "
                + "cuando sea requerida.</html>");
        description.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        description.setForeground(new Color(225, 235, 255));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(description);

        panel.add(iconPanel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }

    private String construirTituloVehiculo(VehiculoDTO vehiculo) {
        if (vehiculo == null) {
            return "Vehículo no disponible";
        }

        String marca = valorSeguro(vehiculo.getMarca());
        String modelo = valorSeguro(vehiculo.getModelo());
        String anio = vehiculo.getAnio() > 0 ? String.valueOf(vehiculo.getAnio()) : "";

        String titulo = (marca + " " + modelo + " " + anio).trim();
        return titulo.isBlank() ? "Vehículo no disponible" : titulo;
    }

    private String formatearFecha(LocalDateTime fecha) {
        if (fecha == null) {
            return "No disponible";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM, yyyy", new Locale("es", "MX"));
        return fecha.format(formatter);
    }

    private String valorSeguro(String texto) {
        return (texto == null || texto.isBlank()) ? "No disponible" : texto;
    }

    private String normalizarEstado(SolicitudDTO solicitud) {
        if (solicitud == null || solicitud.getEstado() == null) {
            return "";
        }

        String estado = solicitud.getEstado().toString().toUpperCase();
        estado = estado.replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U");

        return estado;
    }

    private EstadoVisual resolverEstadoVisual(SolicitudDTO solicitud) {
        String estadoNormalizado = normalizarEstado(solicitud);

        if (estadoNormalizado.contains("ACEPT")) {
            return new EstadoVisual(
                    "Aceptada",
                    new Color(220, 243, 227),
                    new Color(178, 224, 191),
                    new Color(11, 124, 59),
                    false,
                    new String[][]{
                        {"Finalizar Contratación", "filled-green"},
                        {"Cancelar Solicitud", "light"}
                    }
            );
        }

        if (estadoNormalizado.contains("RECHAZ")) {
            return new EstadoVisual(
                    "Rechazada",
                    new Color(248, 225, 225),
                    new Color(238, 181, 181),
                    new Color(220, 38, 38),
                    false,
                    new String[][]{
                        {"Ver Detalles del Rechazo", "light"}
                    }
            );
        }

        if (estadoNormalizado.contains("REVISION") || estadoNormalizado.contains("EN_REVISION")) {
            return new EstadoVisual(
                    "En Revisión",
                    new Color(245, 239, 196),
                    new Color(227, 208, 126),
                    new Color(176, 123, 0),
                    true,
                    new String[][]{}
            );
        }

        if (estadoNormalizado.contains("ENVIADA") || estadoNormalizado.contains("ENVIADO")) {
            return new EstadoVisual(
                    "Enviada",
                    new Color(222, 232, 250),
                    new Color(178, 198, 235),
                    new Color(37, 99, 235),
                    false,
                    new String[][]{
                        {"Editar Solicitud", "light"},
                        {"Cancelar Solicitud", "light"}
                    }
            );
        }

        if (estadoNormalizado.contains("ADICIONAL")
                || estadoNormalizado.contains("PENDIENTE")
                || estadoNormalizado.contains("INFORMACION")) {
            return new EstadoVisual(
                    "Info. Adicional Requerida",
                    new Color(246, 231, 210),
                    new Color(230, 199, 154),
                    new Color(234, 88, 12),
                    false,
                    new String[][]{
                        {"Cargar Información Pendiente", "filled-orange"}
                    }
            );
        }

        return new EstadoVisual(
                valorSeguro(solicitud != null && solicitud.getEstado() != null ? solicitud.getEstado().toString() : "Enviada"),
                new Color(222, 232, 250),
                new Color(178, 198, 235),
                new Color(37, 99, 235),
                false,
                new String[][]{
                    {"Ver Solicitud", "light"}
                }
        );
    }

    private static class EstadoVisual {
        String statusText;
        Color bgColor;
        Color borderColor;
        Color accent;
        boolean showProcessingText;
        String[][] buttons;

        EstadoVisual(String statusText, Color bgColor, Color borderColor, Color accent,
                boolean showProcessingText, String[][] buttons) {
            this.statusText = statusText;
            this.bgColor = bgColor;
            this.borderColor = borderColor;
            this.accent = accent;
            this.showProcessingText = showProcessingText;
            this.buttons = buttons;
        }
    }
}