#!/usr/bin/env bash

cd $(dirname $0)

docker-compose -p cache-manager -f docker-compose.yml up -d --build