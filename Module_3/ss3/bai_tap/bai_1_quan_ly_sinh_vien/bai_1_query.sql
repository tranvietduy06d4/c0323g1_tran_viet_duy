use QuanLySinhVien;

--- Hiển thị tất cả các sinh viên có tên bắt đầu bằng ký tự ‘h’

select *
from student
where StudentName like 'h%';

--- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select *
from class
where StartDate >= '2023-12-01 00:00:00';

--- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from subject
where Credit >= 3 and Credit <= 5;

--- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
Set sql_safe_updates=0;
update student
set ClassID = 2
where StudentName = 'Hung';
Set sql_safe_updates=1;

--- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select StudentName, Mark, SubName
from student
join mark on student.StudentId = mark.StudentId
join subject on mark.SubId = subject.SubId
order by Mark DESC, StudentName ASC;





