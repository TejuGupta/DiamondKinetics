
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class SearchContinuityAboveValueTest {
		
		enum Type {searchContinuityAboveValue,backSearchContinuityWithinRange,searchContinuityAboveValueTwoSignals,searchMultiContinuityWithinRange};
		
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 {Type.searchContinuityAboveValue,"../DiamondKinetics/src/latestSwing.csv", 139, 145, 0.4564, 3, 139}, 
	                 {Type.searchContinuityAboveValue,"../DiamondKinetics/src/latestSwing.csv", 0, 10, -17.9999, 12, -1}, 
	                 {Type.searchContinuityAboveValue,"../DiamondKinetics/src/latestSwing.csv", 0, 25, 4.0, 15, -1}, 
	                 {Type.searchContinuityAboveValue,"../DiamondKinetics/src/latestSwing.csv", 1200, 1250, 3.0, 40, 1200}, 
	                
	               
	           });
	    }
	    private Type type;
	    private String data;
	    private int indexBegin,indexEnd,winLength;
	    private Double threshold;
	    private int expected;
	   

	    public SearchContinuityAboveValueTest(Type type,String data, int indexBegin, int indexEnd, Double threshold,
				int winLength, int out) {
	    	this.type= type;
	        this.data= data;
	        this.indexBegin = indexBegin;
	        this.indexEnd = indexEnd;
	        this.threshold = threshold;
	        this.winLength = winLength;
	        this.expected = out;
	    }
	    
	  
	    
	    @Test
	    public void testSearchContinuityAboveValue() {
	    	Assume.assumeTrue(type == Type.searchContinuityAboveValue);
	        assertEquals(expected, SensorDataAnalysis.searchContinuityAboveValue(data,indexBegin,indexEnd,threshold,winLength));
	    }
	    

	}


