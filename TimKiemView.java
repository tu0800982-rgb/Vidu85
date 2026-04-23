package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane; // ✅ thêm

import controller.TimKiemListener;
import model.TimKiemModel;

public class TimKiemView extends JFrame {
	private TimKiemModel timKiemModel;
	private JTextArea jTextArea_vanBan;
	private JTextField jTextField_tuKhoa;
	private JLabel jLabel_ketQua;

	public TimKiemView() throws HeadlessException {
		this.timKiemModel = new TimKiemModel();
		this.init();
	}

	private void init() {
		this.setTitle("Tìm Kiếm Văn Bản");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Arial", Font.BOLD, 20);

		// Center
		JLabel jLabel_vanBan = new JLabel("văn Bản");
		jLabel_vanBan.setFont(font);
		
		jTextArea_vanBan = new JTextArea(100, 100);
		jTextArea_vanBan.setFont(font);
		jTextArea_vanBan.setLineWrap(true); // Xuống dòng tự động
		jTextArea_vanBan.setWrapStyleWord(true); //xuống dòng theo từ → đẹp hơn 
		JScrollPane scrollPane = new JScrollPane(jTextArea_vanBan);


		// Footer
		TimKiemListener timKiemListener = new TimKiemListener(this);

		JLabel jLabel_tuKhoa = new JLabel("Từ Khóa");
		jLabel_tuKhoa.setFont(font);
		
		jTextField_tuKhoa = new JTextField();
		jTextField_tuKhoa.setFont(font);

		JButton jButton_thongKe = new JButton("Thống Kê");
		jButton_thongKe.setFont(font);
		jButton_thongKe.addActionListener(timKiemListener);
		jButton_thongKe.setBackground(Color.BLUE);
		jButton_thongKe.setForeground(Color.RED); // Chữ trắng cho dễ nhìn

		jLabel_ketQua = new JLabel("Kết Quả.....");
		jLabel_ketQua.setBackground(Color.GREEN);
		jLabel_ketQua.setFont(font);
		jLabel_ketQua.setOpaque(true);
		jLabel_ketQua.setHorizontalAlignment(JLabel.CENTER); // Căn giữa

		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setLayout(new GridLayout(2, 2, 20, 20));
		jPanel_footer.add(jLabel_tuKhoa);
		jPanel_footer.add(jTextField_tuKhoa);
		jPanel_footer.add(jButton_thongKe);
		jPanel_footer.add(jLabel_ketQua);

		this.setLayout(new BorderLayout());
		this.add(jLabel_vanBan, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER); // Dùng scroll thay vì textarea trực tiếp
		this.add(jPanel_footer, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public void timKiem() {
		this.timKiemModel.setVanBan(jTextArea_vanBan.getText());
		this.timKiemModel.setTuKhoa(jTextField_tuKhoa.getText());
		this.timKiemModel.timKiem();
		this.jLabel_ketQua.setText(this.timKiemModel.getKetQua());

	}
}
