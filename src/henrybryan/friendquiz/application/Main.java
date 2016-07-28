/**
 * 
 */
package henrybryan.friendquiz.application;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Main {

	public static final String dbName= "FQ";
	
	public static void main(String[] args) {
		startUp();
		shutDown();
		System.out.println("Sefini, All done");
	}

	public static void startUp() {
		System.out.println("startUp()");
		Services.createDataAccess(dbName);
	}
	
	public static void shutDown() {
		System.out.println("shutDown()");
		Services.closeDataAccess();
	}
}
