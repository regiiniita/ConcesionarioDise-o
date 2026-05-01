/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import dto.VehiculoDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de solicitudes.
 * @author regina, mariana, ernesto, isaac y luis
 */
public interface ISolicitudBO {
    
    SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente);
    SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitudConDatos); 
    SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud);
    List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente);
    SolicitudDTO agregarVehiculo(SolicitudDTO solicitud);
}