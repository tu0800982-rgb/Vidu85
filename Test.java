package test;

import javax.swing.UIManager;

import model.TimKiemModel;
import view.TimKiemView;

public class Test {
public static void main(String[] args) {
	 try {
		        //Xét Giao Diện trước
		        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
		        //Sau đó mới Tạo UI
		    	new TimKiemView(); // Tạo cửa sổ và chạy chương trình
		    	
		    } catch (Exception ex) {
		        ex.printStackTrace(); // Nếu set giao diện lỗi, in lỗi ra bảng điều khiển
		    }
	    }
}

