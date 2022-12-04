import * as api from "./api.js";

export async function getAllBooks() {
  return api.get("/data/books?sortBy=_createdOn%20desc");
}

export async function getBookByUser(userId) {
  return api.get(`/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
                  
}

export async function getBookById(id) {
  return api.get(`/data/books/${id}`);
}

export async function createBook(book) {
  return api.post("/data/books", book);
}

export async function deleteBook(id) {
  return api.del(`/data/books/${id}`);
}

export async function updateBook(id, book) {
    return api.put(`/data/books/${id}`, book);
}

export async function likeBook(id) {
  return api.post('/data/likes', id);
}

export async function totalLikes(bookId) {
  return api.get(`/data/likes?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`);
}

export async function verifyIfLiked(userId, bookId) {
  return api.get(`/data/likes?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`)
}
	

