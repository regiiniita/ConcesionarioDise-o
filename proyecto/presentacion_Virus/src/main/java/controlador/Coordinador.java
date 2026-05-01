package controlador;

import administrarCliente.ControlCliente;
import administrarCliente.FacadeAdministrarCliente;
import administrarSolicitud.ControlSolicitud;
import administrarSolicitud.FachadaAdministrarSolicitud;
import administrarVehiculo.ControlVehiculo;
import administrarVehiculo.FacadeAdministrarVehiculo;
import dto.ClienteDTO;
import dto.SolicitudDTO;
import dto.VehiculoDTO;
import enums.EstadoSolicitudDTO;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import presentacion.*;

public class Coordinador {
    private PantallaDashboard pantallaDashboard;
    private PantallaFormularioDatosPersonales pantallaFormularioDatosPersonales;
    private PantallaFormularioInformacionFinanciera pantallaFormularioInformacionFinanciera;
    private PantallaCatalogoVehiculos pantallaCatalogoVehiculos;
    private PantallaRevisionSolicitud pantallaRevisionSolicitud;
    private PantallaConfirmacionSolicitud pantallaConfirmacionSolicitud;
    
    // Subsistemas (Atributos de Interface)
    private final ControlCliente controlCliente;
    private final ControlVehiculo controlVehiculo;
    private final ControlSolicitud controlSolicitud;
    
    private SolicitudDTO solicitud;
    private List<SolicitudDTO> solicitudes;
    
    private ClienteDTO cliente;


    public Coordinador() {
        // Se instancian las fachadas
        this.controlCliente = new ControlCliente();
        this.controlVehiculo = new ControlVehiculo();
        this.controlSolicitud = new ControlSolicitud();
    }
    
    /**
     * Guarda los datos del cliente y los mantiene en memoria para la solicitud.
     * @param cliente
     */
    public void guardarDatosPersonales(ClienteDTO cliente) {
        this.cliente = this.administrarCliente.guardarDatosPersonales(cliente);
        System.out.println("Datos de cliente recibidos y enviados al subsistema.");
    }

    /**
     * Recupera la lista de vehículos del subsistema Mock.
     * @return 
     */
    public List<VehiculoDTO> obtenerVehiculosDisponibles() {
        return this.administrarVehiculo.obtenerCatalogoDisponibles();
    }
    
    public void iniciarSistema(){
        this.pantallaDashboard = new PantallaDashboard(this);
        pantallaDashboard.setVisible(true);
    }
    
    public void mostrarFormularioDatosPersonales(){
        this.pantallaFormularioDatosPersonales = new PantallaFormularioDatosPersonales(this);
        pantallaFormularioDatosPersonales.setVisible(true);
    }
    
    public void mostrarFormularioInformacionFinanciera(){
        this.pantallaFormularioInformacionFinanciera = new PantallaFormularioInformacionFinanciera(this);
        pantallaFormularioInformacionFinanciera.setVisible(true);
    }
    
    public void mostrarCatalagoVehoculos(){
        this.pantallaCatalogoVehiculos = new PantallaCatalogoVehiculos(this);
        pantallaCatalogoVehiculos.setVisible(true);
    }
    
    public void mostrarRevisionSolicitud(){
        this.pantallaRevisionSolicitud = new PantallaRevisionSolicitud(this);
        pantallaRevisionSolicitud.setVisible(true);
    }
    
    public void mostrarConfirmacionSolicitud(){
        
        solicitud.setId(generarIdSolicitud());
        solicitud.setEstado(EstadoSolicitudDTO.ENVIADA);
        solicitud.setFechaCreacion(LocalDateTime.now());
        
        if(solicitudes == null){
            solicitudes = new ArrayList<>();
        }
        solicitudes.add(solicitud);
        
        this.pantallaConfirmacionSolicitud = new PantallaConfirmacionSolicitud(this);
        pantallaConfirmacionSolicitud.setVisible(true);
    }
    
    public SolicitudDTO asignarClienteASolicitud(ClienteDTO cliente){
        this.solicitud = controlSolicitud.iniciarNuevaSolicitud(cliente);
        return this.solicitud;
    }
    
    public SolicitudDTO agregarInformacionFinanciera(SolicitudDTO solicitudConDatos){
        this.solicitud = this.controlSolicitud.agregarDatosFinancieros(solicitudConDatos);
        return this.solicitud;
    }
    
    public void asignarVehiculoSeleccionado(VehiculoDTO vehiculo){
        this.solicitud.setVehiculo(vehiculo);
    }
    
    public SolicitudDTO obtenerSolicitud(){
        return this.solicitud;
    }
    
    public SolicitudDTO setSolicitud(SolicitudDTO solicitud){
        this.solicitud = solicitud;
        return this.solicitud;
    }
    
    public List<SolicitudDTO> obtenerSolicitudes(){
        return controlSolicitud.consultarPorCliente(this.cliente.getCurp());
    }
    
    private String generarIdSolicitud(){
        String PREFIJO = "CR-";
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int LONGITUD = 7;
        SecureRandom RANDOM = new SecureRandom();
        
        StringBuilder sb = new StringBuilder(PREFIJO);

        for (int i = 0; i < LONGITUD; i++) {
            int indice = RANDOM.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(indice));
        }

        return sb.toString();
    }
}
