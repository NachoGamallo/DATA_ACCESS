package mainFolder.Ejercicio.DAO.Impl;

import mainFolder.Ejercicio.DAO.Interface.IRutaDAO;
import mainFolder.Ejercicio.config.GestionSesiones;
import mainFolder.Ejercicio.module.Ruta;
import mainFolder.Ejercicio.module.Usuario;
import org.hibernate.Session;

import java.util.List;

public class RutaImplDAO implements IRutaDAO {

    @Override
    public Ruta findById(Integer id) {
        try (Session session = GestionSesiones.getSessionFactory().openSession()){

            return session.find(Ruta.class,id);

        }
    }

    @Override
    public List<Ruta> findAll() {

        try (Session session = GestionSesiones.getSessionFactory().openSession()){

            return session.createQuery("from Ruta",Ruta.class).list();

        }

    }

    @Override
    public void create(Ruta ruta) {

        

    }

    @Override
    public void update(Ruta ruta) {

    }

    @Override
    public void delete(Ruta ruta) {

    }

}
