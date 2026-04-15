package controlador;

import administrarCliente.FacadeAdministrarCliente;
import administrarCliente.IAdministrarCliente;
import administrarVehiculo.FacadeAdministrarVehiculo;
import administrarVehiculo.IAdministrarVehiculo;
import dto.ClienteDTO;
import dto.VehiculoDTO;
import java.util.List;
import presentacion.*;

public class Coordinador {
    private PantallaDashboard pantallaDashboard;
    private PantallaFormularioDatosPersonales pantallaFormularioDatosPersonales;
    private PantallaFormularioInformacionFinanciera pantallaFormularioInformacionFinanciera;
    private PantallaCatalogoVehiculos pantallaCatalogoVehiculos;
    private PantallaRevisionSolicitud pantallaRevisionSolicitud;
    private PantallaConfirmacionSolicitud pantallaConfirmacionSolicitud;
    
    // Subsistemas (Atributos de Interface)
    private final IAdministrarCliente administrarCliente;
    private final IAdministrarVehiculo administrarVehiculo;


    public Coordinador() {
        // Se instancian las fachadas
        this.administrarCliente = new FacadeAdministrarCliente();
        this.administrarVehiculo = new FacadeAdministrarVehiculo();
    }
    
    /**
     * Guarda los datos del cliente y los mantiene en memoria para la solicitud.
     * @param cliente
     */
    public void guardarDatosPersonales(ClienteDTO cliente) {
        this.administrarCliente.guardarDatosPersonales(cliente);
        System.out.println("Datos de cliente recibidos y enviados al subsistema.");
    }

    /**
     * Recupera la lista de vehículos del subsistema Mock.
     * @return 
     */
    public List<VehiculoDTO> obtenerVehiculosDisponibles() {
        return this.administrarVehiculo.obtenerCatalogoDisponibles();
    }
    
    public void iniciarSistema(){
        if(this.pantallaDashboard == null){
            this.pantallaDashboard = new PantallaDashboard(this);
        }
        pantallaDashboard.setVisible(true);
    }
    
    public void mostrarFormularioDatosPersonales(){
        if(this.pantallaFormularioDatosPersonales == null){
            this.pantallaFormularioDatosPersonales = new PantallaFormularioDatosPersonales(this);
        }
        pantallaFormularioDatosPersonales.setVisible(true);
    }
    
    public void mostrarFormularioInformacionFinanciera(){
        if(this.pantallaFormularioInformacionFinanciera == null){
            this.pantallaFormularioInformacionFinanciera = new PantallaFormularioInformacionFinanciera(this);
        }
        pantallaFormularioInformacionFinanciera.setVisible(true);
    }
    
    public void mostrarCatalagoVehoculos(){
        if(this.pantallaCatalogoVehiculos == null){
            this.pantallaCatalogoVehiculos = new PantallaCatalogoVehiculos(this);
        }
        pantallaCatalogoVehiculos.setVisible(true);
    }
    
    public void mostrarRevisionSolicitud(){
        if(this.pantallaRevisionSolicitud == null){
            this.pantallaRevisionSolicitud = new PantallaRevisionSolicitud(this);
        }
        pantallaRevisionSolicitud.setVisible(true);
    }
    
    public void mostrarConfirmacionSolicitud(){
        if(this.pantallaConfirmacionSolicitud == null){
            this.pantallaConfirmacionSolicitud = new PantallaConfirmacionSolicitud(this);
        }
        pantallaConfirmacionSolicitud.setVisible(true);
    }
}
