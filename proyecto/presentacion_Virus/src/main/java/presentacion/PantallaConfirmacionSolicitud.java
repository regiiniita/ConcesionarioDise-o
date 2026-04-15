package presentacion;

import controlador.Coordinador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaConfirmacionSolicitud extends JFrame {

    private final Coordinador coordinador;

    private static final Color COLOR_FONDO = new Color(239, 242, 247);
    private static final Color COLOR_AZUL = new Color(37, 99, 235);
    private static final Color COLOR_AZUL_CLARO = new Color(239, 246, 255);
    private static final Color COLOR_VERDE = new Color(22, 163, 74);
    private static final Color COLOR_AMARILLO_SUAVE = new Color(254, 249, 195);
    private static final Color COLOR_AMARILLO_TEXTO = new Color(161, 98, 7);
    private static final Color COLOR_BORDE = new Color(209, 213, 219);
    private static final Color COLOR_TEXTO = new Color(15, 23, 42);
    private static final Color COLOR_TEXTO_SECUNDARIO = new Color(71, 85, 105);
    private static final Color COLOR_CAJA = Color.WHITE;
    private static final Color COLOR_ICONO_GRIS = new Color(100, 116, 139);

    private static final int ANCHO_CONTENIDO = 560;

    public PantallaConfirmacionSolicitud(Coordinador coordinador) {
        this.coordinador = coordinador;

        setTitle("Confirmación de Solicitud");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(COLOR_FONDO);
        fondo.setBorder(new EmptyBorder(16, 16, 16, 16));
        setContentPane(fondo);

        JPanel contenedorExterior = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        contenedorExterior.setOpaque(false);

        JPanel principal = new JPanel();
        principal.setOpaque(false);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 900));

        principal.add(crearIconoExito());
        principal.add(Box.createVerticalStrut(18));
        principal.add(crearTitulo());
        principal.add(Box.createVerticalStrut(8));
        principal.add(crearSubtitulo());
        principal.add(Box.createVerticalStrut(18));
        principal.add(crearPanelIdSolicitud());
        principal.add(Box.createVerticalStrut(18));
        principal.add(crearPanelEstado());
        principal.add(Box.createVerticalStrut(18));
        principal.add(crearPanelTiempoEstimado());
        principal.add(Box.createVerticalStrut(18));
        principal.add(crearPanelNotificaciones());
        principal.add(Box.createVerticalStrut(28));
        principal.add(crearBotonFinal());

        contenedorExterior.add(principal);

        JScrollPane scroll = new JScrollPane(contenedorExterior);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(COLOR_FONDO);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(14);

        fondo.add(scroll, BorderLayout.CENTER);
    }

    private JPanel crearIconoExito() {
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        contenedor.setOpaque(false);
        contenedor.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.setMaximumSize(new Dimension(ANCHO_CONTENIDO, 90));
        contenedor.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 90));

        JPanel circulo = new JPanel(new GridBagLayout());
        circulo.setBackground(COLOR_VERDE);
        circulo.setPreferredSize(new Dimension(82, 82));
        circulo.setMaximumSize(new Dimension(82, 82));

        JLabel check = new JLabel("✓");
        check.setFont(new Font("Segoe UI Symbol", Font.BOLD, 32));
        check.setForeground(Color.WHITE);

        circulo.add(check);
        contenedor.add(circulo);

        return contenedor;
    }

    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("¡Solicitud Enviada Exitosamente!");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(COLOR_TEXTO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return titulo;
    }

    private JLabel crearSubtitulo() {
        JLabel subtitulo = new JLabel("Su solicitud de pre-aprobación de crédito ha sido registrada y está en revisión.");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setForeground(COLOR_TEXTO_SECUNDARIO);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return subtitulo;
    }

    private JPanel crearPanelIdSolicitud() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLOR_AZUL);
        panel.setBorder(new EmptyBorder(18, 18, 18, 18));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 100));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO, 100));

        JLabel lblTitulo = new JLabel("ID de Solicitud");
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblId = new JLabel(coordinador.obtenerSolicitud().getId());
        lblId.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblId.setForeground(Color.WHITE);
        lblId.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(18));
        panel.add(lblId);

        return panel;
    }

    private JPanel crearPanelEstado() {
        JPanel panel = crearCardBase();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 300));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO, 300));

        JPanel encabezado = new JPanel(new BorderLayout(10, 0));
        encabezado.setOpaque(false);
        encabezado.setAlignmentX(Component.LEFT_ALIGNMENT);
        encabezado.setMaximumSize(new Dimension(ANCHO_CONTENIDO - 32, 42));

        JPanel icono = new JPanel(new GridBagLayout());
        icono.setBackground(COLOR_AMARILLO_SUAVE);
        icono.setPreferredSize(new Dimension(36, 36));
        icono.setMaximumSize(new Dimension(36, 36));

        JLabel reloj = new JLabel("◔");
        reloj.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
        reloj.setForeground(COLOR_AMARILLO_TEXTO);
        icono.add(reloj);

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Estado: Enviada");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titulo.setForeground(COLOR_TEXTO);

        JLabel subtitulo = new JLabel("Su solicitud está siendo procesada");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitulo.setForeground(COLOR_TEXTO_SECUNDARIO);

        textos.add(titulo);
        textos.add(Box.createVerticalStrut(2));
        textos.add(subtitulo);

        encabezado.add(icono, BorderLayout.WEST);
        encabezado.add(textos, BorderLayout.CENTER);

        panel.add(encabezado);
        panel.add(Box.createVerticalStrut(14));
        panel.add(crearSeparador());
        panel.add(Box.createVerticalStrut(18));

        JLabel queSigue = new JLabel("¿Qué sigue?");
        queSigue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        queSigue.setForeground(COLOR_TEXTO);
        queSigue.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(queSigue);
        panel.add(Box.createVerticalStrut(14));

        panel.add(crearPaso("1", "Validación de Documentos", "Verificaremos todos sus documentos enviados"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(crearPaso("2", "Consulta de Buró de Crédito", "Revisaremos su historial y puntaje crediticio"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(crearPaso("3", "Análisis de Capacidad de Pago", "Evaluaremos su capacidad para pagar el crédito"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(crearPaso("4", "Decisión Final", "Recibirá el resultado de su pre-aprobación"));

        return panel;
    }

    private JPanel crearPaso(String numero, String tituloPaso, String descripcion) {
        JPanel panel = new JPanel(new BorderLayout(12, 0));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO - 32, 42));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO - 32, 42));

        JPanel numeroPanel = new JPanel(new GridBagLayout());
        numeroPanel.setBackground(new Color(219, 234, 254));
        numeroPanel.setPreferredSize(new Dimension(30, 30));
        numeroPanel.setMaximumSize(new Dimension(30, 30));

        JLabel lblNumero = new JLabel(numero);
        lblNumero.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNumero.setForeground(COLOR_AZUL);
        numeroPanel.add(lblNumero);

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel(tituloPaso);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titulo.setForeground(COLOR_TEXTO);

        JLabel desc = new JLabel(descripcion);
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        desc.setForeground(COLOR_TEXTO_SECUNDARIO);

        textos.add(titulo);
        textos.add(Box.createVerticalStrut(2));
        textos.add(desc);

        panel.add(numeroPanel, BorderLayout.WEST);
        panel.add(textos, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelTiempoEstimado() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLOR_AZUL_CLARO);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(147, 197, 253), 1, true),
                new EmptyBorder(14, 16, 14, 16)
        ));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 88));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO, 88));

        JPanel filaTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        filaTitulo.setOpaque(false);
        filaTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        filaTitulo.setMaximumSize(new Dimension(ANCHO_CONTENIDO - 32, 20));

        JLabel icono = new JLabel("◔");
        icono.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
        icono.setForeground(COLOR_AZUL);

        JLabel titulo = new JLabel("Tiempo Estimado");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titulo.setForeground(COLOR_TEXTO);

        filaTitulo.add(icono);
        filaTitulo.add(titulo);

        JLabel descripcion = new JLabel("<html>Debería recibir una respuesta en <b>24-48 horas</b>. Le mantendremos informado durante todo el proceso.</html>");
        descripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descripcion.setForeground(new Color(30, 64, 175));
        descripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(filaTitulo);
        panel.add(Box.createVerticalStrut(8));
        panel.add(descripcion);

        return panel;
    }

    private JPanel crearPanelNotificaciones() {
        JPanel panel = crearCardBase();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Será notificado vía:");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titulo.setForeground(COLOR_TEXTO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel fila = new JPanel(new GridLayout(1, 2, 12, 0));
        fila.setOpaque(false);
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        fila.setMaximumSize(new Dimension(ANCHO_CONTENIDO - 32, 40));
        fila.setPreferredSize(new Dimension(ANCHO_CONTENIDO - 32, 40));

        fila.add(crearCanal("✉", "Correo electrónico"));
        fila.add(crearCanal("💬", "SMS"));

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(14));
        panel.add(fila);

        return panel;
    }

    private JPanel crearCanal(String icono, String texto) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        panel.setBackground(new Color(248, 250, 252));
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 1, true),
                new EmptyBorder(2, 4, 2, 4)
        ));

        JLabel lblIcono = new JLabel(icono);
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        lblIcono.setForeground(COLOR_ICONO_GRIS);

        JLabel lblTexto = new JLabel(texto);
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTexto.setForeground(COLOR_TEXTO);

        panel.add(lblIcono);
        panel.add(lblTexto);

        return panel;
    }

    private JPanel crearBotonFinal() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 40));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO, 40));

        JButton boton = new JButton("Terminar");
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        boton.setForeground(COLOR_TEXTO);
        boton.setBackground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(214, 214, 214), 1, true),
                new EmptyBorder(8, 14, 8, 14)
        ));

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                coordinador.iniciarSistema();
            }
        });

        panel.add(boton);
        return panel;
    }

    private JPanel crearCardBase() {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_CAJA);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(ANCHO_CONTENIDO, 10));
        panel.setMaximumSize(new Dimension(ANCHO_CONTENIDO, Integer.MAX_VALUE));
        return panel;
    }

    private JSeparator crearSeparador() {
        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(226, 232, 240));
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        return separador;
    }
}
