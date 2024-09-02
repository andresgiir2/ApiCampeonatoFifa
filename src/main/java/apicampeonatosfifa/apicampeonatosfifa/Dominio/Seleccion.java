package apicampeonatosfifa.apicampeonatosfifa.Dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="Pais")
public class Seleccion {

    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_seleccion")
    @GenericGenerator(name = "secuencia_seleccion", strategy = "increment")
    private int Id;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Entidad")
    private String Entidad;

    public Seleccion() {
    }

    public Seleccion(int id, String nombre, String entidad) {
        Id = id;
        Nombre = nombre;
        Entidad = entidad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String entidad) {
        Entidad = entidad;
    }

    
}
