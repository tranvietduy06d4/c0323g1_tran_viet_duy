import { Component } from "react";
class Student extends Component {
  constructor() {
    super();
    this.state = {
      studentList: [
        {
          id: 1,
          name: "Hoàng Văn Bách",
          age: 32,
          address: "Ha Noi",
        },
        {
          id: 2,
          name: "Nguyễn Văn Chương",
          age: 25,
          address: "Vũng Tàu",
        },
        {
          id: 3,
          name: "Dam Thoai Tin ",
          age: 26,
          address: "Da Nang",
        },
        {
          id: 4,
          name: "Nguyễn Hoàng Nhất",
          age: 29,
          address: "Quang Nam",
        },
        {
          id: 5,
          name: "Trần Văn Lanh",
          age: 27,
          address: "Quang Tri",
        },
        {
          id: 6,
          name: "Tran Viet Duy",
          age: 36,
          address: "Hoi An",
        },
      ],
    };
  }

  render() {
    return (
      <>
        <h1>Student List</h1>
        <table border={1}>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
          </tr>

          {this.state.studentList.map((element, index) => {
            return (
              <tr key={index}>
                <td>{element.id}</td>
                <td>{element.name}</td>
                <td>{element.age}</td>
                <td>{element.address}</td>
              </tr>
            );
          })}
        </table>
      </>
    );
  }
}
export default Student;
