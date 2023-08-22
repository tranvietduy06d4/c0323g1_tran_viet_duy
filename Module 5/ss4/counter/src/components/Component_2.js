import {useState} from "react"
import useIncrement from "../hooks/useIncrement";

function Component2() {
    const [count, increase] = useIncrement(2);
    return(
        <>
        <h1>Count 2: {count}</h1>
        <button onClick={increase}>Add 2</button>
        </>
    );
}
export default Component2;