package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Grupo;

@Repository
public interface IGrupoRepositorio extends JpaRepository<Grupo, Integer>{

    @Query("SELECT g FROM Campeonato g WHERE LOWER(g.nombre) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<Grupo> Buscar(String nombre);
}
