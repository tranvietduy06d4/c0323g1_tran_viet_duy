import './App.css';
import {students} from './studentComponent.js';

export default function App() {
  return (
   <table>
    <h1>Student List</h1>
    <tr>
      <th>Company</th>
      <th>Contact</th>
      <th>Country</th>
    </tr>
    {students.map(student => (
          <tr>
            <td>{student.company}</td>
            <td>{student.contact}</td>
            <td>{student.country}</td>
          </tr>
        ))}
   </table>
  );
}

