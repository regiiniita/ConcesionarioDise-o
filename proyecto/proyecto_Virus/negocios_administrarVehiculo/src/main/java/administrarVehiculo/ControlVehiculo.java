/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarVehiculo;

import dto.VehiculoDTO;
import enums.EstadoVehiculoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Control interno que simula el catálogo de vehículos con el nuevo constructor.
 * @author regina
 */
class ControlVehiculo {

    protected ControlVehiculo() {}

    protected List<VehiculoDTO> obtenerCatalogoDisponibles() {
        List<VehiculoDTO> catalogo = new ArrayList<>();
        
        catalogo.add(new VehiculoDTO(
            "HON7890123456",        
            "Honda",                
            "CR-V EX-L",            
            2024,                  
            589000.0,              
            EstadoVehiculoDTO.DISPONIBLE             
        ));

        catalogo.add(new VehiculoDTO(
            "TOY1234567890", 
            "Toyota", 
            "RAV4", 
            2024, 
            610000.0, 
            EstadoVehiculoDTO.DISPONIBLE     
        ));

        catalogo.add(new VehiculoDTO(
            "MAZ4567890123", 
            "Mazda", 
            "CX-5", 
            2023, 
            550000.0, 
            EstadoVehiculoDTO.DISPONIBLE     
        ));
        
        catalogo.add(new VehiculoDTO(
            "NISS9876543210", 
            "Nissan", 
            "Versa Advance", 
            2023, 
            340000.0, 
            EstadoVehiculoDTO.DISPONIBLE  
        ));

        catalogo.add(new VehiculoDTO(
            "BMW1122334455", 
            "BMW", 
            "X3 xDrive30i", 
            2024, 
            1250000.0, 
            EstadoVehiculoDTO.DISPONIBLE  
        ));

        catalogo.add(new VehiculoDTO(
            "FORD5566778899", 
            "Ford", 
            "Ranger XLT", 
            2024, 
            785000.0, 
            EstadoVehiculoDTO.DISPONIBLE  
        ));

        catalogo.add(new VehiculoDTO(
            "SEAT3344556677", 
            "SEAT", 
            "Ibiza FR", 
            2023, 
            415000.0, 
            EstadoVehiculoDTO.DISPONIBLE  
        ));

        catalogo.add(new VehiculoDTO(
            "TESL9988776655", 
            "Tesla", 
            "Model 3", 
            2024, 
            899000.0, 
            EstadoVehiculoDTO.DISPONIBLE  
        ));

        System.out.println("Catálogo cargado con " + catalogo.size() + " vehículos.");
        return catalogo;
    }
}