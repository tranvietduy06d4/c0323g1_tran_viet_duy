use ss3;

-- Câu 1 - Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp ( yêu cầu viết code ra giấy )

select class.name, count(class.name) as student_amount
from class
join student on class.id = student.class_id
group by class.name;

-- Câu 2 -Tính điểm lớn nhất của mỗi các lớp ( yêu cầu viết code ra giấy )
select class.name, max(student.point) as max_point
from class
join student on class.id = student.class_id
group by class.name;

-- Câu 3 - Tình điểm trung bình  của từng lớp ( yêu cầu viết code ra giấy )

select class.name, avg(student.point) as average_point
from class
join student on class.id = student.class_id
group by class.name;

-- Câu 4 - Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym. ( yêu cầu viết code ra giấy )

select student.name, student.birthday, instructor.name, instructor.birthday
from student
left join class on student.class_id = class.id
left join instructor_class on class.id = instructor_class.class_id
left join instructor on instructor_class.instructor_id = instructor.id
union all
select student.name, student.birthday, instructor.name , instructor.birthday
from student
right join class on student.class_id = class.id
right join instructor_class on class.id = instructor_class.class_id
right join instructor on instructor_class.instructor_id = instructor.id;

-- Câu 6:   Lấy ra các học viên có điểm số là cao nhất của trung tâm. ( yêu cầu viết code ra giấy )
select student.name, max(student.point)
from student
group by student.point;
having student.point = max(student.point);

having student.point > max(student.point);
 
 
 
 
 