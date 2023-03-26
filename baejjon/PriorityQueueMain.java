package gwonjihun.baejjon;
import java.util.*;
public class PriorityQueueMain {
	public static void main(String[] args) {
		PriorityQueue<Car> pq = new PriorityQueue<>();
		pq.add(new Car("?��반떼", 2015));
		pq.add(new Car("?��?��?��", 2015));
		pq.add(new Car("?��반떼", 2015));
		pq.add(new Car("차반?��", 2015));
	
		System.out.println(pq);
		
		while(!pq.isEmpty()) System.out.println(pq.poll());

		PriorityQueue<Car> pq2 = new PriorityQueue<>((o1,o2)->Integer.compare(o1.year, o2.year));
		pq2.add(new Car("?��반떼", 2015));
		pq2.add(new Car("?��?��?��", 2015));
		pq2.add(new Car("?��반떼", 2015));
		pq2.add(new Car("차반?��", 2015));
		
		System.out.println(pq2);
		
		while(!pq2.isEmpty()) System.out.println(pq2.poll());
		
		
		PriorityQueue<Car> pq1 = new PriorityQueue<>(new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				return -Integer.compare(o1.year, o2.year);
			}
			
			
		});
		pq1.add(new Car("?��반떼", 2015));
		pq1.add(new Car("?��?��?��", 2016));
		pq1.add(new Car("?��반떼", 2014));
		pq1.add(new Car("차반?��", 2010));
		
		System.out.println(pq1);
		
		while(!pq1.isEmpty()) System.out.println(pq1.poll());
	}
}
