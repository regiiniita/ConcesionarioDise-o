package controlador;

import presentacion.*;

public class Coordinador {
    private PantallaDashboard pantallaDashboard;
    private PantallaFormularioDatosPersonales pantallaFormularioDatosPersonales;
    private PantallaFormularioInformacionFinanciera pantallaFormularioInformacionFinanciera;
    private PantallaCatalogoVehiculos pantallaCatalogoVehiculos;
    private PantallaRevisionSolicitud pantallaRevisionSolicitud;
    private PantallaConfirmacionSolicitud pantallaConfirmacionSolicitud;
    
    public Coordinador(){
        
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
