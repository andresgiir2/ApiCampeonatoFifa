package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios;

import java.util.List;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Usuario;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.UsuarioLoginDTO;

public interface IUsuarioServicio {

    public UsuarioLoginDTO login(String nombreUsuario, String clave);
    public List<Usuario> Listar();
    public Usuario Obtener(Integer Id);
    public List<Usuario> Buscar( String nombre);
    public Usuario Agregar(Usuario Pais);
    public Usuario Modificar(Usuario Pais);
    public boolean Eliminar(Integer Id);
}
