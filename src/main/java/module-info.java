module org.bham {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;

    //requires org.controlsfx.controls;

    opens org.bham to javafx.fxml;
    exports org.bham;
}
