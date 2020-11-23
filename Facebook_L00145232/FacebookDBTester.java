public class FacebookDBTester{
   public static void main(String[] args) {
      FacebookDB fbDb = new FacebookDB();
      String sql = "INSERT INTO user VALUES ('bart.simpson@lyit.ie','LetMeIn','Bart','Simpson') " +
            "ON DUPLICATE KEY UPDATE password='LetMeIn',firstname='Bart',lastname='Simpson'";
      fbDb.createDatabase();
      fbDb.insertIntoDatabase(sql);
   }
}