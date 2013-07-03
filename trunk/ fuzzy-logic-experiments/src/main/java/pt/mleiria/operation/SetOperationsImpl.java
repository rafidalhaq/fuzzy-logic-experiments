/**
 * 
 */
package pt.mleiria.operation;

import pt.mleiria.utils.MathUtils;


/**
 * @author NB13712
 * 
 */
public class SetOperationsImpl implements SetOperations {

	private float a;
	private float b;
	private static final float ONE = 1.0f;

	public SetOperationsImpl(final float a, final float b) {
		if (!isValid(a, b)) {
			throw new IllegalArgumentException(
					"Os argumentos devem estar no intervalo [0,1]");
		}
		this.a = a;
		this.b = b;
	}

	public SetOperationsImpl() {

	}

	public void setA(float a) {
		this.a = a;
	}

	public void setB(float b) {
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.mleiria.operation.SetOperations#conjuntion()
	 */
	public float conjunction() {
		return Math.min(a, b);
	}

	public float difference() {
		final float result = MathUtils.roundNPlaces(a - b, 10.0f);
		return result < 0.0f ? 0.0f : result; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.mleiria.operation.SetOperations#disjunction()
	 */
	public float disjunction() {
		return Math.max(a, b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.mleiria.operation.SetOperations#not()
	 */
	public float not(final float x) {
		if (!isValid(x, x)) {
			throw new IllegalArgumentException(
					"Os argumentos devem estar no intervalo [0,1]");
		}
		return MathUtils.roundNPlaces(ONE - x, 10.0f);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.mleiria.operation.SetOperations#implication()
	 */
	public boolean implication() {
		return a >= b ? true : false;
	}

	private boolean isValid(final float a, final float b) {
		if (a > 1 || a < 0) {
			return false;
		} else if (b > 1 || b < 0) {
			return false;
		} else {
			return true;
		}
	}

}
