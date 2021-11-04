Trabajos prácticos
Enunciado 1:
Description:
Un cliente nos ha solicitado crear servicios similar a Spotify.

Entidades

Artist
idArtist
name
genre
image

Album
idAlbum
idArtist
name

track
id
name
idArtist
idAlbum
reproduction
duration

GET /spotify/play/track/{trackId}
Incrementar el reproduction en uno, para luego realizar las metricas de cada cancion.

GET /artist/{artistId}/songs/rank
Devolver el top 5 de canciones populares del artista.

GET /artist/rank
Devolver el top 5 de artistas populares.

GET /track/rank
Devolver el top 5 de canciones populares.

Acceptance Criteria
Usar lombok.
Usar streams.
Usar optional.
Usar Validator.
Crear collection en postman.
Crear adviceController
Crear exceptions custom
Crear nuevo repo llamado spotify-service
Crear el swagger de los endpoints que se van a implementar
POST /artist
PUT /artist/{artistId}
GET /artist/{artistId}
DELETE /artist/{artistId}
POST /album
PUT /album/{albumId}
GET /album/{albumId}
DELETE /album/{artistId}
POST /track
PUT /track/{trackId}
GET /track/{trackId}
DELETE /track/{artistId}
GET /spotify/play/track/{trackId}
GET /artist/{artistId}/songs/rank
GET /artist/rank
GET /track/rank
Crear un nuevo proyecto llamado spotify-service.
Realizar la implementacion con springboot.
Crear pull request.
Crear interfaces para cada servicio.
