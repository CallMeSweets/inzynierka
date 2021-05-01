#!/bin/bash

if [ -z "${M2_HOME}" ]; then
  export MVN_EXEC="mvn"
else
  export MVN_EXEC="${M2_HOME}/bin/mvn"
fi

build() {
    $MVN_EXEC clean package -DskipTests
}

build_all(){
    build_basket_service
    build_books_service
    build_clothes_service
    build_mailing_service
    build_receipts_service
    build_sales_service
    build_shoes_service
}

build_basket_service(){
    cd basket-service
    build
    docker build -t grz3lak1997/basket-service:1 .
    docker push grz3lak1997/basket-service:1
    cd ..
}

build_books_service(){
    cd books-service
    build
    docker build -t grz3lak1997/books-service:1 .
    docker push grz3lak1997/books-service:1
    cd ..
}

build_clothes_service(){
    cd clothes-service
    build
    docker build -t grz3lak1997/jacket-tshirt-service:1 .
    docker push grz3lak1997/jacket-tshirt-service:1
    cd ..
}

build_mailing_service(){
    cd mailing-service
    build
    docker build -t grz3lak1997/mailing-service:1 .
    docker push grz3lak1997/mailing-service:1
    cd ..
}

build_receipts_service(){
    cd receipts-service
    build
    docker build -t grz3lak1997/receipts-service:1 .
    docker push grz3lak1997/receipts-service:1
    cd ..
}

build_sales_service(){
    cd sales-service
    build
    docker build -t grz3lak1997/sales-service:1 .
    docker push grz3lak1997/sales-service:1
    cd ..
}

build_shoes_service(){
    cd shoes-service
    build
    docker build -t grz3lak1997/shoes-service:1 .
    docker push grz3lak1997/shoes-service:1
    cd ..
}


case "$1" in
  all)
    build_all
    ;;
  basket)
    build_basket_service
    ;;
  books)
    build_books_service
    ;;
  clothes)
    build_clothes_service
    ;;
  mailing)
    build_mailing_service
    ;;
  receipts)
    build_receipts_service
    ;;
  sales)
    build_sales_service
    ;;
  shoes)
    build_shoes_service
    ;;
  *)
    echo "Usage: $0 {all|shoes|sales|receipts|mailing|clothes|books|basket}"
esac
