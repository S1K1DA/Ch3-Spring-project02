> # CH3 일정 관리 앱 만들기 과제

### 스파르타 내일배움캠프 Spring 백엔드 2기
### 3조 정은식

---

> ## 요약

**일정 관리 앱**

`필수` [STEP 1] : 일정 CRUD

`필수` [STEP 2] : 유저 CRUD

`필수` [STEP 3] : 회원가입

`필수` [STEP 4] : 로그인(인증)

`선택` [STEP 5] : 다양한 예외처리

`선택` [STEP 6] : 비밀번호 암호화

`선택` [STEP 7] : 댓글 CRUD

`선택` [STEP 8] : 일정 페이징 조회


---

> ## 프로젝트 구조

<img width="400" height="600" alt="image" src="https://github.com/user-attachments/assets/8649a33b-14d4-40b9-97bf-769a663ab631" />


---

> ## ✅ 필수 기능

### STEP 1. 일정 CRUD

* 일정 생성/ 일정 조회(단건,전체)/ 일정 수정/ 일정 삭제 기능 구현 
* JPA Auditing을 활용하여 작성일, 수정일 자동관리!
* REST API 규칙에 맞게 상태 코드 반환

<img width="2461" height="1168" alt="image" src="https://github.com/user-attachments/assets/f8bde106-191e-41e3-bc28-7334d160a608" />
<img width="2501" height="1160" alt="image" src="https://github.com/user-attachments/assets/095aef30-158a-4b45-a557-b41d103a8b69" />
<img width="2494" height="1489" alt="image" src="https://github.com/user-attachments/assets/6d1d42bd-b0f1-410b-a56c-6d920b4bd1cc" />
<img width="2546" height="1119" alt="image" src="https://github.com/user-attachments/assets/99015832-f04c-4bc4-b2e3-d1971c2ce27a" />
<img width="2506" height="916" alt="image" src="https://github.com/user-attachments/assets/2af04dd0-a536-4aef-859d-be4fd22446d4" />
<img width="2469" height="1393" alt="image" src="https://github.com/user-attachments/assets/067c87b0-0dbf-42a1-8f1d-5b1a230c4fe6" />


---

### STEP 2. 유저 CRUD

* 유저 생성/ 유저 조회(단건,전체)/ 유저 정보 수정/ 유저 삭제 기능 구현
* 유저와 일정 간 연관관계(1:N) 매칭 - 한유저의 여러가지 일정

<img width="2440" height="1058" alt="image" src="https://github.com/user-attachments/assets/858fe51c-062e-4608-aeb0-7e1c3fba3932" />
<img width="2496" height="1333" alt="image" src="https://github.com/user-attachments/assets/737f784b-e77b-4fc3-b3f5-6214d5da24d2" />
<img width="2485" height="1085" alt="image" src="https://github.com/user-attachments/assets/4f1e379b-dedc-49d4-911e-b5524877a2df" />
<img width="2406" height="1135" alt="image" src="https://github.com/user-attachments/assets/2e51586f-6840-4758-bb03-89ab4c6aaab5" />
<img width="2455" height="1006" alt="image" src="https://github.com/user-attachments/assets/ec75b2e1-9a56-45d8-a8ca-48f9fe951844" />

---

### STEP 3. 회원가입

* 유저에 비밀번호를 추가해여 회원가입 기능 구현
* Validation을 활용하여 입력값 검증(비밀번호 길이)

<img width="1616" height="1027" alt="image" src="https://github.com/user-attachments/assets/c0f97989-11e1-4bf1-92c2-2c27f7f4f3c2" />
<img width="1722" height="1028" alt="image" src="https://github.com/user-attachments/assets/a9f530ba-0d2e-4265-a046-e88e9d28c1d1" />


---

### STEP 4. 로그인(인증)

* 이메일과 비밀번호를 이용한 로그인 기능
* Cookie,session 기반 인증
* 로그인 시 세션에 사용자 정보 저장

<img width="2399" height="1019" alt="image" src="https://github.com/user-attachments/assets/ea4982e0-96d0-4ce9-b265-df841bf6f599" />

---

> ## ✅ 선택 기능 (도전 과제)

### STEP 5. 다양한 예외처리

* CustomException과 GlobalExceptionHandler를 통한 예외 처리
* Validation 오류 및 비즈니스 예외에 대한 공통 응답 처리

<img width="2292" height="873" alt="image" src="https://github.com/user-attachments/assets/b5d9ff0b-d395-4968-bb7d-2eba9dd15f73" />
<img width="2313" height="785" alt="image" src="https://github.com/user-attachments/assets/51c4678b-d423-4bab-a70d-7032409869ec" />

---

### STEP 6. 비밀번호 암호화

* BCrypt기반 PasswordEncoder 구현
* 회원가입 시 비민ㅂ번호 암호화 후 저장
* 로그인 할떄 암호화된 비밀번호와 저장된 비밀번호 비교 처리

