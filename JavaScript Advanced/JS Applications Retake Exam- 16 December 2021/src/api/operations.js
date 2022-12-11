import * as api from "./api.js";

export async function getAllItems() {
  return api.get("/data/theaters?sortBy=_createdOn%20desc&distinct=title");
}

export async function getItemsByUser(userId) {
  return api.get(`/data/theaters?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
                  
}

export async function getItemById(id) {
  return api.get(`/data/theaters/${id}`);
}

export async function createItem(item) {
  return api.post("/data/theaters", item);
}

export async function deleteItem(id) {
  return api.del(`/data/theaters/${id}`);
}

export async function updateItem(id, item) {
    return api.put(`/data/theaters/${id}`, item);
}

export async function likeItem(id) {
  return api.post('/data/likes', id);
}

export async function getTotalLikes(theaterId) {
  return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22&distinct=_ownerId&count`);
                ///data/likes?where=theaterId%3D%22${theaterId}%22&distinct=_ownerId&count
}

export async function isLikedByUser(theaterId, userId) {
return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
}
	

