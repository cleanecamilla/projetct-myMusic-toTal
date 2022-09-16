# MyMusic

## Features
1. Allows users to search for new musics in datatabase
2. Allows users to add musics to their playlists
3. Allows users to remove musics from their playlists
4. Create premium and common user profiles

Aplicação: https://my-music-jefferson023.cloud.okteto.net/swagger-ui/index.html

## Routes

### Music
- **`GET /api/v1/musicas`**: search for music matching filter param.

### Playlist
- **`POST /api/v1/playlists/{playlistId}`**: add the music passed in the request's body to the playlist
- **`DELETE /api/v1/playlists/{playlistId}`**: remove the music passed in the request's body to the playlist
- **`GET /api/v1/playlists/{playlistId}`**: return the data of the playlist 

### Login
- **`POST /auth/login`**: return a token when the username passed in the request's body is valid. 

### User
- **`POST /api/v1/users`**: saves a new user in database
- **`GET /api/v1/users/{userId}`**: return the data of the user


## Team
- [Edimara](https://github.com/edimaras)
- [Elvis](https://github.com/ebarbiericiandtier)
- [Jefferson](https://github.com/jeffrhudson)
- [Lucas](https://github.com/lucascruz77)
- [Rebecca](https://github.com/moraesrebecca)
