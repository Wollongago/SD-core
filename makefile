up:
	@docker network inspect sd-core >/dev/null || docker network create sd-core
	docker-compose -p sd-core up -d

bash:
	docker exec -it $$(docker ps -aqf "name=sd-core-sd_core-1") /bin/bash

stop:
	docker-compose -p sd-core stop sd_core

restart:
	@LOGPATH=$$(docker inspect --format='{{.LogPath}}' sd-core-sd_core-1); \
	if [ -n "$${LOGPATH}" ]; then sudo truncate -s 0 $${LOGPATH}; fi
	docker-compose -p sd-core restart sd_core

down:
	docker-compose -p sd-core down --remove-orphans

logs:
	docker-compose -p sd-core logs -f sd_core

build:
	docker build -t springio/gs-spring-boot-docker .