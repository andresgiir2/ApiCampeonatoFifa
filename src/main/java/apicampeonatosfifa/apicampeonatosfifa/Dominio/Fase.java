package apicampeonatosfifa.apicampeonatosfifa.Dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "fase")
public class Fase {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fase", nullable = false)
    private String nombre;

    public Fase() {
    }

    public Fase(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}