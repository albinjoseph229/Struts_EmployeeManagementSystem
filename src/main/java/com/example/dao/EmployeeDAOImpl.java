package com.example.dao;

import com.example.model.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Long addEmployee(Employee employee) {
        Transaction transaction = null;
        Long employeeId = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employeeId = (Long) session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return employeeId;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Employee existingEmployee = session.get(Employee.class, employee.getId());
            if (existingEmployee != null) {
                if (employee.getName() != null && !employee.getName().isEmpty()) {
                    existingEmployee.setName(employee.getName());
                }
                if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
                    existingEmployee.setEmail(employee.getEmail());
                }
                if (employee.getSalary() != null) {
                    existingEmployee.setSalary(employee.getSalary());
                }

                session.update(existingEmployee);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employees = session.createQuery("FROM Employee", Employee.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public boolean isEmailUnique(String email, Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Employee WHERE email = :email AND id <> :id";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("email", email);
            query.setParameter("id", id != null ? id : -1L); // Avoid null ID

            Employee employee = query.uniqueResult();

            return employee == null; // If no other employee has this email, it's unique
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
