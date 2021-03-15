#!/usr/bin/env bash

./mvnw clean install package
if (( $? == 0 )); then
  ls $(pwd)/target/*.jar | java -jar $(tee)
else
  echo "You gotta enable execution permission on the ./mvnw script"
fi