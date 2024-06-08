package apifestivofecha.apifestivofecha.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivofecha.apifestivofecha.core.entidades.Festivos;

@Repository
public interface IFestivosRepositorio extends JpaRepository<Festivos, Integer> {
    
    /**
     * Usamos Metodos de query para encontrar todos los festivos por dia y mes.
     */
    List<Festivos> findByDiaAndMes(int dia, int mes);
    
}
