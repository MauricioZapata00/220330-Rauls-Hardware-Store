package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Document(collection = "facturas")
public class FacturaDTO {

    @Id
    private String id;

    private Long incrementable;
    private String fecha;
    private HashMap<String, Integer> productos;
    private String nombreVendedor;
    private String nombreCliente;
    private Double totalAPagar;

    public FacturaDTO(Long incrementable) {
        this.incrementable = incrementable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIncrementable() {
        return incrementable;
    }

    public void setIncrementable(Long incrementable) {
        this.incrementable = incrementable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public HashMap<String, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Integer> productos) {
        this.productos = productos;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacturaDTO)) return false;
        FacturaDTO that = (FacturaDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getIncrementable(), that.getIncrementable()) && Objects.equals(getFecha(), that.getFecha()) && Objects.equals(getProductos(), that.getProductos()) && Objects.equals(getNombreVendedor(), that.getNombreVendedor()) && Objects.equals(getNombreCliente(), that.getNombreCliente()) && Objects.equals(getTotalAPagar(), that.getTotalAPagar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIncrementable(), getFecha(), getProductos(), getNombreVendedor(), getNombreCliente(), getTotalAPagar());
    }
}
