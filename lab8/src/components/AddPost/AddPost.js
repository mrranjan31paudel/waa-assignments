import { useRef } from "react";

import "./AddPost.css";

function AddPost(props) {
  const formRef = useRef(null);

  const resetForm = () => {
    if (formRef === null)
      return;

    formRef.current["postTitle"].value = "";
    formRef.current["postContent"].value = "";
    formRef.current["postAuthor"].value = "";
  }

  const handleAddPost = function (event) {
    event.preventDefault();

    const postData = {
      title: formRef.current["postTitle"].value,
      content: formRef.current["postContent"].value
    };
    const authorId = parseInt(formRef.current["postAuthor"].value, 10);

    props.addPost(authorId, postData, resetForm);
  }

  return (
    <div className="add-post-form">
      <form ref={formRef} onSubmit={handleAddPost}>
        <div className="mb-8">
          <input name="postTitle" placeholder="Title" required min="5" max="50" />
        </div>

        <div className="mb-8">
          <select name="postAuthor" placeholder="Author" required>
            <option value=""></option>
            {(props.users || []).map(user => (
              <option key={user.id} value={user.id}>{user.name}</option>
            ))}
          </select>
        </div>
        <div className="mb-8"><textarea name="postContent" placeholder="Content" required min="5" max="100"></textarea>
        </div>
        <div className="mb-8">
          <button type="submit">Add Post</button>
        </div>
      </form>
    </div>
  );
}

export default AddPost;
