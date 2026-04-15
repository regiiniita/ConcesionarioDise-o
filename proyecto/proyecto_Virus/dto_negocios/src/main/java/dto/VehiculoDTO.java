/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import enums.EstadoVehiculoDTO;
import java.io.Serializable;

/**
 *
 * @author 
 */
public class VehiculoDTO implements Serializable {
    private String serie;
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private EstadoVehiculoDTO estado;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String serie, String marca, String modelo, int anio, double precio, EstadoVehiculoDTO estado) {
        this.serie = serie;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.estado = estado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoVehiculoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculoDTO estado) {
        this.estado = estado;
    }
}
