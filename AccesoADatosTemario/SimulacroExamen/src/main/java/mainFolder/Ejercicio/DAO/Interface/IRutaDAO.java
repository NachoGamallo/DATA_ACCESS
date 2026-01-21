package mainFolder.Ejercicio.DAO.Interface;

import mainFolder.Ejercicio.module.Ruta;

import java.util.List;

public interface IRutaDAO {

    Ruta findById(Integer id);

    List<Ruta> findAll();

    void create(Ruta ruta);

    void update(Ruta ruta);

    void delete(Ruta ruta);

}
