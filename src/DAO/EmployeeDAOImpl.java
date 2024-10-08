package DAO;

import DTO.Employee;
import Service.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection(); // creating connection
        Employee employee = null;
        // SQL code to communicate with the db
        String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees where id = ?"; //? is a placeholder

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id); //setting the placeholder

        ResultSet rs = ps.executeQuery(); //executing query

        if (rs.next()) { //if we have a result
            int oid = rs.getInt("id"); //oid = obtained id
            int employeeId = rs.getInt("employee_id");
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            int deptId = rs.getInt("dept_id");

            employee = new Employee(oid, employeeId, firstname, lastname, deptId);
        }
        return employee;


    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, dept_id) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDepartmentId());

        int result = ps.executeUpdate();
        //Database.closePreparedStatement(ps);
        //Database.closeConnection(con);

        return result; //returns the number of lines affected in our database
    }

    @Override
    public int update(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "UPDATE employees set employee_id = ?, firstname = ?, last_name = ?, dept_id = ? where id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setInt(4, employee.getDepartmentId());
        ps.setInt(5,employee.getEmployeeId());

        int result = ps.executeUpdate();
        //Database.closePreparedStatement(ps);
        //Database.closeConnection(con);
        return result;

    }

    @Override
    public int delete(Employee employee) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "DELETE FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployeeId());

        int result = ps.executeUpdate();
        //Database.closePreparedStatement(ps);
        //Database.closeConnection(con);
        return result;
    }
}
