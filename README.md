# 2023.2-147730-12
UseCase Diagram [Tổng quan]
# [Quy tắc chung](Homework00/README.md)
# Nội dung hàng tuần 
1.  [**Homework00**](Homework00/README.md) (22/02/2024-29/02/2024)
	- Create an account in github
	- Create a private repository in github, join with all members in your group
	-  Naming your project name (check the previous lesson)
	- Create a sub-directory (Homework01)
	-  Each member in the group does the following tasks
	-  HelloWorld.java: Ask a user to enter his/her name, then display hello to that name
	-  Implement MVCTutorial example
	-  Implement Calculator, using MVC model with 2 version: Swing and JavaFX (use Scene Builder)
	-  Each member must perform all of these GIT actions:
	-  add file, remove file, modify, commit, push, pull, merge (resolve conflict), create branch merge branch
	-  take a screenshot to prove that you have done all actions
	-  Each member create his/her own report
1. [**Homework01**](Homework01/README.md) (29/02/2024-07/03/2024)
	- Vẽ biểu đồ use case :![UseCase Diagram](Homework01/UseCase%20Diagram%20[Tổng%20quan].png)
2. [**Homework02**](Homework02)(07/03/2024-14/03/2024)
	- Vẽ biểu đồ use case (bao gồm biểu đồ tổng quan và các biểu đồ phân rã nếu có)
	- Mỗi thành viên chọn một use case nghiệp vụ (bỏ qua các use case đăng nhập đăng ký) để thực hiện. Cần chỉ rõ ai làm use case nào. Trừ khi không còn use case, sinh viên không được phép chọn các use case dễ (ví dụ use case xóa dữ liệu, xem 1 bản ghi dữ liệu đơn giản). Use case được chọn phải có giao diện người dùng (GUI). Mỗi thành viên sẽ làm việc xuyên suốt với use case này. Trong bài tập này, mỗi thành viên cần đặc tả use case mình phụ trách. Trong đặc tả có thêm biểu đồ hoạt động (activity diagram) cho 1 luồng nào đó ( Vẽ cả càng tốt). Đồng thời cả nhóm hoàn thành tài liệu SRS theo mẫu trong thư mục Google Drive.
	- Thư mục group: có file doc SRS, file pdf SRS, file project Astah, file ảnh biểu đồ export từ Astah
	- Mỗi cá nhân nộp báo cáo cá nhân trong thư mục cá nhân
3. [**Homework03**](Homework03)( 14/03/2024 - 21/03/2024)  (Phân tích use case)
	- Bài tập cá nhân: 
		- Vẽ các biểu đồ trình tự (mức phân tích) trong use case mình phụ trách. Có thể cần vẽ nhiều biểu đồ, mỗi biểu đồ ứng với một scenario (luồng) trong use case. Cần chọn ít nhất 1 biểu đồ trình tự đã vẽ và vẽ thêm biểu đồ giao tiếp biểu diễn tương đương với biểu đồ trình tự này.

		- Dựa trên các biểu đồ trình tự đã vẽ, vẽ biểu đồ lớp (mức phân tích) cho use case mình phụ trách.

	- Bài tập nhóm: Vẽ biểu đồ lớp (mức phân tích) cho cả nhóm. Lưu ý: các lớp cùng chức năng ở nhiều use case phải dùng thống nhất cùng 1 tên.
4. [**Homework04**](Homework04) (Thiết kế giao diện)
	1. Bài tập nhóm: Vẽ sơ đồ chuyển đổi màn hình (screen transition diagram), từ màn hình home đến tất cả các màn hình chi tiết trong các use case nhóm phụ trách.
	2. Bài tập cá nhân: Vẽ sơ đồ chuyển đổi màn hình (screen transition diagram), từ màn hình home đến tất cả các màn hình chi tiết trong các use case mà mình phụ trách.
		Thiết kế tất cả các màn hình dẫn từ trang home tới use case của mình.
		Đặc tả tất cả các màn hình trong use case của mình.

	Thiết kế từng subsystem (nếu có) trong use case của mình (vẽ biểu đồ trình tự cho từng hành vi mà subsystem cung cấp như minh họa trong hình dưới đây, mỗi hành vi một biểu đồ trình tự). Vẽ biểu đồ lớp cho từng subsystem
	![capture/Pasted%20image%2020240424115144.png]

5. [**Homework05**](Homework05)
	1. Bài tập cá nhân: Vẽ các biểu đồ trình tự (mức thiết kế) trong use case mình phụ trách. Có thể cần vẽ nhiều biểu đồ, mỗi biểu đồ ứng với một scenario trong use case. Sau đó tìm các hành vi và thuộc tính cho các lớp thiết kế và vẽ biểu đồ lớp (mức thiết kế) cho use case mình phụ trách.
		Lưu ý: cần dùng interaction ref để biểu đồ trình tự không bị quá phức tạp trong 1 hình vẽ
		Vẽ biểu đồ phụ thuộc gói
	2. Bài tập nhóm: Gộp lại các biểu đồ lớp (mức thiết kế) của mỗi thành viên, tổ chức thành các package cho hợp lý, thống nhất cách thức đặt tên.
		Sau đó, vẽ biểu đồ phụ thuộc package cho toàn nhóm và cho từng cá nhân (cần phân thành các tầng)
