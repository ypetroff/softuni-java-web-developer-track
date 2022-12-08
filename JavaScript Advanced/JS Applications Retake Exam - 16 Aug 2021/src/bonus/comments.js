import * as api from '../api/api.js';

const endpoints = {
    byGameId: (gameId) => ``,
    post: ''
};

export async function getByGameId(gameId) {
    return api.get(endpoints.gameId(gameId))
}

export async function postComments(comment) {
    return api.post(endpoints.post, comment)
}

/*

*/