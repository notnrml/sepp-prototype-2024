module org.bham {
    requires javafx.controls;
    requires javafx.fxml;

    //requires org.controlsfx.controls;

    opens org.bham to javafx.fxml;
    exports org.bham;
}
