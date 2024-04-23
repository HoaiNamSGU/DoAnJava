package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.CuaHangDAO;
import model.CuaHang;
import view.CuaHangView;

public class CuaHangActionListener implements ActionListener {
	private CuaHangView CuaHangView;

	public CuaHangActionListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == CuaHangView.comboBox_search_QuanHuyen) {

			CuaHangView.updateComBoBox_XaPhuong();

			ArrayList<CuaHang> newData = advancedSearch();
			CuaHangView.updateData(newData);

		}
		if (src == CuaHangView.comboBox_search_XaPhuong) {

			ArrayList<CuaHang> newData = advancedSearch();
			CuaHangView.updateData(newData);
		}
		if (src == CuaHangView.jbutton_Sreach) {
			String text = CuaHangView.textField_Search.getText();
			ArrayList<CuaHang> newData = CuaHangDAO.getintance().Select_search("*", text);
			CuaHangView.updateData(newData);
		}
		// hành động enter của text_seach tương đương hành động gị nút tìm kiếm
		CuaHangView.textField_Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Gọi hành động của nút refesh khi nhấn phím Enter
				CuaHangView.jbutton_Sreach.doClick();
			}
		});
		if (src == CuaHangView.jbutton_refesh) {

			CuaHangView.comboBox_search_QuanHuyen.setSelectedItem("Tất cả");
			CuaHangView.textField_Search.setText(null);
			CuaHangView.updateComBoBox_XaPhuong();
			CuaHangView.loadCuaHang();
		}

	}

	// tìm kiếm nâng cao
	public ArrayList<CuaHang> advancedSearch() {
		String Quan_Huyen_condition = CuaHangView.comboBox_search_QuanHuyen.getSelectedItem().toString();
		String Xa_phuong_condition = CuaHangView.comboBox_search_XaPhuong.getSelectedItem().toString();
		ArrayList<CuaHang> mixerResult;

		if (Quan_Huyen_condition.equals("Tất cả")) {
			return CuaHangDAO.getintance().selectAll();
		} else {
			// Lấy danh sách cửa hàng dựa trên Quan_Huyen_condition
			ArrayList<CuaHang> Quan_Huyen = CuaHangDAO.getintance().Select_search("DiaChi", Quan_Huyen_condition);
			if (Xa_phuong_condition.equals("Tất cả")) {
				return Quan_Huyen;
			} else {
				// Thực hiện tìm kiếm nâng cao dựa trên cả hai điều kiện

				mixerResult = CuaHangDAO.getintance().advancedSearch(Quan_Huyen_condition, Xa_phuong_condition);
				return mixerResult;
			}
		}
	}

	/*
	 * public ArrayList<CuaHang> advancedSearch() { ArrayList<CuaHang> mixerResult =
	 * new ArrayList<CuaHang>(); String Quan_Huyen_condition =
	 * CuaHangView.comboBox_search_QuanHuyen.getSelectedItem().toString(); String
	 * Xa_phuong_condition =
	 * CuaHangView.comboBox_search_XaPhuong.getSelectedItem().toString(); if
	 * (Quan_Huyen_condition.equals("Tất cả")) { return
	 * CuaHangDAO.getintance().selectAll(); } else { ArrayList<CuaHang> Quan_Huyen =
	 * CuaHangDAO.getintance().Select_search("DiaChi", Quan_Huyen_condition); if
	 * (Xa_phuong_condition.equals("Tất cả")) { return Quan_Huyen; } else {
	 * ArrayList<CuaHang> Xa_Phuong =
	 * CuaHangDAO.getintance().Select_search("DiaChi", Xa_phuong_condition); for
	 * (CuaHang itemQuan : Quan_Huyen) { String MaCH_Quan = itemQuan.getMaCH();
	 * 
	 * // Duyệt qua danh sách Xa_Phuong và kiểm tra MaCH for (CuaHang itemXa :
	 * Xa_Phuong) { String MaCH_Xa = itemXa.getMaCH();
	 * 
	 * // So sánh MaCH của hai đối tượng if (MaCH_Quan.equals(MaCH_Xa)) { // Nếu
	 * MaCH trùng khớp, thêm vào danh sách kết quả mixerResult.add(itemQuan); break;
	 * // Chỉ cần tìm thấy một MaCH trùng khớp là đủ } } } } } return mixerResult; }
	 */

}
