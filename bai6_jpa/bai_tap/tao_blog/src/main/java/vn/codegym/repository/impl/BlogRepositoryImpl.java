package vn.codegym.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    EntityManager entityManager;
    private static SessionFactory sessionFactory;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query =entityManager.createQuery("SELECT b FROM Blog as b",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog  as b where b.id = :id",Blog.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException exception){
            return  null;
        }
    }

    @Override
    public Blog updateNew(Blog blog) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            session.save(blog);
            session.saveOrUpdate(blog);
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
        return blog;
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId()!=null){
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog!=null){
            entityManager.remove(blog);
        }

    }
    }
