import { useState } from "react";

function useIncrement(addAmount) {
  const [count, setCount] = useState(0);

  function increase () {
    let newCount = count + addAmount;
    setCount(newCount);
  }

  return [count, increase];
}
export default useIncrement;
