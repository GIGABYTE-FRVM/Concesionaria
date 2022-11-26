/**
 * Please Visit: Fans Page Facebook: https://web.facebook.com/coverstarcomunity
 * Group Facebook: https://web.facebook.com/groups/454664331926261 Youtube:
 * https://www.youtube.com/channel/UClcEDDeJvnJ69p-n7XsRqHQ Instagram:
 * coverstarstory
 */
package net.javaguides.concesionaria.herramientas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Venta;

/**
 *
 * @author Cover Star
 */
public class AutoTableModel extends AbstractTableModel {

    List<Auto> listAutos = new ArrayList<Auto>();
    private final String HEADER[] = {"#","id", "Marca", "Modelo", "AnoFabricacion", "Combustible","Color","Precio"};

    public void setList(List<Auto> listVenta) {
        this.listAutos = listVenta;
    }

    public void save(Auto auto) {
        listAutos.add(auto);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Auto auto) {
        listAutos.set(index, auto);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listAutos.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Auto findOne(int index) {
        return listAutos.get(index);
    }

    public int getRowCount() {
        
        return listAutos==null?0:listAutos.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    public String getColumnName(int column) {
        return HEADER[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = listAutos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return auto.getId();
            case 2:
                return auto.getMarca();
            case 3:
                return auto.getModelo();
            case 4:
                return auto.getAñoFabricacion();
            case 5:
                return auto.getCombustible();
            case 6:
                return auto.getColor();
            case 7:
                return auto.getPrecio();

            default:
                return null;
        }
    }
}
