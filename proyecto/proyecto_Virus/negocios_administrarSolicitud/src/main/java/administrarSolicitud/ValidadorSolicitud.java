/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarSolicitud;

import dto.SolicitudDTO;

/**
 * Clase utilitaria encargada de centralizar las validaciones de negocio 
 * para el subsistema de Solicitudes.
 * @author regina, mariana, ernesto, isaac y luis
 */
public class ValidadorSolicitud {

    /**
     * Valida la integridad y congruencia de los datos financieros de una solicitud.
     * Verifica que no existan campos nulos o en blanco, que los valores numéricos 
     * sean positivos y lógicos, y que los documentos requeridos estén presentes.
     * @param solicitud El objeto SolicitudDTO que contiene los datos a validar.
     * @throws IllegalArgumentException Si alguna de las reglas de validación de negocio falla. 
     * El mensaje de la excepción contiene el detalle del error para ser mostrado al usuario.
     */
    public void validarDatosFinancieros(SolicitudDTO solicitud) {

        if (solicitud.getTipoEmpleo() == null || solicitud.getTipoEmpleo().contains("Seleccionar")) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de empleo válido.");
        }
        
        if (solicitud.getNombreEmpresa() == null || solicitud.getNombreEmpresa().isBlank()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede estar vacío.");
        }
        
        if (solicitud.getPuesto() == null || solicitud.getPuesto().isBlank()) {
            throw new IllegalArgumentException("El puesto o actividad principal no puede estar vacío.");
        }
        
        if (solicitud.getTipoContrato() == null || solicitud.getTipoContrato().contains("Seleccionar")) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de contrato válido.");
        }
        
        if (solicitud.getAntiguedadLaboral() == null || solicitud.getAntiguedadLaboral().contains("Seleccionar")) {
            throw new IllegalArgumentException("Debe seleccionar su antigüedad laboral.");
        }

        if (solicitud.getIngresoMensualBruto() == null || solicitud.getIngresoMensualBruto() <= 0) {
            throw new IllegalArgumentException("El ingreso mensual bruto debe ser mayor a 0.");
        }
        
        if (solicitud.getIngresoMensualNeto() == null || solicitud.getIngresoMensualNeto() <= 0) {
            throw new IllegalArgumentException("El ingreso mensual neto debe ser mayor a 0.");
        }
        
        if (solicitud.getGastosMensuales() == null || solicitud.getGastosMensuales() < 0) {
            throw new IllegalArgumentException("Los gastos mensuales no pueden ser negativos.");
        }

        if (solicitud.getIngresoMensualNeto() > solicitud.getIngresoMensualBruto()) {
            throw new IllegalArgumentException("El ingreso mensual neto no puede ser mayor al ingreso bruto.");
        }
        if (solicitud.getRutaComprobanteIngresos() == null || solicitud.getRutaComprobanteIngresos().isBlank()) {
            throw new IllegalArgumentException("Debe adjuntar el comprobante de ingresos (PDF).");
        }
        
        if (solicitud.getRutaComprobanteEmpleo() == null || solicitud.getRutaComprobanteEmpleo().isBlank()) {
            throw new IllegalArgumentException("Debe adjuntar el comprobante de empleo (PDF).");
        }
    }
}