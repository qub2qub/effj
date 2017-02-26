// Service provider framework sketch - Service provider interface - Page 12
package effj.ch02.item01;

public interface Provider {
	Service newService();

	static String getStr() {return "str";}; // since 1.8
}