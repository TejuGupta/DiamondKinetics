
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class SearchContinuityAboveValueTwoSignalsTest {
		
		enum Type {searchContinuityAboveValueTwoSignals};
		
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 {Type.searchContinuityAboveValueTwoSignals, "../DiamondKinetics/src/latestSwing.csv", "../DiamondKinetics/src/latestSwing.csv", 2, 90, 0.2, 0.3, 12, 2 }, 
	                
	           });
	    }
	    private Type type;
	    private String data1,data2;
	    private int indexBegin,indexEnd,winLength;
	    private Double thresholdLo,thresholdHi;
	    private int expected;
	    private String expectedOutput;
	    
	    public SearchContinuityAboveValueTwoSignalsTest(Type type,String data1, String data2, int indexBegin, int indexEnd, Double thresholdLo,
					Double thresholdHi, int winLength, int out) {
		    	this.type= type;
		        this.data1= data1;
		        this.data2 = data2;
		        this.indexBegin = indexBegin;
		        this.indexEnd = indexEnd;
		        this.thresholdLo = thresholdLo;
		        this.thresholdHi = thresholdHi;
		        this.winLength = winLength;
		        this.expected = out;
		    }

	    @Test
	    public void testSearchContinuityAboveValueTwoSignals() {
	    	Assume.assumeTrue(type == Type.searchContinuityAboveValueTwoSignals);
	        assertEquals(expected, SensorDataAnalysis.searchContinuityAboveValueTwoSignals(data1,data2,indexBegin,indexEnd,thresholdLo,thresholdHi,winLength));
	    }
	    
	}


