package ex.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XmlParserUtil {
	
	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;
	
	public void XmlParserUtil()
	{
		
	}
	
	/**
	 * xml 텍스트를 파싱하여 map 형태로 return
	 * **/
	public static Map<String,Object> parseXmlToMap(String content) throws Exception
	{
		
		factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		
		builder = factory.newDocumentBuilder();
		
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(content));
		
        Document doc = builder.parse(is);
        Element element = doc.getDocumentElement();
        
        Map<String, Object> map = new HashMap<String,Object>();
        for(int i = 0 ; i < element.getChildNodes().getLength() ; i++)
        {
        	parse(element.getTagName(), element.getChildNodes().item(i),map);
        }
        return map;
	}
	
	private static void parse(String tagname, Node node, Map<String,Object> map) throws Exception
	{
		if(node.getNodeType()==Node.TEXT_NODE)
		{
			//이미 tag가 map에 존재하는 경우는 배열형태로 담는다.
			if(map.containsKey(tagname))
			{	
				if("ArrayList".equals(map.get(tagname).getClass().getSimpleName())) 
				{
					ArrayList<String> list = (ArrayList<String>) map.get(tagname);
					list.add(node.getTextContent());
					map.put(tagname, list);
				}
				else if("String".equals(map.get(tagname).getClass().getSimpleName()))
				{
					ArrayList<String> list = new ArrayList<String>();
					list.add((String)map.get(tagname));
					list.add(node.getTextContent());
					map.put(tagname, list);
				}
			}
			else
			{
				map.put(tagname, node.getTextContent());
			}
			return;
		}
		else if(node.getNodeType() == Node.ELEMENT_NODE)
		{
			//tag만 존재하고 text 값이 없는 경우(null)인 경우 빈칸인식을 위해 강제로 값을 넣는다. None등의 값으로 대체해도 됨
			if(node.getChildNodes().getLength() == 0)
			{
				node.setTextContent(" ");
			}
			for(int i = 0 ; i < node.getChildNodes().getLength() ; i++)
			{
				parse(((Element)node).getTagName() , node.getChildNodes().item(i), map);
			}
		}
		
	}

}
