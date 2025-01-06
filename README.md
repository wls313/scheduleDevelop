## 프로젝트 계획 이유
내일배움캠프의 과제 전에 만들었던 schedule를 develop 하는것이 과제로 나와서 만들게 됐다.

#### 기능설명
### 1.Member
  create

  
    member을 생성하는 기능.
    생성시 body에 password를 제외한 나머지 값들을 보여줍니다.
    
  read

  
    member을 보여주는 기능.
    userId를 통해 볼수있는것과 전부다 보는 2가지가 가능합니다.

  update

  
    member의 정보를 업데이트하는 기능
    memberName 과 email만 변경 가능하며 변경할때 빈값을 보낼경우 원래값으로 유지됩니다.
    
  delete

  
    memeber의 정보를 삭제하는 기능
    member의 정보를 삭제하더라도 schedule에는 정보가 남아있습니다.
    
  
### 2.schedule
  create

  
    schedule을 생성하는기능.
    생성시 body에 생성한 값들을 보여줍니다.
    
  read

  
    writer의 값을 통해 그 writer가 만든 모든 스케줄을 보여주는것까지만 구현해놨습니다.
    
  update

  
    schedule을 업데이트하는 기능
    title과 contents만 변경 가능하며 빈값을 보낼경우 원래 값으로 유지됩니다.
  
  delete
    스케줄을 삭제합니다.  

    
### 3.login
   로그인기능
   
     생성되어있는 memebeId와 password를 통해 로그인할경우 memberId가 cookie 에 저장되며 session을 통해 로그인 가능합니다.
     
     로그인 하지않을경우 회원가입을 제외한 다른 행동은 불가능합니다.
