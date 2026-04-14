package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaFormularioInformacionFinanciera extends JFrame {
    
    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_INPUT = new Color(244, 244, 246);
    private static final Color COLOR_SUBIDA = new Color(148, 163, 184);

    public PantallaFormularioInformacionFinanciera(Coordinador coordinador) {
        this.coordinador = coordinador;
        
        setTitle("Información Financiera");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(COLOR_FONDO);
        fondo.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(fondo);

        JPanel contenedorCentral = new JPanel();
        contenedorCentral.setOpaque(false);
        contenedorCentral.setLayout(new BoxLayout(contenedorCentral, BoxLayout.Y_AXIS));
        contenedorCentral.setPreferredSize(new Dimension(690, 800));

        contenedorCentral.add(crearEncabezado());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearCardInformacionLaboral());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearCardIngresosGastos());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearCardDocumentosFinancieros());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearPie());

        fondo.add(contenedorCentral);
    }

    private JPanel crearEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(690, 40));
        panel.setMaximumSize(new Dimension(690, 40));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        izquierda.setOpaque(false);

//        JLabel icono = new JLabel("◉");
//        icono.setOpaque(true);
//        icono.setBackground(COLOR_AZUL);
//        icono.setForeground(Color.WHITE);
//        icono.setHorizontalAlignment(SwingConstants.CENTER);
//        icono.setPreferredSize(new Dimension(26, 26));
//        icono.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));

        JLabel titulo = new JLabel("Información Financiera");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        titulo.setForeground(COLOR_TEXTO);

