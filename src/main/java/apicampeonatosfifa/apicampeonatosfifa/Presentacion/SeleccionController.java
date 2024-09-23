package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.ISeleccionServicio;
import apicampeonatosfifa.apicampeonatosfifa.Dominio.Seleccion;

@RestController
@RequestMapping("/api/selecciones")
public class SeleccionController {

    private ISeleccionServicio servicio;


    public SeleccionController(ISeleccionServicio servicio){
        this.servicio = servicio;
    }

    @RequestMapping(value = "/Listar", method=RequestMethod.GET)
    public List<Seleccion> Listar() {
        return servicio.Listar();
    }

    

    @RequestMapping(value = "/Obtener/{Id}", method=RequestMethod.GET)
    public Seleccion Obtener(@PathVariable Integer Id){
        return servicio.Obtener(Id);
    }

    @RequestMapping(value = "/Agregar", method=RequestMethod.POST)
    public Seleccion Agregar(@RequestBody Seleccion Pais){
        return servicio.Agregar(Pais);
    }

    @RequestMapping(value = "/Modificar", method=RequestMethod.PUT)
    public Seleccion Modificar(@RequestBody Seleccion Pais){
        return servicio.Modificar(Pais);
    }

    @RequestMapping(value = "/Eliminar/{Id}", method=RequestMethod.DELETE)
    public boolean Eliminar(@PathVariable Integer Id){
        return servicio.Eliminar(Id);
    }
}
