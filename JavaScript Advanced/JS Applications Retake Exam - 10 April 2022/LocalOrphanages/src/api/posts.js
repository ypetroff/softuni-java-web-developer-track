import * as api from "./api.js";

export async function getAllPosts() {
  return api.get("/data/posts?sortBy=_createdOn%20desc");
  
}

export async function getPostsByUser(userId) {
  return api.get(`/data/posts?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
                  
}

export async function getPostById(id) {
  return api.get(`/data/posts/${id}`);
}

export async function createPost(post) {
  return api.post("/data/posts", post);
}

export async function deletePost(id) {
  return api.del(`/data/posts/${id}`);
}

export async function updatePost(id, post) {
    return api.put(`/data/posts/${id}`, post);
}

export async function didUserDonated(postId, userId) {
  return api.get(`/data/donations?where=postId%3D%22${postId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
}

export async function userDonate(postId) {
  return api.post('/data/donations', postId)
}

export async function getTotalDonations(postId) {
 return api.get(`/data/donations?where=postId%3D%22${postId}%22&distinct=_ownerId&count`)
}
	

