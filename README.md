# makeVoca


영어 문장을 넣으면 자동으로 단어장을 만들어 주는 프로그램입니다.



설치방법

1. eclipse - file - import - project from git - clone uri - uri:https://github.com/ghanIn/makeVoca.git - import existing eclipse projects

2. DB (MariaDB)
	
	CREATE TABLE VOCA(

	VOCA VARCHAR (80), // 단
	MEAN VARCHAR (100) // 

	);

3. applicationContext.xml 에서 본인의 데이터베이스로 설정변경


추가할 기능

- 단어 빈도수 보여주기
- 단어장 카드 모양 (slide기능)
- 정렬

문제점

- 속도
