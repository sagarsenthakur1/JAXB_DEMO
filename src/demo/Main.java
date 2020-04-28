package demo;
import jaxb.*;

public class Main {
	public static void main(String[] args) {
		EmployeeJAXB obj = new EmployeeJAXB();
		obj.marshall();
		System.out.println(obj.unmarshall());
	}

}
