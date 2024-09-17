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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Obtener'");
    }

    @Override
    public List<Seleccion> Buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public Seleccion Agregar(Seleccion Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Agregar'");
    }

    @Override
    public Seleccion Modificar(Seleccion Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Modificar'");
    }

    @Override
    public Seleccion Eliminar(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Eliminar'");
    }



}
