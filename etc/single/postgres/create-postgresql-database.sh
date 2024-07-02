#!/bin/bash

set -e
set -u

echo "  Creating user and database 'cache'"
psql -v ON_ERROR_STOP=1 --username "cache" <<-EOSQL
      CREATE USER cache;
	    CREATE DATABASE cache;
	    GRANT ALL PRIVILEGES ON DATABASE cache TO cache;
EOSQL

