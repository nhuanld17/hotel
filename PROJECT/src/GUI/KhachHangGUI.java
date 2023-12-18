package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.KhachHangBUS;
import BUS.RoomBUS;
import Controller.KhachHangController;
import DAO.RoomDAO;
import DTO.KhachHang;
import DTO.Room;

public class KhachHangGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_name;
    private JTextField textField_Age;
    private JTextField textField_roomNumber;
    private JTextField textField_dateOrder;
    private JTable table_KhachHang;
    private JTable table_Room;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KhachHangGUI frame = new KhachHangGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public KhachHangGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 496);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(34, 49, 63));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(SystemColor.activeCaption);
        tabbedPane.setBounds(0, 0, 861, 457);
        contentPane.add(tabbedPane);
        tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(34, 49, 63)); // Đổi màu nền của panel thành màu xanh đậm
        panel_1.setBorder(null);
        tabbedPane.addTab("THÔNG TIN KHÁCH HÀNG", null, panel_1, null);
        tabbedPane.setBackgroundAt(0, Color.WHITE);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("THÔNG TIN KHÁCH HÀNG");
        lblNewLabel.setForeground(new Color(240, 248, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(297, 11, 266, 25);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Họ và tên");
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 55, 79, 28);
        panel_1.add(lblNewLabel_1);
        
        textField_name = new JTextField();
        textField_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_name.setBackground(SystemColor.control);
        textField_name.setBounds(99, 55, 178, 28);
        panel_1.add(textField_name);
        textField_name.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("Tuổi");
        lblNewLabel_1_1.setForeground(SystemColor.text);
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 100, 79, 28);
        panel_1.add(lblNewLabel_1_1);
        
        textField_Age = new JTextField();
        textField_Age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Age.setBackground(SystemColor.control);
        textField_Age.setColumns(10);
        textField_Age.setBounds(99, 102, 178, 28);
        panel_1.add(textField_Age);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Số phòng");
        lblNewLabel_1_2_1.setForeground(SystemColor.text);
        lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(297, 100, 79, 28);
        panel_1.add(lblNewLabel_1_2_1);
        
        textField_roomNumber = new JTextField();
        textField_roomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_roomNumber.setBackground(SystemColor.control);
        textField_roomNumber.setColumns(10);
        textField_roomNumber.setBounds(421, 102, 178, 28);
        panel_1.add(textField_roomNumber);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Ngày đặt phòng");
        lblNewLabel_1_2_2.setForeground(SystemColor.text);
        lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_2.setBounds(297, 55, 119, 28);
        panel_1.add(lblNewLabel_1_2_2);
        
        textField_dateOrder = new JTextField();
        textField_dateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_dateOrder.setBackground(SystemColor.control);
        textField_dateOrder.setColumns(10);
        textField_dateOrder.setBounds(421, 57, 178, 28);
        panel_1.add(textField_dateOrder);
        
        ActionListener actionListener = new KhachHangController(this);
        
        JButton button_Them = new JButton("THÊM");
        button_Them.addActionListener(actionListener);
        button_Them.addActionListener(actionListener);
        button_Them.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT\\icon\\icons8-add-24.png"));
        button_Them.setFont(new Font("Tahoma", Font.BOLD, 14));
        button_Them.addActionListener(actionListener);
        button_Them.setBounds(619, 55, 113, 30);
        button_Them.setBackground(new Color(46, 204, 113)); // Đổi màu nền thành màu xanh lá cây
        button_Them.setForeground(Color.WHITE); // Đổi màu chữ thành trắng
        panel_1.add(button_Them);
        
        JButton button_Sua = new JButton("SỬA");
        button_Sua.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT\\icon\\icons8-edit-30.png"));
        button_Sua.setFont(new Font("Tahoma", Font.BOLD, 14));
        button_Sua.addActionListener(actionListener);
        button_Sua.setBounds(742, 55, 104, 30);
        button_Sua.setBackground(new Color(255, 165, 0)); // Đổi màu nền thành màu cam
        button_Sua.setForeground(Color.WHITE); // Đổi màu chữ thành trắng
        panel_1.add(button_Sua);
        
        JButton button_Xoa = new JButton("XÓA");
        button_Xoa.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT\\icon\\icons8-delete-24.png"));
        button_Xoa.addActionListener(actionListener);
        button_Xoa.setFont(new Font("Tahoma", Font.BOLD, 14));
        button_Xoa.setBounds(742, 100, 104, 30);
        button_Xoa.setBackground(new Color(231, 76, 60)); // Đổi màu nền thành màu đỏ
        button_Xoa.setForeground(Color.WHITE); // Đổi màu chữ thành trắng
        panel_1.add(button_Xoa);
        
        JButton button_Luu = new JButton("LƯU");
        button_Luu.addActionListener(actionListener);
        button_Luu.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT\\icon\\icons8-save-25.png"));
        button_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
        button_Luu.setBounds(619, 100, 113, 30);
        button_Luu.setBackground(new Color(52, 152, 219)); // Đổi màu nền thành màu xanh dương
        button_Luu.setForeground(Color.WHITE); // Đổi màu chữ thành trắng
        panel_1.add(button_Luu);
        
        table_KhachHang = new JTable();
        table_KhachHang.setFont(new Font("Calibri", Font.PLAIN, 16));
        table_KhachHang.setBackground(SystemColor.controlLtHighlight);
        table_KhachHang.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "H\u1ECD v\u00E0 t\u00EAn", "Tu\u1ED5i", "Ngày nhận phòng", "S\u1ED1 ph\u00F2ng"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, true, true, true, true
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        Font font = new Font("Arial", Font.BOLD, 16);
        JTableHeader header = table_KhachHang.getTableHeader();
        header.setFont(font);
        table_KhachHang.setBounds(10, 153, 836, 223);
        table_KhachHang.setRowHeight(25);
        updateKhachHangTable();

        
        JScrollPane scrollPane = new JScrollPane(table_KhachHang);
        scrollPane.setBounds(10, 205, 836, 216);
        panel_1.add(scrollPane);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 168, 589, 2);
        panel_1.add(separator);
        
        JButton btnNewButton = new JButton("UPDATE");
        btnNewButton.addActionListener(actionListener);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(742, 141, 104, 29);
        panel_1.add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(34, 49, 63));
        panel.setBorder(null);
        tabbedPane.addTab("THÔNG TIN PHÒNG", null, panel, null);
        tabbedPane.setBackgroundAt(1, Color.WHITE);
        panel.setLayout(null);
        
        table_Room = new JTable();
        table_Room.setFont(new Font("Calibri", Font.PLAIN, 16));
        table_Room.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"S\u1ED0 PH\u00D2NG", "TR\u1EA0NG TH\u00C1I"
        	}
        ));
        JTableHeader header1 = table_Room.getTableHeader();
        header1.setFont(font);
        table_Room.setBounds(10, 153, 836, 223);
        table_Room.setRowHeight(25);
        table_Room.setBounds(204, 62, 403, 359);
        updateRoomTableData();
        
        JScrollPane scrollPane_1 = new JScrollPane(table_Room);
        scrollPane_1.setBounds(204, 62, 403, 348);
        panel.add(scrollPane_1);
        
        JLabel lblNewLabel_2 = new JLabel("THÔNG TIN PHÒNG ");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(293, 11, 210, 40);
        panel.add(lblNewLabel_2);
        tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 18));
    }

	private void updateKhachHangTable() {
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		
		// Lấy dữ liệu từ bảng khachhang và lưu vào Arl
		KhachHangBUS khachHangBUS = new KhachHangBUS();
		ArrayList<KhachHang> khachHangs = khachHangBUS.listKhachHangs();
		clearKhachHangTable();
		
		for (KhachHang khachHang : khachHangs) {
			model.addRow(khachHang.toObject());
		}
	}
	private void clearKhachHangTable() {
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		int rowCount = model.getRowCount();
		
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	private void updateRoomTableData() {
		DefaultTableModel model = (DefaultTableModel) table_Room.getModel();
		
		// Lấy dữ liệu từ bảng room và lưu vào 1 Arl
		
		RoomBUS roomBUS = new RoomBUS();
		ArrayList<Room> rooms = roomBUS.listRooms();
		clearRoomTable();
		// Thêm dữ liệu vào bảng
		for (Room room : rooms) {
			model.addRow(room.toObject());
		}
	}
	
	private void clearRoomTable() {
		DefaultTableModel model = (DefaultTableModel) table_Room.getModel();
		int rowCount = model.getRowCount();
		
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	public void setEmptyForm() {
		this.textField_name.setText(null);
		this.textField_Age.setText(null);
		this.textField_dateOrder.setText(null);
		this.textField_roomNumber.setText(null);
	}

	public void edit() {
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		int rowIndex = table_KhachHang.getSelectedRow();
		if (!table_KhachHang.isRowSelected(rowIndex)) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 khách hàng trong danh sách");
		}else {
			String name = String.valueOf(model.getValueAt(rowIndex, 1));
			int age = Integer.valueOf((String) model.getValueAt(rowIndex, 2));
			Date dateOrder = (Date) model.getValueAt(rowIndex, 3);
			int roomNumber = Integer.valueOf((String) model.getValueAt(rowIndex, 4));
			
			this.textField_name.setText(name);
			this.textField_Age.setText(age+"");
			this.textField_dateOrder.setText(dateOrder+"");
			this.textField_roomNumber.setText(roomNumber+"");
		}
	}

	public void delete() {
		DefaultTableModel model = (DefaultTableModel)table_KhachHang.getModel();
		int rowIndex = table_KhachHang.getSelectedRow();
		
		if (!table_KhachHang.isRowSelected(rowIndex)) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 khách hàng trong danh sách");
		}else {
			int id = Integer.valueOf((String) model.getValueAt(rowIndex, 0));
			String name = String.valueOf(model.getValueAt(rowIndex, 1));
			int age = Integer.valueOf((String) model.getValueAt(rowIndex, 2));
			//Date dateOrder = (Date) model.getValueAt(rowIndex, 3);
			Date dateOrder = Date.valueOf(model.getValueAt(rowIndex, 3)+"");
			int roomNumber = Integer.valueOf((String) model.getValueAt(rowIndex, 4));
			
			KhachHang khachHang = new KhachHang(id, name, age, dateOrder, roomNumber);
			
			RoomDAO roomDAO = new RoomDAO();
			ArrayList<Room> rooms = roomDAO.listRooms();
			RoomBUS roomBUS = new RoomBUS();
			
			for (Room room : rooms) {
				if (room.getRoomNumber() == roomNumber) {
					roomBUS.setFalse(room);
				}
			}
			updateRoomTableData();
			KhachHangBUS khachHangBUS = new KhachHangBUS();
			khachHangBUS.delete(khachHang);
			updateKhachHangTable();
		}
	}

	public void save() {
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		//int rowIndex= table_KhachHang.getSelectedRow();
		RoomBUS roomBUS = new RoomBUS();
		if (textField_name.getText().isBlank() || textField_Age.getText().isBlank() || textField_dateOrder.getText().isBlank() || textField_roomNumber.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
		}
		if (!this.textField_dateOrder.getText().matches("^(?:(?:19|20)\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]|(?:0[1-9]|1\\d|2[0-8]))|(?:19|20)\\d\\d-(0[1-9]|1[0-2])-(29|30)(?:-0[1-9]|-1[0-9]|-2[0-8])|(?:19|20)(?:0[48]|[2468][048]|[13579][26])-02-29$\r\n")) {
			JOptionPane.showMessageDialog(null, "Nhập theo định dạng yy-mm-dd");
		}
		String name = String.valueOf(textField_name.getText());
		//int age = Integer.valueOf((textField_Age.getText()+""));
		int age = Integer.valueOf((String)textField_Age.getText());
		//java.sql.Date dateOrder = java.sql.Date.valueOf(textField_dateOrder.getText());
		Date dateOrder = Date.valueOf(String.valueOf(textField_dateOrder.getText()));
		int roomNumber = Integer.valueOf((String) textField_roomNumber.getText());
		
		ArrayList<Room> rooms = new RoomBUS().listRooms();
		for (Room room : rooms) {
			if (room.getRoomNumber() == roomNumber) {
				if (room.isOrdered() == true) {
					JOptionPane.showMessageDialog(null, "Phòng "+roomNumber+" đã được đặt hoặc không có phòng "+roomNumber);
				}else {
					roomBUS.setTrue(room);
					
					updateRoomTableData();
					
					KhachHang khachHang = new KhachHang(name, age, dateOrder, roomNumber);
					KhachHangBUS khachHangBUS = new KhachHangBUS();
					khachHangBUS.addKhachHang(khachHang);
					updateKhachHangTable();
				}
			}
		}
		
	}

	public void update() {
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		int rowIndex = table_KhachHang.getSelectedRow();
		
		int id = Integer.valueOf((String) table_KhachHang.getValueAt(rowIndex, 0));
		String name = textField_name.getText();
		int age = Integer.valueOf(textField_Age.getText());
		Date dateOrder = Date.valueOf(textField_dateOrder.getText());
		int roomNumber = Integer.valueOf(textField_roomNumber.getText());
		int oldRoomNumber = Integer.valueOf((String) model.getValueAt(rowIndex, 4));
		
		ArrayList<Room> rooms = new RoomBUS().listRooms();
		for (Room room : rooms) {
			if (room.getRoomNumber() == roomNumber) {
				if (room.isOrdered() == true) {
					JOptionPane.showMessageDialog(null, "Phòng "+roomNumber+" đã được đặt hoặc không có phòng "+roomNumber);
				}else {
					if (roomNumber != oldRoomNumber) {
						for (Room room2 : rooms) {
							if (room2.getRoomNumber() == oldRoomNumber) {
								new RoomBUS().setFalse(room2);
							}
						}
					}
					
					RoomBUS roomBUS = new RoomBUS();
					roomBUS.setTrue(room);
					
					updateRoomTableData();
					KhachHang khachHang = new KhachHang(id, name, age, dateOrder, roomNumber);
					
					KhachHangBUS khachHangBUS = new KhachHangBUS();
					khachHangBUS.edit(khachHang);
					updateKhachHangTable();
				}
			}
		}

	}
	
}
