run:
	docker run -p 8000:8000 springio/gs-spring-boot-docker

build:
	docker build -t springio/gs-spring-boot-docker .