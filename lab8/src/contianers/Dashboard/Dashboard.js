import { useEffect, useState } from "react";

import PostDetails from "../../components/PostDetails/PostDetails";
import Posts from "../Posts/Posts";
import http from "../../services/http";
import AddPost from "../../components/AddPost/AddPost";

import "./Dashboard.css"

function Dashboard(props) {

  const [selectedPostId, setSelectedPostId] = useState(0);
  const [posts, setPosts] = useState([]);
  const [users, setUsers] = useState([]);

  const fetchPosts = (params = {}) => {
    http.get("/posts", params)
      .then(result => {
        setPosts(result.data || []);
      })
      .catch(error => {
        console.log(error.message);
      });
  }

  const fetchUsers = (params = {}) => {
    http.get("/users", params)
      .then(result => {
        setUsers(result.data || []);
      })
      .catch(error => {
        console.log(error.message);
      });
  }

  const createPost = (authorId, postData, onSuccess) => {
    http.post(`/users/${authorId}/posts`, postData)
      .then(result => {
        fetchPosts();
        onSuccess();
      })
      .catch(error => {
        console.log(error.message);
      })
  }

  const deletePost = id => {
    http.delete(`/posts/${id}`)
      .then(result => {
        fetchPosts();
        setSelectedPostId(0);
      })
      .catch(error => {
        console.log(error);
      })
  }

  useEffect(() => {
    fetchPosts();
    fetchUsers();
  }, []);

  const handlePostDelete = id => {
    deletePost(id);
  }

  const handleAddPost = (authorId, postData, onSuccess) => {
    createPost(authorId, postData, onSuccess);
  }

  return (
    <div className="dashboard row">
      <div className="col30 mr-8">
        <Posts posts={posts} onPostSelect={postId => setSelectedPostId(postId)} />
      </div>
      <div className="col40 mr-8">
        <PostDetails
          postId={selectedPostId}
          onDelete={() => handlePostDelete(selectedPostId)}
          onCloseDetails={() => setSelectedPostId(0)} />
      </div>
      <div className="col30 ">
        <AddPost users={users} addPost={handleAddPost} />
      </div>
    </div>
  )
}

export default Dashboard;
