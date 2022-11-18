import { useState } from "react"

import "./PostForm.css";

function PostForm(props) {
  const [inputTitle, setInputTitle] = useState("");

  const handleClick = () => {
    setInputTitle("");
    props.onTitleChange(inputTitle);
  }

  const handleChange = (event) => {
    const { value } = event.target;

    setInputTitle(value);
  }

  return (
    <div className="post-form mb-8">
      <div className="post-form-field">
        <input value={inputTitle} onChange={handleChange} />
      </div>
      <div>
        <button onClick={handleClick}>Change Title</button>
      </div>
    </div>
  )
}

export default PostForm;
