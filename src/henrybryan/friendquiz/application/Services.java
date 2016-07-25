/**
 * 
 */
package henrybryan.friendquiz.application;

import henrybryan.friendquiz.persistence.DataAccessStub;

/**
 * @author Bryan Wodi <talk2kamp@gmail.com>
 *
 */
public class Services {
	private static DataAccessStub dataAccessService = null;
	
	public static DataAccessStub createDataAccess(String dbName){
        if (dataAccessService == null)
        {
            dataAccessService = new DataAccessStub(dbName);
            dataAccessService.open(dbName);
        }
        return dataAccessService;
    }
	
	public static DataAccessStub getDataAccess(String dbName){
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
