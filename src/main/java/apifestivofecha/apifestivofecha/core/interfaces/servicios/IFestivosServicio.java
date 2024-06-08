package apifestivofecha.apifestivofecha.core.interfaces.servicios;

import java.util.List;

import apifestivofecha.apifestivofecha.core.interfaces.dtos.FestivoDto;

public interface IFestivosServicio {
     
    //public Festivos obtenerDia(int dia);

    //public Festivos obtenerMes(int mes);

    //public Festivos obtenerAño(int año);

    public boolean verificarFestivos(int dia, int mes, int año);

    public List<FestivoDto> obtenerFestivosAño(int año);

}
