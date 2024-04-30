module com.example.selibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.selibrary to javafx.fxml;
    exports com.example.selibrary;
}