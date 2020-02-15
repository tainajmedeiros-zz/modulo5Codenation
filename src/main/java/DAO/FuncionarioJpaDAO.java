package DAO;

import Entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioJpaDAO {

    private static FuncionarioJpaDAO instance;
    protected EntityManager entityManager;

    public static FuncionarioJpaDAO getInstance(){
        if (instance == null){
            instance = new FuncionarioJpaDAO();
        }
        return instance;
    }

    private FuncionarioJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("Sales");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Funcionario getByMatricula(final int matricula) {
        return entityManager.find(Funcionario.class, matricula);
    }

    @SuppressWarnings("unchecked")
    public List<Funcionario> findAll() {
        return entityManager.createQuery("FROM " +
                Funcionario.class.getName()).getResultList();
    }

    public void persist(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Funcionario funcionario) {
        try {
            entityManager.getTransaction().begin();
            funcionario = entityManager.find(Funcionario.class, funcionario.getMatricula());
            entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeByMatricula(final int matricula) {
        try {
            Funcionario funcionario = getByMatricula(matricula);
            remove(funcionario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
