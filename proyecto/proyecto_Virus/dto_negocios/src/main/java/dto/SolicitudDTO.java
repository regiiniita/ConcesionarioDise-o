/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import enums.EstadoSolicitudDTO;
import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class SolicitudDTO {
    private String id;
    private LocalDateTime fechaEnvio;
    private EstadoSolicitudDTO estado;
    private VehiculoDTO vehiculo;
    private ClienteDTO cliente;
    private String tipoEmpleo;
    private String puesto;
    private String tipoContrato;
    private String nombreEmpresa;
    private String antiguedadLaboral;
    private Double ingresoMensualBruto;
    private Double ingresoMensualNeto;
    private Double gastosMensuales;
    private String rutaComprobanteIngresos;
    private String rutaComprobanteEmpleo;
    private Double enganche;
    private LocalDateTime fechaCreacion;

    public SolicitudDTO() {
    }

    public SolicitudDTO(String id, LocalDateTime fechaEnvio, EstadoSolicitudDTO estado, VehiculoDTO vehiculo, ClienteDTO cliente, String tipoEmpleo, String puesto, String tipoContrato, String nombreEmpresa, String antiguedadLaboral, Double ingresoMensualBruto, Double ingresoMensualNeto, Double gastosMensuales, String rutaComprobanteIngresos, String rutaComprobanteEmpleo, Double enganche, LocalDateTime fechaCreacion) {
        this.id = id;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.tipoEmpleo = tipoEmpleo;
        this.puesto = puesto;
        this.tipoContrato = tipoContrato;
        this.nombreEmpresa = nombreEmpresa;
        this.antiguedadLaboral = antiguedadLaboral;
        this.ingresoMensualBruto = ingresoMensualBruto;
        this.ingresoMensualNeto = ingresoMensualNeto;
        this.gastosMensuales = gastosMensuales;
        this.rutaComprobanteIngresos = rutaComprobanteIngresos;
        this.rutaComprobanteEmpleo = rutaComprobanteEmpleo;
        this.enganche = enganche;
        this.fechaCreacion = fechaCreacion;
    }

    


    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoSolicitudDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitudDTO estado) {
        this.estado = estado;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public String getTipoEmpleo() {
        return tipoEmpleo;
    }

    public void setTipoEmpleo(String tipoEmpleo) {
        this.tipoEmpleo = tipoEmpleo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getAntiguedadLaboral() {
        return antiguedadLaboral;
    }

    public void setAntiguedadLaboral(String antiguedadLaboral) {
        this.antiguedadLaboral = antiguedadLaboral;
    }

    public Double getIngresoMensualBruto() {
        return ingresoMensualBruto;
    }

    public void setIngresoMensualBruto(Double ingresoMensualBruto) {
        this.ingresoMensualBruto = ingresoMensualBruto;
    }

    public Double getIngresoMensualNeto() {
        return ingresoMensualNeto;
    }

    public void setIngresoMensualNeto(Double ingresoMensualNeto) {
        this.ingresoMensualNeto = ingresoMensualNeto;
    }

    public Double getGastosMensuales() {
        return gastosMensuales;
    }

    public void setGastosMensuales(Double gastosMensuales) {
        this.gastosMensuales = gastosMensuales;
    }

    public String getRutaComprobanteIngresos() {
        return rutaComprobanteIngresos;
    }

    public void setRutaComprobanteIngresos(String rutaComprobanteIngresos) {
        this.rutaComprobanteIngresos = rutaComprobanteIngresos;
    }

    public String getRutaComprobanteEmpleo() {
        return rutaComprobanteEmpleo;
    }

    public void setRutaComprobanteEmpleo(String rutaComprobanteEmpleo) {
        this.rutaComprobanteEmpleo = rutaComprobanteEmpleo;
    }

    public Double getEnganche() {
        return enganche;
    }

    public void setEnganche(Double enganche) {
        this.enganche = enganche;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
