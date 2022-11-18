import Post from "../../components/Post/Post";

import "./Posts.css";

function Posts(props) {

  return (
    <div className="posts-container">
      <h3>Posts ({(props.posts || []).length})</h3>
      <div className="posts">
        {(props.posts || []).map(post => (
          <Post
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author?.name}
            onClick={() => props.onPostSelect(post.id)} />
        ))}
      </div>
    </div>
  )
}

export default Posts;
