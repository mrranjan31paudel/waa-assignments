import React from "react";
import Comment from "../../components/Comment/Comment";

const Comments = React.memo(function Comments(props) {

  return (
    <>
      {(props.comments || []).map((comment, idx) => (
        <Comment key={comment.id + idx} comment={comment.name} />
      ))}
    </>
  );
})

export default Comments;
