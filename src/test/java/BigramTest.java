import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class BigramTest {
	
	Bigram bigram;

	@Before
	public void setUp() throws Exception {
		bigram= new Bigram();
		
	}

	@Test
	public void testGetProcessedList() {
		List<String> actual =bigram.getProcessedList("the quick brown fox", 2);
		List<String> expected = new ArrayList<String>();
		expected.add("the quick");
		expected.add("quick brown");
		expected.add("brown fox");
		
		assertTrue(actual.size()== expected.size());		
		assertEquals(expected, actual);
		
	}	

}
