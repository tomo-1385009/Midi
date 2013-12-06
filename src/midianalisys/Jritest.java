/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midianalisys;

/**
 *
 * @author tomo
 */
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;
class Jritest 
{
	public static void main(String[] args) 
	{
		Rengine engine = new Rengine(new String[]{"--no-save"}, false, null);
		engine.assign("a", new int[]{36});
		REXP result = engine.eval("sqrt(a)");
		System.out.println(result.asDouble());
		engine.end();
	}
}
