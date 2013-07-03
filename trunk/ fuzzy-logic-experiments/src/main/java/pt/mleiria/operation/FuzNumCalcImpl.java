/**
 * 
 */
package pt.mleiria.operation;

/**
 * @author NB13712
 *
 */
public class FuzNumCalcImpl implements FuzNumCalc{

	private final float[] a;
	private final float[] b;
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public FuzNumCalcImpl(float[] a, float[] b) {
		if(!isValid(a,b)){
			throw new IllegalArgumentException("Os argumentos não são válidos!");
		}
		this.a = a;
		this.b = b;
	}
	public float[] add() {
		float result[] = new float[3];
		float apex = addApex(a[1], b[1]);
		result[1] = apex;
		getMargins(apex, result);
		return result;
	}

	public float[] subtract() {
		float result[] = new float[3];
		float apex = subtractApex(a[1], b[1]);
		result[1] = apex;
		getMargins(apex, result);
		return result;
	}

	public float[] multiply() {
		float result[] = new float[3];
		float apex = multiplyApex(a[1], b[1]);
		result[1] = apex;
		getMargins(apex, result);
		return result;
	}

	public float[] divide() {
		float result[] = new float[3];
		float apex = divideApex(a[1], b[1]);
		result[1] = apex;
		getMargins(apex, result);
		return result;
	}

	private float addApex(float apexA, float apexB){
		return apexA + apexB;
	}

	private float subtractApex(float apexA, float apexB){
		return apexA - apexB;
	}
	
	private float multiplyApex(float apexA, float apexB){
		return apexA * apexB;
	}
	
	private float divideApex(float apexA, float apexB){
		return apexA / apexB;
	}
	
	private void getMargins(final float apex, final float[] result){
		float base = findBase(a[0], a[2], b[0], b[2]);
		float leftHand = apex - base;
		result[0] = leftHand;
		float rightHand = apex + base;
		result[2] = rightHand;
	}

	private float findBase(float aInf, float aSup, float bInf, float bSup){
		return (((aSup - aInf) + (bSup - bInf)) / 2);
	}
	
	private boolean isValid(final float[] a, final float[] b){
		//Validar a ordem crescente
		if(a.length != 3 && b.length != 3){
			return false;
		}else{
			if(verifySort(a) && verifySort(b)){
				return true;
			}else{
				return false;
			}
		}
	}
	private boolean verifySort(float[] input){
		if(input[0] > input[1] || input[0] > input[2] || input[1] > input[2]){
			return false;
		}else{
			return true;
		}
	}
}
