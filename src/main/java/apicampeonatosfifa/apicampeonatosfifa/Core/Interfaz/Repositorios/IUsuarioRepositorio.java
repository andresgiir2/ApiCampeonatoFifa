package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apicampeonatosfifa.apicampeonatosfifa.Dominio.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1")
    Usuario Obtener(String usuario);

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.clave = ?2")
    Usuario validarUsuario(String usuario, String clave);
}
