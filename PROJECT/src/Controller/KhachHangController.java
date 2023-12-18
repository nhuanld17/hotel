package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.KhachHangGUI;

public class KhachHangController implements ActionListener{
	private KhachHangGUI khachHangGUI;
	
	

	public KhachHangController(KhachHangGUI khachHangGUI) {
		this.khachHangGUI = khachHangGUI;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name.equals("THÊM")) {
			khachHangGUI.setEmptyForm();
		}
		if (name.equals("SỬA")) {
			khachHangGUI.edit();
			while (name.equals("LƯU")) {
				JOptionPane.showInternalMessageDialog(null, "Sau khi sửa thông tin, hãy bấm nút cập nhật");
			}
		}
		if (name.equals("XÓA")) {
			khachHangGUI.delete();
		}
		if (name.equals("LƯU")) {
			khachHangGUI.save();
		}
		if (name.equals("UPDATE")) {
			khachHangGUI.update();
		}
	}
}
