package apicampeonatosfifa.apicampeonatosfifa.Aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicampeonatosfifa.apicampeonatosfifa.Aplicacion.Seguridad.SeguridadServicio;
import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios.IUsuarioRepositorio;
import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.IUsuarioServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Usuario;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.UsuarioLoginDTO;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    private IUsuarioRepositorio repositorio;

    @Autowired
    private SeguridadServicio servicioSeguridad;

    public UsuarioServicio(IUsuarioRepositorio repositorio){
        this.repositorio = repositorio;
    }
    @Override
    public UsuarioLoginDTO login(String nombreUsuario, String clave) {
        Usuario usuarioObtenido = repositorio.validarUsuario(nombreUsuario, clave);
        UsuarioLoginDTO usuarioLoginDTO = new UsuarioLoginDTO(usuarioObtenido);
        if (usuarioObtenido != null) {
            usuarioLoginDTO.setToken(servicioSeguridad.generarToken(nombreUsuario));
        }
        return usuarioLoginDTO;
    }

    @Override
    public List<Usuario> Listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Listar'");
    }

    @Override
    public Usuario Obtener(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Obtener'");
    }

    @Override
    public List<Usuario> Buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public Usuario Agregar(Usuario Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Agregar'");
    }

    @Override
    public Usuario Modificar(Usuario Pais) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Modificar'");
    }

    @Override
    public boolean Eliminar(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Eliminar'");
    }

}
