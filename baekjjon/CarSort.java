package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

class Car implements Comparable<Car>{
	String name;
	int year;
	Car(String name,int year){
		this.name = name;
		this.year = year;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+year;
	}
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}
	
	
}
public class CarSort {
	public static void main(String[] args) throws Exception{
		
		
		System.out.println();
		int[] ia= {22,11,33};
		System.out.println(Arrays.toString(ia));
		Arrays.sort(ia);
		System.out.println(Arrays.toString(ia));
		
		List<Integer> il = new ArrayList<>();
		il.add(22);
		il.add(33);
		il.add(11);
		
		System.out.println(il);
		
		Collections.sort(il);
		System.out.println(il);
		
		Car[] ca= {
				new Car("아반떼", 2020),
				new Car("모닝", 2000),
				new Car("우르스", 2019),
				new Car("람보르기니", 2023),
				new Car("포르쉐", 2021)
		};
		
		System.out.println(Arrays.toString(ca));
		Arrays.sort(ca,Collections.reverseOrder());
		System.out.println(Arrays.toString(ca));
		System.out.println();
		
		
		List<Car> cl = new ArrayList<>();
		cl.add(new Car("아반떼", 2000));
		cl.add(new Car("모닝", 2020));
		cl.add(new Car("우르스", 2001));
		cl.add(new Car("람보르기니", 2100));
		cl.add(new Car("포르쉐", 2081));
		System.out.println(cl);
		Collections.sort(cl);
		System.out.println(cl);

		System.out.println();
		
		//local inner class -> method 안에도 클래스가 선언되어진다.
		class YearComparator implements Comparator<Car>{

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.year, o2.year);
			}
			
		}
		Comparator<Car> yc= new YearComparator();
		Collections.sort(cl,yc);
		System.out.println(cl);
		
		
		Collections.sort(cl, new  Comparator<Car>(){

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return -Integer.compare(o1.year, o2.year);
			}	
		} );

		System.out.println(cl);
		
		
		Collections.sort(cl,(o1,o2) -> o1.name.compareTo(o2.name));
		System.out.println(cl);
		Collections.sort(cl, (o1,o2) -> Integer.compare(o1.year,o2.year));
	}
}
