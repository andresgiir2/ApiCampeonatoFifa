package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.GrupoPais;

@Repository
public interface IGrupoPaisRepositorio extends JpaRepository<GrupoPais, GrupoPaisId>{

}

