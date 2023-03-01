
# 公共接口实现
## 默认的首页

**URL:** `http://127.0.0.1:1996/SocietiesSystem`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 默认的首页





**Request-example:**
```
curl -X GET -i http://127.0.0.1:1996/SocietiesSystem/
```

**Response-example:**
```
Forward or redirect to a page view.
```

## 用户登录路由，向前端返回登录页面

**URL:** `http://127.0.0.1:1996/SocietiesSystem/toLogin`

**Type:** `POST`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 用户登录路由，向前端返回登录页面





**Request-example:**
```
curl -X POST -i http://127.0.0.1:1996/SocietiesSystem/toLogin
```

**Response-example:**
```
Forward or redirect to a page view.
```

