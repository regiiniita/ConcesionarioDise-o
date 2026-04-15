/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarVehiculo;

import dto.VehiculoDTO;
import java.util.List;

/**
 * Interfaz para el subsistema de gestión de vehículos.
 */
public interface IAdministrarVehiculo {
    /**
     * Obtiene la lista de vehículos disponibles en el catálogo.
     * @return Lista de objetos VehiculoDTO.
     */
    public List<VehiculoDTO> obtenerCatalogoDisponibles();
}