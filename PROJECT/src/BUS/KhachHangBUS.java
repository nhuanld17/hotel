package BUS;

import java.util.ArrayList;

import DAO.KhachHangDAO;
import DTO.KhachHang;

public class KhachHangBUS {
	public ArrayList<KhachHang> listKhachHangs() {
		return new KhachHangDAO().listKhachHangs();
	}
	public void addKhachHang(KhachHang khachHang) {
		new KhachHangDAO().addKhachHang(khachHang);
	}
	public void edit(KhachHang khachHang) {
		new KhachHangDAO().editKhachHang(khachHang);
	}
	public boolean isExist(KhachHang khachHang) {
		return new KhachHangDAO().isExist(khachHang);
	}
	public void delete(KhachHang khachHang) {
		new KhachHangDAO().deleteKhachHang(khachHang);
	}
}
