package ferreteria.raul.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "productos")
public class ProductoDTO {

    @Id
    private String id;

    private String nombreProducto;
    private Integer cantidad;
    private Double precio;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombreProducto, Double precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoDTO)) return false;
        ProductoDTO that = (ProductoDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNombreProducto(), that.getNombreProducto()) && Objects.equals(getCantidad(), that.getCantidad()) && Objects.equals(getPrecio(), that.getPrecio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreProducto(), getCantidad(), getPrecio());
    }
}
