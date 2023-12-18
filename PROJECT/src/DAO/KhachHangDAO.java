package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.rtf.RTFEditorKit;

import DTO.KhachHang;

public class KhachHangDAO {
	public ArrayList<KhachHang> listKhachHangs() {
		try {
			ArrayList<KhachHang> result = new ArrayList<KhachHang>();
			ResultSet resultSet = new DBConn().queryDB("SELECT * FROM khachhang");
			while (resultSet.next()) {
				result.add(new KhachHang(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getDate("dateOrder"), resultSet.getInt("roomNumber")));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<KhachHang>();
	}
	
	public void addKhachHang(KhachHang khachHang) {
		try {
			new DBConn().updateDB("INSERT INTO khachhang(name, age, dateOrder, roomNumber) VALUES('"+khachHang.getName()+"','"+khachHang.getAge()+"','"+khachHang.getDateOrder()+"','"+khachHang.getRoomNumber()+"')");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editKhachHang(KhachHang khachHang) {
		try {
			new DBConn().updateDB("UPDATE khachhang SET name = '"+khachHang.getName()+"', age = '"+khachHang.getAge()+"', dateOrder = '"+khachHang.getDateOrder()+"', roomNumber = '"+khachHang.getRoomNumber()+"' WHERE id = '"+khachHang.getId()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isExist(KhachHang khachHang) {
	    ResultSet resultSet = null;
	    try {
	        resultSet = new DBConn().queryDB("SELECT * FROM khachhang WHERE id = '"+khachHang.getId()+"'");
	        
	        if (resultSet.next()) {
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public void deleteKhachHang(KhachHang khachHang) {
		try {
			new DBConn().updateDB("DELETE FROM khachhang WHERE id ='"+khachHang.getId()+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
