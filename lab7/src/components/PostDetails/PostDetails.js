import "./PostDetails.css";

function PostDetails(props) {

  return (
    <div className="post-details">
      {!props.id
        ? "No post selected!"
        : (
          <>
            <h3>{props.title}</h3>
            <div className="post-author">{props.author}</div>
            <div className="post-content">{props.content}</div>
            <div className="post-actions">
              <button>Edit</button>&ensp;&ensp;
              <button>Delete</button>&ensp;&ensp;
              <button>Close</button>
            </div>
          </>
        )}
    </div>
  );
}

export default PostDetails;
