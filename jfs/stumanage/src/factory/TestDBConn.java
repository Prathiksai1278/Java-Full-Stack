package factory;

public class TestDBConn {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
            System.out.println("Connection successful to studb (localhost:3306)");
        } catch (Exception e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}
