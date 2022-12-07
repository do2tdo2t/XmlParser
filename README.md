# XmlParser
1. XmlParser
 - 설명: Xml 전문을 읽어 들여 Map<String,Object> 형태로 저장하는 전역 클래스. 배열이 전달되는 경우 ArrayList<String> 형으로 저장
 - parseXmlToMap(String content): xml 전문을 읽어서 Map<String,Object>로 return
 
2. VO Map<String,Object>
 - 설명: Map<String,Object> 형태의 객체를 VO로 전환하는 JavaBean VO Class에 상속될 추상 클래스
 - Abstarct Class
 - mapToVO(Map<String,Object>): Map의 key는 모두 대문자, 구분자를 _로 사용. VO class의 멤버필드는 카멜표기법을 따르되 Map의 key와 명명규칙을 따라야 함. 멤버필드를 Key 값으로 사용하기 위해 Vo의 convertFieldNameTokey(String fieldName) 을 사용함
 
