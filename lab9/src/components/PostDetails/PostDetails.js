import React, { useEffect, useState } from "react";

import http from "../../services/http";
import Comment from "../Comment/Comment";

import "./PostDetails.css";

const PostDetails = React.memo(function PostDetails(props) {
  const { postId } = props;
  const [post, setPost] = useState(null);


  const fetchPost = (id = 0) => {
    http.get(`/posts/${id}/comments`)
      .then(result => {
        setPost(result.data || null);
      })
      .catch(error => {
        console.log(error.message);
      })
  }

  useEffect(() => {
    if (typeof postId !== 'number' || postId <= 0) {
      setPost(null);
    }
    else {
      fetchPost(postId);
    }
  }, [postId]);

  return (
    <div className="post-details">
      {!post
        ? "No post selected!"
        : (
          <>
            <h3>{post.title}</h3>
            <div className="post-author">{post.author?.name}</div>
            <div className="post-content">{post.content}</div>
            <div className="post-comments">
              <div className="post-comments-count">{post.comments ? post.comments.length : 0} Comments</div>
              {(post.comments || []).map((comment, idx) => <Comment key={comment.id + idx} comment={comment.name} />)}
            </div>
            <div className="post-actions">
              <button>Edit</button>&ensp;&ensp;
              <button onClick={props.onDelete}>Delete</button>&ensp;&ensp;
              <button onClick={props.onCloseDetails}>Close</button>
            </div>
          </>
        )}
    </div>
  );
})

export default PostDetails;
