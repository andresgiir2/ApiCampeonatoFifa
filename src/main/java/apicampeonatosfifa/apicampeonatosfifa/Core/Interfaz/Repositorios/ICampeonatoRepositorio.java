package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Campeonato;

@Repository
public interface ICampeonatoRepositorio extends JpaRepository<Campeonato, Integer>{

     @Query("SELECT c FROM Campeonato c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<Campeonato> Buscar(String nombre);
}
