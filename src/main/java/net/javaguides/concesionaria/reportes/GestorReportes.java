package net.javaguides.concesionaria.reportes;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.WindowConstants;
import net.bytebuddy.description.method.MethodDescription.TypeToken;
import net.javaguides.concesionaria.GestorVenta;
import net.javaguides.hibernate.model.Personal;
import net.javaguides.hibernate.model.Venta;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GestorReportes {

    GenerarReportes pantallaReportesMain;
    GenerarReportes1 pantallaReportesVentasPorEmpleado;
    GestorVenta gestorVentas;

    public void exportarReporteEmpleados() throws IOException {
        try {
            
            
            JasperReport report = (JasperReport) JRLoader.loadObject(GestorReportes.class.getResource("ReporteVentasPorEmpleado.jasper"));
            System.out.print("Cargando... 1");
            JasperPrint jprint = JasperFillManager.fillReport(report, null, VentasDataSource.getDataSource());

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            

        } catch (JRException ex) {
            ex.getMessage();
        }
    }
    public void exportarReporteOtro() throws IOException {
        try {
            
            
            JasperReport report = (JasperReport) JRLoader.loadObject(GestorReportes.class.getResource("ReporteVentas.jasper"));
            System.out.print("Cargando... 2");
            
            
            List<Venta> reporteVentas = gestorVentas.conocerVentas();
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteVentas.toArray());
            Map<String, Object> parameters = new HashMap();
            parameters.put("ds", ds);
            JasperPrint jprint = JasperFillManager.fillReport(report, null, VentasDataSource.getDataSource());

            JasperViewer view = new JasperViewer(jprint, true);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

            
        } catch (JRException ex) {
            ex.getMessage();
        }
    }

    public GestorReportes() {
        pantallaReportesMain = new GenerarReportes();
        pantallaReportesMain.conocerGestor(this);
        pantallaReportesMain.setVisible(true);
        gestorVentas = new GestorVenta();
    }

    public void crearReporteVentasPorEmpleado() {
        pantallaReportesVentasPorEmpleado = new GenerarReportes1();
        pantallaReportesVentasPorEmpleado.conocerGestor(this);
        pantallaReportesVentasPorEmpleado.setVisible(true);
    }

}
