/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import enums.EstadoSolicitudDTO;
import interfaces.ISolicitudDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de Negocio para el subsistema de Solicitudes.
 * @author regina, mariana, ernesto, isaac y luis
 */
public class SolicitudBO implements ISolicitudBO{
    
    private static SolicitudBO instancia;
    private ISolicitudDAO solicitudDAO;
    private ValidadorSolicitud validador;

    /**
     * Aquí se inicializan las dependencias hacia la capa de persistencia (DAO).
     */
    private SolicitudBO() {
        // this.solicitudDAO = SolicitudDAO.getInstancia();
    }

    /**
     * Obtiene la única instancia de la clase SolicitudBO.
     * @return Instancia única de SolicitudBO.
     */
    public static SolicitudBO getInstancia() {
        if (instancia == null) {
            instancia = new SolicitudBO();
        }
        return instancia;
    }


    /**
     * Inicializa una nueva solicitud en memoria asociándola a un cliente.
     * Establece el estado inicial como BORRADOR y asigna la fecha de creación.
     * Este método NO guarda la solicitud en la base de datos.
     * @param cliente El DTO del cliente que está iniciando el trámite.
     * @return Un nuevo objeto SolicitudDTO con los datos base configurados.
     */
    @Override
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("La solicitud debe tener un cliente asignado.");
        }
        SolicitudDTO nueva = new SolicitudDTO();
        nueva.setCliente(cliente);
        nueva.setEstado(EstadoSolicitudDTO.BORRADOR);
        nueva.setFechaCreacion(LocalDateTime.now());
        return nueva;
    }

    /**
     * Procesa y valida la información financiera agregada a la solicitud.
     * Delega la responsabilidad de validación a la clase utilitaria ValidadorSolicitud.
     * Si los datos son incorrectos, la validación lanzará una excepción deteniendo el flujo.
     * @param solicitud El objeto SolicitudDTO con los datos financieros precargados.
     * @return El mismo objeto SolicitudDTO si pasa todas las reglas de validación.
     * @throws IllegalArgumentException Si algún dato financiero incumple las reglas de negocio.
     */
    @Override
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud) {
        validador.validarDatosFinancieros(solicitud);
        return solicitud; 
    }

    /**
     * Finaliza el proceso de captura de la solicitud, actualiza su estado 
     * y delega su persistencia a la base de datos.
     * @param solicitud El objeto SolicitudDTO finalizado y validado.
     * @return El objeto SolicitudDTO con su estado actualizado a ENVIADA.
     */
    @Override
    public SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud) {
        solicitud.setEstado(EstadoSolicitudDTO.ENVIADA);
        solicitud.setFechaEnvio(LocalDateTime.now());
        //solicitudDAO.agregar(solicitud);    
        return solicitud;
    }

    /**
     * Busca y recupera todas las solicitudes asociadas a un cliente en particular.
     * @param idCliente El identificador único del cliente (ej. CURP o ID).
     * @return Lista de solicitudes pertenecientes al cliente especificado.
     */
    @Override
    public List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente) {
        return new ArrayList<>();
        // return solicitudDAO.obtenerSolicitudesPorCliente();
    }
    
     /**
     * Recibe una solicitud con el vehículo seleccionado y valida sus datos.
     * @param solicitud El objeto SolicitudDTO que contiene el vehículo a validar.
     * @return El objeto SolicitudDTO validado.
     */
    @Override
    public SolicitudDTO agregarVehiculo(SolicitudDTO solicitud) {
        if (solicitud.getVehiculo() == null) {
            throw new IllegalArgumentException("Debe seleccionar un vehículo del catálogo.");
        }
        return solicitud;
    }
}