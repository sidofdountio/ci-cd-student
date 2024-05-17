# This Docker cmd start service and build App image from Dockerfile
ENV_FILE=./.env.dev docker compose  down
ENV_FILE=./.env.dev docker compose  up -d --build
#ENV_FILE=./.env.dev docker build -t dountio/devops-skills-api:v1 .
# This docker cmd start docker services
#ENV_FILE=./.env.dev docker compose  up -d
#AWS
#ENV_FILE=./.env.dev docker buildx build --platform linux/amd64 -t dountio/devops-skills-api:v1.0.0 .
#echo " start push the image"
#docker tag devops-skills-api:v1 dountio/devops-skills-api:v1
#docker push dountio/devops-skills-api:v1
#echo "finish push image"
# This docker cmd start docker services

#ENV_FILE=./.env.dev docker compose  up -d

