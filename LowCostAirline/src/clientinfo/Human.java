package clientinfo;

import java.io.Serializable;

/** Human class that serves for demonstrating inheritance.
 * (because Client class inherits it). 
 * Describes a person with a name.
 * @author Anastasia
 */
public class Human implements Serializable {
	
	private String name;
	
	/** static variable for object counting
	 */
	public static int counter;
	
	/** Human constructor
	 * for initializing some info and counting objects of type Human
	 * @param name - for establishing a person's name
	 */
	public Human(String name) {
		setName(name);
		
		counter++;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String clientName) {
		if (clientName!=null) 
			name=clientName;
		else
			System.out.println("Incorrect name value");
	}

	//Overridden methods (automatically generated)
	
	/* Overridden hashCode(); 
	 * will always return the same result; 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* Overridden equals(): 
	 * compare the properties of the objects; 
	 * and some other stuff; 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* Overridden toString(): 
	 * returns some info about the object parameters in a string; 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}


}
