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
    private String curp;
    private String estadoCivil;
    private String telefono;
    private String correo;
    private String rutaCurp;
    private String rutaRfc;
    private String rutaIdentificacion;

    public ClienteDTO() {
    }

    public ClienteDTO(String idCliente, String nombre, String rfc, String direccion, String curp, String estadoCivil, String telefono, String correo, String rutaCurp, String rutaRfc, String rutaIdentificacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.direccion = direccion;
        this.curp = curp;
        this.estadoCivil = estadoCivil;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaCurp = rutaCurp;
        this.rutaRfc = rutaRfc;
        this.rutaIdentificacion = rutaIdentificacion;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRutaCurp() {
        return rutaCurp;
    }

    public void setRutaCurp(String rutaCurp) {
        this.rutaCurp = rutaCurp;
    }

    public String getRutaRfc() {
        return rutaRfc;
    }

    public void setRutaRfc(String rutaRfc) {
        this.rutaRfc = rutaRfc;
    }

    public String getRutaIdentificacion() {
        return rutaIdentificacion;
    }

    public void setRutaIdentificacion(String rutaIdentificacion) {
        this.rutaIdentificacion = rutaIdentificacion;
    }
    
    
    
}
