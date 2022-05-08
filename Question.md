# Questions
해당 문서는 RESTHotel을 설계하는 과정에서 발생하는 궁금증과 그에 알맞은 답을 정리한 문서.

---
#### 1. Room Status로 무엇을 정의해야 하는가?
* Check In
* Check Out
* Leaving
* Cleaning
    * Cleaning의 Status를 나눌 필요가 있는가?(Before, Current, After)
  

#### 2. Resource의 CRUD 외의 API 요청들은 어떤 HTTP Method를 사용해야 하는가?
* Check In, Out API
  * Room Status를 변경하는 API이기 때문에 Patch를 써야 하는가?  
    -> Patch를 사용하는 쪽이 조금 더 명확하고, 바뀌는 상태 정보는 Body에 포함시켜 요청한다.  
    [참고 : Rest uri design for changing the status for resource](https://stackoverflow.com/questions/18233632/rest-uri-design-for-changing-the-status-for-resource)
* Room Service API
  * 음식을 주문하는 요청은 결국 주문과 비슷한 개념이기 때문에 POST를 사용한다.
* Cleaning Service API
  * 방 청소에 대한 요청 또한 청소라는 주문이 새로 생성된 것이기 때문에 POST를 사용한다.
* ETC...

