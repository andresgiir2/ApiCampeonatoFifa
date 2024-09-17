package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Ciudad;

@Repository
public interface ICiudadRepositorio extends JpaRepository<Ciudad, Integer>{

}