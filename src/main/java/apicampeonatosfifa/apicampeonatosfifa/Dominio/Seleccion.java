package apicampeonatosfifa.apicampeonatosfifa.Dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pais")
public class Seleccion {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_seleccion")
    @GenericGenerator(name = "secuencia_seleccion", strategy = "increment")
    private int Id;

    @Column(name = "pais")
    private String nombre;

    @Column(name = "entidad")
    private String Entidad;

    public Seleccion() {
    }

    public Seleccion(int id, String nombre, String entidad) {
        this.Id = id;
        this.nombre = nombre;
        this.Entidad = entidad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String entidad) {
        Entidad = entidad;
    }

    
}
