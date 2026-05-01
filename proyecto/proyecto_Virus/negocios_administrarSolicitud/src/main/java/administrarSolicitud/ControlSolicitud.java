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
 * Actúa como intermediario entre el Coordinador de la interfaz gráfica 
 * y la Fachada del subsistema de negocio.
 * @author regina, mariana, ernesto, isaac y luis
 */
public class ControlSolicitud {
    
    private IAdministrarSolicitud fachada;

    /**
     * Constructor por defecto.
     * Inicializa la conexión con el subsistema de negocio instanciando su Fachada.
     */
    public ControlSolicitud() {
        this.fachada = new FachadaAdministrarSolicitud();
    }

    /**
     * Envía la petición al subsistema de negocio para iniciar una nueva solicitud.
     * @param cliente El cliente que realiza la solicitud.
     * @return La solicitud inicializada en estado de borrador.
     */
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        return fachada.iniciarNuevaSolicitud(cliente);
    }

    /**
     * Envía los datos financieros capturados al subsistema para su validación lógica.
     * @param solicitud La solicitud con los datos financieros precargados.
     * @return La solicitud si ha superado todas las validaciones de negocio.
     * @throws IllegalArgumentException Si los datos no cumplen con las reglas del negocio.
     */
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud) {
        return fachada.agregarDatosFinancieros(solicitud);
    }

    /**
     * Finaliza el caso de uso de captura, solicitando al negocio que procese 
     * y persista la solicitud completada.
     * @param solicitud La solicitud completa.
     * @return La solicitud confirmada y con estado ENVIADA.
     */
    public SolicitudDTO enviar(SolicitudDTO solicitud) {
        return fachada.confirmarEnvioSolicitud(solicitud);
    }

    /**
     * Solicita al negocio la lista histórica de trámites realizados por un cliente.
     * @param idCliente Identificador único del cliente.
     * @return Lista de solicitudes vinculadas a dicho cliente.
     */
    public List<SolicitudDTO> consultarPorCliente(String idCliente) {
        return fachada.obtenerSolicitudesPorCliente(idCliente);
    }
    
    /**
     * Envía el vehículo seleccionado al subsistema para su validación lógica.
     * @param solicitud La solicitud con el vehículo asignado.
     * @return La solicitud validada.
     */
    public SolicitudDTO agregarVehiculo(SolicitudDTO solicitud) {
        return fachada.agregarVehiculo(solicitud);
    }
}
