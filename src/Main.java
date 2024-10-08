import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import DTO.Employee;
import Service.Database;

import java.sql.Connection;
import java.sql.SQLException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

//        Employee employee = new Employee(1, 123456, "George", "Bourikas", 3);
//
//        System.out.println(employee);
//
//        Connection con = Database.getConnection();
//
//        if (con != null ){
//            System.out.println("Database connection Successful");
//        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = employeeDAO.get(1);
        System.out.println(employee);
    }

}