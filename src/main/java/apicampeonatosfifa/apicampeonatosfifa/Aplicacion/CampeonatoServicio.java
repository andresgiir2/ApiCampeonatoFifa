package apicampeonatosfifa.apicampeonatosfifa.Aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios.ICampeonatoRepositorio;
import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.ICampeonatoServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Campeonato;

@Service
public class CampeonatoServicio implements ICampeonatoServicio{

    private ICampeonatoRepositorio repositorio;
    
    public CampeonatoServicio(ICampeonatoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Campeonato> Listar() {
        return repositorio.findAll();
    }

    @Override
    public Campeonato Obtener(Integer Id) {
        return repositorio.findById(Id).isPresent()? repositorio.findById(Id).get() : null;
    }

    @Override
    public List<Campeonato> Buscar(String nombre) {
        return repositorio.Buscar(nombre);
    }

    @Override
    public Campeonato Agregar(Campeonato campeonato) {
        campeonato.setId(0);
        var CampeonatoGuardado = repositorio.save(campeonato);
        return Obtener(CampeonatoGuardado.getId());

    }

    @Override
    public Campeonato Modificar(Campeonato campeonato) {
        return repositorio.findById(campeonato.getId()).isPresent()? repositorio.save(campeonato) : null;
    }

    @Override
    public boolean Eliminar(Integer Id) {
        if (repositorio.findById(Id).isPresent()) {
            try{
                repositorio.deleteById(Id);
                return true;

            }catch(Exception ex){

            }
            
        }
        return false;       
    }

}
