package DAO;

import DAOinterface.UserDAOInterface;
import manager.Manager;
import model.Employee;

import java.util.List;

public class EmployeeDAO implements UserDAOInterface<Employee>
{
    @Override
    public boolean delete(Employee entity)
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAll()
    {
        Manager.beginTransaction();
        List<Employee> employees = (List<Employee>) Manager.getSession().createQuery("from Employee").list();
        Manager.commitTransaction();
        return employees;
    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public boolean saveOrUpdate(Employee entity)
    {
        return false;
    }

    @Override
    public Employee findByLoginAndPassword(String login, String password)
    {
        return null;
    }
}