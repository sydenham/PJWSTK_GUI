/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad4;


public class Main {
  public static void main(String[] args)
  {
    Spiewak s1 = new Spiewak("Carrey"){
      public String spiewaj(){
    	  return "oooooooooooo";
      }
    };

    Spiewak s2 = new Spiewak("Houston"){
    	 public String spiewaj(){
       	  return "a4iBBiii";
         }
    };

    Spiewak s3 = new Spiewak("Madonna"){
    	 public String spiewaj(){
       	  return "aAa";
         }
    };

    Spiewak sp[] = {s1, s2, s3};

    for (Spiewak s : sp)
      System.out.println(s);

//metoda najgłośniej ststyczna bo wywołujemy ją na śpiewaku a nie jego obiektach
    System.out.println("\n" + Spiewak.najglosniej(sp));
  }
}
