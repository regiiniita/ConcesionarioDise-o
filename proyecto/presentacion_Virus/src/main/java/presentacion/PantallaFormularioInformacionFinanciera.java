package presentacion;

import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PantallaFormularioInformacionFinanciera extends JFrame {

    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_INPUT = new Color(244, 244, 246);
    private static final Color COLOR_SUBIDA = new Color(148, 163, 184);

    // Componentes del formulario
    private JComboBox<String> comboTipoEmpleo;
    private JTextField txtEmpresaActividad;
    private JTextField txtPuestoActividad;
    private JComboBox<String> comboAntiguedad;
    private JComboBox<String> comboTipoContrato;

    private JTextField txtIngresoBruto;
    private JTextField txtIngresoNeto;
    private JTextField txtGastosMensuales;

    // Variables donde se guardará la información
    private String tipoEmpleoSeleccionado;
    private String empresaActividadEconomica;
    private String puestoActividadPrincipal;
    private String antiguedadLaboralSeleccionada;
    private String tipoContratoSeleccionado;
    private String ingresoMensualBruto;
    private String ingresoMensualNeto;
    private String gastosMensuales;

    private String rutaComprobanteIngresos;
    private String rutaComprobanteEmpleo;

    // Labels para mostrar nombre del archivo elegido
    private JLabel lblArchivoIngresos;
    private JLabel lblArchivoEmpleo;

    public PantallaFormularioInformacionFinanciera(Coordinador coordinador) {
        this.coordinador = coordinador;

        setTitle("Información Financiera");
        setSize(800, 850);
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

        JLabel titulo = new JLabel("Información Financiera");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 17));
        titulo.setForeground(COLOR_TEXTO);

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
        comboTipoEmpleo = crearComboCampoComponente(
                new String[]{"Seleccionar tipo", "Empleado", "Independiente", "Empresario", "Jubilado"}
        );
        grid.add(crearPanelCampoConComponente("Tipo de Empleo *", comboTipoEmpleo, 320, 58), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 12, 0);
        txtEmpresaActividad = crearTextFieldBase("Corporación ABC", 320);
        grid.add(crearPanelCampoConComponente("Nombre de Empresa / Actividad Económica *", txtEmpresaActividad, 320, 58), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 14);
        txtPuestoActividad = crearTextFieldBase("Gerente de Ventas", 320);
        grid.add(crearPanelCampoConComponente("Puesto / Actividad Principal *", txtPuestoActividad, 320, 58), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 0);
        comboAntiguedad = crearComboCampoComponente(
                new String[]{"Seleccionar antigüedad", "Menos de 1 año", "1 a 3 años", "3 a 5 años", "Más de 5 años"}
        );
        grid.add(crearPanelCampoConComponente("Antigüedad Laboral *", comboAntiguedad, 320, 58), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        comboTipoContrato = crearComboCampoComponente(
                new String[]{"Seleccionar tipo de contrato", "Tiempo completo", "Medio tiempo", "Temporal", "Por honorarios", "Indefinido"}
        );
        grid.add(crearPanelCampoConComponente("Tipo de Contrato *", comboTipoContrato, 654, 62), gbc);

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
        txtIngresoBruto = crearTextFieldBase("25000", 320);
        grid.add(crearPanelCampoConComponente("Ingreso Mensual Bruto (MXN) *", txtIngresoBruto, 320, 58), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 12, 0);
        txtIngresoNeto = crearTextFieldBase("20000", 320);
        grid.add(crearPanelCampoConComponente("Ingreso Mensual Neto (MXN) *", txtIngresoNeto, 320, 58), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        txtGastosMensuales = crearTextFieldBase("8000", 654);
        grid.add(crearPanelCampoConComponente("Gastos Mensuales (MXN) *", txtGastosMensuales, 654, 58), gbc);

        card.add(grid);
        return card;
    }

    private JPanel crearCardDocumentosFinancieros() {
        JPanel card = crearCardBase(690, 220);
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
        contenedor.setPreferredSize(new Dimension(654, 130));
        contenedor.setMaximumSize(new Dimension(654, 130));

        contenedor.add(crearCajaDocumentoSubida(
                "Comprobante de Ingresos *",
                "Solo archivos PDF",
                true
        ));

        contenedor.add(crearCajaDocumentoSubida(
                "Comprobante de Empleo *",
                "Solo archivos PDF",
                false
        ));

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

        btnAtras.addActionListener((ActionEvent e) -> {
            setVisible(false);
            coordinador.mostrarFormularioDatosPersonales();
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

        btnContinuar.addActionListener((ActionEvent e) -> {
            if (!validarFormulario()) {
                return;
            }

            guardarDatosEnVariables();

            coordinador.agregarInformacionFinanciera(getTipoEmpleoSeleccionado(), getPuestoActividadPrincipal(), getTipoContratoSeleccionado(), getEmpresaActividadEconomica(), getAntiguedadLaboralSeleccionada() , Double.parseDouble(getIngresoMensualBruto()), Double.parseDouble(getIngresoMensualNeto()), Double.parseDouble(getGastosMensuales()), getRutaComprobanteIngresos(), getRutaComprobanteEmpleo());

            setVisible(false);
            coordinador.mostrarCatalagoVehoculos();
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

    private JPanel crearPanelCampoConComponente(String labelText, Component componente, int ancho, int alto) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(ancho, alto));
        panel.setMinimumSize(new Dimension(ancho, alto));
        panel.setMaximumSize(new Dimension(ancho, alto));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (componente instanceof JComponent jComp) {
            jComp.setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        panel.add(label);
        panel.add(Box.createVerticalStrut(4));
        panel.add(componente);

        return panel;
    }

    private JTextField crearTextFieldBase(String texto, int ancho) {
        JTextField campo = new JTextField(texto);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campo.setForeground(COLOR_TEXTO_SECUNDARIO);
        campo.setBackground(COLOR_INPUT);
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_INPUT, 1, true),
                new EmptyBorder(7, 10, 7, 10)
        ));
        campo.setPreferredSize(new Dimension(ancho, 30));
        campo.setMinimumSize(new Dimension(ancho, 30));
        campo.setMaximumSize(new Dimension(ancho, 30));
        campo.setCaretColor(COLOR_TEXTO);
        return campo;
    }

    private JComboBox<String> crearComboCampoComponente(String[] opciones) {
        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        combo.setForeground(COLOR_TEXTO_SECUNDARIO);
        combo.setBackground(COLOR_INPUT);
        combo.setPreferredSize(new Dimension(320, 30));
        combo.setMinimumSize(new Dimension(320, 30));
        combo.setMaximumSize(new Dimension(654, 30));
        return combo;
    }

    private JPanel crearCajaDocumentoSubida(String titulo, String subtitulo, boolean esIngresos) {
        JPanel caja = new JPanel();
        caja.setOpaque(false);
        caja.setLayout(new BoxLayout(caja, BoxLayout.Y_AXIS));
        caja.setBorder(BorderFactory.createDashedBorder(new Color(203, 213, 225), 4, 4, 2, true));
        caja.setPreferredSize(new Dimension(320, 130));

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

        JButton btnSeleccionar = new JButton("Seleccionar archivo");
        btnSeleccionar.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnSeleccionar.setBackground(COLOR_AZUL);
        btnSeleccionar.setForeground(Color.BLACK);
        btnSeleccionar.setFocusPainted(false);
        btnSeleccionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblArchivo = new JLabel("Ningún archivo seleccionado");
        lblArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        lblArchivo.setForeground(COLOR_TEXTO_SECUNDARIO);
        lblArchivo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSeleccionar.addActionListener((ActionEvent e) -> {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar documento PDF");

        chooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filtroPdf = new FileNameExtensionFilter("Documentos PDF (*.pdf)", "pdf");
        chooser.setFileFilter(filtroPdf);

        int resultado = chooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            // Validación de seguridad adicional
            if (archivo.getName().toLowerCase().endsWith(".pdf")) {
                if (esIngresos) {
                    rutaComprobanteIngresos = archivo.getAbsolutePath();
                    lblArchivoIngresos.setText(archivo.getName());
                } else {
                    rutaComprobanteEmpleo = archivo.getAbsolutePath();
                    lblArchivoEmpleo.setText(archivo.getName());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos en formato PDF.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

        if (esIngresos) {
            lblArchivoIngresos = lblArchivo;
        } else {
            lblArchivoEmpleo = lblArchivo;
        }

        caja.add(Box.createVerticalGlue());
        caja.add(icono);
        caja.add(Box.createVerticalStrut(4));
        caja.add(lblTitulo);
        caja.add(Box.createVerticalStrut(4));
        caja.add(lblSubtitulo);
        caja.add(Box.createVerticalStrut(8));
        caja.add(btnSeleccionar);
        caja.add(Box.createVerticalStrut(6));
        caja.add(lblArchivo);
        caja.add(Box.createVerticalGlue());

        return caja;
    }

    private boolean validarFormulario() {
        if (comboTipoEmpleo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de empleo.");
            return false;
        }

        if (txtEmpresaActividad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de empresa o actividad económica.");
            return false;
        }

        if (txtPuestoActividad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el puesto o actividad principal.");
            return false;
        }

        if (comboAntiguedad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione la antigüedad laboral.");
            return false;
        }

        if (comboTipoContrato.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de contrato.");
            return false;
        }

        if (txtIngresoBruto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ingreso mensual bruto.");
            return false;
        }

        if (txtIngresoNeto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ingreso mensual neto.");
            return false;
        }

        if (txtGastosMensuales.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese los gastos mensuales.");
            return false;
        }

        if (rutaComprobanteIngresos == null || rutaComprobanteIngresos.isBlank()) {
            JOptionPane.showMessageDialog(this, "Seleccione el comprobante de ingresos.");
            return false;
        }

        if (rutaComprobanteEmpleo == null || rutaComprobanteEmpleo.isBlank()) {
            JOptionPane.showMessageDialog(this, "Seleccione el comprobante de empleo.");
            return false;
        }

        return true;
    }

    private void guardarDatosEnVariables() {
        tipoEmpleoSeleccionado = comboTipoEmpleo.getSelectedItem().toString();
        empresaActividadEconomica = txtEmpresaActividad.getText().trim();
        puestoActividadPrincipal = txtPuestoActividad.getText().trim();
        antiguedadLaboralSeleccionada = comboAntiguedad.getSelectedItem().toString();
        tipoContratoSeleccionado = comboTipoContrato.getSelectedItem().toString();

        ingresoMensualBruto = txtIngresoBruto.getText().trim();
        ingresoMensualNeto = txtIngresoNeto.getText().trim();
        gastosMensuales = txtGastosMensuales.getText().trim();
    }

    public String getTipoEmpleoSeleccionado() {
        return tipoEmpleoSeleccionado;
    }

    public String getEmpresaActividadEconomica() {
        return empresaActividadEconomica;
    }

    public String getPuestoActividadPrincipal() {
        return puestoActividadPrincipal;
    }

    public String getAntiguedadLaboralSeleccionada() {
        return antiguedadLaboralSeleccionada;
    }

    public String getTipoContratoSeleccionado() {
        return tipoContratoSeleccionado;
    }

    public String getIngresoMensualBruto() {
        return ingresoMensualBruto;
    }

    public String getIngresoMensualNeto() {
        return ingresoMensualNeto;
    }

    public String getGastosMensuales() {
        return gastosMensuales;
    }

    public String getRutaComprobanteIngresos() {
        return rutaComprobanteIngresos;
    }

    public String getRutaComprobanteEmpleo() {
        return rutaComprobanteEmpleo;
    }
}