## No-Auth Requests
Requests that do not require authentication.
- Path: `/api/v1/authenticate`, `/api/v1/users`
- Method: `POST`

## Refresh Request
The only request that is used to refresh the access token and should contain expired access token in the `Authorization` Header.
- Path: `/api/v1/authenticate/refresh`
- Method: `POST`

## Authentication process
1. If a request (except no-auth requests) does not contain a proper authentication header (i.e. header either null or no `Bearer ` prefix), return response `401 (Unauthorized)`.
2. If a request contains a proper authentication header, validate the access token
   1. If the access token is expired, return response `401` with message `TOKEN_EXPIRED`. OR
   2. If there is any JWT exception, return response `401 (Unauthorized)`.
3. If access token is valid, proceed the request further to authorization based on roles or authorities.

## Refresh Process
1. If the request (except no-auth requests) does not contain a proper authentication header i.e. either null or no `Bearer ` prefix, return response `401 (Unauthorized)`.
2. If a request contains a proper authentication header, validate the access token
   1. If the access token is expired, continue. OR
   2. If there is any JWT exception, return response `401 (Unauthorized)`.
3. In `AuthController`.`refreshToken()`
   1. If refresh token of the request body is not valid (expired or any other exception), return response `401 (Unauthorized)`. OR
   2. If no user details can be obtained from the refresh token's subject (username), return response `401 (Unauthorized)`.
   3. Otherwise, generate a new access token and return an object containing access and refresh tokens.