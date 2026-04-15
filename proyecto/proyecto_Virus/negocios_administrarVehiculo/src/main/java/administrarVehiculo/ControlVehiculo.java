/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarVehiculo;

import dto.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Control interno que simula el catálogo de vehículos (Mock).
 */
class ControlVehiculo {

    protected ControlVehiculo() {}

    /**
     * Devuelve una lista simulada que incluye el vehículo del escenario.
     */
    protected List<VehiculoDTO> obtenerCatalogoDisponibles() {
        System.out.println("Cargando catálogo de vehículos...");
        List<VehiculoDTO> catalogo = new ArrayList<>();
        
        // Datos del escenario: Honda CR-V EX-L 2024 ($589,000)
        catalogo.add(new VehiculoDTO(101, "Honda", "CR-V EX-L 2024", 589000.0));

        
        return catalogo;
    }
}