import { useCallback, useEffect, useMemo, useState } from "react";

import PostDetails from "../../components/PostDetails/PostDetails";
import Posts from "../Posts/Posts";
import http from "../../services/http";
import AddPost from "../../components/AddPost/AddPost";

import "./Dashboard.css";
import SelectedPostIdContext from "./SelectedPostIdContext";

function Dashboard(props) {

  const [selectedPostId, setSelectedPostId] = useState(0);
  const [posts, setPosts] = useState([]);
  const [users, setUsers] = useState([]);
  const memoizedSelectedPostId = useMemo(() => selectedPostId, [selectedPostId]);

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

  const handleSelectedPostDelete = useCallback(() => {
    deletePost(selectedPostId);
  }, [selectedPostId]);

  const handlePostDetailsClose = useCallback(() => {
    setSelectedPostId(0);
  }, []);

  const handleAddPost = (authorId, postData, onSuccess) => {
    createPost(authorId, postData, onSuccess);
  }

  return (
    <SelectedPostIdContext.Provider value={selectedPostId}>
      <div className="dashboard row">
        <div className="col30 mr-8">
          <Posts posts={posts} onPostSelect={postId => setSelectedPostId(postId)} />
        </div>
        <div className="col40 mr-8">
          <PostDetails
            postId={memoizedSelectedPostId}
            onDelete={handleSelectedPostDelete}
            onCloseDetails={handlePostDetailsClose} />
        </div>
        <div className="col30 ">
          <AddPost users={users} addPost={handleAddPost} />
        </div>
      </div>
    </SelectedPostIdContext.Provider>
  )
}

export default Dashboard;
