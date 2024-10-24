#!/bin/bash

sed -i "s/\${IMAGE_TAG}/${BUILD_NUMBER}/g" deployment.yaml

kubectl apply -f deployment.yaml