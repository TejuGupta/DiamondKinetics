
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class BackSearchContinuityWithinRangeTest {		
		
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {   	              
	                 { "../DiamondKinetics/src/latestSwing.csv", 90, 0, 0.2, 0.702148, 12, 90}, 
	               
	           });
	    }
	  
	    private String data;
	    private int indexBegin,indexEnd,winLength;
	    private Double thresholdLo,thresholdHi;
	    private int expected;
	    
	    public BackSearchContinuityWithinRangeTest(String data, int indexBegin, int indexEnd, Double thresholdLo,
				Double thresholdHi, int winLength, int out) {
	    	
	        this.data= data;
	        this.indexBegin = indexBegin;
	        this.indexEnd = indexEnd;
	        this.thresholdLo = thresholdLo;
	        this.thresholdHi = thresholdHi;
	        this.winLength = winLength;
	        this.expected = out;
	    }
	    
	    @Test
	    public void testBackSearchContinuityWithinRange() {
	    	 assertEquals(expected, SensorDataAnalysis.backSearchContinuityWithinRange(data,indexBegin,indexEnd,thresholdLo,thresholdHi,winLength));
	    }
	}


