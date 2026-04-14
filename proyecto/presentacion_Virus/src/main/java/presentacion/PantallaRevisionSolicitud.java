package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaRevisionSolicitud extends JFrame {
    
    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_VERDE = new Color(34, 197, 94);
    private static final Color COLOR_VERDE_SUAVE = new Color(240, 253, 244);
    private static final Color COLOR_AZUL_SUAVE = new Color(239, 246, 255);

    public PantallaRevisionSolicitud(Coordinador coordinador) {
        this.coordinador = coordinador;
        
        setTitle("Revisar Solicitud");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(COLOR_FONDO);
        fondo.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(fondo);

        JPanel principal = new JPanel();
        principal.setOpaque(false);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        principal.add(crearEncabezado());
        principal.add(Box.createVerticalStrut(12));
        principal.add(crearCardInformacionPersonal());
        principal.add(Box.createVerticalStrut(12));
        principal.add(crearCardInformacionFinanciera());
        principal.add(Box.createVerticalStrut(12));
        principal.add(crearCardInformacionVehiculo());
        principal.add(Box.createVerticalStrut(12));
        principal.add(crearCardAviso());
        principal.add(Box.createVerticalStrut(12));
        principal.add(crearPie());

        JScrollPane scroll = new JScrollPane(principal);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        scroll.getHorizontalScrollBar().setUnitIncrement(14);
        scroll.getViewport().setBackground(COLOR_FONDO);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        fondo.add(scroll, BorderLayout.CENTER);
    }

    private JPanel crearEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        izquierda.setOpaque(false);

//        JLabel icono = new JLabel("◉");
//        icono.setOpaque(true);
//        icono.setBackground(COLOR_AZUL);
//        icono.setForeground(Color.WHITE);
//        icono.setHorizontalAlignment(SwingConstants.CENTER);
//        icono.setPreferredSize(new Dimension(20, 20));
//        icono.setFont(new Font("Segoe UI Symbol", Font.BOLD, 10));

        JLabel titulo = new JLabel("Revisar Solicitud");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titulo.setForeground(COLOR_TEXTO);

        JLabel paso = new JLabel("Paso 4 de 4");
        paso.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        paso.setForeground(COLOR_TEXTO_SECUNDARIO);

//        izquierda.add(icono);
        izquierda.add(titulo);

        panel.add(izquierda, BorderLayout.WEST);
        panel.add(paso, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardInformacionPersonal() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información Personal"));
        card.add(Box.createVerticalStrut(18));
        card.add(crearPanelDatos(new String[][]{
                {"Nombre Completo:", "Jesús Valenzuela"},
                {"Edad:", "23"},
                {"CURP:", "VAEJ010315HSRLRSA4"},
                {"RFC:", "VAEJ010315KJ2"},
                {"Estado Civil:", "Soltero"},
                {"Teléfono:", "644 123 4567"},
                {"Correo:", "jesus.valenzuela23@outlook.com"},
                {"Domicilio:", "Calle Náinari 245, Cd. Obregón, Sonora"}
        }));
        card.add(Box.createVerticalStrut(16));
        card.add(crearSeparador());
        card.add(Box.createVerticalStrut(16));
        card.add(crearSubtituloCentrado("Documentos Personales:"));
        card.add(Box.createVerticalStrut(10));
        card.add(crearPanelDocumentos(new String[]{
                "CURP_Jesus_Valenzuela.pdf",
                "RFC_Jesus_Valenzuela.pdf",
                "INE_Jesus_Valenzuela.pdf"
        }));
        return card;
    }

    private JPanel crearCardInformacionFinanciera() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información Financiera"));
        card.add(Box.createVerticalStrut(18));
        card.add(crearPanelDatos(new String[][]{
                {"Tipo de Empleo:", "Dueño de negocio"},
                {"Empresa:", "Valenzuela Servicios Digitales"},
                {"Puesto:", "Director General"},
                {"Antigüedad:", "3 años"},
                {"Tipo de Contrato:", "Actividad empresarial"},
                {"Ingreso Mensual Bruto:", "$48,500 MXN"},
                {"Ingreso Mensual Neto:", "$41,200 MXN"},
                {"Gastos Mensuales:", "$12,800 MXN"}
        }));
        card.add(Box.createVerticalStrut(16));

        JPanel ingresoDisponible = new JPanel(new BorderLayout());
        ingresoDisponible.setBackground(COLOR_VERDE_SUAVE);
        ingresoDisponible.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(187, 247, 208), 1, true),
                new EmptyBorder(12, 12, 12, 12)
        ));
        ingresoDisponible.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        ingresoDisponible.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblIngreso = new JLabel("Ingreso Disponible:");
        lblIngreso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblIngreso.setForeground(new Color(22, 101, 52));

        JLabel valorIngreso = new JLabel("$28,400 MXN");
        valorIngreso.setFont(new Font("Segoe UI", Font.BOLD, 18));
        valorIngreso.setForeground(new Color(22, 163, 74));

        ingresoDisponible.add(lblIngreso, BorderLayout.WEST);
        ingresoDisponible.add(valorIngreso, BorderLayout.EAST);

        card.add(ingresoDisponible);
        card.add(Box.createVerticalStrut(16));
        card.add(crearSeparador());
        card.add(Box.createVerticalStrut(16));
        card.add(crearSubtituloCentrado("Documentos Financieros:"));
        card.add(Box.createVerticalStrut(10));
        card.add(crearPanelDocumentos(new String[]{
                "Estado_Cuenta_BBVA_Marzo.pdf",
                "Constancia_Situacion_Fiscal.pdf"
        }));
        return card;
    }

    private JPanel crearCardInformacionVehiculo() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información del Vehículo"));
        card.add(Box.createVerticalStrut(18));
        card.add(crearPanelDatos(new String[][]{
                {"Vehículo:", "Honda CR-V EX-L 2024"},
                {"Precio del Vehículo:", "$589,000 MXN"},
                {"Enganche:", "$60,000 MXN"},
                {"Monto del Crédito:", "$529,000 MXN"}
        }));
        return card;
    }

    private JPanel crearCardAviso() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(COLOR_AZUL_SUAVE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(147, 197, 253), 1, true),
                new EmptyBorder(14, 14, 14, 14)
        ));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));

        JLabel titulo = new JLabel("Antes de enviar:");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titulo.setForeground(new Color(30, 64, 175));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea area = new JTextArea(
                "• Por favor verifica que toda la información sea correcta.\n" +
                "• Asegúrate de que todos los documentos requeridos hayan sido cargados.\n" +
                "• Tu solicitud será revisada en un plazo de 24 a 48 horas.\n" +
                "• Recibirás notificaciones por correo electrónico y SMS."
        );
        area.setEditable(false);
        area.setOpaque(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        area.setForeground(new Color(59, 130, 246));
        area.setBorder(null);
        area.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(titulo);
        card.add(Box.createVerticalStrut(8));
        card.add(area);

        return card;
    }

    private JPanel crearPie() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnAtras.setFocusPainted(false);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(214, 214, 214), 1, true),
                new EmptyBorder(8, 16, 8, 16)
        ));
        
        btnAtras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                coordinador.mostrarCatalagoVehoculos();
            }
        });

        JButton btnEnviar = new JButton("Enviar Solicitud de Pre-Aprobación");
        btnEnviar.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnEnviar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setBackground(COLOR_VERDE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_VERDE, 1, true),
                new EmptyBorder(8, 16, 8, 16)
        ));
        
        btnEnviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                coordinador.mostrarConfirmacionSolicitud();
            }
        });

        panel.add(btnAtras, BorderLayout.WEST);
        panel.add(btnEnviar, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardBase() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        return card;
    }

    private JPanel crearTituloSeccion(String texto) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24));

        JLabel icono = new JLabel("•");
        icono.setFont(new Font("Segoe UI", Font.BOLD, 12));
        icono.setForeground(COLOR_AZUL);

        JLabel titulo = new JLabel(texto);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titulo.setForeground(COLOR_AZUL);

        panel.add(icono);
        panel.add(titulo);

        return panel;
    }

    private JPanel crearSubtituloCentrado(String texto) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 18));

        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lbl.setForeground(COLOR_TEXTO_SECUNDARIO);

        panel.add(lbl);
        return panel;
    }

    private JPanel crearPanelDatos(String[][] datos) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        for (int i = 0; i < datos.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(crearLabelDato(datos[i][0]), gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(crearValorDato(datos[i][1]), gbc);
        }

        return panel;
    }

    private JPanel crearPanelDocumentos(String[] documentos) {
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        contenedor.setOpaque(false);
        contenedor.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (String doc : documentos) {
            contenedor.add(crearChipDocumento(doc));
        }

        return contenedor;
    }

    private JLabel crearLabelDato(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setForeground(COLOR_TEXTO_SECUNDARIO);
        return label;
    }

    private JLabel crearValorDato(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setForeground(COLOR_TEXTO);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    private JSeparator crearSeparador() {
        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(226, 232, 240));
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        return separador;
    }

    private JComponent crearChipDocumento(String texto) {
        JLabel chip = new JLabel("◉  " + texto);
        chip.setOpaque(true);
        chip.setBackground(new Color(240, 253, 244));
        chip.setForeground(new Color(22, 101, 52));
        chip.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        chip.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(187, 247, 208), 1, true),
                new EmptyBorder(6, 8, 6, 8)
        ));
        return chip;
    }
}