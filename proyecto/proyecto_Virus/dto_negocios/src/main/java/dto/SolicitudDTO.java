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

    public SolicitudDTO() {
    }

    public SolicitudDTO(String id, LocalDateTime fechaEnvio, EstadoSolicitudDTO estado, VehiculoDTO vehiculo, ClienteDTO cliente) {
        this.id = id;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
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
}
