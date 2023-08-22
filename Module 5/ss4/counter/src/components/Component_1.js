import {useState} from "react"
import useIncrement from "../hooks/useIncrement";

function Component1() {
    const [count, increase] = useIncrement(1);
    return(
        <>
        <h1>Count 1: {count}</h1>
        <button onClick={increase}>Add 1</button>
        </>
    );
}
export default Component1;