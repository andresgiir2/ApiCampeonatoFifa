package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import java.util.Objects;

public class GrupoPaisId {

    private int grupo; // Cambiado a 'grupo' para coincidir con el nombre de la propiedad ManyToOne
    private int pais;  // Cambiado a 'pais' para coincidir con la propiedad ManyToOne

    // Constructor vacío
    public GrupoPaisId() {}

    // Constructor con parámetros
    public GrupoPaisId(int grupo, int pais) {
        this.grupo = grupo;
        this.pais = pais;
    }

    // Getters y Setters
    public int getGrupo() {
        return grupo; 
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoPaisId that = (GrupoPaisId) o;
        return grupo == that.grupo && pais == that.pais;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo, pais);
    }

}