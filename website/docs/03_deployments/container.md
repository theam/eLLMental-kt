# Docker Containers

This doc will show how to build a Docker container image and then how to run it locally. We will use Docker for our commands demonstration, but any OCI style container framework should work.

To build the image just run the docker build command in the root directory of the repo as follows:

```sh
docker build -t kotlin-app -f ./semantic-search-service-demo/Dockerfile .
```

> we use the tag kotlin-app, change it to whatever makes sense for you

Then we can run this app in default port `8080` as follows:

```sh
docker run -p 8080:8080 kotlin-app
```

Make sure your application is running in this port or else the port binding won't work.

Finally to test it quickly, just run a curl command:

```sh
curl -v localhost:8080
```

Depending on how your application is structured, this will most likely return a `200` or `404` status code. If it returns either of them, it means your application is running.