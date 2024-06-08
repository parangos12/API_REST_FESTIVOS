package apifestivofecha.apifestivofecha.core.interfaces.dtos;

import java.time.LocalDate;

public class FestivoDto {

    private LocalDate fecha;
    private String festivo;


    public FestivoDto(LocalDate fechaFestiva, String festivo) {
        this.fecha = fechaFestiva;
        this.festivo = festivo;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getFestivo() {
        return festivo;
    }


    public void setFestivo(String festivo) {
        this.festivo = festivo;
    }

    
}
