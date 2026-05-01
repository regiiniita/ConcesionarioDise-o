/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import java.util.List;

/**
 * Clase que implementa el patrón de diseño Fachada (Facade) para el subsistema de Solicitudes.
 * Proporciona una interfaz unificada y simplificada para que las capas externas 
 * interactúen con la lógica de negocio, 
 * ocultando la complejidad de los Objetos de Negocio (BOs) subyacentes.
 * @author regina, mariana, ernesto, isaac y luis
 */
public class FachadaAdministrarSolicitud implements IAdministrarSolicitud {
    
    private ISolicitudBO solicitudBO;

    /**
     * Constructor de la Fachada.
     * Inicializa las dependencias necesarias obteniendo la instancia única (Singleton)
     * del Objeto de Negocio de Solicitudes.
     */
    public FachadaAdministrarSolicitud() {
        this.solicitudBO = SolicitudBO.getInstancia();
    }

    /**
     * Delega la inicialización de una nueva solicitud al BO correspondiente.
     * @param cliente El cliente que inicia la solicitud.
     * @return La nueva solicitud en estado de borrador.
     */
    @Override
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        return solicitudBO.iniciarNuevaSolicitud(cliente);
    }

    /**
     * Delega la validación y procesamiento de los datos financieros al BO.
     * @param solicitud La solicitud con los datos financieros a validar.
     * @return La solicitud validada.
     * @throws IllegalArgumentException Si la validación en el BO falla.
     */
    @Override
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud) {
        return solicitudBO.agregarDatosFinancieros(solicitud);
    }

    /**
     * Delega la confirmación de envío y persistencia final de la solicitud al BO.
     * @param solicitud La solicitud con todos los datos completos.
     * @return La solicitud con estado actualizado a ENVIADA.
     */
    @Override
    public SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud) {
        return solicitudBO.confirmarEnvioSolicitud(solicitud);
    }

    /**
     * Delega la consulta del historial de solicitudes de un cliente específico al BO.
     * @param idCliente El identificador único del cliente.
     * @return Lista de solicitudes asociadas a ese cliente.
     */
    @Override
    public List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente) {
        return solicitudBO.obtenerSolicitudesPorCliente(idCliente);
    }

    @Override
    public SolicitudDTO agregarVehiculo(SolicitudDTO solicitud) {
        return solicitudBO.agregarVehiculo(solicitud);
    }
}