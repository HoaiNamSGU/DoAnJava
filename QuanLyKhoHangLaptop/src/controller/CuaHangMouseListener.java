package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CuaHangDAO;
import model.CuaHang;
import view.CuaHangView;
import view.SuaCuaHang;
import view.ThemCuaHang;

public class CuaHangMouseListener implements MouseListener {
	private CuaHangView CuaHangView;

	public CuaHangMouseListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
		String LabelText = clickedLabel.getText();
		if (LabelText.equals("Thêm")) {
			ThemCuaHang ThemCH = new ThemCuaHang();
			ThemCH.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					clickedLabel.setForeground(Color.BLACK);
					clickedLabel.setBackground(null);
				}
			});
			ThemCH.comboBox_QuanHuyen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ThemCH.updateComBoBox_XaPhuong();
				}
			});

			ThemCH.comboBox_TPHO.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}
			});
			ThemCH.comboBox_XaPhuong.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}
			});
			ThemCH.Button_XacNhan.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String maCH = ThemCH.textField_MaCH.getText();
					String tenCH = ThemCH.textField_TenCH.getText();
					String sdt = ThemCH.textField_SDT.getText();
					String diaChi = ThemCH.textField_DiaChi.getText() + ", "
							+ ThemCH.comboBox_XaPhuong.getSelectedItem() + ", "
							+ ThemCH.comboBox_QuanHuyen.getSelectedItem() + ", "
							+ ThemCH.comboBox_TPHO.getSelectedItem();

					// Kiểm tra xem các trường có được nhập đầy đủ không
					if (maCH.isEmpty() || tenCH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
						JOptionPane.showMessageDialog(ThemCH, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Kiểm tra xem mã cửa hàng đã tồn tại chưa
					if (CuaHangDAO.getintance().isMaCHExists(maCH)) {
						CuaHang CH = CuaHangDAO.getintance().selectById(maCH);
						if (CH.getIsDelete() == 0) {
							JOptionPane.showMessageDialog(ThemCH, "Mã cửa hàng đã tồn tại", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							int choice = JOptionPane.showConfirmDialog(ThemCH,
									"Cửa hàng đã bị xóa, bạn có muốn khôi phục lại không?", "Xác nhận",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (choice == JOptionPane.YES_OPTION) {
								CuaHangDAO.getintance().restoreCuaHang(maCH);
								CuaHangView.loadCuaHang();
								ThemCH.dispose();
							} else {
								JOptionPane.showMessageDialog(ThemCH, "Mã cửa hàng đã tồn tại", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
					if (!sdt.startsWith("0") || !sdt.matches("\\d+") || sdt.length() < 10 || sdt.length() > 11) {
						JOptionPane.showMessageDialog(ThemCH, "Số điện thoại của cửa hàng không hợp lệ", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Tạo đối tượng cửa hàng mới
					CuaHang CH = new CuaHang(maCH, tenCH, diaChi, sdt, 0);
					// Thêm cửa hàng vào cơ sở dữ liệu
					if (CH != null) {
						CuaHangDAO.getintance().insertCuaHang(CH);
						CuaHangView.loadCuaHang();
						JOptionPane.showMessageDialog(ThemCH, "Cửa hàng đã được thêm thành công", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						ThemCH.dispose();
					}
				}
			});
			ThemCH.Button_HuyBo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!ThemCH.textField_MaCH.getText().isEmpty() || !ThemCH.textField_TenCH.getText().isEmpty()
							|| !ThemCH.textField_SDT.getText().isEmpty()
							|| !ThemCH.textField_DiaChi.getText().isEmpty()) {
						int choice = JOptionPane.showConfirmDialog(ThemCH, "Xác nhận hủy bỏ?", "Xác nhận",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (choice == JOptionPane.YES_OPTION)
							ThemCH.dispose();
						else
							return;
					}
					ThemCH.dispose();
				}
			});
		}
		if (LabelText.equals("Xóa")) {
			int selectecRow = CuaHangView.table.getSelectedRow();
			if (selectecRow != -1) {
				String MaCH = CuaHangView.table.getValueAt(selectecRow, 0).toString();
				String TenCH = CuaHangView.table.getValueAt(selectecRow, 1).toString();

				if (CuaHangDAO.getintance().isMaCHExists(MaCH)) {
					int choice = JOptionPane.showConfirmDialog(CuaHangView, "Xác nhận xóa cửa hàng " + TenCH,
							"Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (choice == JOptionPane.YES_OPTION) {
						CuaHangDAO.getintance().soft_deleteCuaHang(MaCH);
						CuaHangView.loadCuaHang();
						JOptionPane.showMessageDialog(CuaHangView, "Sản phẩm đã được xóa thành công", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(CuaHangView, "Cửa hàng không tồn lại", "Lỗi dữ liệu",
							JOptionPane.ERROR_MESSAGE);
			} else
				JOptionPane.showMessageDialog(CuaHangView, "Chưa chọn cửa hàng muốn xóa", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
		}

		if (LabelText.equals("Sửa")) {
			// SuaCH.textField_MaCH

			int selectecRow = CuaHangView.table.getSelectedRow();
			if (selectecRow != -1) {
				final String old_MaCH = CuaHangView.table.getValueAt(selectecRow, 0).toString();
				SuaCuaHang SuaCH = new SuaCuaHang();

				SuaCH.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						clickedLabel.setForeground(Color.BLACK);
						clickedLabel.setBackground(null);
					}
				});
				SuaCH.comboBox_QuanHuyen.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						SuaCH.updateComBoBox_XaPhuong();
					}
				});
				SuaCH.comboBox_TPHO.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

					}
				});
				SuaCH.comboBox_XaPhuong.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

					}
				});

				String MaCH = CuaHangView.table.getValueAt(selectecRow, 0).toString();
				CuaHang CH;
				if (CuaHangDAO.getintance().isMaCHExists(MaCH)) {
					CH = CuaHangDAO.getintance().selectById(MaCH);

					// đưa các dữ liệu của cửa hàng cần sửa lên giao diện sửa
					SuaCH.textField_MaCH.setText(CH.getMaCH());
					SuaCH.textField_TenCH.setText(CH.getTenCH());
					SuaCH.textField_SDT.setText(CH.getSDT());
					SuaCH.textField_DiaChi.setText(CH.getDiaChi());
					String[] diachi = CH.getDiaChi().split(", ");
					String ThanhPho = diachi[diachi.length - 1];
					String Quan_Huyen = diachi[diachi.length - 2];
					String Xa_Phuong = diachi[diachi.length - 3];
					String Duong = diachi[diachi.length - 4];

					for (String item : SuaCH.ThanhPho) {
						if (ThanhPho.equals(item)) {
							SuaCH.comboBox_TPHO.setSelectedItem(ThanhPho);
							break;
						}
					}
					for (String item : SuaCH.Quan_Huyen) {
						if (Quan_Huyen.equals(item)) {
							SuaCH.comboBox_QuanHuyen.setSelectedItem(Quan_Huyen);
							SuaCH.updateComBoBox_XaPhuong();
							break;
						}
					}
					for (String item : SuaCH.Xa_Phuong) {
						if (Xa_Phuong.equals(item)) {
							SuaCH.comboBox_XaPhuong.setSelectedItem(Xa_Phuong);
							break;
						}
					}
					SuaCH.textField_DiaChi.setText(Duong);
				}
					// sửa dữ liệu
					SuaCH.Button_XacNhan.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String maCH = SuaCH.textField_MaCH.getText();
							String tenCH = SuaCH.textField_TenCH.getText();
							String sdt = SuaCH.textField_SDT.getText();
							String diaChi = SuaCH.textField_DiaChi.getText() + ", "
									+ SuaCH.comboBox_XaPhuong.getSelectedItem() + ", "
									+ SuaCH.comboBox_QuanHuyen.getSelectedItem() + ", "
									+ SuaCH.comboBox_TPHO.getSelectedItem();

							// Kiểm tra xem các trường có được nhập đầy đủ không
							if (maCH.isEmpty() || tenCH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
								JOptionPane.showMessageDialog(SuaCH, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							// kiểm tra xem mã mới có trùng với mã cũ không
							if (!old_MaCH.equals(maCH)) {
								// Kiểm tra xem mã cửa hàng đã tồn tại chưa
								if (CuaHangDAO.getintance().isMaCHExists(maCH)) {
									CuaHang CH = CuaHangDAO.getintance().selectById(maCH);
									//kiểm tra xem cửa hàng tồn tại đã bị xóa hay chưa
									if (CH.getIsDelete() == 0) {
										JOptionPane.showMessageDialog(SuaCH, "Mã cửa hàng đã tồn tại", "Lỗi",
												JOptionPane.ERROR_MESSAGE);
										return;
										
									} else {
										// nếu cửa hàng đã bị xóa thì hỏi xem người dùng có muốn khôi phục lại hay không
										int choice = JOptionPane.showConfirmDialog(SuaCH,
												"Cửa hàng đã bị xóa, bạn có muốn khôi phục lại không?", "Xác nhận",
												JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
										if (choice == JOptionPane.YES_OPTION) {
											CuaHangDAO.getintance().restoreCuaHang(maCH);
											CuaHangView.loadCuaHang();
											SuaCH.dispose();
										} else {
											JOptionPane.showMessageDialog(SuaCH, "Mã cửa hàng đã tồn tại", "Lỗi",
													JOptionPane.ERROR_MESSAGE);
											return;
										}
									}
								}
							}
							if (!sdt.startsWith("0") || !sdt.matches("\\d+") || sdt.length() < 10
									|| sdt.length() > 11) {
								JOptionPane.showMessageDialog(SuaCH, "Số điện thoại của cửa hàng không hợp lệ", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							// Tạo đối tượng cửa hàng mới
							CuaHang CH = new CuaHang(maCH, tenCH, diaChi, sdt, 0);
							// Thêm cửa hàng vào cơ sở dữ liệu
							if (CH != null) {
								CuaHangDAO.getintance().updateCuaHang(old_MaCH, CH);
								CuaHangView.loadCuaHang();
								JOptionPane.showMessageDialog(SuaCH, "Cửa hàng đã được sửa thành công", "Thông báo",
										JOptionPane.INFORMATION_MESSAGE);
								SuaCH.dispose();
							}
						}
					});
				}
			 else
				JOptionPane.showMessageDialog(CuaHangView, "Chưa chọn cửa hàng muốn sửa", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
		}

	}

	/*
	 * public static void resetComponent(Component component) { if (component
	 * instanceof JLabel) { JLabel label = (JLabel) component;
	 * label.setForeground(Color.BLACK); label.setBackground(null); } else if
	 * (component instanceof JButton) { JButton button = (JButton) component;
	 * button.setForeground(Color.BLACK); button.setBackground(null); } // Có thể
	 * thêm các trường hợp khác ở đây nếu cần }
	 */

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
