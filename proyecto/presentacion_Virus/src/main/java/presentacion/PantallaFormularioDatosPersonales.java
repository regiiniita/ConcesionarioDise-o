package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaFormularioDatosPersonales extends JFrame {
    
    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_INPUT = new Color(244, 244, 246);
    private static final Color COLOR_SUBIDA = new Color(148, 163, 184);

    public PantallaFormularioDatosPersonales(Coordinador coordinador) {
        this.coordinador = coordinador;
        
        setTitle("Información Personal");
        setSize(1000, 910);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(COLOR_FONDO);
        fondo.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(fondo);

        JPanel contenedorCentral = new JPanel();
        contenedorCentral.setOpaque(false);
        contenedorCentral.setLayout(new BoxLayout(contenedorCentral, BoxLayout.Y_AXIS));
        contenedorCentral.setPreferredSize(new Dimension(690, 760));

        contenedorCentral.add(crearEncabezado());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearCardInformacionBasica());
        contenedorCentral.add(Box.createVerticalStrut(18));
        contenedorCentral.add(crearCardDocumentos());
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

        JLabel titulo = new JLabel("Información Personal");
        titulo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        titulo.setForeground(COLOR_TEXTO);

//        izquierda.add(icono);
        izquierda.add(titulo);

        JLabel paso = new JLabel("Paso 1 de 4");
        paso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        paso.setForeground(new Color(71, 85, 105));

        panel.add(izquierda, BorderLayout.WEST);
        panel.add(paso, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardInformacionBasica() {
        JPanel card = crearCardBase(690, 390);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel seccion = new JLabel("Información Básica");
        seccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        seccion.setForeground(COLOR_AZUL);
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(seccion);
        card.add(Box.createVerticalStrut(16));

        JPanel grid = new JPanel(new GridBagLayout());
        grid.setOpaque(false);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setPreferredSize(new Dimension(654, 320));
        grid.setMaximumSize(new Dimension(654, 320));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 12, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        grid.add(crearCampo("Nombre(s) *", "Juan"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearCampo("Apellidos *", "García Pérez"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 14);
        grid.add(crearCampo("Edad *", "30"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearComboCampo("Estado Civil *", "Seleccionar estado"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 12, 14);
        grid.add(crearCampo("CURP *", "GAPR900101HDFRNN09"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearCampo("RFC *", "GAPR900101XXX"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 12, 14);
        grid.add(crearCampo("Número de Teléfono *", "+52 55 1234 5678"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 12, 0);
        grid.add(crearCampo("Correo Electrónico *", "juan.garcia@ejemplo.com"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        grid.add(crearCampoDomicilio("Domicilio *", "Calle Principal 123, Colonia Centro, CDMX"), gbc);

        card.add(grid);
        return card;
    }

    private JPanel crearCardDocumentos() {
        JPanel card = crearCardBase(690, 210);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel seccion = new JLabel("Documentos Requeridos");
        seccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        seccion.setForeground(COLOR_AZUL);
        seccion.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(seccion);
        card.add(Box.createVerticalStrut(18));

        JPanel contenedor = new JPanel(new GridLayout(1, 3, 12, 0));
        contenedor.setOpaque(false);
        contenedor.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenedor.setPreferredSize(new Dimension(654, 95));
        contenedor.setMaximumSize(new Dimension(654, 95));

        contenedor.add(crearCajaDocumento("Documento CURP *", "PDF, JPG, o PNG"));
        contenedor.add(crearCajaDocumento("Documento RFC *", "PDF, JPG, o PNG"));
        contenedor.add(crearCajaDocumento("ID Oficial (INE/Pasaporte) *", "PDF, JPG, o PNG"));

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
                coordinador.iniciarSistema();
            }
        });

        JButton btnContinuar = new JButton("Continuar a Información Financiera");
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
                coordinador.mostrarFormularioInformacionFinanciera();
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

    private JPanel crearComboCampo(String labelText, String primerItem) {
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

        JComboBox<String> combo = new JComboBox<>(new String[]{
                primerItem,
                "Soltero(a)",
                "Casado(a)",
                "Divorciado(a)",
                "Viudo(a)"
        });
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

    private JPanel crearCajaDocumento(String titulo, String subtitulo) {
        JPanel caja = new JPanel();
        caja.setOpaque(false);
        caja.setLayout(new BoxLayout(caja, BoxLayout.Y_AXIS));
        caja.setBorder(BorderFactory.createDashedBorder(new Color(203, 213, 225), 4, 4, 2, true));
        caja.setPreferredSize(new Dimension(210, 95));

        JLabel icono = new JLabel("⇪");
        icono.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
        icono.setForeground(COLOR_SUBIDA);
        icono.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTitulo.setForeground(COLOR_TEXTO);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel(subtitulo);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblSubtitulo.setForeground(COLOR_TEXTO_SECUNDARIO);
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        caja.add(Box.createVerticalGlue());
        caja.add(icono);
        caja.add(Box.createVerticalStrut(2));
        caja.add(lblTitulo);
        caja.add(Box.createVerticalStrut(3));
        caja.add(lblSubtitulo);
        caja.add(Box.createVerticalGlue());

        return caja;
    }
}