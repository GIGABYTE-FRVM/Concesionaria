
package net.javaguides.concesionaria.reportes;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class VentasDataSource implements JRDataSource{
    private final Object [][] listadoVentasPorEmpleado;
    private int index; 
    
    @Override
    public boolean next() throws JRException {
        index++;
        return(index < listadoVentasPorEmpleado.length);
    }
    
    public VentasDataSource(){
        index=-1;
        listadoVentasPorEmpleado = new Object [][]{{1,"Matias Arias","43132313",10,10}};
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        
        String fieldName = jrf.getName();
        
        switch(fieldName){
            
            case "orden":
                value = listadoVentasPorEmpleado[index][0];
            break;
            
            case "nombre":
                value = listadoVentasPorEmpleado[index][1];                
            break;
            case "nombreCompleto":
                value = listadoVentasPorEmpleado[index][1];                
            break;
            
            case "documento":
                value = listadoVentasPorEmpleado[index][2];                
            break;
            
            case "cantidadDeVentas":
                value = listadoVentasPorEmpleado[index][3];                
            break;
            
            case "montoTotal":
                value = listadoVentasPorEmpleado[index][3];                
            break;
            
        }
        
        return value;
    }
    
    public static JRDataSource getDataSource(){
        return new VentasDataSource();
    }
}
