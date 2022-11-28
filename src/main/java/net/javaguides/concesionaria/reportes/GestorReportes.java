package net.javaguides.concesionaria.reportes;


import java.util.ArrayList;
import java.util.List;
import net.javaguides.concesionaria.GestorVenta;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Personal;
import net.javaguides.hibernate.model.Venta;
import java.text.NumberFormat;
import net.javaguides.hibernate.model.Marca;

public class GestorReportes {

    GenerarReportes pantallaReportesMain;
    GenerarReportesVentasPorEmpleado pantallaReportesVentasPorEmpleado;
    GenerarReporteVentasPorMarca pantallaReportesVentasPorMarca;

    GestorVenta gestorVentas;
    List<List<Object>> dataset;
    GestorHibernate gestorHibernate;
    NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();

    public GestorReportes() {
        pantallaReportesMain = new GenerarReportes();
        pantallaReportesMain.conocerGestor(this);
        pantallaReportesMain.setVisible(true);
        gestorVentas = new GestorVenta();
        gestorVentas.mostrarPantalla(false);
        gestorHibernate = GestorHibernate.getInstancia();
    }

    public void crearReporteVentasPorEmpleado() {
        pantallaReportesVentasPorEmpleado = new GenerarReportesVentasPorEmpleado();
        pantallaReportesVentasPorEmpleado.conocerGestor(this);
        pantallaReportesVentasPorEmpleado.setVisible(true);
    }

    public void exportarReporteVentasPorEmpleado() {
        generarDatasetVentasPorEmpleado();
        List<String> headers = new ArrayList<String>();
        headers.add("Orden");
        headers.add("Nombre empleado");
        headers.add("Documento");
        headers.add("Cantidad de ventas");
        headers.add("Monto total");
        VistaReporte vistaReporte = new VistaReporte(this, dataset, headers);
        vistaReporte.setVisible(true);
    }

    private void generarDatasetVentasPorMarcas() {
        dataset = new ArrayList<List<Object>>();
        List<Marca> listadoMarcas = gestorHibernate.getAllObjects("Marca");
        String fechaDesdeHasta = " v.fecha LIKE '%"+pantallaReportesVentasPorMarca.getAño()+"'";
        for (int i = 0; i < listadoMarcas.size(); i++) {
            int montoTotal = 0;
            System.out.println("Venta as v where v.auto.marca =" + listadoMarcas.get(i).getId() + " AND " + fechaDesdeHasta);
            List<Venta> ventasMarcas = gestorHibernate.getAllObjects("Venta as v where v.auto.marca =" + listadoMarcas.get(i).getId() + " AND " + fechaDesdeHasta);

            if (!ventasMarcas.isEmpty()) {
                List<Object> filaReporte = new ArrayList<>();
                filaReporte.add(i);
                filaReporte.add(listadoMarcas.get(i).toString());
                filaReporte.add(ventasMarcas.size());
                for (int j = 0; j < ventasMarcas.size(); j++) {
                    montoTotal += ventasMarcas.get(j).getTotal();
                }
                filaReporte.add(formatoImporte.format(montoTotal));
                System.out.println(filaReporte);
                dataset.add(filaReporte);
            }

        }
    }
    public void crearReporteVentasPorMarca() {
        pantallaReportesVentasPorMarca = new GenerarReporteVentasPorMarca();
        pantallaReportesVentasPorMarca.conocerGestor(this);
        pantallaReportesVentasPorMarca.setVisible(true);
    }

    public void exportarReporteVentasPorMarca() {
        generarDatasetVentasPorMarcas();
        List<String> headers = new ArrayList<String>();
        headers.add("Orden");
        headers.add("Nombre de Marca");
        headers.add("Cantidad de ventas");
        headers.add("Ganancia Anual");
        VistaReporte vistaReporte = new VistaReporte(this, dataset, headers);
        vistaReporte.setVisible(true);
    }

    private void generarDatasetVentasPorEmpleado() {
        dataset = new ArrayList<List<Object>>();
        List<Personal> listadoEmpleados = gestorHibernate.getAllObjects("Personal");
        //String fechaDesde = "01/01/2000";
        String fechaDesde = pantallaReportesVentasPorEmpleado.getFechaDesde();

        //String fechaHasta = "31/12/2022";        
        String fechaHasta = pantallaReportesVentasPorEmpleado.getFechaHasta();

        String fechaDesdeHasta = "AND v.fecha BETWEEN '" + fechaDesde + "' AND '" + fechaHasta + "'";
        for (int i = 0; i < listadoEmpleados.size(); i++) {
            int montoTotal = 0;
            System.out.println("Venta as v where v.id_vendedor =" + listadoEmpleados.get(i).getId() + " " + fechaDesdeHasta);
            List<Venta> ventasEmpleado = gestorHibernate.getAllObjects("Venta as v where v.vendedor =" + listadoEmpleados.get(i).getId() + " " + fechaDesdeHasta);

            if (!ventasEmpleado.isEmpty()) {
                List<Object> filaReporte = new ArrayList<>();
                filaReporte.add(i);
                filaReporte.add(listadoEmpleados.get(i).toString());
                filaReporte.add(listadoEmpleados.get(i).getDocumento());
                filaReporte.add(ventasEmpleado.size());
                for (int j = 0; j < ventasEmpleado.size(); j++) {
                    montoTotal += ventasEmpleado.get(j).getTotal();
                }
                filaReporte.add(formatoImporte.format(montoTotal));
                System.out.println(filaReporte);
                dataset.add(filaReporte);
            }

        }
    }
    public void mostrarPantallaVPE(boolean b) {
        pantallaReportesVentasPorEmpleado.setVisible(b);
    }
    public void mostrarPantallaVPM(boolean b) {
        pantallaReportesVentasPorMarca.setVisible(b);
    }
    public void mostrarPantalla(boolean b) {
        pantallaReportesMain.setVisible(b);
    }

}
