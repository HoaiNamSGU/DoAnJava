package test;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import dao.LaptopDAO;
import model.Laptop;
import view.mainView;


public class test {
	public static mainView mv;
	public static void main(String[] args) {	
		mv=new mainView();
	}
}

