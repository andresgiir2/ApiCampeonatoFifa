package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.IUsuarioServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.UsuarioLoginDTO;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;


    @RequestMapping(value="/login/{nombreUsuario}/{clave}", method=RequestMethod.GET)
    public UsuarioLoginDTO login(@PathVariable String nombreUsuario, @PathVariable String clave){
        return servicio.login(nombreUsuario, clave);
    }

}
