#!/usr/bin/env bash

cd $(dirname $0)

docker-compose --env-file environment -p cache-manager -f docker-compose.yml up -d