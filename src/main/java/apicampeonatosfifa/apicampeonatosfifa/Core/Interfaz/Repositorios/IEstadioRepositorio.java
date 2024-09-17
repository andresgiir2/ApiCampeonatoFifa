package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Estadio;


@Repository
public interface IEstadioRepositorio extends JpaRepository<Estadio, Integer>{

}
