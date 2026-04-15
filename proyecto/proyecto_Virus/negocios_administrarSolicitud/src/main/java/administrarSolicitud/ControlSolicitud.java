/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarSolicitud;

import dto.ClienteDTO;
import dto.SolicitudDTO;
import enums.EstadoSolicitudDTO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControlSolicitud {
    protected ControlSolicitud(){
    }
    
    protected SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente){
        SolicitudDTO nueva = new SolicitudDTO();
        nueva.setCliente(cliente);
        nueva.setEstado(EstadoSolicitudDTO.BORRADOR);
        return nueva;
    }
    
    protected SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud, String tipoEmpleo, String puesto, String tipoContrato, String nombreEmpresa, String antiguedadLaboral, Double ingresoMensualBruto, Double ingresoMensualNeto, Double gastosMensuales, String rutaComprobanteIngresos, String rutaComprobanteEmpleo){
        solicitud.setTipoEmpleo(tipoEmpleo);
        solicitud.setPuesto(puesto);
        solicitud.setTipoContrato(tipoContrato);
        solicitud.setNombreEmpresa(nombreEmpresa);
        solicitud.setAntiguedadLaboral(antiguedadLaboral);
        solicitud.setIngresoMensualBruto(ingresoMensualBruto);
        solicitud.setIngresoMensualNeto(ingresoMensualNeto);
        solicitud.setGastosMensuales(gastosMensuales);
        solicitud.setRutaComprobanteIngresos(rutaComprobanteIngresos);
        solicitud.setRutaComprobanteEmpleo(rutaComprobanteEmpleo);
        
        return solicitud;
    }
    
    protected SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud){
        solicitud.setEstado(EstadoSolicitudDTO.ENVIADA);
        
        //persistir solicitud
        
        JOptionPane.showMessageDialog(null, "Solicitud enviada");
        return solicitud;
    }
    
    protected List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente){
        return null;
    }
}
