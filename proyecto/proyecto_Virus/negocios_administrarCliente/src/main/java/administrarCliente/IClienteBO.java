/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administrarCliente;

import dto.ClienteDTO;

/**
 *
 * @author regina, mariana, ernesto, isaac y luis
 */
public interface IClienteBO {
    
    ClienteDTO guardarDatosPersonales(ClienteDTO cliente);
    
    ClienteDTO consultarCliente(String id);
    
}
