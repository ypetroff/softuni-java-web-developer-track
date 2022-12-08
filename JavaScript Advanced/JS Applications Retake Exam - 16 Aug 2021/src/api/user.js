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
 // different problems will require  data from various fields. Check the register form in order to be most accurate
export async function register(email, password) {
 const result = await post('/users/register', {email, password});
//this userData will vary depending on the concrete problem HOWEVER user id and access token shoud be always present
const userData = {
    id: result._id,
    email: result.email,
    accessToken: result.accessToken,
 }

 setUserData(userData);

 return result;

}
//add id to the button in the html
export function logout() { //<a href="javascript:void(0)">Logout</a>
    get('/users/logout');
    clearUserData();
}



