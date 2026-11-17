package util;

import java.sql.Connection;

public class test {
	 public static void main(String[] args) {
	        try (Connection conn = JdbcUtil.getConnection()) {
	            System.out.println("Ket noi thanh cong!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
