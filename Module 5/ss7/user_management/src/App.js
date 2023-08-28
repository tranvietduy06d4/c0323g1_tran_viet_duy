import UserList from "./components/UserList";
import { Provider } from "react-redux";
import store from "./redux/Store";

function App() {
  return (
    <Provider store={store}>
      <UserList />
    </Provider>
  );
}

export default App;
