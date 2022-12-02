import { get, post } from "./api.js";
import { clearUserData, setUserData } from "../util.js";

 // different problems will require  data from various fields. Check the register form in order to be most accurate
export async function login(email, password) {
 const result = await post('/users/login', {email, password});
//this userData will vary depending on the concrete problem HOWEVER user id and access token shoud be always present
 const userData = {
    id: result._id,
    email: result.email,
    accessToken: result.accessToken
 }

 setUserData(userData);

 return result;
}
export async function register(email, password) {
 const result = await post('/users/register', {email, password});
const userData = {
    id: result._id,
    email: result.email,
    accessToken: result.accessToken,
 }

 setUserData(userData);

 return result;

}

export function logout() { 
    get('/users/logout');
    clearUserData();
}



