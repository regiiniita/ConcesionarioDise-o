/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarCliente;

import dto.DireccionDTO;

/**
 * Clase utilitaria encargada de validar los datos de la dirección
 * de un cliente dentro del sistema.
 * 
 * Verifica que los campos obligatorios de la dirección no sean nulos
 * o vacíos y que el código postal tenga un formato válido.
 * 
 * @author mariana
 */
public class ValidadorDireccion {
    
     /**
     * Valida la integridad de los datos de una dirección.
     * 
     * Comprueba que los campos esenciales como calle, número exterior,
     * colonia, código postal, ciudad y estado estén presentes y cumplan
     * con los formatos esperados.
     * 
     * @param direccion El objeto DireccionDTO que contiene los datos a validar.
     * @throws IllegalArgumentException Si alguna de las reglas de validación falla.
     * El mensaje de la excepción describe el error específico.
     */
    public void validarDireccion(DireccionDTO direccion){
        
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección del cliente es obligatoria.");
        }

        if (direccion.getCalle() == null || direccion.getCalle().isBlank()) {
            throw new IllegalArgumentException("La calle no puede estar vacía.");
        }

        if (direccion.getNumeroExterior() == null || direccion.getNumeroExterior().isBlank()) {
            throw new IllegalArgumentException("El número exterior no puede estar vacío.");
        }

        if (direccion.getColonia() == null || direccion.getColonia().isBlank()) {
            throw new IllegalArgumentException("La colonia no puede estar vacía.");
        }

        if (direccion.getCodigoPostal() == null || direccion.getCodigoPostal().isBlank()) {
            throw new IllegalArgumentException("El código postal no puede estar vacío.");
        }

        if (!direccion.getCodigoPostal().matches("^\\d{5}$")) {
            throw new IllegalArgumentException("El código postal debe contener 5 dígitos.");
        }

        if (direccion.getCiudad() == null || direccion.getCiudad().isBlank()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        }

        if (direccion.getEstado() == null || direccion.getEstado().isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        
    }
    
}
