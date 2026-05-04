/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarCliente;

import dto.ClienteDTO;

/**
 * Clase utilitaria encargada de centralizar las validaciones de negocio 
 * para el subsistema de Clientes.
 * 
 * Se encarga de validar la integridad de los datos personales del cliente,
 * incluyendo nombres, apellidos, RFC, CURP, estado civil, teléfono, correo
 * y documentos obligatorios, así como la validación de su dirección.
 * 
 * @author regina, mariana, ernesto, isaac y luis
 */

public class ValidadorCliente {
    
    /**
     * Valida los datos personales y de contacto de un cliente.
     * 
     * Verifica que los campos obligatorios no sean nulos o vacíos,
     * que cumplan con longitudes mínimas, que los formatos de RFC,
     * CURP, teléfono y correo sean válidos, y que los documentos
     * requeridos estén presentes. También delega la validación de la
     * dirección a la clase {@link ValidadorDireccion}.
     * 
     * @param cliente El objeto ClienteDTO que contiene los datos a validar.
     * @throws IllegalArgumentException Si alguna de las reglas de validación falla.
     * El mensaje de la excepción describe el error específico para su manejo o visualización.
     */
    public void validarNombre(ClienteDTO cliente){
        
        if(cliente == null){
            throw new IllegalArgumentException("Los datos del cliente son obligatorios.");
        }
        
        if(cliente.getpNombre() == null || cliente.getpNombre().isBlank()){
            throw new IllegalArgumentException("El primer nombre no puede estar vacío.");
        }
        
        if (cliente.getpNombre().length() < 2) {
            throw new IllegalArgumentException("El primer nombre debe tener al menos 2 caracteres.");
        }

        if (cliente.getsNombre() != null && !cliente.getsNombre().isBlank()) {
            throw new IllegalArgumentException("El segundo nombre debe tener al menos 2 caracteres.");
        }
        
        if (cliente.getsNombre().length() < 2) {
            throw new IllegalArgumentException("El segundo nombre debe tener al menos 2 caracteres.");
        }

        if (cliente.getApellidoP() == null || cliente.getApellidoP().isBlank()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
        }

        if (cliente.getApellidoP().length() < 2) {
            throw new IllegalArgumentException("El apellido paterno debe tener al menos 2 caracteres.");
        }

        if (cliente.getApellidoM() == null || cliente.getApellidoM().isBlank()) {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
        }

        if (cliente.getApellidoM().length() < 2) {
            throw new IllegalArgumentException("El apellido materno debe tener al menos 2 caracteres.");
        }

        if (cliente.getRfc() == null || cliente.getRfc().isBlank()) {
            throw new IllegalArgumentException("El RFC no puede estar vacío.");
        }

        if (!cliente.getRfc().matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$")) {
            throw new IllegalArgumentException("El RFC no tiene un formato válido.");
        }

        if (cliente.getCurp() == null || cliente.getCurp().isBlank()) {
            throw new IllegalArgumentException("La CURP no puede estar vacía.");
        }

        if (!cliente.getCurp().matches("^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]{2}$")) {
            throw new IllegalArgumentException("La CURP no tiene un formato válido.");
        }

        if (cliente.getEstadoCivil() == null || cliente.getEstadoCivil().contains("Seleccionar")) {
            throw new IllegalArgumentException("Debe seleccionar un estado civil válido.");
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }

        if (!cliente.getTelefono().matches("^\\d{10}$")) {
            throw new IllegalArgumentException("El teléfono debe contener 10 dígitos.");
        }

        if (cliente.getCorreo() == null || cliente.getCorreo().isBlank()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío.");
        }

        if (!cliente.getCorreo().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }

        if (cliente.getRutaCurp() == null || cliente.getRutaCurp().isBlank()) {
            throw new IllegalArgumentException("Debe adjuntar el documento de CURP.");
        }

        if (cliente.getRutaRfc() == null || cliente.getRutaRfc().isBlank()) {
            throw new IllegalArgumentException("Debe adjuntar el documento de RFC.");
        }

        if (cliente.getRutaIdentificacion() == null || cliente.getRutaIdentificacion().isBlank()) {
            throw new IllegalArgumentException("Debe adjuntar una identificación oficial.");
        }
        
        ValidadorDireccion validadorDireccion = new ValidadorDireccion();
        validadorDireccion.validarDireccion(cliente.getDireccion());
        
    }
    
}
