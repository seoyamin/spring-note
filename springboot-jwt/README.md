# :herb:Spring Boot JWT 
## 1. JWT (Json Web Token)
`json 객체`를 통해 토큰 자체에 다양한 정보를 저장하는 웹 토큰 <br>
https://jwt.io/introduction

<br>

## 2. JWT 장단점
#### 2-1. 장점
  - 중앙 인증 서버나 데이터 스토어에 대한 의존성이 없으므로, 시스템을 수평적으로 확장 가능
  - Base 64 URL Safe Encoding을 사용하므로 URL, Cookie, Header 등 다양한 용도로 사용 가능
### 2-2. 단점
  - Payload의 정보량이 많아지면 네트워크 사용량이 증가하므로, 효율적인 데이터 설계가 필요
  - 토큰이 클라이언트에 저장되므로, 서버에서 그 토큰을 직접 조작할 수 없음
  
<br>

## 3. JWT 구성요소
#### 3-1. Header
Header에는 토큰의 타입(jwt 등)과 signature를 해싱하기 위한 알고리즘 정보가 담겨있다.
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```
#### 3-2. Payload
Payload에는 실제 시스템에서 사용하기 위해 서버와 클라이언트가 주고받는 정보가 담겨있다.
```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "admin": true
}
```
#### 3-3. Signature
Signature는 서버에서 토큰의 유효성을 검증하기 위한 문자열이다.
