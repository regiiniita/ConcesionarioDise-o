/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarVehiculo;

import dto.VehiculoDTO;
import java.util.List;

/**
 * Fachada que expone los servicios del subsistema de vehículos.
 */
public class FacadeAdministrarVehiculo implements IAdministrarVehiculo {
    private ControlVehiculo control;

    public FacadeAdministrarVehiculo() {
        this.control = new ControlVehiculo();
    }

    @Override
    public List<VehiculoDTO> obtenerCatalogoDisponibles() {
        return this.control.obtenerCatalogoDisponibles();
    }
}