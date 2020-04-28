package jaxb;
import javax.xml.bind.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

public class EmployeeJAXB {
	File xmlFile = new File("src\\data\\Employee.xml");
	 String jdbcURL = "jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";
     String username = "root";
     String password = "Ocean@123";
	public void marshall() {
		
		try {
			Employee emp=new Employee(1,"SAGAR","Sen","Engineer");
			JAXBContext jc=JAXBContext.newInstance(Employee.class);
					Marshaller ms=jc.createMarshaller();
					ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(emp,System.out);
			ms.marshal(emp,new File("src\\data\\Employee.xml"));
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
		}
		
	}
	public Employee unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);              
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
		    Connection connection = null;
		    connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
            DatabaseMetaData dbm = connection.getMetaData();
	         String sql = "INSERT INTO empl (id, firstName,lastName,department) VALUES (?, ?,?,?)";
	            PreparedStatement statement = connection.prepareStatement(sql);    
	             statement.setInt(1, employee.getId());
	             statement.setString(2, employee.getFirstName());
	             statement.setString(3, employee.getLastName());
	             statement.setString(4, employee.getDepartment());
	             statement.addBatch();
	             statement.executeBatch();
	             connection.commit();
		         connection.close();
	 
			return employee;
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
			return null;
		}
		
}
}