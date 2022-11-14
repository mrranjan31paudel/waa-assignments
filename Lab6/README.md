# Lab 6 Assignment

## No-Auth Requests
Requests that do not require authentication.
- Path: `/api/v1/authenticate`, `/api/v1/users`
- Method: `POST`
- Body: `{...}`
- Authorization Header: `null`

## Refresh Request
The only request that is used to refresh the access token and should contain expired access token in the `Authorization` Header and refresh token in the request body.
- Path: `/api/v1/authenticate/refresh`
- Method: `POST`
- Body:
  ```
  {
    "refreshToken": "..."
  }
  ```
- Authorization Header: `"Bearer ..."`

## Authentication process
*(Only for the requests except no-auth requests.)*
1. If a request does not contain a proper authentication header (i.e. header either null or no `Bearer ` prefix), return response `401 (Unauthorized)`.
2. If a request contains a proper authentication header, validate the access token
   1. If the access token is expired, return response `401` with message `TOKEN_EXPIRED`. OR
   2. If there is any other JWT exception, return response `401 (Unauthorized)`.
3. If the access token is valid, proceed the request further to authorization based on roles or authorities.

## Refresh Process
*(Only for the refresh request)*
1. If the request does not contain a proper authentication header i.e. either null or no `Bearer ` prefix, return response `401 (Unauthorized)`.
2. If the request contains a proper authentication header, validate the access token
   1. If the access token is expired, continue. OR
   2. If there is any other JWT exception, return response `401 (Unauthorized)`.
3. In `AuthController`.`refreshToken()`
   1. If the refresh token from the request body is not valid (expired or any other exception), return response `401 (Unauthorized)`. OR
   2. If no user details can be obtained from the refresh token's subject (username), return response `401 (Unauthorized)`.
   3. Otherwise, generate a new access token and return an object containing access and refresh tokens.