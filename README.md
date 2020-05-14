# Environment Setup Instructions

## Install Docker & docker-compose

Setup steps:

1. Install Docker: [Ubuntu](https://docs.docker.com/engine/install/ubuntu/) / [Fedora](https://docs.docker.com/engine/install/fedora/)

2. Reboot you PC/Laptop

3. [Docker post-installation](https://docs.docker.com/engine/install/linux-postinstall/)

4. Install [docker-compose](https://docs.docker.com/compose/install/)

5. Open Terminal

6. In terminal check docker is running with command: " docker ps -a "

7. In terminal in project folder execute: " docker-compose up -d "

8. In terminal check docker container is running: " docker ps "

9. In terminal execute: " docker exec -it postgres-10 bash "

10. In terminal execute: " createdb app_db -U postgres -E utf8 "

10. In terminal execute: " exit "

You can start and stop your container with postgres by executing:
docker start postgres-10
docker stop postgres-10

You can use [Swagger](http://127.0.0.1:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

"Хм, интересно, получится? Привет из Снежинска"