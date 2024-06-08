package apifestivofecha.apifestivofecha.core.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo")
public class TipoFecha {

    @Id
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "tipo", length = 100, unique = false)
    private String tipo;

    public TipoFecha() {
    }

    public TipoFecha(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
