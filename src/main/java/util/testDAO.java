package util;
import dao.*;
public class testDAO {
    public static void main(String[] args) {

        NhanVienDAO nvDAO = new NhanVienDAO();
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        DanhMucDAO dmDAO = new DanhMucDAO();
        SanPhamDAO spDAO = new SanPhamDAO();
        KichCoDAO kcDAO = new KichCoDAO();
        SanPhamKichCoDAO spkcDAO = new SanPhamKichCoDAO();
        HoaDonDAO hdDAO = new HoaDonDAO();
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

        System.out.println("Nhan vien: " + nvDAO.findAll().size());
        System.out.println("Tai khoan: " + tkDAO.findAll().size());
        System.out.println("Danh muc: " + dmDAO.findAll().size());
        System.out.println("San pham: " + spDAO.findAll().size());
        System.out.println("Kich co: " + kcDAO.findAll().size());
        System.out.println("San pham kich co: " + spkcDAO.findAll().size());
        System.out.println("Hoa don: " + hdDAO.findAll().size());
        System.out.println("Chi tiet hoa don: " + cthdDAO.findAll().size());
    }
}
