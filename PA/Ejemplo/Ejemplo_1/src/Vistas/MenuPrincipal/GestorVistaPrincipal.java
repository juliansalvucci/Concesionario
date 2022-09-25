package Vistas.MenuPrincipal;
import Vistas.Concesionario.GestorVistaCliente;
import Vistas.Concesionario.GestorVistaMarca;
import Vistas.Concesionario.GestorVistaModelo;
import Vistas.GestorVista;
import Vistas.GestionProyecto.GestorVistaProyecto;
import Vistas.GestionProyecto.GestorVistaTipoProyecto;
import javax.swing.JDesktopPane;

public class GestorVistaPrincipal extends GestorVista{
    public FrmPrincipal frmPrincipal;

    ////////////////////////////////////////////////////////////////
    public void abrirPrincipal() {
        FrmPrincipal frmPrincipal = new FrmPrincipal(this);
        frmPrincipal.setVisible(true);
    }

       
    
    public void abrirProyecto(JDesktopPane escritorio ) {
        GestorVistaProyecto gestor= new GestorVistaProyecto();
        gestor.openFormulario(escritorio);
    }

    public  void abrirTipoProyecto(JDesktopPane escritorio) {
        GestorVistaTipoProyecto gestor= new GestorVistaTipoProyecto();
        gestor.openFormulario(escritorio); 
    }
    
    
    public  void abrirMarca(JDesktopPane escritorio) {
        GestorVistaMarca gestor= new GestorVistaMarca();
        gestor.openFormulario(escritorio); 
    }
    
    public  void abrirModelo(JDesktopPane escritorio) {
        GestorVistaModelo gestor= new GestorVistaModelo();
        gestor.openFormulario(escritorio); 
    }
    
    public  void abrirCliente(JDesktopPane escritorio) {
        GestorVistaCliente gestor= new GestorVistaCliente();
        gestor.openFormulario(escritorio); 
    }

}
