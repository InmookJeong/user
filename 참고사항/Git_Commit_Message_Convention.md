# Git Commit Message Convention

## 개요
- 많은 프로젝트들이 git을 통해 형상관리를 하고 있습니다.
- 소스코드를 추가, 수정하거나 삭제할 때마다 변경된 이력을 관리하기 위해 커밋 메시지를 작성하게 됩니다.
- 이때 개발자마다 커밋 메시지를 작성하는 형식이 다르면 어떻게 될까요?
- 프로젝트 초기에는 이력이 많지 않기때문에 문제가 되지 않습니다.
- 하지만 시간이 지날수록 수정 이력이 쌓이게 되고 각자의 방식으로 작성된 메시지 내용을 쉽게 이해하기 힘들어집니다.
- 즉 메시지의 가독성이 떨어지고 협업의 효율을 저하시킬 수 있습니다.
- 이러한 문제를 해결하기 위해 '**커밋 메시지의 작성 규칙**'이 필요합니다.
- 커밋 메시지의 구조와 작성 규칙, 그리고 작성을 위한 키워드를 제공함으로써 일관된 메시지 형식을 유지할 수 있고,
- 팀원간의 소통 및 코드 리뷰 등 협업의 효율을 증가시킬 수 있습니다.

## Commit Message 구조
```
[Tag] - [Subject]

[Body]

[Footer]
```
- Tag
    - 어떤 유형의 커밋 메시지를 작성한 것인지 태그를 통해 표현
- Subject
    - Commit message의 제목 작성
    - 제목 입력은 필수 사항
- Body
    - Commit message의 본문 작성
    - 본문 입력은 선택 사항
- Footer
    - Commit message의 꼬리말 작성
    - 꼬리말 입력은 선택 사항

## Commit Message 작성 규칙
- Tag
    - Tag의 종류
        - feat : 새로운 기능 추가
        - fix : 버그 수정
        - docs : 문서 추가 또는 내용 수정
        - style : 코드 포맷 변경, 세미콜론 누락, 코드 변경이 없는 경우
        - refactor : 코드 리팩토링
        - test : 테스트 코드 작성
        - chore : 빌드 수정, 패키지 매너저 설정, 운영 코드 변경이 없는 경우
        - comment : 주석 추가 또는 수정
        - design : CSS 등 사용자 UI 디자인 변경
        - rename : 파일명 또는 폴더명 수정
        - remove : 파일(소스코드 포함) 또는 폴더 삭제
- Subject
    - 제목은 50자 이하로 작성
    - 제목의 첫 글자는 대문자로 작성
    - 마침표나 특수기호 사용 금지
    - 제목은 현재형으로 작성
    - 예시
        ```
        docs - Add git commit message convention document
        ```
    - 첫 글자 예시
        - Add : 소스코드 추가
        - Create : 최초 생성
        - Update : 수정
        - Fix : 소스코드 오류 수정
        - Remove : 삭제
        - Move : 이동
        - Rename : 이름 변경
- Body
    - 무엇을 변경했는지 왜 변경했는지 내용을 상세 작성
    - 한 줄에 72자 이하로 작성
    - 예시
        ```
        docs - Add git commit message convention document

        Add a document containing Git commit message convention.
          - Sub message
        Write a second comment.
        ```
- Footer
    - 이슈트래커 아이디를 작성할 때 사용
    - '유형: #이슈번호' 형식으로 작성
    - 유형 종류
        - Fixes : 수정중인 이슈번호 작성(아직 해결되지 않은 상황)
        - Resolves : 해결한 이슈번호 작성
        - Ref : 참고할 이슈번호 작성
        - Related to : 작성한 커밋에 관련된 이슈번호 작성(아직 해결되지 않은 경우)
    - 예시
        ```
        docs - Add git commit message convention document

        Add a document containing Git commit message convention.
          - Sub message
        Write a second comment.

        Fixes: #22              // 22번 이슈를 수정하고 있는 중
        Resolves: #120          // 120번 이슈 해결
        Ref: #48                // 48번 이슈를 참고해야 함
        Related to: #23, #89    // 현재 커밋과 관련된 이슈는 23번과 89번이 있으며 아직 해결되지 않은 상황
        ```
## 출처 및 참고
- [[Git] Commit Message Convention (협업을 위한 git 커밋컨벤션)](https://velog.io/@msung99/Git-Commit-Message-Convension)
- [Git Commit Message Convention](https://github.com/gyoogle/tech-interview-for-developer/blob/master/ETC/Git%20Commit%20Message%20Convention.md)