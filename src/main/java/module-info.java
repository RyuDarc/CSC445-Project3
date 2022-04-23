module com.csc445.jvrr.pthree {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.csc445.jrvv.pthree to javafx.fxml;
    exports com.csc445.jrvv.pthree;
}