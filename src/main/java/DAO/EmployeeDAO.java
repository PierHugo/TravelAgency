package DAO;

import DAOinterface.UserDAOInterface;
import controller.Controller;
import model.Employee;

import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO implements UserDAOInterface<Employee, Integer>
{

    public Employee findById(Integer id)
    {
        Controller.beginTransaction();
        Employee employee = Controller.getSession().find(Employee.class, id);
        Controller.commitTransaction();
        return employee;
    }

    public Employee findByLoginAndPassword(String login, String password)
    {
        Controller.beginTransaction();
        TypedQuery<Employee> query = Controller.getSession().createQuery("FROM Employee WHERE login = :login AND password = :password", Employee.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<Employee> employees = query.getResultList();
        Controller.commitTransaction();
        if (employees.size() == 0)
            return null;
        else
            return employees.get(0);
    }

    public boolean delete(Employee entity)
    {
        try
        {
            Controller.beginTransaction();
            if (!Controller.getSession().contains(entity))
                Controller.getSession().merge(entity);
            Controller.getSession().delete(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAll()
    {
        Controller.beginTransaction();
        List<Employee> employees = (List<Employee>) Controller.getSession().createQuery("from Employee").list();
        Controller.commitTransaction();
        return employees;
    }

    public void deleteAll()
    {
        Controller.beginTransaction();
        for (Employee employee : findAll())
        {
            if (!Controller.getSession().contains(employee))
                Controller.getSession().merge(employee);
            Controller.getSession().delete(employee);
        }
        Controller.commitTransaction();
    }

    public boolean saveOrUpdate(Employee entity)
    {
        try
        {
            Controller.beginTransaction();
            Controller.getSession().saveOrUpdate(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
