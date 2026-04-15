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
public class FachadaAdministrarSolicitud implements IAdministrarSolicitud{
    
    private ControlSolicitud controlSolicitud;

    public FachadaAdministrarSolicitud(ControlSolicitud controlSolicitud) {
        this.controlSolicitud = controlSolicitud;
    }

    @Override
    public SolicitudDTO iniciarNuevaSolicitud(ClienteDTO cliente) {
        return this.controlSolicitud.iniciarNuevaSolicitud(cliente);
    }

    @Override
    public SolicitudDTO agregarDatosFinancieros(SolicitudDTO solicitud, String tipoEmpleo, String puesto, String tipoContrato, String nombreEmpresa, String antiguedadLaboral, Double ingresoMensualBruto, Double ingresoMensualNeto, Double gastosMensuales, String rutaComprobanteIngresos, String rutaComprobanteEmpleo) {
        return this.controlSolicitud.agregarDatosFinancieros(solicitud, tipoEmpleo, puesto, tipoContrato, nombreEmpresa, antiguedadLaboral, ingresoMensualBruto, ingresoMensualNeto, gastosMensuales, rutaComprobanteIngresos, rutaComprobanteEmpleo);
    }

    @Override
    public SolicitudDTO confirmarEnvioSolicitud(SolicitudDTO solicitud) {
        return this.controlSolicitud.confirmarEnvioSolicitud(solicitud);
    }

    @Override
    public List<SolicitudDTO> obtenerSolicitudesPorCliente(String idCliente) {
        return this.controlSolicitud.obtenerSolicitudesPorCliente(idCliente);
    }
}
