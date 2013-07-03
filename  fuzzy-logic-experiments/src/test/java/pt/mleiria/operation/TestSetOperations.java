/**
 * 
 */
package pt.mleiria.operation;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import pt.mleiria.utils.Hedge;

/**
 * @author NB13712
 *
 */
public class TestSetOperations extends TestCase {
	private static final Logger LOG = Logger.getLogger(TestSetOperations.class);
	
	public void testConjunction(){
		final SetOperations so = new SetOperationsImpl(0.3f, 0.8f);
		assertEquals(0.3f, so.conjunction());
	}
	
	public void testDisjunction(){
		final SetOperations so = new SetOperationsImpl(0.2f, 0.6f);
		assertEquals(0.6f, so.disjunction());
	}
	public void testNot(){
		final SetOperations so = new SetOperationsImpl();
		assertEquals(0.1f, so.not(0.9f));
	}
	public void testImplication(){
		final SetOperations so = new SetOperationsImpl(0.8f, 0.7f);
		assertEquals(true, so.implication());
		so.setA(0.7f);
		so.setB(0.8f);
		assertEquals(false, so.implication());
		
	}
	public void testDifference(){
		final SetOperations so = new SetOperationsImpl(0.8f, 0.1f);
		assertEquals(0.7f, so.difference());
		so.setA(0.2f);
		so.setB(0.3f);
		assertEquals(0.0f, so.difference());
		so.setA(0.7f);
		so.setB(0.4f);
		assertEquals(0.3f, so.difference());
	}
	public void testComplement(){
		final SetOperations so = new SetOperationsImpl();
		final float a = 0.8f;
		so.setA(a);
		so.setB(so.not(a));
		final float disunction = so.disjunction();
		assertEquals(0.8f, disunction);
	}
	public void testSeriesOfConjunctions(){
		final SetOperations so = new SetOperationsImpl();
		final float a = 0.7f;
		final float b = 0.2f;
		final float c = 0.3f;
		final float d = 0.1f;
		final float e = 0.6f;
		so.setA(a);
		so.setB(b);
		float ab = so.conjunction();
		so.setA(ab);
		so.setB(c);
		float abc = so.conjunction();
		so.setA(abc);
		so.setB(d);
		float abcd = so.conjunction();
		so.setA(abcd);
		so.setB(e);
		float result = so.conjunction();
		assertEquals(0.1f, result);
	}
	public void testSeriesOfConjunctions_1(){
		LOG.info("START testSeriesOfConjunctions_1");
		final SetOperations so = new SetOperationsImpl();
		final float a = 0.7f;
		final float b = 0.2f;
		final float c = 0.3f;
		final float d = 0.1f;
		final float e = 0.6f;
		final float hedgedA = so.not(a);
		LOG.info("A-->" +  a + ":hedgedA-->" + hedgedA);
		so.setA(hedgedA);
		so.setB(b);
		LOG.info("B-->" +  b + ":hedgedB-->" + b);
		float ab = so.conjunction();
		so.setA(ab);
		so.setB(c);
		LOG.info("C-->" +  c + ":hedgedC-->" + c);
		float abc = so.conjunction();
		so.setA(abc);
		so.setB(d);
		LOG.info("D-->" +  d + ":hedgedD-->" + d);
		float abcd = so.conjunction();
		so.setA(abcd);
		so.setB(e);
		LOG.info("E-->" +  e + ":hedgedE-->" + e);
		float result = so.conjunction();
		LOG.info("R-->" +  result + ":hedgedR-->" + result);
		LOG.info("END testSeriesOfConjunctions_1");
		assertEquals(0.1f, result);
	}
	public void testSeriesOfConjunctions_2(){
		LOG.info("START testSeriesOfConjunctions_2");
		final SetOperations so = new SetOperationsImpl();
		final float a = 0.7f;
		final float b = 0.2f;
		final float c = 0.3f;
		final float d = 0.1f;
		final float e = 0.6f;
		final float hedgedA = a;
		LOG.info("A-->" +  a + ":hedgedA-->" + hedgedA);
		so.setA(hedgedA);
		so.setB(b);
		LOG.info("B-->" +  b + ":hedgedB-->" + b);
		float ab = so.conjunction();
		so.setA(ab);
		so.setB(c);
		LOG.info("C-->" +  c + ":hedgedC-->" + c);
		float abc = so.conjunction();
		so.setA(abc);
		float hedgedD = Hedge.VERY(d);
		so.setB(hedgedD);
		LOG.info("D-->" +  d + ":hedgedD-->" + hedgedD);
		float abcd = so.conjunction();
		so.setA(abcd);
		so.setB(e);
		LOG.info("E-->" +  e + ":hedgedE-->" + e);
		float result = so.conjunction();
		LOG.info("R-->" +  result + ":hedgedR-->" + result);
		LOG.info("END testSeriesOfConjunctions_2");
		assertEquals(0.01f, result);
	}
	public void testSeriesOfDisjunction(){
		LOG.info("START testSeriesOfDisjunction");
		final SetOperations so = new SetOperationsImpl();
		final float a = 0.7f;
		final float b = 0.2f;
		final float c = 0.3f;
		final float d = 0.1f;
		final float e = 0.6f;
		final float hedgedA = a;
		LOG.info("A-->" +  a + ":hedgedA-->" + hedgedA);
		so.setA(hedgedA);
		so.setB(b);
		LOG.info("B-->" +  b + ":hedgedB-->" + b);
		float ab = so.disjunction();
		so.setA(ab);
		so.setB(c);
		LOG.info("C-->" +  c + ":hedgedC-->" + c);
		float abc = so.disjunction();
		so.setA(abc);
		float hedgedD = d;
		so.setB(hedgedD);
		LOG.info("D-->" +  d + ":hedgedD-->" + hedgedD);
		float abcd = so.disjunction();
		so.setA(abcd);
		so.setB(e);
		LOG.info("E-->" +  e + ":hedgedE-->" + e);
		float result = so.disjunction();
		LOG.info("R-->" +  result + ":hedgedR-->" + result);
		LOG.info("END testSeriesOfDisjunction");
		assertEquals(0.7f, result);
	}


}