package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "volantes")
public class VolanteDTO {

    @Id
    private String id;

    private String fecha;
    private String NITProveedor;
    private String nombreProveedor;
    private HashMap<String, Integer> productosAIngresar;

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
}
