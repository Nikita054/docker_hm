cd main_docker
docker build -t main_image .
cd ../
docker-compose build
docker-compose run -d --publish 8081:8080 main_service