<img width="2430" height="952" alt="image" src="https://github.com/user-attachments/assets/374838f7-4087-405c-b2ef-d6678545ed35" />
<img width="1538" height="156" alt="image" src="https://github.com/user-attachments/assets/96d247f2-be90-4da2-8cb9-0d5a72d2041c" />

---

### STEP 7. 댓글 CRUD

* 일정에 댓글 작성/ 댓글 조회/ 댓글 수정/ 댓글 삭제 기능 구현
* 댓글, 일정, 유저 간 연관관계 매칭
* 댓글 작성 시 세션 로그인 활용

<img width="2453" height="1113" alt="image" src="https://github.com/user-attachments/assets/6bc9397f-9512-4994-83ae-d8d37d64bb47" />
<img width="2431" height="1175" alt="image" src="https://github.com/user-attachments/assets/2e416c92-ede8-40c1-9886-ea2bd11294d0" />
<img width="2457" height="1106" alt="image" src="https://github.com/user-attachments/assets/b87e73ff-a3ee-448b-83ac-096dee62de1b" />
<img width="2484" height="1381" alt="image" src="https://github.com/user-attachments/assets/4aef8d44-78e4-4dd4-ba87-b29b7a6ed863" />
<img width="2414" height="1195" alt="image" src="https://github.com/user-attachments/assets/032333ee-1401-48ad-9134-a020d773ade6" />
<img width="2436" height="1354" alt="image" src="https://github.com/user-attachments/assets/4f0d8290-f106-4d5b-855e-fabbfbec1ca0" />
<img width="2428" height="1145" alt="image" src="https://github.com/user-attachments/assets/45bc3c0f-2e88-43e4-9b8b-8c78456be9a8" />
<img width="2444" height="1133" alt="image" src="https://github.com/user-attachments/assets/26133040-7c80-4f62-a110-6fbe94573663" />
<img width="2436" height="1169" alt="image" src="https://github.com/user-attachments/assets/adc199e0-64fb-4a27-aa74-6f3d95a8687e" />
<img width="2477" height="898" alt="image" src="https://github.com/user-attachments/assets/4d64da66-5035-4ece-ba9e-9f08246553a7" />

---

### STEP 8. 일정 페이징 조회
* Spring Data JPA의 Pageable, Page를 활용한 일정 페이징 처리

<img width="2456" height="1481" alt="image" src="https://github.com/user-attachments/assets/0ea3b2b1-d908-4c88-aab7-d9e993317616" />

---

## 설치 방법

* 프로젝트 클론
  * git clone https://github.com/S1K1DA/Ch3-Spring-project02.git
  * Ch3-Spring-project02
 
* 개발 환경
  * Java : 17
  * Spring Boot : 3.x
  * Build Tool : Gradle
  * Database : MySQL
  * ORM : Spring Data JPA
 
---

> # API 명세서

> ## [일정 API]

### 1. 일정 생성 API (POST)

URL
```
http://localhost:8080/api/schedules
```

Request Body
```
{
  "userId": "2",
  "title": "일정 댓글 테스트",
  "content": "포스트맨 테스트 중"
}
```

Response
```
201 Created
{
    "content": "포스트맨 테스트 중",
    "createdAt": "2026-01-12T11:58:27.6219548",
    "id": 2,
    "title": "일정 댓글 테스트",
    "updatedAt": "2026-01-12T11:58:27.6219548",
    "userId": 2,
    "userName": "시키"
}
```

### 2. 일정 전체 조회(페이징) API (GET)

URL
```
http://localhost:8080/api/schedules

```

Response
```
200 OK
{
    "content": [
        {
            "commentCount": 0,
            "content": "포스트맨 테스트 중",
            "createdAt": "2026-01-12T11:58:27.621955",
            "id": 2,
            "title": "일정 댓글 테스트",
            "updatedAt": "2026-01-12T11:58:27.621955",
            "userName": "시키"
        },
        {
            "commentCount": 5,
            "content": "포스트맨 테스트 중",
            "createdAt": "2026-01-12T02:56:39.718862",
            "id": 1,
            "title": "일정 댓글 테스트",
            "updatedAt": "2026-01-12T02:56:39.718862",
            "userName": "시키"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 10,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 1
}
```

### 3. 일정 단건 조회 API (GET)

URL
```
http://localhost:8080/api/schedules/1

```

Response
```
200 OK
{
    "content": "포스트맨 테스트 중",
    "createdAt": "2026-01-12T02:56:39.718862",
    "id": 1,
    "title": "일정 댓글 테스트",
    "updatedAt": "2026-01-12T02:56:39.718862",
    "userId": 2,
    "userName": "시키"
}
```


### 4. 일정 수정 API (PATCH)

URL
```
[GET http://localhost:8080/api/schedules/1](http://localhost:8080/api/schedules/1)

```

Request Body
```
{
  "title": "수정된 일정",
  "content": "내용 수정 완료"
}
```



