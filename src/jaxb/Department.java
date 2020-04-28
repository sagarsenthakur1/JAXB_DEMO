package jaxb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Department implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    Integer id;
    String name;
     
    public Department() {
        super();
    }
 
    public Department(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
     
    //Setters and Getters
    
 
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}