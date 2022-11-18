import { useState } from "react";
import PostDetails from "../../components/PostDetails/PostDetails";
import PostForm from "../../components/PostForm/PostForm";
import Posts from "../Posts/Posts";

import "./Dashboard.css"

function Dashboard(props) {

  const [selectedPost, setSelectedPost] = useState(null);
  const [posts, setPosts] = useState([
    { id: 1, title: "Post 1", author: "John Cena", content: "this is the post 1" },
    { id: 2, title: "Post 2", author: "Rey Mysterio", content: "this is the post 2" }
  ]);

  const handleFirstPostTitleChange = title => {
    let newPosts = [...posts];
    newPosts[0] = {
      ...newPosts[0],
      title: title
    };

    setPosts(newPosts);
  }

  return (
    <div className="dashboard">
      <Posts posts={posts} onPostSelect={post => setSelectedPost({ ...post })} />
      <div className="mb-8">
        <div>Change first post title:</div>
        <PostForm onTitleChange={handleFirstPostTitleChange} />
      </div>
      <PostDetails {...(selectedPost || {})} />
    </div>
  )
}

export default Dashboard;
