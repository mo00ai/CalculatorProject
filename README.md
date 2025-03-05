<h2>CalculatorProject</h2>
 
- 자바로 구현하는 계산기
- 브랜치로 lv 구분

<br>

<h2>프로젝트 소개</h2>

<br>

📌 프로젝트 개요
이 프로젝트는 자바의 기본 문법과 객체 지향 개념을 익히기 위한 실습 과제로, 두 가지 방식의 계산기를 구현합니다.

<br>

branch
- first : 클래스를 사용하지 않은 계산기 (Lv1)
- second : 클래스를 사용한 계산기 (Lv2)
- third : 도전 기능 구현 계산기 (Lv3)

<br>

first
- Calculator.java
- 정수 계산기

<br>

second
- App.java
  - 숫자, 연산자 기호 입력 및 연산 결과 출력
  - try-catch문으로 입력 숫자와 기호의 예외처리를 담당
  
- Calculator.java
  - Queue<Number> resultList : 결과값 저장 리스트
    - 게터 세터
  - checkingInput() : 기능 1, input 숫자 정수인지 확인하는 메서드
  - checkingOperator() : 기능 2, 올바른 연산 기호를 입력했는지 확인하는 메서드
  - calculate() : 기능 3, 연산하는 메서드
  - printResult() : 기능4, 연산 결과를 출력하는 메서드
  - addResult() : 기능5, 결과값을 리스트에 추가하는 메서드
  - removeResult() : 기능6, 결과값을 리스트에서 삭제하는 메서드
 
  <br>

third
- App.java
  - 숫자, 연산자 기호 입력 및 연산 결과 출력
  - try-catch문으로 입력 숫자와 기호의 예외처리를 담당
  - ArithmeticCalculator의 메서드 호출

- ArithmeticCalculator.java
  - OperatorType operatortype : Enum 클래스 객체 선언
  - Queue<Number> resultList : 결과값 저장 리스트
  - 게터 세터
  - checkingInput() : 기능 1, input 숫자 정수인지 확인하는 메서드
  - checkingOperator() : 기능 2, 올바른 연산 기호를 입력했는지 확인하는 메서드
  - calculate() : 기능 3, 연산하는 메서드
  - printResult() : 기능4, 연산 결과를 출력하는 메서드
  - addResult() : 기능5, 결과값을 리스트에 추가하는 메서드
  - removeResult() : 기능6, 결과값을 리스트에서 삭제하는 메서드
  - printBiggerInput() : 기능7, 입력값보다 큰 결과값 리스트를 출력

- OperatorType.java
  - 사칙연산자 기호를 담은 Enum 클래스
  - contains() : 기능1, 인자값으로 들어온 연산자 기호가 Enum 클래스에 포함되어있는지 확인하는 메서드


<br>


콘솔 화면
```console
첫 번째 숫자를 입력하세요: ]
숫자만 입력해주세요.

첫 번째 숫자를 입력하세요: 1
두 번째 숫자를 입력하세요: 3

입력한 숫자
[1,3]

 + , - , * , / 
기호를 적어주세요: *


[1 * 3 = 3]

더 계산하시겠습니까? (exit 입력 시 종료)
yes

(재실행)
[3]

첫 번째 숫자를 입력하세요: 2.4
3
두 번째 숫자를 입력하세요: 3.5

입력한 숫자
[2.4,3.5]

 + , - , * , / 
기호를 적어주세요: *


[2.4 * 3.5 = 8.4]

더 계산하시겠습니까? (exit 입력 시 종료)

```
  

