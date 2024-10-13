package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.IGrupoServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Grupo;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.DTOs.TablaPosicionesDTO;

@RestController
@RequestMapping("/api/Grupos")
public class GrupoControlador {


    private IGrupoServicio servicio;


    public GrupoControlador(IGrupoServicio servicio){
        this.servicio = servicio;
    }

    @RequestMapping(value = "/Posiciones/{id}", method=RequestMethod.GET)
    public List<TablaPosicionesDTO> obtenerPosiciones(@PathVariable int id) {
        return servicio.obtenerPosiciones(id);
    }

    @RequestMapping(value = "/Listar", method=RequestMethod.GET)
    public List<Grupo> Listar() {
        return servicio.Listar();
    }

    

    @RequestMapping(value = "/Obtener/{Id}", method=RequestMethod.GET)
    public Grupo Obtener(@PathVariable Integer Id){
        return servicio.Obtener(Id);
    }

    @RequestMapping(value = "/Buscar/{nombre}", method=RequestMethod.GET)
    public List<Grupo> Buscar(@PathVariable String nombre){
        return servicio.Buscar(nombre);
    }

    @RequestMapping(value = "/Agregar", method=RequestMethod.POST)
    public Grupo Agregar(@RequestBody Grupo Pais){
        return servicio.Agregar(Pais);
    }

    @RequestMapping(value = "/Modificar", method=RequestMethod.PUT)
    public Grupo Modificar(@RequestBody Grupo Pais){
        return servicio.Modificar(Pais);
    }

    @RequestMapping(value = "/Eliminar/{Id}", method=RequestMethod.DELETE)
    public boolean Eliminar(@PathVariable Integer Id){
        return servicio.Eliminar(Id);
    }
}
