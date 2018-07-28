package assignment4.test;



import assignment4.BdayProblem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aMaha 
 */
public class TestBirthdayCollector {
    @Test public void testHashTable0() {
         BdayProblem<String, Integer> hashTable = new BdayProblem<String, Integer>(2);
        assertEquals(0,hashTable.size());
      
    }
    @Test public void testHashTable() {
         BdayProblem<String, Integer> hashTable = new BdayProblem<String, Integer>(2);
        hashTable.put("Hello0",1);
        hashTable.put("Hello1",2);
        assertEquals(2,hashTable.size());
        assertNotNull(hashTable.get("Hello0"));
        assertNotNull(hashTable.get("Hello1"));

    }
}
