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
import net.javaguides.hibernate.model.Venta;

/**
 *
 * @author Cover Star
 */
public class VentaTableModel extends AbstractTableModel {

    List<Venta> listVenta = new ArrayList<Venta>();
    private final String HEADER[] = {"#","ID", "Fecha", "Hora", "Vendedor", "Cliente","Auto","Precio","Impuesto","Cantidad","Ganancia","Total"};

    public void setList(List<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    public void save(Venta venta) {
        listVenta.add(venta);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Venta venta) {
        listVenta.set(index, venta);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listVenta.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Venta findOne(int index) {
        return listVenta.get(index);
    }

    public int getRowCount() {
        
        return listVenta==null?0:listVenta.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    public String getColumnName(int column) {
        return HEADER[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta venta = listVenta.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return venta.getId();
            case 2:
                return venta.getFecha();
            case 3:
                return venta.getHora();
            case 4:
                return venta.getVendedor();
            case 5:
                return venta.getCliente();
            case 6:
                return venta.getAuto();
            case 7:
                return venta.getPrecio();
            case 8:
                return venta.getImpuesto();
            case 9:
                return venta.getCantidad();
            case 10:
                return venta.getGanancia();
            case 11:
                return venta.getTotal();

            default:
                return null;
        }
    }
}
