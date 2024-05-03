
module QuanLyKhoHangLaptop {
	requires java.desktop;
	requires java.sql;
	requires mysql.connector.java;
	requires org.apache.poi.ooxml;
	requires org.apache.poi.poi;
	requires itextpdf;
	requires javafx.controls;
	opens test to javafx.graphics, javafx.fxml;
}