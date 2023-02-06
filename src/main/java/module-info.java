module com.ticketon.ticketon {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.ticketon.ticketon to javafx.fxml;
    exports com.ticketon.ticketon;
}