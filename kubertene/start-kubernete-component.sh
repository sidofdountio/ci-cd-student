#!/bin/bash
kubectl apply -f postgres-config.yaml
kubectl apply -f postgres-secret.yaml
kubectl apply -f postgres-service.yaml
kubectl apply -f postgres.yaml
kubectl apply -f school-api-service.yaml
kubectl apply -f school-api.yaml
echo "======================services================================= "
kubectl get svc
echo "======================services and pod========================"
kubectl get pod
echo "======================services and port========================"
kubectl get svc -o wide
