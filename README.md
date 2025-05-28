# 📚 JavaFX Study Schedule

Đây là ứng dụng JavaFX giúp người dùng quản lý **lịch học**, bao gồm đăng nhập, thêm/sửa/xoá lịch và hiển thị thời khóa biểu một cách trực quan.

## 🚀 Tính năng

- 🧑‍💻 Đăng nhập hệ thống người dùng
- 🗓️ Quản lý thời khóa biểu (thêm, sửa, xóa buổi học)
- ✅ Đánh dấu hoàn thành buổi học
- 🎨 Giao diện người dùng đẹp, dễ sử dụng với JavaFX + FXML

## 🛠️ Công nghệ sử dụng

- **Java 8**
- **JavaFX**
- **FXML** cho giao diện
- **JDBC / SQLite** (theo file `qltkb.sql`)
- IDE: Eclipse (dựa theo `.project`, `.classpath`)

📦 Cách chạy ứng dụng
1. Yêu cầu
JDK 8

JavaFX SDK (nếu JDK không tích hợp)

Eclipse hoặc IntelliJ

2. Cấu hình chạy (VM Options)
text
Copy
Edit
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
3. Chạy ứng dụng
Mở dự án trong Eclipse

Chạy file Main.java từ thư mục src/run/

4. Khởi tạo cơ sở dữ liệu
Mở file qltkb.sql bằng SQLite hoặc DBeaver để import dữ liệu.

Cấu hình Connect.java để trỏ đúng đến file .db nếu có sử dụng SQLite.
