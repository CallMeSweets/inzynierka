while sleep 1;
do
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/shoe/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/tshirt/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/jacket/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/book/1'
  echo ''

  curl --location --request GET 'http://localhost:8080/api/v1/basket/book/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/basket/tshirt/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/basket/jacket/1'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/basket/shoe/1'
  echo ''

  curl --location --request GET 'http://localhost:8080/api/v1/basket/discount'
  echo ''
  curl --location --request GET 'http://localhost:8080/api/v1/basket/receipt'
  echo ''
done

