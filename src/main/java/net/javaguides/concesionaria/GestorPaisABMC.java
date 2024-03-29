package net.javaguides.concesionaria;

import java.awt.Color;
import net.javaguides.concesionaria.herramientas.Notificador;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Pais;
import net.javaguides.hibernate.model.Region;

public class GestorPaisABMC {
    
    private int ultimoIdPais;
    List<Region> listaRegiones;
    private List<Pais> listaPaises;
    GestorRegionABMC gestorRegion;
    GestorHibernate gestorHibernate;
    GestorMarcaABMC gestorMarca;
    Notificador notificador;
    Color disableColor = new Color(153,153,153);

    PaisABMC pantallaPais;

    public GestorPaisABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
        gestorRegion = new GestorRegionABMC();
        gestorRegion.conocerGestorPais(this);
        gestorRegion.mostrarPantalla(false);
        pantallaPais = new PaisABMC(this);
    }

    public void registrarPais() {
        String nombre = pantallaPais.getTxtNombre();
        Region region = pantallaPais.getRegion();
        Pais paisObject = new Pais(nombre, region);
        if (esValido(paisObject, 0)) {
            gestorHibernate.saveObject(paisObject);
            pantallaPais.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaPais.setAlwaysOnTop(true);
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
        pantallaPais.setAlwaysOnTop(true);

    }

    public void modificarPais() {
        Pais paisObject;
        paisObject = pantallaPais.getPais();
        paisObject.setNombre(pantallaPais.getTxtNombre());
        paisObject.setRegion(pantallaPais.getRegion());
        if (esValido(paisObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(paisObject);
            pantallaPais.setAlwaysOnTop(false);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
        pantallaPais.setAlwaysOnTop(true);

    }

    public void conocerPaises() {
        listaPaises = gestorHibernate.getAllObjects("Pais");
    }

    public void conocerRegiones() {
        if (!(listaRegiones == null)) {
            listaRegiones.clear();
        }
        listaRegiones = gestorRegion.conocerListRegiones();
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerPaises();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Region");
        Object data[] = new Object[3];
        try {
            for (Pais pais : listaPaises) {
                data[0] = Integer.toString(pais.getId());
                data[1] = pais;
                data[2] = pais.getRegion().getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void eliminarPais() {
        Pais paisObject = pantallaPais.getPais();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este pais?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(paisObject);
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    void mostrarRegionesABMC() {
        gestorRegion.mostrarPantalla(true);
        gestorRegion.notificarGestor(this);
        solicitarActualizacionRegiones();
    }

    void actualizarComboRegiones() {
        pantallaPais.actualizarComboRegiones();
    }

    synchronized void solicitarActualizacionRegiones() {
        notificador = new Notificador();
        new Thread(() -> {
            notificador.solicitar();
        }).start();
    }

    public void notificarGestor(GestorMarcaABMC gestorSubscrito) {
        this.gestorMarca = gestorSubscrito;
    }

    public List<Pais> conocerListPaises() {
        conocerPaises();
        return listaPaises;
    }

    public synchronized void notificarSubscriptores() {
        if (!(gestorMarca == null)) {
            gestorMarca.notificarActualizacionPaises();
        }
    }

    public void conocerGestorMarca(GestorMarcaABMC gestorMarca) {
        this.gestorMarca = gestorMarca;
    }

    public boolean esValido(Pais pais, int tipo) {
        if (pais.getNombre().length() == 0) {
            return false;
        }
        if (tipo == 0) {
            for (Pais paisOfList : listaPaises) {
                if (paisOfList.getNombre().equalsIgnoreCase(pais.getNombre())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarPantalla() {
        pantallaPais.setVisible(true);
    }

    void notificarActualizacionRegiones() {
        new Thread(() -> {
            notificador.entregar();
            conocerRegiones();
            pantallaPais.actualizarComboRegiones();
        }).start();
    }

    void mostrarPaisABMC() {
        gestorRegion.mostrarPantalla(true);
    }

    public int conocerUltimoIdPais() {
        conocerPaises();
        if (listaPaises.isEmpty()) {
            ultimoIdPais = 0;
        } else {
            Optional<Integer> maximoId = listaPaises.stream()
                    .map(Pais::getId)
                    .max(Integer::compare);

            ultimoIdPais = maximoId.get();
        }

        return ultimoIdPais + 1;
    }
    
    public boolean validarCamposVacios(JTextField txtNombre) {
        if(txtNombre.getForeground().equals(disableColor)) {
            return false;
        }else {
            return validarCamposTexto(txtNombre.getText());
        }
    }
    
    public boolean validarCamposTexto(String campoTexto) {
        campoTexto = campoTexto.toUpperCase();
        return campoTexto.matches("[A-Z]*");
    }
}
