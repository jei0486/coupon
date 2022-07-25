### 쿠폰 서비스

### 요구사항 (목적)
- 사용자에게 쿠폰을 제공하는 서비스를 개발
- 기능 명세에대한 개발 및 성능테스트

### 기능명세
- 랜덤한 코드의 쿠폰을 N개 생성하여 데이터베이스에 보관하는 API 구현
- 사용자에게 지급된 쿠폰을 조회하는 API 구현
- 지급된 쿠폰을 사용하는 API 구현
- 지급된 쿠폰을 사용 취소하는 API 구현
- 발급된 쿠폰중 당일 만료된 전체 쿠폰 목록 조회하는 API 구현
- 쿠폰 만료일 1일전 알림 배치

### 프로젝트 정의
- common-coupon : 공통 dto, entity
- api-coupon    : api , kafka publishing , db read
- kafka-coupon  : kafka consume , db write
