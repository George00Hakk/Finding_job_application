package org.Find.DAO;

import org.Find.Entity.Vacancy;
import org.hibernate.Session;
import org.Find.Hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VacancyDAOImpl implements VacancyDAO{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Vacancy vacancy) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(vacancy);

        transaction.commit();
        session.close();
    }

    @Override
    public Vacancy getVacancyById(int id) {
        Session session = sessionFactory.openSession();
        Vacancy vacancy=session.get(Vacancy.class, id);
        session.close();
        return vacancy;
    }

    @Override
    public Vacancy getVacancyByName(String Name) {
        Session session = sessionFactory.openSession();
        Vacancy vacancy=session.get(Vacancy.class, Name);
        session.close();
        return vacancy;
    }

    @Override
    public List<Vacancy> getAll() {
        Session session = sessionFactory.openSession();
        List<Vacancy> vacancies=session.createQuery("from Vacancy",Vacancy.class).list();
        session.close();
        return vacancies;
    }

    @Override
    public void delete(Vacancy vacancy) {
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.createQuery("delete from Vacancy where id="+vacancy.getId()).executeUpdate();

        transaction.commit();
        session.close();
    }
}
