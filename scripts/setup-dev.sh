#!/usr/bin/env sh

if ! (docker run --name tdd.yes -e POSTGRES_PASSWORD=1234 --restart=always -p 15240:5432 -d postgres:11); then
  echo "Failed to start database service"
  exit 1
fi
sleep 3
if ! (docker exec -it tdd.yes createdb -U postgres -O postgres tdd.yes); then
  echo "Failed to start database service"
  exit 1
fi
if ! (./scripts/setup-git.sh); then
  echo "Failed to init git hooks"
  exit 1
fi
echo "Dev environment setup completed, enjoy please!"
