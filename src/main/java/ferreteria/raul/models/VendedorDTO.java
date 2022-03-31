package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "vendedores")
public class VendedorDTO {

    @Id
    private String id;

    private String nombreVendedor;
    private String celularVendedor;
    private String cedulaVendedor;

    public VendedorDTO(String cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getCelularVendedor() {
        return celularVendedor;
    }

    public void setCelularVendedor(String celularVendedor) {
        this.celularVendedor = celularVendedor;
    }

    public String getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(String cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendedorDTO)) return false;
        VendedorDTO that = (VendedorDTO) o;
        return getId().equals(that.getId()) && getNombreVendedor().equals(that.getNombreVendedor()) && getCelularVendedor().equals(that.getCelularVendedor()) && getCedulaVendedor().equals(that.getCedulaVendedor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreVendedor(), getCelularVendedor(), getCedulaVendedor());
    }
}
