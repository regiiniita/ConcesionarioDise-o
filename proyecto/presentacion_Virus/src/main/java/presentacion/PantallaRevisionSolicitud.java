package presentacion;

import controlador.Coordinador;
import dto.SolicitudDTO;
import dto.ClienteDTO;
import dto.VehiculoDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PantallaRevisionSolicitud extends JFrame {

    private final Coordinador coordinador;
    private SolicitudDTO solicitud;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(100, 116, 139);
    private static final Color COLOR_VERDE = new Color(34, 197, 94);
    private static final Color COLOR_VERDE_SUAVE = new Color(240, 253, 244);
    private static final Color COLOR_AZUL_SUAVE = new Color(239, 246, 255);

    private final NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));

    public PantallaRevisionSolicitud(Coordinador coordinador) {
        this.coordinador = coordinador;
        this.solicitud = coordinador.obtenerSolicitud();

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

        JLabel titulo = new JLabel("Revisar Solicitud");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titulo.setForeground(COLOR_TEXTO);

        JLabel paso = new JLabel("Paso 4 de 4");
        paso.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        paso.setForeground(COLOR_TEXTO_SECUNDARIO);

        izquierda.add(titulo);

        panel.add(izquierda, BorderLayout.WEST);
        panel.add(paso, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearCardInformacionPersonal() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información Personal"));
        card.add(Box.createVerticalStrut(18));

        ClienteDTO cliente = solicitud != null ? solicitud.getCliente() : null;

        String nombreCompleto = "No disponible";
        String rfc = "No disponible";
        String domicilio = "No disponible";
        String curp = "No disponible";
        String estadoCivil = "No disponible";
        String telefono = "No disponible";
        String correo = "No disponible";
        
        if (cliente != null) {
            nombreCompleto = valorSeguro(cliente.getNombre());
            rfc = valorSeguro(cliente.getRfc());
            domicilio = valorSeguro(cliente.getDireccion());
            curp = valorSeguro(cliente.getCurp());
            estadoCivil = valorSeguro(cliente.getEstadoCivil());
            telefono = valorSeguro(cliente.getTelefono());
            correo = valorSeguro(cliente.getCorreo());
        }

        card.add(crearPanelDatos(new String[][]{
            {"Nombre Completo:", nombreCompleto},
            {"Edad:", "No disponible"},
            {"CURP:", curp},
            {"RFC:", rfc},
            {"Estado Civil:", estadoCivil},
            {"Teléfono:", telefono},
            {"Correo:", correo},
            {"Domicilio:", domicilio}
        }));

        card.add(Box.createVerticalStrut(16));
        card.add(crearSeparador());
        card.add(Box.createVerticalStrut(16));
        card.add(crearSubtituloCentrado("Documentos Personales:"));
        card.add(Box.createVerticalStrut(10));

        card.add(crearPanelDocumentos(new String[]{
            "CURP: " + obtenerNombreArchivo(solicitud != null ? solicitud.getCliente().getRutaCurp() : null),
            "RFC: " + obtenerNombreArchivo(solicitud != null ? solicitud.getCliente().getRutaRfc(): null),
            "INE/Pasaporte: " + obtenerNombreArchivo(solicitud != null ? solicitud.getCliente().getRutaIdentificacion(): null)
        }));

        return card;
    }

    private JPanel crearCardInformacionFinanciera() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información Financiera"));
        card.add(Box.createVerticalStrut(18));

        String tipoEmpleo = solicitud != null ? valorSeguro(solicitud.getTipoEmpleo()) : "No disponible";
        String empresa = solicitud != null ? valorSeguro(solicitud.getNombreEmpresa()) : "No disponible";
        String puesto = solicitud != null ? valorSeguro(solicitud.getPuesto()) : "No disponible";
        String antiguedad = solicitud != null ? valorSeguro(solicitud.getAntiguedadLaboral()) : "No disponible";
        String tipoContrato = solicitud != null ? valorSeguro(solicitud.getTipoContrato()) : "No disponible";

        Double ingresoBruto = solicitud != null ? solicitud.getIngresoMensualBruto() : null;
        Double ingresoNeto = solicitud != null ? solicitud.getIngresoMensualNeto() : null;
        Double gastosMensuales = solicitud != null ? solicitud.getGastosMensuales() : null;

        card.add(crearPanelDatos(new String[][]{
            {"Tipo de Empleo:", tipoEmpleo},
            {"Empresa:", empresa},
            {"Puesto:", puesto},
            {"Antigüedad:", antiguedad},
            {"Tipo de Contrato:", tipoContrato},
            {"Ingreso Mensual Bruto:", formatearMonedaNullable(ingresoBruto)},
            {"Ingreso Mensual Neto:", formatearMonedaNullable(ingresoNeto)},
            {"Gastos Mensuales:", formatearMonedaNullable(gastosMensuales)}
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

        double disponible = 0.0;
        if (ingresoNeto != null && gastosMensuales != null) {
            disponible = ingresoNeto - gastosMensuales;
        }

        JLabel valorIngreso = new JLabel(formatoMoneda.format(disponible));
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
            obtenerNombreArchivo(solicitud != null ? solicitud.getRutaComprobanteIngresos() : null),
            obtenerNombreArchivo(solicitud != null ? solicitud.getRutaComprobanteEmpleo() : null)
        }));

        return card;
    }

    private JPanel crearCardInformacionVehiculo() {
        JPanel card = crearCardBase();
        card.add(crearTituloSeccion("Información del Vehículo"));
        card.add(Box.createVerticalStrut(18));

        VehiculoDTO vehiculo = solicitud != null ? solicitud.getVehiculo() : null;

        String nombreVehiculo = "No disponible";
        String precioVehiculo = "No disponible";
        String montoCredito = "No disponible";

        if (vehiculo != null) {
            nombreVehiculo = vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getAnio();
            precioVehiculo = formatoMoneda.format(vehiculo.getPrecio());
        }

        String enganche = "No disponible";
        if(solicitud != null){
            enganche = formatoMoneda.format(solicitud.getEnganche());
        }

        if (vehiculo != null && solicitud != null) {
            // TODO: Si luego agregas enganche a SolicitudDTO, recalcula correctamente el monto del crédito.
            montoCredito = formatoMoneda.format(vehiculo.getPrecio());
        }

        card.add(crearPanelDatos(new String[][]{
            {"Vehículo:", nombreVehiculo},
            {"Precio del Vehículo:", precioVehiculo},
            {"Enganche:", enganche},
            {"Monto del Crédito:", montoCredito}
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

        String fechaEnvioTexto = "No disponible";
        String estadoTexto = "No disponible";

        if (solicitud != null) {
            if (solicitud.getFechaEnvio() != null) {
                fechaEnvioTexto = solicitud.getFechaEnvio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            }
            if (solicitud.getEstado() != null) {
                estadoTexto = solicitud.getEstado().toString();
            }
        }

        JTextArea area = new JTextArea(
                "• Revise que toda la información mostrada sea correcta.\n" +
                "• Estado actual de la solicitud: " + estadoTexto + ".\n" +
                "• Fecha de envío registrada: " + fechaEnvioTexto + ".\n" +
                "• Si todo es correcto, puede enviar su solicitud para revisión."
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

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private String valorSeguro(String valor) {
        return (valor == null || valor.trim().isEmpty()) ? "No disponible" : valor;
    }

    private String formatearMonedaNullable(Double valor) {
        return valor == null ? "No disponible" : formatoMoneda.format(valor);
    }

    private String obtenerNombreArchivo(String ruta) {
        if (ruta == null || ruta.trim().isEmpty()) {
            return "No disponible";
        }
        return new File(ruta).getName();
    }
}