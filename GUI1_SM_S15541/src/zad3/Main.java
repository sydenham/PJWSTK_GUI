/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad3;


public class Main {

  public static void main(String[] args) {
    String fname = System.getProperty("user.home") + "/tab.txt";     
    Sort sort = new Sort(fname);
    sort.readFile();
  }
    
}
