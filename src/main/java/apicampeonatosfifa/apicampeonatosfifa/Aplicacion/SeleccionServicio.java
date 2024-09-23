package apicampeonatosfifa.apicampeonatosfifa.Aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios.ISeleccionRepositorio;
import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.ISeleccionServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Seleccion;

@Service
public class SeleccionServicio implements ISeleccionServicio {


    private ISeleccionRepositorio repositorio;
    
    public SeleccionServicio(ISeleccionRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Seleccion> Listar() {
        return repositorio.findAll();
    }

    @Override
    public Seleccion Obtener(Integer Id) {
        return repositorio.findById(Id).isPresent()? repositorio.findById(Id).get() : null;
    }

    @Override
    public List<Seleccion> Buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public Seleccion Agregar(Seleccion Pais) {
        Pais.setId(0);
        return repositorio.save(Pais);
    }

    @Override
    public Seleccion Modificar(Seleccion Pais) {
        return repositorio.findById(Pais.getId()).isPresent()? repositorio.save(Pais) : null;
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
