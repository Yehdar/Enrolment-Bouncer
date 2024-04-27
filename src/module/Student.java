package module;

import java.util.*;


/**
 * An abstract class representing a student
 * that extends Comparable and includes methods and fields 
 * related to student information and courses. 
 * It also implements the Comparable interface to 
 * enable comparison between Student objects based on their IDs.
 * 
 * This class provides basic properties and methods to manage student information and courses.
 * Note that when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generic. 
 */
public abstract class Student implements Comparable {
	protected int id;
	protected String name;
	protected ArrayList<Course> courses;
	
	public Student() {}
	
	public abstract void addCourse(Course course) throws Exception;
	
	public abstract void dropCourse(Course course);
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public ArrayList<Course> getCourses() {
		return this.courses;
	}
	
	public int compareTo(Object object) {
		Student obj = (Student) object;
		if (this.id < obj.getId()) {
			return -1;
		} else if (this.id > obj.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	
	
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}


/**
 * A class representing a registered student.
 * This class extends the abstract class Student and provides methods and properties
 * specific to registered students and their course registrations.
 */
class RegisteredStudent extends Student {

	public RegisteredStudent(int id, String name) {
		super.id = id;
		super.name = name;
		super.courses = new ArrayList<>();
	}

	@Override
    public void addCourse(Course course) throws Exception {
        if (!course.offered) {
            throw new RegistrationException("Course not offered");
        }
        if (course.getPrerequisite() != null && !courses.contains(course.getPrerequisite())) {
            throw new PrerequisiteException("Missing Prerequisite" + course.getName());
        }
        super.courses.add(course);
    }

	@Override
	public void dropCourse(Course course) {
		super.courses.remove(course);
	}
	
	public int hashCode() {
		return Objects.hash(super.name, super.id, super.courses);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisteredStudent other = (RegisteredStudent) obj;
		return Objects.equals(name, other.name) && Objects.equals(id, other.id) && Objects.equals(courses, other.courses) ;
	}
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}



/**
 * A class representing a course.
 * This class contains information about a course, including its name, prerequisite,
 * and whether it is currently offered.
 */
class Course {
	protected String name;
	protected boolean offered;
	protected Course prerequisite;
	
	public Course(String name, boolean offered) {
		this.name = name;
		this.offered = offered;
	}

	public Course(String name, Course prerequisite, boolean offered) {
		this.name = name;
		this.offered = offered;
		this.prerequisite = prerequisite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
    
    
}




/**
 * A custom exception class representing an exception related to course registration.
 * This exception can be used to handle registration-related errors.
 */
class RegistrationException extends Exception {
	public RegistrationException() {
		super();
	}
	
	public RegistrationException (String message) {
		super(message);
	}
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}

/**
 * A custom exception class representing an exception related to course prerequisites.
 * This exception can be used to handle errors related to course prerequisites.
 */
class PrerequisiteException extends RegistrationException {
	public PrerequisiteException() {
		super();
	}
	
	public PrerequisiteException (String message) {
		super(message);
	}
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}