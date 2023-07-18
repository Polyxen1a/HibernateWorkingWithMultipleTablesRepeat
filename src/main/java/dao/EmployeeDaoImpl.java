package dao;

import config.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDaoImpl extends Employee {
    public EmployeeDaoImpl(String darya, String androva, String woman, int i) {
        super(darya, androva, woman, i, o);
    }

    @Override
    public void create(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }


    @Override
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }


    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

            @Override
            public void deleteEmployee (Employee employee){
                try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                    Transaction transaction = session.beginTransaction();
                    session.delete(employee);
                    transaction.commit();
                }
            }
        }