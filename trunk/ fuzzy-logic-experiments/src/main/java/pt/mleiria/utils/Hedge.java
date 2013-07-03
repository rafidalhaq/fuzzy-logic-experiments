/**
 * 
 */
package pt.mleiria.utils;

/**
 * @author NB13712
 *
 */
public class Hedge {
	
	
	public static float GREATLY(final float value){
		return VERY(value);
	}
	public static float VERY(final float value){
		return MathUtils.roundNPlaces((float)Math.pow(value, 2), 100.0f);
	}
	
	public static float SLIGHTLY(final float value){
		return MathUtils.roundNPlaces((float)Math.sqrt(value), 100.0f);
	}

}
