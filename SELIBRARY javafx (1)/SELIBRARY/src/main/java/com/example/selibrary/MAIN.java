
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.geometry.Pos.CENTER_LEFT;
import static javafx.geometry.Pos.CENTER_RIGHT;


public class MAIN extends Application {

static   Scene sc1;
    static Scene scene;
    static Scene signupscene;
    static Scene scene2;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       launch(args);
        Scanner sc = new Scanner(System.in);
        Student s1 = null;
        try {
            s1 = new Student();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(" C language",1, "111-222-333", "5-12-2000",  50));
        books.add(new Book("Java: A Beginner’s Guide ",2, "1260440210 ", "10-10-2019 ", 43));
        books.add(new Book("Introduction to Algorithms",3, "0262033844", "31-07-2009", 45));
        books.add(new Book("Head First Design Patterns",4, "0596007124", "09-04-2004", 45));
        books.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship",5, "0132350882", "11-08-2008", 10));
        books.add(new Book(" Python Crash Course, 2nd Edition: A Hands-On, Project-Based Introduction to Programming", 6, "1593279280", "01-05-2019", 5));
        books.add(new Book("JavaScript: The Good Parts",7, "0596517742", "01-05-2008", 12));
        books.add(new Book("Programming in ANSI C",8, "8120305965", "01-03-1994", 10));
        books.add(new Book("The C++ Programming Language, 4th Edition",9, "0321563840", "31-05-2013", 15));
        books.add(new Book("The Art of Computer Programming, Vol. 1: Fundamental Algorithms, 3rd Edition",10, "0201896834", "24-07-1997",  7));
        //   File myfile = new File("BookInfo.txt");
        File file=new File("signup.txt");
        file.createNewFile();

        Account a1 = new Account(books);


