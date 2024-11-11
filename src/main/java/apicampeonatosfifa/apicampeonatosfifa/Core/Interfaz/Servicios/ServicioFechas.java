package apicampeonatosfifa.apicampeonatosfifa.Core.Interfaz.Servicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ServicioFechas {

    private final Map<String, String> festivosFijos;
    private final Map<String, Integer> festivosMoviles;

    public ServicioFechas() {
        festivosFijos = new HashMap<>();
        festivosMoviles = new HashMap<>();

        festivosFijos.put("01-01", "Año nuevo");
        festivosFijos.put("01-05", "Día del Trabajo");
        festivosFijos.put("20-07", "Independencia Colombia");
        festivosFijos.put("07-08", "Batalla de Boyacá");
        festivosFijos.put("08-12", "Inmaculada Concepción");
        festivosFijos.put("25-12", "Navidad");

        festivosMoviles.put("Jueves Santo", -3);
        festivosMoviles.put("Viernes Santo", -2);
        festivosMoviles.put("Ascensión del Señor", 40);
        festivosMoviles.put("Corpus Christi", 61);
        festivosMoviles.put("Sagrado Corazón de Jesús", 68);
    }

    public Date getDomingoRamos(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        
        int dia = 15 + dias;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, año);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        
        if (dia > 31) {
            cal.set(Calendar.MONTH, Calendar.APRIL);
            cal.set(Calendar.DAY_OF_MONTH, dia - 31);
        }
        return cal.getTime();
    }

    public Date incrementarDias(Date fecha, int dias) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(fecha);
        cld.add(Calendar.DATE, dias);
        return cld.getTime();
    }

    public Date siguienteLunes(Date fecha) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(fecha);

        int diaSemana = cld.get(Calendar.DAY_OF_WEEK);
        if (diaSemana != Calendar.MONDAY) {
            fecha = incrementarDias(fecha, (diaSemana > Calendar.MONDAY) ? 9 - diaSemana : 1);
        }
        return fecha;
    }

    public String esFestivo(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH) + 1;
        String clave = String.format("%02d-%02d", mes, dia);

        if (festivosFijos.containsKey(clave)) {
            return festivosFijos.get(clave);
        }

        int año = cal.get(Calendar.YEAR);
        Date domingoPascua = incrementarDias(getDomingoRamos(año), 7);

        for (Map.Entry<String, Integer> entry : festivosMoviles.entrySet()) {
            Date fechaFestivo = incrementarDias(domingoPascua, entry.getValue());
            if (entry.getKey().equals("Ascensión del Señor") || entry.getKey().equals("Corpus Christi") || entry.getKey().equals("Sagrado Corazón de Jesús")) {
                fechaFestivo = siguienteLunes(fechaFestivo);
            }
            if (esMismaFecha(fecha, fechaFestivo)) {
                return entry.getKey();
            }
        }

        return null;
    }

    private boolean esMismaFecha(Date fecha1, Date fecha2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(fecha1);
        cal2.setTime(fecha2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public boolean esFechaValida(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            formato.setLenient(false);
            formato.parse(fecha);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
