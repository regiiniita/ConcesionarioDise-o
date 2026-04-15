/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarCliente;

import dto.ClienteDTO;

/**
 * Fachada del subsistema AdministrarCliente.
 * Implementa la interfaz IAdministrarCliente y actúa como el único punto de 
 * acceso a la funcionalidad interna del subsistema desde la capa de presentación.
 * @author regin
 */
public class FacadeAdministrarCliente implements IAdministrarCliente {

    /** Referencia a la clase de control interna del subsistema. */
    private ControlCliente control;

    /**
     * Constructor que inicializa la lógica interna del subsistema.
     */
    public FacadeAdministrarCliente() {
        // En un esquema de subsistema, la fachada instancia su propio control
        this.control = new ControlCliente();
    }

    /**
     * Delega la responsabilidad de guardar los datos personales al objeto de control.
     * @param cliente El DTO con la información del cliente.
     */
    @Override
    public ClienteDTO guardarDatosPersonales(ClienteDTO cliente) {
        return this.control.guardarDatosPersonales(cliente);
    }

    /**
     * Delega la consulta de un cliente al objeto de control.
     * @param id Identificador del cliente.
     * @return ClienteDTO con los datos obtenidos.
     */
    @Override
    public ClienteDTO consultarCliente(String id) {
        return this.control.consultarCliente(id);
    }
}
