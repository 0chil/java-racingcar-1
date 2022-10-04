# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 3단계 - 자동차 경주
- 자동차
  - [x] 자동차는 값이 이동가능하면 전진한다
  - [x] 자동차는 값이 이동불가능하면 머무른다
  - [x] 차는 위치를 반환할 수 있다
  - [x] 이름이 있는 차를 생성한다
  - [ ] 이름은 1자 이상이다
  - [ ] 이름은 5자 이하다
  - [ ] 이름은 공백일 수 없다
- 자동차 이동가능 판단
  - [x] 생성된 값이 4 이상이면 전진할 수 있다
- 수 생성
  - [x] 랜덤값을 생성한다
- 자동차 컬렉션
  - [ ] 이름들로 자동차들을 생성한다
  - [x] 주어진 대수만큼 자동차를 생성한다
  - [x] 자동차들은 전진/멈출 수 있다
  - [x] 자동차들은 n번 움직일 수 있다
  - [x] 차들의 위치를 반환할 수 있다
  - [ ] 우승자(들)을 반환한다
- 입/출력
  - [x] 자동차 대수, 시도 횟수 입력
    - [x] 숫자만 입력받아야 한다
  - [x] 결과 출력
  - [x] 결과는 모아서 한번에 출력한다
  - [ ] 이름을 쉼표 기준으로 구분하여 입력
  - [ ] 결과에 자동차 이름을 함께 출력한다
  - [ ] 결과에 우승자를 출력한다
- 게임 진행
  - [x] 입력 받은 자동차 대수만큼 생성하도록 명령한다
  - [x] 입력 받은 시도 횟수만큼 시도하도록 명령한다