package dbconnector;


public class App 
{
    public static void main(String args[]){
        try{
            DatabaseConnector db = new DatabaseConnector();
            db.connect();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}