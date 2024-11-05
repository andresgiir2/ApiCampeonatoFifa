package apicampeonatosfifa.apicampeonatosfifa.Presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios.ServicioFechas;

@RestController
public class FechasController {

    @Autowired
    private ServicioFechas servicioFechas;

    @GetMapping("/esFestivo")
    public ResponseEntity<String> esFestivo(@RequestParam String fecha) {
        if (!servicioFechas.esFechaValida(fecha)) {
            return ResponseEntity.badRequest().body("Formato de fecha inválido o fecha inexistente");
        }

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaParsed = formato.parse(fecha);

            String festivo = servicioFechas.esFestivo(fechaParsed);
            if (festivo != null) {
                return ResponseEntity.ok("La fecha es festiva: " + festivo);
            } else {
                return ResponseEntity.ok("La fecha no es festiva");
            }
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Error al analizar la fecha");
        }
    }
}
