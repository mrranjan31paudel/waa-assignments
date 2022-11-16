import "./Post.css";

function Post(props) {

  return (
    <div className="post" onClick={props.onClick}>
      <div className="post-prop">
        <strong>Id:</strong> {props.id}
      </div>
      <div className="post-prop">
        <strong>Title:</strong> {props.title}
      </div>
      <div className="post-prop">
        <strong>Author:</strong> {props.author}
      </div>
    </div>
  );
}

export default Post;
