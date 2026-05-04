/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarVehiculo;

import dto.VehiculoDTO;
import enums.EstadoVehiculoDTO;
import java.time.Year;

/**
 * Clase utilitaria encargada de centralizar las validaciones de negocio 
 * para el subsistema de Vehículos.
 * 
 * Valida la integridad de los datos del vehículo, asegurando que los campos
 * obligatorios estén presentes, que los valores sean coherentes y que el estado
 * del vehículo sea válido dentro del flujo del sistema.
 * 
 * @author regina, mariana, ernesto, isaac y luis
 */
public class ValidadorVehiculo {

    /**
     * Valida los datos de un vehículo.
     * 
     * Verifica que la serie, marca, modelo, año, precio y estado cumplan
     * con las reglas de negocio establecidas.
     * 
     * @param vehiculo El objeto VehiculoDTO que contiene los datos a validar.
     * @throws IllegalArgumentException Si alguna validación falla.
     */
    public void validarVehiculo(VehiculoDTO vehiculo) {

        if (vehiculo == null) {
            throw new IllegalArgumentException("Los datos del vehículo son obligatorios.");
        }

        if (vehiculo.getSerie() == null || vehiculo.getSerie().isBlank()) {
            throw new IllegalArgumentException("La serie del vehículo no puede estar vacía.");
        }

        if (vehiculo.getSerie().length() != 17) {
            throw new IllegalArgumentException("La serie del vehículo debe contener 17 caracteres.");
        }

        if (vehiculo.getMarca() == null || vehiculo.getMarca().isBlank()) {
            throw new IllegalArgumentException("La marca del vehículo no puede estar vacía.");
        }

        if (vehiculo.getModelo() == null || vehiculo.getModelo().isBlank()) {
            throw new IllegalArgumentException("El modelo del vehículo no puede estar vacío.");
        }

        int anioActual = Year.now().getValue();

        if (vehiculo.getAnio() < 1980 || vehiculo.getAnio() > anioActual + 1) {
            throw new IllegalArgumentException("El año del vehículo no es válido.");
        }

        if (vehiculo.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del vehículo debe ser mayor a 0.");
        }

        if (vehiculo.getEstado() == null) {
            throw new IllegalArgumentException("El estado del vehículo es obligatorio.");
        }

        if (vehiculo.getEstado() == EstadoVehiculoDTO.ENTREGADO) {
            throw new IllegalArgumentException("No se puede registrar un vehículo como ENTREGADO directamente.");
        }

        boolean estadoValido = vehiculo.getEstado() == EstadoVehiculoDTO.DISPONIBLE
                || vehiculo.getEstado() == EstadoVehiculoDTO.RESERVADO
                || vehiculo.getEstado() == EstadoVehiculoDTO.ENTREGADO;

        if (!estadoValido) {
            throw new IllegalArgumentException("El estado del vehículo no es válido.");
        }
    }
}