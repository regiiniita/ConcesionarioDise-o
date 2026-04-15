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
    protected void guardarDatosPersonales(ClienteDTO cliente) {
        if (cliente != null) {
            // Simula la validación de los datos de entrada del escenario
            System.out.println("[MOCK] Guardando datos de: " + cliente.getNombre());
            System.out.println("[MOCK] RFC registrado: " + cliente.getRfc());
            System.out.println("[MOCK] Domicilio registrado: " + cliente.getDireccion());
        }
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
        
        ClienteDTO juan = new ClienteDTO();
        juan.setIdCliente(id);
        // Datos obtenidos de las especificaciones del escenario
        juan.setNombre("Juan García Pérez");
        juan.setRfc("GAPR900101XXX");
        juan.setDireccion("Calle Principal 123, Colonia Centro, CDMX");
        
        return juan;
    }
}