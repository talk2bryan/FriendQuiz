/**
 * 
 */
package ca.henrybryan.friendquiz.application;


import ca.henrybryan.friendquiz.persistence.DataAccess;
import ca.henrybryan.friendquiz.persistence.DataAccessStub;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Services {
	private static DataAccess dataAccessService = null;
	
	public static DataAccess createDataAccess(String dbName){
        if (dataAccessService == null)
        {
            dataAccessService = new DataAccessStub(dbName);
            dataAccessService.open(dbName);
        }
        return dataAccessService;
    }
	
	public static DataAccess getDataAccess(String dbName){
		//-----hack -- REMOVE --------//
		createDataAccess(dbName);
		//-----hack -- REMOVE --------//
        System.out.println(dbName + ": Initiating...");
        if (dataAccessService == null)
        {
            System.out.println("Connection could not be established.");
            System.exit(1);
        }
        return dataAccessService;
    }
	
	public static void closeDataAccess(){
        if (dataAccessService != null){
                dataAccessService.close();
                dataAccessService = null;
        }
    }

}