Response
```
200 OK
{
    "content": "내용 수정 완료",
    "createdAt": "2026-01-12T02:56:39.718862",
    "id": 1,
    "title": "수정된 일정",
    "updatedAt": "2026-01-12T02:56:39.718862",
    "userId": 2,
    "userName": "시키"
}

```

### 5. 일정 삭제 API (DELETE)

URL
```
http://localhost:8080/api/schedules/2
```

Response
```
204 NO Content
```

> ## [유저 API]


### 6. 유저 생성(회원가입) API (POST)

URL
```
http://localhost:8080/api/users
```

Request Body
```
{
  "userName": "나다시키",
  "email": "siki123@naver.com",
  "password": "123456789"
}
```

Response
```
201 Created
{
    "createdAt": "2026-01-12T12:06:05.8515908",
    "email": "siki123@naver.com",
    "id": 4,
    "updatedAt": "2026-01-12T12:06:05.8515908",
    "userName": "나다시키"
}
```

### 7. 유저 전체 조회 API (GET)

URL
```
http://localhost:8080/api/users

```

Response
```
200 OK
[
    {
        "createdAt": "2026-01-12T02:07:16.672845",
        "email": "bamtol2100@naver.com",
        "id": 2,
        "updatedAt": "2026-01-12T02:07:16.672845",
        "userName": "시키"
    },
    {
        "createdAt": "2026-01-12T03:01:02.796014",
        "email": "dmstlr2100@naver.com",
        "id": 3,
        "updatedAt": "2026-01-12T03:01:02.796014",
        "userName": "은식"
    },
    {
        "createdAt": "2026-01-12T12:06:05.851591",
        "email": "siki123@naver.com",
        "id": 4,
        "updatedAt": "2026-01-12T12:06:05.851591",
        "userName": "나다시키"
    }
]
```


### 8. 유저 단건 조회 API (GET)

URL
```
http://localhost:8080/api/users/4

```

Response
```

200 OK
{
    "createdAt": "2026-01-12T12:06:05.851591",
    "email": "siki123@naver.com",
    "id": 4,
    "updatedAt": "2026-01-12T12:06:05.851591",
    "userName": "나다시키"
}
```

### 9. 유저 정보 수정 API (PATCH)

URL
```
http://localhost:8080/api/users/2
```
Request Body
```
{
  "email": "bamtol210000@naver.com"
}
```


Response
```
200 OK
{
    "createdAt": "2026-01-12T02:07:16.672845",
    "email": "bamtol210000@naver.com",
    "id": 2,
    "updatedAt": "2026-01-12T02:07:16.672845",
    "userName": "시키"
}
```

### 10. 유저 삭제 API (DELETE)

URL
```
http://localhost:8080/api/users/2
```

Response
```
204 No Content
```

### 11. 유저 로그인 (POST)
URL
```
http://localhost:8080/api/users/login

```

Request Body
```
{
  "email": "dmstlr2100@naver.com",
  "password": "123456789"
}
```

Response
```
200 OK
```

> ## [댓글 API]

### 12. 댓글 생성 API (POST)

URL
```
http://localhost:8080/api/schedules/1/comments
```

Request Body
```
{
  "content": "댓글 테스트입니다6"
}

```

Response
```
201 Created
{
    "content": "댓글 테스트입니다6",
    "createdAt": "2026-01-12T11:12:46.2244239",
    "id": 10,
    "scheduleId": 1,
    "userId": 3,
    "userName": "은식"
}
```

### 13. 댓글 전체 조회 API (GET)

URL
```
http://localhost:8080/api/schedules/3/comments
```

Response
```
200 OK
[
    {
        "content": "댓글 테스트입니다6",
        "createdAt": "2026-01-12T12:21:10.476247",
        "id": 11,
        "scheduleId": 3,
        "updatedAt": "2026-01-12T12:21:10.476247",
        "userId": 3,
        "userName": "은식"
    },
    {
        "content": "댓글 테스트입니다6",
        "createdAt": "2026-01-12T12:21:11.476581",
        "id": 12,
        "scheduleId": 3,
        "updatedAt": "2026-01-12T12:21:11.476581",
        "userId": 3,
        "userName": "은식"
    },
]
```

### 14. 댓글 수정 API (PATCH)

URL
```
http://localhost:8080/api/comments/11
```

Request Body
```
{
  "content": "댓글 수정 테스트입니다"
}
```

Response
```
200 OK
{
    "content": "댓글 수정 테스트입니다",
    "createdAt": "2026-01-12T12:21:10.476247",
    "id": 11,
    "scheduleId": 3,
    "updatedAt": "2026-01-12T12:21:10.476247",
    "userId": 3,
    "userName": "은식"
}
```

### 15. 댓글 삭제 API (DELETE)

URL
```
http://localhost:8080/api/comments/11
```

Response
```
204 No Content
```

🔥 그럼 20000 입니다!🔥



