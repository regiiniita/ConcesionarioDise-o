package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDashboard extends JFrame {

    private static final Color BG = new Color(239, 242, 247);
    private static final Color PRIMARY = new Color(37, 99, 235);
    private static final Color TEXT_DARK = new Color(25, 41, 65);
    private static final Color TEXT_MUTED = new Color(95, 112, 136);
    
    private final Coordinador coordinador;

    public PantallaDashboard(Coordinador coordinador) {
        this.coordinador = coordinador;
        
        setTitle("Dashboard - Solicitudes de Crédito");
        setSize(1000, 910);
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

        content.add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

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
        btnNueva.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnNueva.setForeground(Color.WHITE);
        btnNueva.setBackground(PRIMARY);
        btnNueva.setFocusPainted(false);
        btnNueva.setBorder(new EmptyBorder(10, 16, 10, 16));
        btnNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnNueva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                coordinador.mostrarFormularioDatosPersonales();
            }
        });
        

        header.add(left, BorderLayout.WEST);
        header.add(btnNueva, BorderLayout.EAST);

        return header;
    }

    private JPanel createCardsSection() {
        JPanel cards = new JPanel(new GridLayout(3, 2, 14, 14));
        cards.setOpaque(false);

        cards.add(createSolicitudCard(
                "Honda CR-V EX-L 2024",
                "ID: CR-A1B2C3D",
                "Aceptada",
                new Color(220, 243, 227),
                new Color(178, 224, 191),
                new Color(11, 124, 59),
                "Fecha de envío: 15 de enero, 2026",
                false,
                new String[][] {
                        {"Finalizar Contratación", "filled-green"},
                        {"Cancelar Solicitud", "light"}
                }
        ));

        cards.add(createSolicitudCard(
                "Nissan Versa Advance 2024",
                "ID: CR-E4F5G6H",
                "Rechazada",
                new Color(248, 225, 225),
                new Color(238, 181, 181),
                new Color(220, 38, 38),
                "Fecha de envío: 20 de enero, 2026",
                false,
                new String[][] {
                        {"Ver Detalles del Rechazo", "light"}
                }
        ));

        cards.add(createSolicitudCard(
                "Ford Lobo XLT 4x4 2024",
                "ID: CR-I7J8K9L",
                "En Revisión",
                new Color(245, 239, 196),
                new Color(227, 208, 126),
                new Color(176, 123, 0),
                "Fecha de envío: 28 de enero, 2026",
                true,
                new String[][] {}
        ));

        cards.add(createSolicitudCard(
                "Mazda 3 i Grand Touring 2024",
                "ID: CR-M1N2O3P",
                "Enviada",
                new Color(222, 232, 250),
                new Color(178, 198, 235),
                new Color(37, 99, 235),
                "Fecha de envío: 1 de febrero, 2026",
                false,
                new String[][] {
                        {"Editar Solicitud", "light"},
                        {"Cancelar Solicitud", "light"}
                }
        ));

        cards.add(createSolicitudCard(
                "Toyota Corolla XLE 2024",
                "ID: CR-Q4R5S6T",
                "Info. Adicional Requerida",
                new Color(246, 231, 210),
                new Color(230, 199, 154),
                new Color(234, 88, 12),
                "Fecha de envío: 3 de febrero, 2026",
                false,
                new String[][] {
                        {"Cargar Información Pendiente", "filled-orange"}
                }
        ));

        JPanel empty = new JPanel();
        empty.setOpaque(false);
        cards.add(empty);

        return cards;
    }

    private JPanel createSolicitudCard(String titleText,
                                       String idText,
                                       String statusText,
                                       Color bgColor,
                                       Color borderColor,
                                       Color accent,
                                       String dateText,
                                       boolean showProcessingText,
                                       String[][] buttons) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(bgColor);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                new EmptyBorder(16, 18, 16, 18)
        ));
        card.setPreferredSize(new Dimension(430, 185));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);

        JLabel title = new JLabel(titleText);
        title.setFont(new Font("Segoe UI", Font.BOLD, 14));
        title.setForeground(accent.darker());

        JLabel status = new JLabel(statusText);
        status.setOpaque(true);
        status.setBackground(accent);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Segoe UI", Font.BOLD, 10));
        status.setBorder(new EmptyBorder(4, 9, 4, 9));

        top.add(title, BorderLayout.WEST);
        top.add(status, BorderLayout.EAST);

        JLabel id = new JLabel(idText);
        id.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        id.setForeground(accent);

        JLabel date = new JLabel(dateText);
        date.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        date.setForeground(accent.darker());

        JSeparator separator = new JSeparator();
        separator.setForeground(borderColor.darker());
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));

        card.add(top);
        card.add(Box.createVerticalStrut(8));
        card.add(id);
        card.add(Box.createVerticalStrut(28));
        card.add(date);
        card.add(Box.createVerticalStrut(24));
        card.add(separator);
        card.add(Box.createVerticalStrut(10));

        if (showProcessingText) {
            JLabel processing = new JLabel("Su solicitud está siendo procesada...");
            processing.setFont(new Font("Segoe UI", Font.ITALIC, 13));
            processing.setForeground(new Color(115, 92, 20));
            card.add(processing);
        } else {
            JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
            actions.setOpaque(false);

            for (String[] buttonData : buttons) {
                actions.add(createActionButton(buttonData[0], buttonData[1]));
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

        JPanel iconPanel = new JPanel(new GridBagLayout());
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
}