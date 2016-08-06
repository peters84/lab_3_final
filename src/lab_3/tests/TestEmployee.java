package lab_3.tests;

import lab_3.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		// 

		System.out.println("same date");
		Employee a = new Employee("a", "20160101");
		Employee b = new Employee("b", "20160101");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.compareTo(b));
		
		System.out.println("reverse same date");
		System.out.println(b.toString());
		System.out.println(a.toString());
		System.out.println(b.compareTo(a));

		System.out.println("a higher seniority than b (earlier in the past)");
		a = new Employee("a", "20100101");
		b = new Employee("b", "20160101");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.compareTo(b));
		
		System.out.println("reverse: b lower seniority than a");
		System.out.println(b.toString());
		System.out.println(a.toString());
		System.out.println(b.compareTo(a));
	}

}
