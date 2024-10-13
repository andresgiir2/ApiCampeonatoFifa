package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.ICampeonatoServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Campeonato;

@RestController
@RequestMapping("/api/Campeonato")
public class CampeonatoController {

    private ICampeonatoServicio servicio;


    public CampeonatoController(ICampeonatoServicio servicio){
        this.servicio = servicio;
    }

    @RequestMapping(value = "/Listar", method=RequestMethod.GET)
    public List<Campeonato> Listar() {
        return servicio.Listar();
    }

    

    @RequestMapping(value = "/Obtener/{Id}", method=RequestMethod.GET)
    public Campeonato Obtener(@PathVariable Integer Id){
        return servicio.Obtener(Id);
    }

    @RequestMapping(value = "/Buscar/{nombre}", method=RequestMethod.GET)
    public List<Campeonato> Buscar(@PathVariable String nombre){
        return servicio.Buscar(nombre);
    }

    @RequestMapping(value = "/Agregar", method=RequestMethod.POST)
    public Campeonato Agregar(@RequestBody Campeonato Pais){
        return servicio.Agregar(Pais);
    }

    @RequestMapping(value = "/Modificar", method=RequestMethod.PUT)
    public Campeonato Modificar(@RequestBody Campeonato Pais){
        return servicio.Modificar(Pais);
    }

    @RequestMapping(value = "/Eliminar/{Id}", method=RequestMethod.DELETE)
    public boolean Eliminar(@PathVariable Integer Id){
        return servicio.Eliminar(Id);
    }
}
