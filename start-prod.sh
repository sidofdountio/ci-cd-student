# This Docker cmd start service and build App image from Dockerfile
ENV_FILE=./.env.prod docker compose  up -d --build
# This docker cmd start docker services
#ENV_FILE=./.env.prod docker compose  up -d
#docker tag devops-skills-api:latest dountio/devops-skills-api:latest
#docker push dountio/devops-skills-api:latest
