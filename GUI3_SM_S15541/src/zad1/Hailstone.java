package zad1;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer> {

	int ini;
	
	Hailstone (int ini){
		this.ini = ini;	
	}
	
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>() {
				
			int next = -1;
			int curr = ini;

			 
			  public boolean hasNext() {
					  return (curr != 1);
			 }
 
			public Integer next() {
				 if (next != -1) 
					  curr = next;
				  
				  if ((curr%2) == 0){
					  	next = curr / 2;
					}else if ((curr%2) == 1){
						next = 3 * curr + 1;	
					}
				return curr;
	        }
		
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

