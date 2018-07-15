/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad2;

import java.math.BigDecimal;
import java.util.HashMap;

public class Calc {
	
	String calc;
	String answer;
	
	

	public String doCalc(String calc){
		try {
			this.calc = calc;
			
			HashMap<String, Runnable> commands = new HashMap<String, Runnable>();
			
			String [] args = calc.split("\\s+");
			
			BigDecimal arg1 = new BigDecimal(args[0]);
			BigDecimal arg2 = new BigDecimal(args[2]);
			
			commands.put("+" , () -> 
			{
			answer = arg1.add(arg2).toString();
			} );
			
			commands.put("-" , () -> 
			{
			answer = arg1.subtract(arg2).toString();
			} );
			
			commands.put("*" , () -> 
			{
			answer = arg1.multiply(arg2).toString();
			} );
			
			commands.put("/" , () -> 
			{
			answer = arg1.divide(arg2, 7, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
			} );
			
			commands.get(args[1]).run();
			return answer;
			
		} catch (Exception e) {
			return "Invalid command to calc";			
		}
	}	
}  

/*
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.function.*;

public class Calc {
	
    private static HashMap<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> commands = new HashMap<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>>();
	
    static {
    	commands.put("+" , ((BigDecimal x, BigDecimal y) -> x.add(y)));
		commands.put("-" , ((BigDecimal x, BigDecimal y) -> x.subtract(y)));
		commands.put("*" , ((BigDecimal x, BigDecimal y) -> x.multiply(y)));
		commands.put("/" , ((BigDecimal x, BigDecimal y) -> x.divide(y, 7, BigDecimal.ROUND_HALF_UP)));
    }
    
	public String doCalc(String calc){
		try {
			String [] args = calc.split("\\s+");
			return commands.get(args[1]).apply(new BigDecimal(args[0]), new BigDecimal(args[2])).toString();
		} catch (Exception e) {
			return "Invalid command to calc";			
		}
	}	
  
}

*/