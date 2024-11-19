module es.masanz.ut4.diana.app {
    requires javafx.controls;
    requires javafx.fxml;

    exports es.masanz.ut4.diana.util;
    exports es.masanz.ut4.diana.app;

    opens es.masanz.ut4.diana.util to javafx.fxml;
    opens es.masanz.ut4.diana.app to javafx.fxml;
}