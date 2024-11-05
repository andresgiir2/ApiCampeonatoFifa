package apicampeonatosfifa.apicampeonatosfifa.Aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios.IGrupoRepositorio;
import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.IGrupoServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Grupo;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.TablaPosicionesDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class GrupoServicio implements IGrupoServicio {

    private IGrupoRepositorio repositorio;

    @PersistenceContext
    private EntityManager em;

    public GrupoServicio(IGrupoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Grupo> Listar() {
        return repositorio.findAll();
    }

    @Override
    public Grupo Obtener(Integer Id) {
        return repositorio.findById(Id).isPresent() ? repositorio.findById(Id).get() : null;
    }

    @Override
    public List<Grupo> Buscar(String nombre) {
        return repositorio.Buscar(nombre);
    }

    @Override
    public Grupo Agregar(Grupo Pais) {
        Pais.setId(0);
        var PaisGuardado = repositorio.save(Pais);
        return Obtener(PaisGuardado.getId());
    }

    @Override
    public Grupo Modificar(Grupo Pais) {
        return repositorio.findById(Pais.getId()).isPresent() ? repositorio.save(Pais) : null;
    }

    @Override
    public boolean Eliminar(Integer Id) {
        if (repositorio.findById(Id).isPresent()) {
            try {
                repositorio.deleteById(Id);
                return true;

            } catch (Exception ex) {

            }

        }
        return false;
    }

    @Override
    public List<TablaPosicionesDTO> obtenerPosiciones(int id) {

        List<TablaPosicionesDTO> tablaPosiciones = em
                .createNativeQuery("Select * From fTablaPosicionesGrupo(:idgrupotabla)", TablaPosicionesDTO.class)
                .setParameter("idgrupotabla", id)
                .getResultList();

        return tablaPosiciones;
    }
}
