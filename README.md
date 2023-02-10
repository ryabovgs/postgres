### Perform multiple requests

1. Add customers: ab -n 10 -c 10 -p post.data 'localhost:8080/customers?firstName=John&lastName=Galt'
2. Add clicks: ab -n 10 -c 10 -p post.data 'localhost:8080/clicks?clickType=BUCKET'