#!/usr/bin/env bash

./mvnw clean install package
if (( $? == 0 )); then
  case $1 in
    -d | *)
      export DEPLOY_MODE='Development'
      ls $(pwd)/target/*.jar | java -jar $(tee)
    ;;
    -p)
      export DEPLOY_MODE='Production'
      ls $(pwd)/target/*.jar | java -jar $(tee)
    ;;
  esac
else
  echo "You gotta enable execution permission on the ./mvnw script"
fi