//        izquierda.add(icono);
        izquierda.add(titulo);

        JLabel paso = new JLabel("Paso 2 de 4");
        paso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        paso.setForeground(new Color(71, 85, 105));

        panel.add(izquierda, BorderLayout.WEST);
        panel.add(paso, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardInformacionLaboral() {
        JPanel card = crearCardBase(690, 255);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel seccion = new JLabel("Información Laboral");
        seccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        seccion.setForeground(COLOR_AZUL);
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(seccion);
        card.add(Box.createVerticalStrut(18));

        JPanel grid = new JPanel(new GridBagLayout());
        grid.setOpaque(false);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setPreferredSize(new Dimension(654, 180));
        grid.setMaximumSize(new Dimension(654, 180));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 12, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        grid.add(crearComboCampo("Tipo de Empleo *", "Seleccionar tipo",
                new String[]{"Seleccionar tipo", "Empleado", "Independiente", "Empresario", "Jubilado"}), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearCampo("Nombre de Empresa / Actividad Económica *", "Corporación ABC"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 14);
        grid.add(crearCampo("Puesto / Actividad Principal *", "Gerente de Ventas"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearComboCampo("Antigüedad Laboral *", "Seleccionar antigüedad",
                new String[]{"Seleccionar antigüedad", "Menos de 1 año", "1 a 3 años", "3 a 5 años", "Más de 5 años"}), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        grid.add(crearComboCampoAncho("Tipo de Contrato *", "Seleccionar tipo de contrato",
                new String[]{"Seleccionar tipo de contrato", "Tiempo completo", "Medio tiempo", "Temporal", "Por honorarios", "Indefinido"}), gbc);

        card.add(grid);
        return card;
    }

    private JPanel crearCardIngresosGastos() {
        JPanel card = crearCardBase(690, 185);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel seccion = new JLabel("Ingresos y Gastos");
        seccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        seccion.setForeground(COLOR_AZUL);
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(seccion);
        card.add(Box.createVerticalStrut(18));

        JPanel grid = new JPanel(new GridBagLayout());
        grid.setOpaque(false);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setPreferredSize(new Dimension(654, 115));
        grid.setMaximumSize(new Dimension(654, 115));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 12, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        grid.add(crearCampo("Ingreso Mensual Bruto (MXN) *", "25000"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearCampo("Ingreso Mensual Neto (MXN) *", "20000"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        grid.add(crearCampoDomicilio("Gastos Mensuales (MXN) *", "8000"), gbc);

        card.add(grid);
        return card;
    }

    private JPanel crearCardDocumentosFinancieros() {
        JPanel card = crearCardBase(690, 195);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel seccion = new JLabel("Documentos Financieros");
        seccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        seccion.setForeground(COLOR_AZUL);
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(seccion);
        card.add(Box.createVerticalStrut(18));

        JPanel contenedor = new JPanel(new GridLayout(1, 2, 12, 0));
        contenedor.setOpaque(false);
        contenedor.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenedor.setPreferredSize(new Dimension(654, 105));
        contenedor.setMaximumSize(new Dimension(654, 105));

        contenedor.add(crearCajaDocumento("Comprobante de Ingresos *", "Recibos de nómina, estados de cuenta o facturas"));
        contenedor.add(crearCajaDocumento("Comprobante de Empleo *", "Carta laboral o registro de negocio"));

        card.add(contenedor);
        return card;
    }

    private JPanel crearPie() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(690, 42));
        panel.setMaximumSize(new Dimension(690, 42));
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
        
        btnAtras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                coordinador.mostrarFormularioDatosPersonales();
            }
        });

        JButton btnContinuar = new JButton("Continuar a Información del Vehículo");
        btnContinuar.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnContinuar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setBackground(COLOR_AZUL);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_AZUL, 1, true),
                new EmptyBorder(8, 16, 8, 16)
        ));
        
        btnContinuar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                coordinador.mostrarCatalagoVehoculos();
            }
        });

        panel.add(btnAtras, BorderLayout.WEST);
        panel.add(btnContinuar, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardBase(int ancho, int alto) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(18, 18, 18, 18)
        ));
        card.setPreferredSize(new Dimension(ancho, alto));
        card.setMinimumSize(new Dimension(ancho, alto));
        card.setMaximumSize(new Dimension(ancho, alto));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        return card;
    }

    private JPanel crearCampo(String labelText, String placeholder) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(320, 58));
        panel.setMinimumSize(new Dimension(320, 58));
        panel.setMaximumSize(new Dimension(320, 58));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField campo = new JTextField(placeholder);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campo.setForeground(COLOR_TEXTO_SECUNDARIO);
        campo.setBackground(COLOR_INPUT);
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_INPUT, 1, true),
                new EmptyBorder(7, 10, 7, 10)
        ));
        campo.setPreferredSize(new Dimension(320, 30));
        campo.setMinimumSize(new Dimension(320, 30));
        campo.setMaximumSize(new Dimension(320, 30));
        campo.setCaretColor(COLOR_TEXTO);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(4));
        panel.add(campo);

        return panel;
    }

    private JPanel crearCampoDomicilio(String labelText, String placeholder) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(654, 58));
        panel.setMinimumSize(new Dimension(654, 58));
        panel.setMaximumSize(new Dimension(654, 58));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField campo = new JTextField(placeholder);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campo.setForeground(COLOR_TEXTO_SECUNDARIO);
        campo.setBackground(COLOR_INPUT);
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_INPUT, 1, true),
                new EmptyBorder(7, 10, 7, 10)
        ));
        campo.setPreferredSize(new Dimension(654, 30));
        campo.setMinimumSize(new Dimension(654, 30));
        campo.setMaximumSize(new Dimension(654, 30));
        campo.setCaretColor(COLOR_TEXTO);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(4));
        panel.add(campo);

        return panel;
    }

    private JPanel crearComboCampo(String labelText, String primerItem, String[] opciones) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(320, 58));
        panel.setMinimumSize(new Dimension(320, 58));
        panel.setMaximumSize(new Dimension(320, 58));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setSelectedItem(primerItem);
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        combo.setForeground(COLOR_TEXTO_SECUNDARIO);
        combo.setBackground(COLOR_INPUT);
        combo.setPreferredSize(new Dimension(320, 30));
        combo.setMinimumSize(new Dimension(320, 30));
        combo.setMaximumSize(new Dimension(320, 30));
        combo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(4));
        panel.add(combo);

        return panel;
    }

    private JPanel crearComboCampoAncho(String labelText, String primerItem, String[] opciones) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(654, 62));
        panel.setMinimumSize(new Dimension(654, 62));
        panel.setMaximumSize(new Dimension(654, 62));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setSelectedItem(primerItem);
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        combo.setForeground(COLOR_TEXTO_SECUNDARIO);
        combo.setBackground(COLOR_INPUT);
        combo.setPreferredSize(new Dimension(654, 30));
        combo.setMinimumSize(new Dimension(654, 30));
        combo.setMaximumSize(new Dimension(654, 30));
        combo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(4));
        panel.add(combo);

        return panel;
    }

    private JPanel crearCajaDocumento(String titulo, String subtitulo) {
        JPanel caja = new JPanel();
        caja.setOpaque(false);
        caja.setLayout(new BoxLayout(caja, BoxLayout.Y_AXIS));
        caja.setBorder(BorderFactory.createDashedBorder(new Color(203, 213, 225), 4, 4, 2, true));
        caja.setPreferredSize(new Dimension(320, 100));

        JLabel icono = new JLabel("⇪");
        icono.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
        icono.setForeground(COLOR_SUBIDA);
        icono.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTitulo.setForeground(COLOR_TEXTO);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("<html><div style='text-align:center; width:220px;'>" + subtitulo + "</div></html>");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblSubtitulo.setForeground(COLOR_TEXTO_SECUNDARIO);
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        caja.add(Box.createVerticalGlue());
        caja.add(icono);
        caja.add(Box.createVerticalStrut(4));
        caja.add(lblTitulo);
        caja.add(Box.createVerticalStrut(4));
        caja.add(lblSubtitulo);
        caja.add(Box.createVerticalGlue());

        return caja;
    }
}