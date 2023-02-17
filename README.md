<img src="https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=header&text=XmlParser자바구현 &fontSize=90" />
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />

# XmlParser
1. [/src/ex/util/XmlParserUtil.java](https://github.com/do2tdo2t/XmlParser/blob/master/src/ex/util/XmlParserUtil.java)
 * 설명: Xml 전문을 읽어 들여 Map<String,Object> 형태로 저장하는 전역 클래스. 배열이 전달되는 경우 ArrayList<String> 형으로 저장
 * 멤버함수: parseXmlToMap
   * 반환값: Map<String,Object>, key-value
   * 파라미터: String content - xml 전문
 
2. [/src/ex/util/VO.java](https://github.com/do2tdo2t/XmlParser/blob/master/src/ex/util/VO.java)
 * 설명: Map<String,Object> 형태의 객체를 VO로 전환하는 JavaBean VO Class에 상속될 추상 클래스
 * 멤버필드: 카멜표기법(Camel Case)으로 작성
 * 멤버함수: mapToVO
   * 파라미터: Map<String,Object>
   * 반환값: X
 * 멤버함수: convertFieldNameTokey
   * 설명: Xml전문의 Key를 VO의 멤버필드명으로 변경(대문자 [스네이크 표기법](https://ko.wikipedia.org/wiki/%EC%8A%A4%EB%84%A4%EC%9D%B4%ED%81%AC_%ED%91%9C%EA%B8%B0%EB%B2%95) -> [카멜 표기법](https://ko.wikipedia.org/wiki/%EC%B9%B4%EB%A9%9C_%ED%91%9C%EA%B8%B0%EB%B2%95), 예시_ USER_NAME -> userName )
   * 파라미터: String
   * 반환값: String
  
