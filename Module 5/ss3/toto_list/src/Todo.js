import { Component } from "react";

class Todo extends Component {
  constructor() {
    super();
    this.state = {
      list: [],
      item: "",
    };
  }

  handleInputName(nameItem) {
    this.setState({ item: nameItem });
  }

  addItem() {
    if (this.state.item.trim() !== "") {
      this.setState((state) => ({
        list: [...state.list, state.item],
        item: "",
      }));
    }
  }

  render() {
    return (
      <>
        <input
          value={this.state.item}
          onChange={(event) => this.handleInputName(event.target.value)}
        ></input>
        <button onClick={() => this.addItem()}>Add work</button>
        <table border={1}>
          <tr>
            <th>STT</th>
            <th>Tên công việc cần làm</th>
          </tr>
          {this.state.list.map((element, index) => {
            return (
              <tr key={index}>
                <td></td>
                <td>{element}</td>
              </tr>
            );
          })}
        </table>
      </>
    );
  }
}
export default Todo;
