package mainFolder.Ejercicio.DAO.Impl;

import mainFolder.Ejercicio.DAO.Interface.IUsuarioDAO;
import mainFolder.Ejercicio.module.Usuario;

import java.util.List;

public class UsuarioImplDAO implements IUsuarioDAO {

    @Override
    public Usuario findById(Integer id) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public void create(Usuario usr) {

    }

    @Override
    public void update(Usuario usr) {

    }

    @Override
    public void delete(Usuario usr) {

    }
}
