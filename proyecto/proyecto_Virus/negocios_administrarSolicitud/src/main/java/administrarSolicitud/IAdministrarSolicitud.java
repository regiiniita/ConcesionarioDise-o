/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import java.util.List;


/**
 *
 * @author 
 */
public interface IAdministrarSolicitud {
    
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente);
    
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud, String tipoEmpleo, String puesto, String tipoContrato, String nombreEmpresa, String antiguedadLaboral, Double ingresoMensualBruto, Double ingresoMensualNeto, Double gastosMensuales, String rutaComprobanteIngresos, String rutaComprobanteEmpleo);
    
    public SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud);
    
    public List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente);
    
}
