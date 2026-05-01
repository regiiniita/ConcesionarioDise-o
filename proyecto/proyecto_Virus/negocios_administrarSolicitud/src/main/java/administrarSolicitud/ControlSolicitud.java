/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import java.util.List;

/**
 * Controlador de casos de uso para la gestión de solicitudes.
 * Recibe las peticiones de la Fachada y orquesta la ejecución de la 
 * lógica de negocio comunicándose directamente con los Objetos de Negocio.
 * @author regina, mariana, ernesto, isaac y luis
 */
public class ControlSolicitud {
    
    private SolicitudBO solicitudBO; 

    /**
     * Constructor del Controlador.
     * Inicializa la conexión con la capa de reglas de negocio.
     */
    public ControlSolicitud() {
        this.solicitudBO = SolicitudBO.getInstancia(); 
    }

    /**
     * Envía la petición al BO para inicializar una nueva solicitud.
     * @param cliente El cliente que realiza la solicitud.
     * @return La solicitud inicializada devuelta por el BO.
     */
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        return solicitudBO.iniciarNuevaSolicitud(cliente);
    }

    /**
     * Envía los datos financieros al BO para aplicar las reglas y validaciones de negocio.
     * @param solicitud La solicitud con los datos financieros precargados.
     * @return La solicitud validada devuelta por el BO.
     */
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud) {
        return solicitudBO.agregarDatosFinancieros(solicitud);
    }

    /**
     * Solicita al BO que procese y persista la solicitud completada.
     * @param solicitud La solicitud completa.
     * @return La solicitud confirmada y con estado actualizado devuelta por el BO.
     */
    public SolicitudDTO enviar(SolicitudDTO solicitud) {
        return solicitudBO.confirmarEnvioSolicitud(solicitud);
    }

    /**
     * Solicita al BO la lista histórica de trámites realizados por un cliente.
     * @param idCliente Identificador único del cliente.
     * @return Lista de solicitudes vinculadas a dicho cliente.
     */
    public List<SolicitudDTO> consultarPorCliente(String idCliente) {
        return solicitudBO.obtenerSolicitudesPorCliente(idCliente);
    }
    
    /**
     * Envía la solicitud con el vehículo seleccionado al BO para su validación lógica.
     * @param solicitud La solicitud con el vehículo asignado.
     * @return La solicitud validada devuelta por el BO.
     */
    public SolicitudDTO agregarVehiculo(SolicitudDTO solicitud) {
        return solicitudBO.agregarVehiculo(solicitud);
    }
}