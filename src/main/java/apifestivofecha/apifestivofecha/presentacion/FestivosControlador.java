 package apifestivofecha.apifestivofecha.presentacion;

 import org.springframework.web.bind.annotation.RestController;

import apifestivofecha.apifestivofecha.core.interfaces.dtos.FestivoDto;
import apifestivofecha.apifestivofecha.core.interfaces.servicios.IFestivosServicio;

import java.time.Month;
import java.time.Year;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;

 @RestController
 @RequestMapping("/festivos")
 public class FestivosControlador {

     private IFestivosServicio servicio;

     public FestivosControlador(IFestivosServicio servicio) {
         this.servicio = servicio;
     }
   
     @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
     public String verificarFestivos(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) {
        if (validarFechaValida(dia, mes, año) == false) {
            return "Fecha No Valida";
        }
            return servicio.verificarFestivos(dia, mes, año);
        }
     

        @RequestMapping(value = "obtener/{año}", method = RequestMethod.GET)
        public List<FestivoDto> obtenerFestivosAño(@PathVariable int año) {
            return servicio.obtenerFestivosAño(año);
        }

public boolean validarFechaValida(int dia, int mes, int año) {
    if (año > 0 && (mes > 0 && mes < 13)) {
        int diasDelMes = Month.of(mes).length(Year.isLeap(año));
        return dia > 0 && dia <= diasDelMes;
    }
    return false;
}

}

