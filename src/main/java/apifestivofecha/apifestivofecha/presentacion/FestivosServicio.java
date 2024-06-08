package apifestivofecha.apifestivofecha.presentacion;

import apifestivofecha.apifestivofecha.core.entidades.Festivos;
import apifestivofecha.apifestivofecha.core.interfaces.dtos.FestivoDto;
import apifestivofecha.apifestivofecha.core.interfaces.repositorios.IFestivosRepositorio;
import apifestivofecha.apifestivofecha.core.interfaces.servicios.IFestivosServicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivosServicio implements IFestivosServicio {

    @Autowired
    private IFestivosRepositorio festivosRepositorio;

    @Override
    public boolean verificarFestivos(int dia, int mes, int año) {
        LocalDate fecha = LocalDate.of(año, mes, dia);
        List<Festivos> festivos = festivosRepositorio.findAll();

        for (Festivos festivo : festivos) {
            LocalDate fechaFestiva;
            switch (festivo.getTipo().getId()) {
                case 1: // Fijo
                    fechaFestiva = LocalDate.of(año, festivo.getMes(), festivo.getDia());
                    break;
                case 2: // Ley de "Puente festivo"
                    fechaFestiva = LocalDate.of(año, festivo.getMes(), festivo.getDia());
                    if (fechaFestiva.getDayOfWeek() != DayOfWeek.MONDAY) {
                        fechaFestiva = fechaFestiva.plusDays(calcularDiasHastaLunes(fechaFestiva));
                    }
                    break;
                case 3: // Basado en el domingo de Pascua
                    LocalDate domingoPascua = calcularDomingoPascua(año);
                    fechaFestiva = domingoPascua.plusDays(festivo.getDiaspascua());
                    break;
                case 4: // Basado en el domingo de Pascua y Ley de "Puente festivo"
                    domingoPascua = calcularDomingoPascua(año);
                    fechaFestiva = domingoPascua.plusDays(festivo.getDiaspascua());
                    if (fechaFestiva.getDayOfWeek() != DayOfWeek.MONDAY) {
                        fechaFestiva = fechaFestiva.plusDays(calcularDiasHastaLunes(fechaFestiva));
                    }
                    break;
                default:
                    return false;
            }

            if (fecha.isEqual(fechaFestiva)) {
                return true;
            }
        }

        return false;
    }

    private int calcularDiasHastaLunes(LocalDate fecha) {
        int diasHastaLunes = 0;
        DayOfWeek diaActual = fecha.getDayOfWeek();
        switch (diaActual) {
            case SUNDAY:
                diasHastaLunes = 1;
                break;
            case SATURDAY:
                diasHastaLunes = 2;
                break;
            case FRIDAY:
                diasHastaLunes = 3;
                break;
            case THURSDAY:
                diasHastaLunes = 4;
                break;
            case WEDNESDAY:
                diasHastaLunes = 5;
                break;
            case TUESDAY:
                diasHastaLunes = 6;
                break;
            case MONDAY:
                diasHastaLunes = 0;
                break;
        }
        return diasHastaLunes;
    }

public LocalDate calcularDomingoPascua(int año) {
    int a = año % 19;
    int b = año % 4;
    int c = año % 7;
    int d = (19 * a + 24) % 30;
    int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

    LocalDate domingoPascua = LocalDate.of(año, Month.MARCH, 15).plusDays(dias + 7);
    return domingoPascua;
}

@Override
public List<FestivoDto> obtenerFestivosAño(int año) {
    List<Festivos> festivos = festivosRepositorio.findAll();
    List<FestivoDto> festivosDto = new ArrayList<>();
    for (Festivos festivo : festivos) {
        LocalDate fechaFestiva=null;
        switch (festivo.getTipo().getId()) {
            case 1: // Fijo
                fechaFestiva = LocalDate.of(año, festivo.getMes(), festivo.getDia());
                break;
            case 2: // Ley de "Puente festivo"
                fechaFestiva = LocalDate.of(año, festivo.getMes(), festivo.getDia());
                if (fechaFestiva.getDayOfWeek() != DayOfWeek.MONDAY) {
                    fechaFestiva = fechaFestiva.plusDays(calcularDiasHastaLunes(fechaFestiva));
                }
                break;
            case 3: // Basado en el domingo de Pascua
                LocalDate domingoPascua = calcularDomingoPascua(año);
                fechaFestiva = domingoPascua.plusDays(festivo.getDiaspascua());
                break;
            case 4: // Basado en el domingo de Pascua y Ley de "Puente festivo"
                domingoPascua = calcularDomingoPascua(año);
                fechaFestiva = domingoPascua.plusDays(festivo.getDiaspascua());
                if (fechaFestiva.getDayOfWeek() != DayOfWeek.MONDAY) {
                    fechaFestiva = fechaFestiva.plusDays(calcularDiasHastaLunes(fechaFestiva));
                }
                break;
        }
        festivosDto.add(new FestivoDto(fechaFestiva, festivo.getNombre()));

           }
        return festivosDto;
}
}