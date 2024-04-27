package module;

import static org.junit.Assert.*;



import org.junit.Test;

import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JunitTest_Student {
	/*
	 * Note for students: these test cases are not comprehensive; you must add your
	 * test cases to test your solution for this lab thoroughly.
	 * 
	 */
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_01_01_() {
		Course c1 = new Course("EECS100", true);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		try {
			s1.addCourse(c1);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}

		boolean added = (s1.getCourses().get(0).equals(c1));

		assertEquals("AddCourse failed", added, true);
	}

	@Test
	public void test_01_02_() {
		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, true);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		try {
			s1.addCourse(c1);
			s1.addCourse(c2);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}

		assertEquals("AddCourse failed", 2, s1.getCourses().size());
	}

	@Test
	public void test_01_03_() {
		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, true);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		try {

			s1.addCourse(c2);
			fail();

		} catch (Exception e) {
			// exception is expected and we catch it
			// System.out.println(e.getMessage());
		}

	}

	@Test
	public void test_01_04_() {
		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, false);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		try {
			s1.addCourse(c1);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		try {
			s1.addCourse(c2);
			fail();
		} catch (Exception e) {
			// exception is expected and we catch it
			// System.out.println(e.getMessage());
		}

	}

	@Test
	public void test_01_05_() {
		Course c1 = new Course("EECS100", true);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		s1.dropCourse(c1);

		assertEquals("Drop course failed", s1.courses.size(), 0);

	}

	@Test
	public void test_01_06_() {
		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, true);
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		try {
			s1.addCourse(c1);
			s1.addCourse(c2);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		s1.dropCourse(c2);

		assertEquals("Drop course failed", s1.courses.size(), 1);
		assertFalse("Drop course failed", s1.courses.contains(c2));

	}

	@Test
	public void test_02_01_() {
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(100, "John Smith");

		boolean actual = s1.equals(s2);
		boolean expected = true;
		assertEquals("equals() Failed!" + expected + " expected but " + actual + " is given", expected, actual);

	}

	@Test
	public void test_02_02_() {

		Course c1 = new Course("EECS100", true);

		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(100, "John Smith");
		try {
			s1.addCourse(c1);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		boolean actual = s1.equals(s2);
		boolean expected = false;
		assertEquals("equals() Failed!" + expected + " expected but " + actual + " is given", expected, actual);
	}

	@Test
	public void test_02_03_() {
		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, true);

		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(100, "John Allens");
		try {
			s1.addCourse(c1);
			s1.addCourse(c2);
			s2.addCourse(c1);
			s1.addCourse(c2);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		boolean actual = s1.equals(s2);
		boolean expected = false;
		assertEquals("equals() Failed!" + expected + " expected but " + actual + " is given", expected, actual);

	}

	@Test
	public void test_03_01_() {
		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(100, "John Smith");
		int actual = s1.compareTo(s2);
		int expected = 0;
		assertEquals("compareTo() Failed!" + expected + " expected but " + actual + " is given", expected, actual);

	}

	@Test
	public void test_03_02_() {

		Course c1 = new Course("EECS100", true);
		Course c2 = new Course("EECS200", c1, true);

		RegisteredStudent s1 = new RegisteredStudent(100, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(200, "John Smith");
		try {
			s1.addCourse(c1);
			s1.addCourse(c2);
			s2.addCourse(c1);
			s1.addCourse(c2);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		int actual = s1.compareTo(s2);
		int expected = -1;
		assertEquals("compareTo() Failed!" + expected + " expected but " + actual + " is given", expected, actual);
	}

	@Test
	public void test_03_03_() {
		Course c1 = new Course("EECS100", true);

		RegisteredStudent s1 = new RegisteredStudent(300, "John Smith");
		RegisteredStudent s2 = new RegisteredStudent(200, "John Smith");
		try {
			s1.addCourse(c1);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			fail();
		}
		int actual = s1.compareTo(s2);
		int expected = 1;
		assertEquals("compareTo() Failed!" + expected + " expected but " + actual + " is given", expected, actual);

	}
}
