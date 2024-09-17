package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Encuentro;

@Repository
public interface IEncuentroRepositorio extends JpaRepository<Encuentro, Integer>{

}
