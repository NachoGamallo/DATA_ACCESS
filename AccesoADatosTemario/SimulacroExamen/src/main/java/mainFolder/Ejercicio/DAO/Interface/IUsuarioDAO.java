package mainFolder.Ejercicio.DAO.Interface;

import mainFolder.Ejercicio.module.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    Usuario findById(Integer id);

    List<Usuario> findAll();

    void create(Usuario usr);

    void update(Usuario usr);

    void delete(Usuario usr);

}
