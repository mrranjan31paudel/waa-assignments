import "./Comment.css";

function Comment(props) {

  return (
    <div className="comment">
      &rarr;&ensp;{props.comment}
    </div>
  );
}

export default Comment;
