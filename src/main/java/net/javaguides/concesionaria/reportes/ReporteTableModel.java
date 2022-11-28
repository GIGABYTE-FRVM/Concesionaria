/**
 * Please Visit: Fans Page Facebook: https://web.facebook.com/coverstarcomunity
 * Group Facebook: https://web.facebook.com/groups/454664331926261 Youtube:
 * https://www.youtube.com/channel/UClcEDDeJvnJ69p-n7XsRqHQ Instagram:
 * coverstarstory
 */
package net.javaguides.concesionaria.reportes;

import net.javaguides.concesionaria.herramientas.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.javaguides.hibernate.model.Venta;

/**
 *
 * @author Cover Star
 */
public class ReporteTableModel extends AbstractTableModel {

    List<List<Object>> listReporte;
    private List<String> header;

    public void setList(List<List<Object>> listReporte,Integer rows, Integer page) {
        this.listReporte = listReporte.size()>rows*page?listReporte.subList(rows*page-rows,rows*page):listReporte.subList(rows*page-rows,listReporte.size());
        System.out.println(listReporte);
    }
    public void setHeader(List<String> header){
        this.header = header;
    }
/*
    public void save(Venta venta) {
        listReporte.add(venta);
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
    }*/

    public int getRowCount() {
        
        return listReporte==null?0:listReporte.size();
    }

    public int getColumnCount() {
        return header.size();
    }

    public String getColumnName(int column) {
        return header.get(column);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Object> filaReporte= listReporte.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            default:
                return filaReporte.get(columnIndex);
        }
        
    }
}
