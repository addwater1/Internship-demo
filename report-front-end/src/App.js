import { useState } from "react";
import "./style.css";

export const App = () => {
  const [count, setCount] = useState(0);

  return (
    <div className='container'>
      <h1>Hello world! {count}</h1>
      <button 
        onClick={() => {
          setCount(c => c+1);
        }}
      >
        Count
      </button>
    </div>
  );
};