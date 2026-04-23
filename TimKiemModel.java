package model;

public class TimKiemModel {
private String vanBan;
private String tuKhoa;
private String ketQua;
public TimKiemModel() {
	this.vanBan = "";
	this.tuKhoa = "";
	this.ketQua = "";
}
public String getVanBan() {
	return vanBan;
}
public void setVanBan(String vanBan) {
	this.vanBan = vanBan;
}
public String getTuKhoa() {
	return tuKhoa;
}
public void setTuKhoa(String tuKhoa) {
	this.tuKhoa = tuKhoa;
}
public String getKetQua() {
	return ketQua;
}
public void setKetQua(String ketQua) {
	this.ketQua = ketQua;
}
public void timKiem() {
    if (this.tuKhoa == null || this.tuKhoa.isEmpty()) {
        this.ketQua = "Vui lòng nhập từ khóa!";
        return;
    }

    int dem = 0;
    int viTri = 0; 

    while (true) {
        int i = this.vanBan.indexOf(this.tuKhoa, viTri);
        if (i == -1) {
            break;
        } else {
            dem++;
            viTri = i + this.tuKhoa.length(); // chuẩn hơn + tránh overlap
        }
    }

    this.ketQua = "Kết quả: có " + dem + " lần xuất hiện của \"" + this.tuKhoa + "\"";
}
}
