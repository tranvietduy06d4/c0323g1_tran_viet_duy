use quanlysinhvien;

-- Câu 1: Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select *
from subject
where Credit = (select max(Credit) from subject);

-- Câu 2: Hiển thị các thông tin môn học có điểm thi lớn nhất.

select *
from subject
join mark on subject.SubId = mark.SubId
where Mark = (select max(Mark) from mark);

-- Câu 3: Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select student.StudentId,student.StudentName,student.Address,student.Phone,student.Status,student.ClassId, avg(mark.Mark) as mark_average
from student
join mark on student.StudentId = mark.StudentId
group by student.StudentId
order by mark_average desc;
