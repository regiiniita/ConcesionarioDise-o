package inicio;

import controlador.Coordinador;

public class InicioAplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Configuramos el LookAndFeel para que se vea "bonita" (System Look)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { /* Ignorar si falla */ }

        // Iniciamos el Coordinador
        Coordinador coordinador = new Coordinador();
        
        // Abrimos la pantalla inicial
        coordinador.iniciarSistema();
    }
    
}
