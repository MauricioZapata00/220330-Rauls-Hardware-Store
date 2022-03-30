package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class ProveedorDTO {

    @Id
    private String id;

    private String nombreProveedor;
    private String celularProveedor;
    private String NIT;

    public ProveedorDTO(String NIT) {
        this.NIT = NIT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreProveedor;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreProveedor = nombreCliente;
    }

    public String getCelularCliente() {
        return celularProveedor;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularProveedor = celularCliente;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}
