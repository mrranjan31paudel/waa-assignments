import Post from "../../components/Post/Post";

import "./Posts.css";

function Posts(props) {

  return (
    <div className="posts-container mb-8">
      <h3>Posts</h3>
      <hr />
      <div className="posts">
        {(props.posts || []).map(post => (
          <Post
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            onClick={() => props.onPostSelect(post)} />
        ))}
      </div>
    </div>
  )
}

export default Posts;
