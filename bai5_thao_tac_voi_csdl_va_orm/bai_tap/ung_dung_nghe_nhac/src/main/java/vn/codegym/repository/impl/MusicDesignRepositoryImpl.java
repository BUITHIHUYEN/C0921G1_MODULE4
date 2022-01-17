package vn.codegym.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.codegym.model.MusicDesign;
import vn.codegym.repository.ConnectionUtil;
import vn.codegym.repository.IMusicDesignRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class MusicDesignRepositoryImpl implements IMusicDesignRepository {
    private static SessionFactory sessionFactory;
    @PersistenceContext
    @Override
    public List<MusicDesign> findAll() {
        TypedQuery<MusicDesign> query = ConnectionUtil.entityManager.createQuery("SELECT s FROM MusicDesign as s",MusicDesign.class);
        return query.getResultList();
    }

    @Override
    public MusicDesign findById(Long id) {
        TypedQuery<MusicDesign> query = ConnectionUtil.entityManager.createQuery("SELECT s FROM MusicDesign  as s where s.id = :id",MusicDesign.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public MusicDesign updateNew(MusicDesign musicDesign) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(musicDesign);
            session.saveOrUpdate(musicDesign);
            transaction.commit();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return null;
    }

    @Override
    public void save(MusicDesign musicDesign) {

    }

    @Override
    public void remove(MusicDesign musicDesign) {

    }
}
