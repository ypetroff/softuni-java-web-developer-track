import * as api from "./api.js";

export async function getAllItems() {
  return api.get("/data/offers?sortBy=_createdOn%20desc");
}

export async function getItemById(id) {
  return api.get(`/data/offers/${id}`);
}

export async function createItem(item) {
  return api.post("/data/offers", item);
}

export async function deleteItem(id) {
  return api.del(`/data/offers/${id}`);
}

export async function updateItem(id, item) {
    return api.put(`/data/offers/${id}`, item);
}

export async function applyItem(id) {
  return api.post('/data/applications', id);
}

export async function getTotalApplications(offerId) {
  return api.get(`/data/applications?where=offerId%3D%22${offerId}%22&distinct=_ownerId&count`);
}

export async function isAppliedByUser(offerId, userId) {
return api.get(`/data/applications?where=offerId%3D%22${offerId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
}
	

