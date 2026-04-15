/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Data Transfer Object (DTO) para la entidad Cliente.
 * 
 * @author regin
 */
public class ClienteDTO {
    
    private String idCliente;
    private String nombre;
    private String rfc;
    private String direccion;

    public ClienteDTO() {
    }
    
    public ClienteDTO(String idCliente, String nombre, String rfc, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.direccion = direccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
