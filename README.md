# RHABBIT 습관을 관리하여 성공하기
#### 매일 매일 할 일들을 토끼처럼 빠르게 해치우자!!
#### 어제의 나를 이긴 나. 좀 멋있을 지도??
![image](https://user-images.githubusercontent.com/86106738/145660960-ab9e9351-b3cd-40e8-a606-0bd15823222c.png)
## RHABBIT 소개하기
#### 매일 습관처럼 해야하는 중요한 일들을 체크하여 
#### 성취율을 확인하며 관리하세요

> ####  시연영상 : https://youtu.be/N6L34DR2AVY  
> ####  배포:

## 주요기능
#### 습관 리스트 작성하기

#### 할일을 완료하면 완료체크하여 성취율 높이기
> 체크박스를 체크하면 그 날의 성취율을 계산하여 프로그레스바로 표시해 줌

#### 매일 해야할 일들은 'Daily체크'하여 다음날 자동으로 보여주기
> 어제의 진행도와 오늘의 진행도를 비교하여 오늘을 알차게 보냈는지 확인해보기
 
## 🗺와이어프레임
![image](https://user-images.githubusercontent.com/86106738/145660434-1f838d4d-4eb6-4fe9-aeda-64cf4f4b377b.png)

## API 설계
 
 [13조_미니프로젝트(Daily_Check)_API_.pdf](https://github.com/Rhabbit13/Rhabbit-FrontEnd/files/7696328/13._.Daily_Check._API_.pdf)

�Back-End
> Spring  
> AWS EC2 (Ubuntu 18.04 LTS)  
> Code With Me(IntelliJ)    
> ARC  

🧑🏻‍💻팀원소개
> 최석영 : JWT 로그인 구현, 주요기능 제작, 검수  
> 김영철 : 주요기능 제작

## Trouble Shooting
#### 매일 모든 회원의 Todo list 카드를 자동으로 작성 해 주어야 하는데 어떻게 구현?  
> 서버에서 Spring batch를 이용하여 매일 생성해준다. -> 제한된 시간안에 학습하지 못함<br>
> 스케줄러를 이용하여 생성해 준다. -> 첫 회원의 글 생성 방법? <br> 
> 프론트에서 최초 로그인시 GET 요청을 보내면 샘플 카드를 생성해 주기로 함<br>  

#### DB, API를 초기에 명확하게 설계하지 못함
> 프로젝트 중간에 계속 DB정보와 API 설계를 변경하여 진행하는데 어려움이 있었다.
> 기술적인 문제로 구현을 못해서 바꾼 부분도 있지만, 초기에 확실히 할 필요가 있다

#### 백엔드 - 프론트엔드  간 CORS 문제?  
> WebSecurity를 이용하여 CORS 설정 추가
