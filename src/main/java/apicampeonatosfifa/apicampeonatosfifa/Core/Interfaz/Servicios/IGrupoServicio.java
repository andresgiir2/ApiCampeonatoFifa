package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios;

import java.util.List;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Grupo;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.TablaPosicionesDTO;

public interface IGrupoServicio {

    public List<Grupo> Listar();
    public Grupo Obtener(Integer Id);
    public List<Grupo> Buscar( String nombre);
    public Grupo Agregar(Grupo Pais);
    public Grupo Modificar(Grupo Pais);
    public boolean Eliminar(Integer Id);
    public List<TablaPosicionesDTO> obtenerPosiciones(int id);
    
}
