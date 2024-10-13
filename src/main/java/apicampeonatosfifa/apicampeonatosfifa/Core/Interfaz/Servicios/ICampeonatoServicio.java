package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios;

import java.util.List;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Campeonato;

public interface ICampeonatoServicio {

    public List<Campeonato> Listar();
    public Campeonato Obtener(Integer Id);
    public List<Campeonato> Buscar( String nombre);
    public Campeonato Agregar(Campeonato Pais);
    public Campeonato Modificar(Campeonato Pais);
    public boolean Eliminar(Integer Id);
}
