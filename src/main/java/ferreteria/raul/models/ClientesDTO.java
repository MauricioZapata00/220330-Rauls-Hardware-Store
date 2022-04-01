package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "clientes")
public class ClientesDTO {

    @Id
    private String id;

    private String nombreCliente;
    private String celularCliente;
    private String cedulaCliente;

    public ClientesDTO() {
    }

    public ClientesDTO(String cedula) {
        this.cedulaCliente = cedula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientesDTO)) return false;
        ClientesDTO that = (ClientesDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNombreCliente(), that.getNombreCliente()) && Objects.equals(getCelularCliente(), that.getCelularCliente()) && Objects.equals(getCedulaCliente(), that.getCedulaCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreCliente(), getCelularCliente(), getCedulaCliente());
    }
}
