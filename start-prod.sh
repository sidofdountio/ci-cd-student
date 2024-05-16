# This Docker cmd start service and build App image from Dockerfile
ENV_FILE=./.env.dev docker compose  up -d --build
# This docker cmd start docker services
#ENV_FILE=./.env.dev docker compose  up -d
