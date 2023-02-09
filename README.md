### Perform multiple requests

ab -n 10 -c 10 -p post.data 'localhost:8080/customers?firstName=John&lastName=Galt'