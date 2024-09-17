package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios;

import java.util.List;


import apicampeonatosfifa.apicampeonatosfifa.Dominio.Seleccion;


public interface ISeleccionServicio {

    public List<Seleccion> Listar();
    public Seleccion Obtener(Integer Id);
    public List<Seleccion> Buscar( String nombre);
    public Seleccion Agregar(Seleccion Pais);
    public Seleccion Modificar(Seleccion Pais);
    public Seleccion Eliminar(Integer Id);
}
