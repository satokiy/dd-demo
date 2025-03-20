
build image
```shell
./gradlew bootBuildImage --imageName=stkymd/spring-boot-docker
```
docker login
```shell
docker login -u <user-name> 
```

push
```shell
docker tag stkymd/spring-boot-docker:latest stkymd/spring-boot-docker:latest
docker push stkymd/spring-boot-docker
```

run
```shell
docker run -it -p 8080:8080 -t stkymd/spring-boot-docker
```

deploy
```shell
kubectl apply -f k8s-manifests/
```

