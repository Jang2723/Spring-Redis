## Redis 명령어 모음
```sql
-- Map<String, String> map = new HashMap<>;
SET greeting "Hello Redis"
GET greeting

-- String
-- SET key value, GET key
SET string "string value"
GET string

-- 정수형 문자열의 경우 증감할 수 있다.
SET intstring 1
INCR intstring
DECR intstring
GET intstring

SET videoid 300
INCR videoid
GET videoid

-- 복수의 Key - Value 설정
MSET name subin age 26 merried false
MGET name age merried


-- List
-- LinkedList이며 Stack 또는 Queue로 활용
LPUSH fruitlist apple
RPUSH fruitlist banana
LPUSH fruitlist coconut
RPUSH fruitlist durian

RPOP fruitlist
LPOP fruitlist

LLEN fruitlist
LRANGE fruitlist 0 3
-- 전체
LRANGE fruitlist 0 -1
-- 0부터 10000000까지
LRANGE fruitlist 0 10000000
-- nothing
LRANGE fruitlist 3 2

-- Sets
SADD students alex
SADD students brad
SADD students chad

SMEMBERS students
SISMEMBER students alex
SISMEMBER students dave

SREM students alex
SCARD students


-- Hash
-- Map<String, Map<String,String>>
HSET alexinfo name alex age 20
HSET alexinfo major CSE
HSET alexinfo name "alex rodriguez"

HGET alexinfo name
HGET alexinfo age

HMGET alexinfo name age major

HGETALL alexinfo
HKEYS alexinfo
HVALS alexinfo
HLEN alexinfo


-- Sorted Set : ZADD 테이블 명 {실수값} {키 이름}
ZADD grades 10 alex
ZADD grades 9 brad 11 chad
ZADD grades 8 dave

ZINCRBY grades 1 dave

ZRANK grades alex
ZRANGE grades 0 3
ZRANGE grades 0 -3

ZREVRANK grades alex
ZREVRANGE grades 0 -1

-- EXPIRE
SET expirekey "to be expired"
EXPIRE expirekey 20
GET expirekey

EXPIRE fruitlist 10

-- DEL 키 삭제 명령어
DEL grades
DEL students

-- FLUSHDB 전체 삭제
FLUSHDB

```

