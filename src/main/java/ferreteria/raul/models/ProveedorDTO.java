package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "proveedores")
public class ProveedorDTO {

    @Id
    private String id;

    private String nombreProveedor;
    private String celularProveedor;
    private String NIT;

    public ProveedorDTO() {
    }

    public ProveedorDTO(String NIT) {
        this.NIT = NIT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreCliente) {
        this.nombreProveedor = nombreCliente;
    }

    public String getCelularProveedor() {
        return celularProveedor;
    }

    public void setCelularProveedor(String celularCliente) {
        this.celularProveedor = celularCliente;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProveedorDTO)) return false;
        ProveedorDTO that = (ProveedorDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(nombreProveedor, that.nombreProveedor) && Objects.equals(celularProveedor, that.celularProveedor) && Objects.equals(getNIT(), that.getNIT());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), nombreProveedor, celularProveedor, getNIT());
    }
}
