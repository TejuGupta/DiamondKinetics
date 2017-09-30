
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class SearchMultiContinuityWithinRangeTest {
		
		enum Type {searchContinuityAboveValue,backSearchContinuityWithinRange,searchContinuityAboveValueTwoSignals,searchMultiContinuityWithinRange};
		
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 {Type.searchMultiContinuityWithinRange,"../DiamondKinetics/src/latestSwing.csv", 0, 90, 0.2, 0.702148, 12, "0 11" }
	           });
	    }
	    private Type type;
	    private String data;
	    private int indexBegin,indexEnd,winLength;
	    private Double thresholdLo,thresholdHi;	 
	    private String expectedOutput;

	   public SearchMultiContinuityWithinRangeTest(Type type,String data, int indexBegin, int indexEnd, Double thresholdLo, Double thresholdHi, int
	    		  winLength, String out) {
		    	this.type= type;
		        this.data= data;		     
		        this.indexBegin = indexBegin;
		        this.indexEnd = indexEnd;
		        this.thresholdLo = thresholdLo;
		        this.thresholdHi = thresholdHi;
		        this.winLength = winLength;
		        this.expectedOutput = out;
		    }
	    
	  
	    @Test
	    public void testSearchMultiContinuityWithinRange() {
	    	Assume.assumeTrue(type == Type.searchMultiContinuityWithinRange);
	        assertEquals(expectedOutput, SensorDataAnalysis.searchMultiContinuityWithinRange(data,indexBegin,indexEnd,thresholdLo,thresholdHi,winLength));
	    }
	    
	}


