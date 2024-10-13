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
public class GrupoServicio implements IGrupoServicio{

    private IGrupoRepositorio repositorio;

    @PersistenceContext
    private EntityManager em;

    public GrupoServicio(IGrupoRepositorio repositorio){
        this.repositorio = repositorio;
    }


    @Override
    public List<Grupo> Listar() {
        return repositorio.findAll();
    }

    @Override
    public Grupo Obtener(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Obtener'");
    }

    @Override
    public List<Grupo> Buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public Grupo Agregar(Grupo Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Agregar'");
    }

    @Override
    public Grupo Modificar(Grupo Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Modificar'");
    }

    @Override
    public boolean Eliminar(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Eliminar'");
    }

   

    @Override
    public List<TablaPosicionesDTO> obtenerPosiciones(int id){

        List<TablaPosicionesDTO> tablaPosiciones = em
                .createNativeQuery("Select * From fTablaPosicionesGrupo(:idgrupotabla)", TablaPosicionesDTO.class)
                .setParameter("idgrupotabla", id)
                .getResultList();


        return tablaPosiciones;
    }
}
