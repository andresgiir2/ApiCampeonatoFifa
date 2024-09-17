package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import java.util.List;

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
}
