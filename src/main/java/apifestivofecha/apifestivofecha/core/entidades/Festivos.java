package apifestivofecha.apifestivofecha.core.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="festivo")
public class Festivos {
    
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "dia", nullable = false)
    private int dia;

    @Column(name = "mes", nullable = false)
    private int mes;

    @Column(name = "diaspascua", nullable = false)
    private int diaspascua;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private TipoFecha tipo;

    public Festivos() {
    }

    public Festivos(int id, String nombre, int dia, int mes, TipoFecha tipo, int diaspascua) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.tipo = tipo;
        this.diaspascua = diaspascua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public TipoFecha getTipo() {
        return tipo;
    }

    public void setTipo(TipoFecha tipo) {
        this.tipo = tipo;
    }

    public int getDiaspascua() {
        return diaspascua;
    }

    public void setDiaspascua(int diaspascua) {
        this.diaspascua = diaspascua;
    }
    
}
