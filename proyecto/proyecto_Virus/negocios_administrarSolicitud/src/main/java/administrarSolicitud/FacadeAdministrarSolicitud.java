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
 * 
 * @author regina, mariana, ernesto, isaac y luis
 */
public class FacadeAdministrarSolicitud implements IAdministrarSolicitud {
    
    private ControlSolicitud control;

    /**
     * Constructor de la Fachada.
     * Inicializa la dependencia con el Controlador del subsistema.
     */
    public FacadeAdministrarSolicitud() {
        this.control = new ControlSolicitud();
    }

    /**
     * Recibe la petición de la interfaz y la delega al Controlador para iniciar la solicitud.
     * @param cliente El cliente que inicia la solicitud.
     * @return La nueva solicitud devuelta por el controlador.
     */
    @Override
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        return control.iniciarNuevaSolicitud(cliente);
    }

    /**
     * Recibe la petición de la interfaz y la delega al Controlador para procesar los datos financieros.
     * @param solicitud La solicitud con los datos financieros.
     * @return La solicitud procesada devuelta por el controlador.
     */
    @Override
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud) {
        return control.agregarDatosFinancieros(solicitud);
    }

    /**
     * Recibe la petición de la interfaz y la delega al Controlador para confirmar el trámite.
     * @param solicitud La solicitud completa a enviar.
     * @return La solicitud confirmada devuelta por el controlador.
     */
    @Override
    public SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud) {
        return control.enviar(solicitud);
    }

    /**
     * Recibe la petición de la interfaz y la delega al Controlador para consultar el historial.
     * @param idCliente El identificador único del cliente.
     * @return Lista de solicitudes obtenida desde el controlador.
     */
    @Override
    public List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente) {
        return control.consultarPorCliente(idCliente);
    }

    /**
     * Recibe la petición de la interfaz y la delega al Controlador para asociar el vehículo.
     * @param solicitud La solicitud con el vehículo asignado.
     * @return La solicitud actualizada devuelta por el controlador.
     */
    @Override
    public SolicitudDTO agregarVehiculo(SolicitudDTO solicitud) {
        return control.agregarVehiculo(solicitud);
    }
}