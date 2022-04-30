MATCH (city:City)<-[l:LOCATED_IN]-(r:Restaurant)-[s:SERVES]->(c:Cuisine)
  WHERE c.cuisine_name = 'Thai' AND (city.city_name = 'Chicago' OR city.city_name = 'Austin') AND r.
    established_year > 1999
RETURN DISTINCT r.restaurant_name, r.ratings
  ORDER BY r.ratings DESC, r.restaurant_name ASC;

MATCH (p1:Person)-[:FRIENDS_WITH*..3]->(p2:Person)-[:LIVES_IN]->(city:City)<-[:LOCATED_IN]-(r:Restaurant)
  WHERE p1.person_name = 'Doug Frost'
RETURN DISTINCT city.city_name, collect(DISTINCT r.restaurant_name)
  ORDER BY city.city_name ASC;

MERGE (b:Brand {brand_name: 'Google'})<-[:BELONGS_TO]-(p:Product)
  ON CREATE SET b.brand_id = 5, b.year_established = 1969
  ON MATCH SET b.brand_id = 4, b.year_established = 1969
RETURN b.brand_id, b.brand_name, b.year_established, COUNT(*) AS ct;

MATCH x = (b:Brand)<-[:BELONGS_TO]-(p:Product)
  WHERE p.quantity < 3 AND p.rate > 3
FOREACH (p IN nodes(x) |
  SET p.tag = 'Low Stock!!'
)
RETURN DISTINCT p.product_name, b.brand_name, p.tag
  ORDER BY p.product_name ASC, b.brand_name DESC;

MATCH (b:Brand)<-[:BELONGS_TO]-(product:Product)<-[:WISHLIST]-(person:Person)
WITH person, COUNT(*) AS ct, sum(product.price) + 5 AS total, collect(DISTINCT b.brand_name) AS brand_list
  WHERE total <= 500
RETURN person.person_name, brand_list, ct, total;

MATCH (b:Brand)<-[:BELONGS_TO]-(product:Product)<-[:BOUGHT]-(person:Person)
  WHERE b.brand_name = 'Apple' OR b.brand_name = 'Samsung'OR b.brand_name = 'Sony'
RETURN
  person.person_name AS name, collect(DISTINCT product.product_name) AS outputList, round(sum(product.price)) AS price
UNION
MATCH (b:Brand)<-[:BELONGS_TO]-(product:Product)<-[:WISHLIST]-(person:Person)
WITH
  person.person_name AS name, collect(DISTINCT product.product_name) AS outputList, round(sum(product.price)) AS price,
  COUNT(*) AS c
  WHERE c >= 3
RETURN name, outputList, price;

MATCH path = shortestPath((p1:Actor)-[:FRIENDS_WITH*..3]->(p2:Actor))
  WHERE p1.birth_year > 1990 AND p1.birth_year = p2.birth_year AND p1.birth_country <> p2.birth_country
RETURN length(path), p1.actor_name, p2.actor_name
  ORDER BY length(path);


MATCH (movie: Movie)
WHERE movie.movie_name IN ['Spider-Man', 'Eternals' ,'Ant-Man', 'Iron Man 1', 'Iron Man 2', 'Iron Man 3']
SET movie.production_company = 'Marvel Studios'
RETURN movie.movie_name, movie.ratings, movie.production_company
ORDER BY movie.movie_name ASC;


