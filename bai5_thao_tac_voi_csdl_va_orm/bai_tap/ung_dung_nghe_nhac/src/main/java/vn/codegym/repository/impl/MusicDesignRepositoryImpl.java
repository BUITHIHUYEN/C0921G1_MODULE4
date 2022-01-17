package vn.codegym.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.MusicDesign;
import vn.codegym.repository.ConnectionUtil;
import vn.codegym.repository.IMusicDesignRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class MusicDesignRepositoryImpl implements IMusicDesignRepository {
    private static SessionFactory sessionFactory;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<MusicDesign> findAll() {
        TypedQuery<MusicDesign> query = ConnectionUtil.entityManager.createQuery("SELECT m FROM MusicDesign as m",MusicDesign.class);
        return query.getResultList();
    }

    @Override
    public MusicDesign findById(Long id) {
        TypedQuery<MusicDesign> query = ConnectionUtil.entityManager.createQuery("SELECT m FROM MusicDesign  as m where m.id = :id",MusicDesign.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException exception){
            return  null;
        }
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
        if (musicDesign.getId()!=null){
            entityManager.merge(musicDesign);
        } else {
            entityManager.persist(musicDesign);
        }
    }

    @Override
    public void remove(Long id ) {
        MusicDesign musicDesign = findById(id);
        if (musicDesign!=null){
            entityManager.remove(musicDesign);
        }

    }
}