        Librarian l1 = null;
        try {
            l1 = new Librarian();
            User u1 = new User();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            a1.Interface2();

        } catch (Exception e) {

            System.out.println("Invalid Output Please input valid input");
            a1.Interface2();
            System.out.println(e.getMessage());
        }

    }

    private ImageView imageview;
    @Override
    public void start(Stage stage) throws IOException {
        StackPane stackPane=new StackPane();
        stage.setTitle("Library Management System");

        //welcome page
        Image wlcmImage = new Image("D:\\SELIBRARY\\src\\main\\java\\com\\example\\selibrary\\Untitled-1 copy 1.PNG");
        ImageView imageViewwlcmImage = new ImageView(wlcmImage);
        imageViewwlcmImage.setFitWidth(800);
        imageViewwlcmImage.setFitHeight(800);
        imageViewwlcmImage.setPreserveRatio(true);
        // start button
        Button startButton = new Button("Start");
        stackPane.getChildren().add(startButton);
        startButton.setFont(Font.font("Century Gothic",15));

        VBox buttonContainer = new VBox(startButton);
        buttonContainer.setAlignment(Pos.BOTTOM_CENTER);
        buttonContainer.setSpacing(10);

        //event handling on start button
        startButton.setOnAction(actionEvent ->{

            HBox hbox2=new HBox();
            Image StLibtImage = new Image("D:\\SELIBRARY\\src\\main\\java\\com\\example\\selibrary\\combiine 2 copy.PNG");
            ImageView imageViewStLib = new ImageView(StLibtImage);
            imageViewStLib.setFitWidth(800);
            imageViewStLib.setFitHeight(800);
            imageViewStLib.setPreserveRatio(true);
            hbox2.getChildren().add(imageViewStLib);
            hbox2.setAlignment(Pos.CENTER);
            hbox2.setAlignment(Pos.BOTTOM_LEFT);

            Button button1= new Button("Librarian");
            button1.setFont(Font.font("Century Gothic",15));
            Button button2= new Button("Student");
            button2.setFont(Font.font("Century Gothic",15));

            VBox imagev=new VBox(imageViewStLib);

            button1.setAlignment(Pos.CENTER);
            button2.setAlignment(Pos.CENTER);

            VBox vb= new VBox(imageViewStLib,button1,button2);
            vb.setAlignment(Pos.TOP_CENTER);
            vb.setLayoutX(0);
            vb.setLayoutY(20);
            vb.setSpacing(5);

            imagev.setAlignment(Pos.CENTER);
            sc1=new Scene(vb);

            stage.setScene(sc1);
            stage.setFullScreen(true);

            stage.show();


            //button1 event handling
            button1.setOnAction(e->{
                stage.setTitle("Library Management System");

                // Create a box
                HBox fronthbox = new HBox();
                VBox leftVBox = new VBox();
                HBox centerhbox= new HBox();

                // login img
                Image leftImage = new Image("D:\\SELIBRARY\\src\\main\\java\\com\\example\\selibrary\\LOGINN.png");
                ImageView imageViewleft = new ImageView(leftImage);
                imageViewleft.setFitWidth(800);
                imageViewleft.setFitHeight(800);
                imageViewleft.setPreserveRatio(true);

                leftVBox.getChildren().add(imageViewleft);
                leftVBox.setAlignment(Pos.TOP_CENTER);
                centerhbox.setAlignment(Pos.TOP_CENTER);

                BorderPane borderPane = new BorderPane();
                //login section
                Label usernameLabel = new Label("Username:");
                usernameLabel.setFont(Font.font("Century Gothic",15));
                TextField usernameTextField = new TextField();
                HBox hboxtextfield = new HBox(usernameTextField);
                hboxtextfield.setSpacing(27);
                usernameTextField.setAlignment(Pos.BOTTOM_CENTER);

                Label passwordLabel = new Label("Password:");
                passwordLabel.setFont(Font.font("Century Gothic",15));

                PasswordField passwordField = new PasswordField();
                HBox hBoxpasswordfield = new HBox(passwordField);
                hBoxpasswordfield.setSpacing(15);

                Button loginButton = new Button("Login");
                loginButton.setFont(Font.font("Century Gothic",15));
                Button backButton = new Button("Back");
                backButton.setFont(Font.font("Century Gothic",15));

                backButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stage.setScene(sc1);
                    }
                });

                // Set event handler on login button
                loginButton.setOnAction(e1 -> {
                    String username = usernameTextField.getText();
                    String password = passwordField.getText();

                    try {
                        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("User Details.txt"));
                        obj.readObject();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        User u1 = new User();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        if (username.equals(new User().getUserName()) && password.equals(new User().getPassword())) {
                            System.out.println("Login successful");
                        } else {
                            System.out.println("Login failed");
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                //SignUp SCENE
                Button button3 = new Button("Signup");
                button3.setFont(Font.font("Century Gothic",15));
                button3.setOnAction(actionEvent1 -> {
                    Image imagelogo = new Image("D:\\SELIBRARY\\src\\main\\java\\com\\example\\selibrary\\signup bottom.png");
                    ImageView logoview = new ImageView(imagelogo);
                    VBox vboxlogo = new VBox(logoview);
                    vboxlogo.setAlignment(Pos.CENTER);
                    vboxlogo.setLayoutX(0);
                    vboxlogo.setLayoutY(20);
                    Button registerbt = new Button("Register");
                    registerbt.setFont(Font.font("Century Gothics",15));
                    HBox hboxreg = new HBox(registerbt);
                    registerbt.setOnAction(actionEvent2 -> {
                        stage.setScene(scene2);
                        stage.setFullScreen(true);
                    });

                    //registerbt.setAlignment(Pos.CENTER);
                    Label namelabel = new Label("Name:");
                    Label passwordlabel = new Label("Password:");
                    TextField usernameTextField1 = new TextField();

                    String username = usernameTextField1.getText();
                    PasswordField passwordField1 = new PasswordField();
                    String password = passwordField1.getText();
                    HBox hBox= new HBox(namelabel,usernameTextField1);
                    hBox.setSpacing(27);
                    hBox.setAlignment(Pos.TOP_CENTER);
                    HBox hBox1= new HBox(passwordlabel,passwordField1);
                    hBox1.setAlignment(Pos.CENTER);
                    hboxreg.setAlignment(Pos.CENTER);
                    hBox1.setSpacing(15);
                    Button backButton2 = new Button("Back");
                    backButton2.setFont(Font.font("Century Gothic",15));
                    //backButton2.setAlignment(Pos.CENTER);
                    HBox hboxback = new HBox(backButton2);
                    hboxback.setAlignment(Pos.CENTER);


                    backButton2.setOnAction(e3 -> {
                        stage.setScene(scene2);
                        stage.setFullScreen(true);

                    });

                    VBox vboxsignup = new VBox(vboxlogo,hBox,hBox1,hboxreg,hboxback);
                    vboxsignup.setSpacing(10);

                    signupscene = new Scene(vboxsignup);
                    stage.setScene(signupscene);
                    stage.setHeight(800);
                    stage.setWidth(800);
                    stage.setFullScreen(true);
                    stage.show();
                });
                Button backButton2 = new Button("Back");
                backButton2.setFont(Font.font("Century Gothic",15));
                //backbutton handling

                backButton2.setOnAction(e3 -> {
                    stage.setScene(sc1);
                    stage.setFullScreen(true);

                });

                VBox loginVBox = new VBox();
                loginVBox.setSpacing(10);
                usernameLabel.setAlignment(CENTER_LEFT);
                usernameTextField.setAlignment(Pos.BOTTOM_LEFT);
                passwordLabel.setAlignment(CENTER_LEFT);
                passwordField.setAlignment(Pos.BOTTOM_LEFT);
                loginVBox.getChildren().addAll(usernameLabel, hboxtextfield, passwordLabel, hBoxpasswordfield, loginButton,backButton,button3);

                borderPane.setRight(centerhbox);
                centerhbox.setAlignment(CENTER_RIGHT);
                borderPane.setLeft(leftVBox);
                borderPane.setCenter(loginVBox);

                loginVBox.setAlignment(CENTER_LEFT);

                scene2=new Scene(borderPane);

                stage.setScene(scene2);
                stage.setFullScreen(true);
                stage.show();

            });
            button2.setOnAction(e->{
                stage.setTitle("Library Management System");

                // Create a layout for the center area
                HBox fronthbox = new HBox();
                VBox leftVBox = new VBox();
                HBox centerhbox= new HBox();

                // login image
                Image leftImage = new Image("D:\\SELIBRARY\\src\\main\\java\\com\\example\\selibrary\\LOGINN.png");
                ImageView imageViewleft = new ImageView(leftImage);
                imageViewleft.setFitWidth(800);
                imageViewleft.setFitHeight(800);
                imageViewleft.setPreserveRatio(true);

                leftVBox.getChildren().add(imageViewleft);

                centerhbox.setAlignment(Pos.TOP_CENTER);

                BorderPane borderPane = new BorderPane();
                //login section
                Label usernameLabel = new Label("Username:");
                usernameLabel.setFont(Font.font("Century Gothic",15));
                TextField usernameTextField = new TextField();
                HBox hboxtextfield = new HBox(usernameTextField);
                hboxtextfield.setSpacing(27);
                Label passwordLabel = new Label("Password:");
                passwordLabel.setFont(Font.font("Century Gothic",15));
                PasswordField passwordField = new PasswordField();
                HBox hboxpasswordfield = new HBox(passwordField);
                hboxpasswordfield.setSpacing(27);


                Button loginButton = new Button("Login");
                loginButton.setFont(Font.font("Century Gothic",15));
                Button backButton2 = new Button("Back");
                backButton2.setFont(Font.font("Century Gothic",15));
                Button button4 = new Button("Signup");
                button4.setFont(Font.font("Century Gothic",15));
                button4.setOnAction(actionEvent1 -> {
                    stage.setScene(signupscene);
                    stage.setFullScreen(true);
                });

                
                backButton2.setOnAction(e3 -> {
                    stage.setScene(sc1);
                    //stage.setFullScreen(true);

                });


                // Set event handler on login button
                loginButton.setOnAction(e1 -> {
                    // Perform login logic here
                    try {
                        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("User Details.txt"));
                    obj.readObject();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    String username = usernameTextField.getText();
                    String password = passwordField.getText();
                    User u1= null;

 try {
                        u1 = new User();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    // Example login validation
                    if (username.equals("1") && password.equals("1")) {
                        System.out.println("Login successful");
                    } else {
                        System.out.println("Login failed");
                    }

                });

                VBox loginVBox = new VBox();
                loginVBox.setSpacing(10);

                usernameLabel.setAlignment(CENTER_LEFT);
                usernameTextField.setAlignment(Pos.BOTTOM_LEFT);
                passwordLabel.setAlignment(CENTER_LEFT);
                passwordField.setAlignment(Pos.BOTTOM_LEFT);
                loginVBox.getChildren().addAll(usernameLabel, hboxtextfield, passwordLabel, hboxpasswordfield, loginButton,backButton2,button4);

                borderPane.setRight(centerhbox);
                centerhbox.setAlignment(CENTER_RIGHT);
                borderPane.setLeft(leftVBox);
                borderPane.setCenter(loginVBox);
                loginVBox.setAlignment(CENTER_LEFT);

                Scene scene = new Scene(borderPane);

                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();

            });
        });
//welcome stage
        stackPane.getChildren().addAll(imageViewwlcmImage,buttonContainer);
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
