package apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TablaPosicionesDTO {

    @Id
    private int id;
    private String pais;
    private int pj;
    private int pg;
    private int pe;
    private int pp;
    private int gf;
    private int gc;
    private int puntos;




    
    public int getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public int getPj() {
        return pj;
    }

    public int getPg() {
        return pg;
    }

    public int getPe() {
        return pe;
    }

    public int getPp() {
        return pp;
    }

    public int getGf() {
        return gf;
    }

    public int getGc() {
        return gc;
    }

    public int getPuntos() {
        return puntos;
    }

    public TablaPosicionesDTO() {
    }

    public TablaPosicionesDTO(int id, String pais, int pj, int pg, int pe, int pp, int gf, int gc, int puntos) {
        this.id = id;
        this.pais = pais;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.puntos = puntos;
    }

    
}
