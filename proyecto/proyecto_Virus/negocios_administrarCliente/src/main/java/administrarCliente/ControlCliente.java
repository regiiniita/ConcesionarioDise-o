/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarCliente;

import dto.ClienteDTO;

/**
 * Clase de control interna del subsistema AdministrarCliente.
 * Implementa la lógica de negocio simulada para validar la integración 
 * con la capa de presentación.
 * @author regin
 */
class ControlCliente {
    
    private ClienteDTO cliente;

    /**
     * Constructor por defecto.
     * Su visibilidad es de paquete para restringir el acceso 
     * externo al subsistema.
     */
    protected ControlCliente() {
    }

    /**
     * Simula el guardado de datos personales. 
     * Al ser un Mock, imprime la acción en consola para verificar la invocación.
     * @param cliente DTO con la información a guardar.
     */
    protected ClienteDTO guardarDatosPersonales(ClienteDTO cliente) {
            System.out.println("Guardando datos de: " + cliente.getNombre());
            return this.cliente = cliente;
        
    }

    /**
     * Simula la consulta de un cliente devolviendo datos "quemados" (hardcoded).
     * Esto permite que la capa de presentación reciba información válida para 
     * mostrar en los formularios.
     * @param id Identificador del cliente a consultar.
     * @return Un objeto ClienteDTO con datos de prueba.
     */
    protected ClienteDTO consultarCliente(String id) {
        System.out.println("Consultando información para ID: " + id);
        return cliente;
    }
}