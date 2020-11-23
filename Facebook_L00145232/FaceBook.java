/*
JAMES KELLY - L00145232
CA 
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import java.io.FileInputStream;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.scene.control.Alert.AlertType; 

// PetrolPrice IS-A Application ==> Inheritance
public class FaceBook extends Application{
   
   private Font buttonFont,labelFont;
   private Stage window;
   private Scene scene,signUp;
   private BorderPane sceneLayout,sceneLayout2;
   private GridPane topPane;
   private Button b1,b2;
   private String sql;
   FacebookDB fbDb = new FacebookDB();
   @Override
   public void start(Stage primaryStage){
      //font and design
      labelFont=Font.font("Sans Serif",FontWeight.BOLD,18);
      buttonFont=Font.font("Sans Serif",FontWeight.BOLD,18);
   
      //initializing window
      window=primaryStage;
      
      //image info     
      ImageView imageView = new ImageView("facebook.png");
      HBox hbox = new HBox(imageView);
      ImageView imageView2 = new ImageView("facebook.png");
      HBox hbox2 = new HBox(imageView2);
      imageView2.setFitHeight(170);
      //buttons recognition
      b2=new Button("Sign Up");
      b2.setOnAction(event->window.setScene(signUp));
      VBox rightPaneHome= new VBox(0);
      b1=new Button("Log in");
      b1.setOnAction((event)->{System.out.println("LOG IN BUTTON CLICKED");});     
      b1.setPrefWidth(100);
      b2.setPrefWidth(100);
      b1.setStyle("-fx-border-color: #000000;-fx-background-color: #f0f8ff;");
      b2.setStyle("-fx-border-color: #000000;-fx-background-color: #f0f8ff;");
      rightPaneHome.getChildren().addAll(b1,b2);
      
     
      //sign up page
      sceneLayout2 = new BorderPane();
      signUp=new Scene(sceneLayout2);
      window.setScene(signUp);
      sceneLayout2.setLeft(imageView2); 
      sceneLayout2.setRight(signUpInfo());
      window.setTitle("SIGN UP FACEBOOK");
      window.show();
      
      //home page
      
      sceneLayout = new BorderPane();
      scene=new Scene(sceneLayout);
      sceneLayout.setLeft(leftPaneHome());  
      sceneLayout.setRight(rightPaneHome);
      sceneLayout.setBottom(imageView);
      primaryStage.setScene(scene);
      
      primaryStage.setTitle("LOGIN ");
      primaryStage.show();
      
   } 
   private GridPane leftPaneHome()
   {
      GridPane leftPane= new GridPane();
      Label email = new Label("Email:");
      leftPane.add(email, 0, 1);
     
      
      TextField userTextField = new TextField();
      leftPane.add(userTextField, 1, 1);
   
      Label pw = new Label("Password:");
      leftPane.add(pw, 0, 2);
   
      PasswordField pwBox = new PasswordField();
      leftPane.add(pwBox, 1, 2);
      email.setPrefWidth(110);
      pw.setPrefWidth(110);
      return leftPane;
   }
   
   private GridPane signUpInfo()
   {
   //initializing
      GridPane signUpInfo= new GridPane();
      Label l1=new Label("Sign Up");
      TextField firstname = new TextField("Enter First Name");
      TextField lastname = new TextField("Enter Surname");
      TextField emailaddress = new TextField("Enter Email Address");
      TextField password = new TextField("Enter Password");
      Button b1= new Button("Sign Up");
      
      //grid layout
      signUpInfo.add(l1, 2, 0);
      signUpInfo.add(firstname, 2, 1);
      signUpInfo.add(lastname, 2, 2);
      signUpInfo.add(emailaddress, 2, 3);
      signUpInfo.add(password, 2, 4);
      signUpInfo.add(b1,2,5);
      
       //button event sql
       
      Alert a = new Alert(AlertType.NONE); //create an alert
      b1.setOnAction(
         (event)->{
            System.out.println("SIGN UP BUTTON CLICKED");
            sql = "INSERT INTO user VALUES ("+"'"+emailaddress.getText()+"','"+password.getText()+"','"+firstname.getText()+"','"+lastname.getText()+"')"+
               "ON DUPLICATE KEY UPDATE password='"+password.getText()+"',firstname='"+firstname.getText()+"',lastname='"+lastname.getText()+"'";
            fbDb.createDatabase();
            fbDb.insertIntoDatabase(sql);
               // set alert type 
                a.setContentText(firstname.getText()+" "+lastname.getText()+" has been signed up to Facebook");
                a.setAlertType(AlertType.CONFIRMATION); 
                // show the dialog 
                a.show(); 
           
         }
         );
       
      //styling
      b1.setPrefWidth(150);
      b1.setStyle("-fx-border-color: #000000;-fx-background-color: #f0f8ff;");
      l1.setFont(labelFont);
      b1.setFont(buttonFont);
      l1.setAlignment(Pos.CENTER);
      
      return signUpInfo;
   }
   
  
   public static void main(String[] args){
      launch(args);
   }
      
  
}
