/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrarCliente;

import dto.ClienteDTO;

/**
 * Interfaz del subsistema AdministrarCliente.
 * Define el contrato para las operaciones relacionadas con la gestión de datos
 * de clientes, permitiendo el desacoplamiento entre la capa de presentación 
 * y la lógica de negocio.
 * * @author regin
 */
public interface IAdministrarCliente {

    /**
     * Registra o actualiza los datos personales de un cliente en el sistema.
     * Este método es invocado principalmente desde el formulario FrmDatosPersonales.
     * * @param cliente Objeto DTO que contiene la información del cliente a guardar.
     */
    public void guardarDatosPersonales(ClienteDTO cliente);

    /**
     * Recupera la información de un cliente específico mediante su identificador.
     * * @param id Identificador único (String) del cliente a consultar.
     * @return Un objeto ClienteDTO con los datos encontrados, o null si no existe.
     */
    public ClienteDTO consultarCliente(String id);
}
