/**
 * 
 */
package pt.mleiria.operation;

/**
 * @author NB13712
 *
 */
public interface SetOperations {
	/**
	 * intersec��o 
	 * @return
	 */
	public float conjunction();
	/**
	 * uni�o
	 * @return
	 */
	public float disjunction();
	/**
	 * nega��o
	 * @param x
	 * @return
	 */
	public float not(float x);
	/**
	 * contem
	 * @return
	 */
	public boolean implication();
	/**
	 * Logical difference (A\B) is set A minus the portion of it that is also in set B
	 * @return
	 */
	public float difference();
	public void setA(float a);
	public void setB(float b);


}
