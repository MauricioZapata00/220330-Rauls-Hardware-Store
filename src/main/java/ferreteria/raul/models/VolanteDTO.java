package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Objects;

@Document(collection = "volantes")
public class VolanteDTO {

    @Id
    private String id;

    private String fecha;
    private String NITProveedor;
    private String nombreProveedor;
    private HashMap<String, Integer> productosAIngresar;

    public VolanteDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNITProveedor() {
        return NITProveedor;
    }

    public void setNITProveedor(String NITProveedor) {
        this.NITProveedor = NITProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public HashMap<String, Integer> getProductosAIngresar() {
        return productosAIngresar;
    }

    public void setProductosAIngresar(HashMap<String, Integer> productosAIngresar) {
        this.productosAIngresar = productosAIngresar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VolanteDTO)) return false;
        VolanteDTO that = (VolanteDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFecha(), that.getFecha()) && Objects.equals(getNITProveedor(), that.getNITProveedor()) && Objects.equals(getNombreProveedor(), that.getNombreProveedor()) && Objects.equals(getProductosAIngresar(), that.getProductosAIngresar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha(), getNITProveedor(), getNombreProveedor(), getProductosAIngresar());
    }
}
