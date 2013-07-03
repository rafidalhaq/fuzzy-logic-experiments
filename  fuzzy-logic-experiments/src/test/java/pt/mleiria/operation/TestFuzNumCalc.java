/**
 * 
 */
package pt.mleiria.operation;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * @author NB13712
 *
 */
public class TestFuzNumCalc extends TestCase{
	private static final Logger LOG = Logger.getLogger(TestFuzNumCalc.class);
	
	public void testAdd(){
		FuzNumCalc fnc = new FuzNumCalcImpl(new float[]{-1,2,5}, new float[]{3,5,7});
		
		float[] result = fnc.add();
		LOG.info("Result-->[" + result[0] + ";" + result[1] + ";" + result[2] + "]");
		assertEquals(result[0], 2.0f);
		assertEquals(result[1], 7.0f);
		assertEquals(result[2], 12.0f);
	}
	
	public void testSubtract(){
		FuzNumCalc fnc = new FuzNumCalcImpl(new float[]{-2,3,8}, new float[]{-1,2,7});
		
		float[] result = fnc.subtract();
		LOG.info("Result-->[" + result[0] + ";" + result[1] + ";" + result[2] + "]");
		assertEquals(result[0], -8.0f);
		assertEquals(result[1], 1.0f);
		assertEquals(result[2], 10.0f);
	}
	public void testMultiply(){
		FuzNumCalc fnc = new FuzNumCalcImpl(new float[]{-2,3,8}, new float[]{-1,2,7});
		
		float[] result = fnc.multiply();
		LOG.info("Result-->[" + result[0] + ";" + result[1] + ";" + result[2] + "]");
		assertEquals(result[0], -3.0f);
		assertEquals(result[1], 6.0f);
		assertEquals(result[2], 15.0f);
	}
	public void testDivide(){
		FuzNumCalc fnc = new FuzNumCalcImpl(new float[]{-2,3,8}, new float[]{-1,2,7});
		
		float[] result = fnc.divide();
		LOG.info("Result-->[" + result[0] + ";" + result[1] + ";" + result[2] + "]");
		assertEquals(result[0], -7.5f);
		assertEquals(result[1], 1.5f);
		assertEquals(result[2], 10.5f);
	}
}
