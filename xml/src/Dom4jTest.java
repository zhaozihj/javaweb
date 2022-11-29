import com.atguigu.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

import static java.lang.Double.parseDouble;

public class Dom4jTest {

    @Test//是指这是一个测试方法，可以不用主方法来调用
    public void test1() throws DocumentException {
        //创建一个SaxReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }


    @Test
    public void test2() throws DocumentException {
        //1.读取books.xml文件
        SAXReader reader= new SAXReader();
        // 2.通过Document对象获取根元素
        //在Junit测试中，相对路径是从模块开始的也就是从xml模块开始的，所以路径中第一个是src
        Document read = reader.read("src/books.xml");
        //3.通过根元素获取book标签对象
        Element element = read.getRootElement();
        //element()和elements()都是通过标签名查找子元素，elements()返回多个，element()返回一个
        List<Element> books = element.elements("book");
        //4.遍历，处理每个book标签转化为Book类
        for(Element book:books){
            //asXML()把标签对象转换为标签字符串
            Element nameElement=book.element("name");
            //getText()获取标签文本内容
            String nameText=nameElement.getText();
            //直接获取指定标签名的文本内容
            String priceText=book.elementText("price");
            String authorText=book.elementText("author");

            //获取属性值
            String snValue=book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText,parseDouble(priceText),authorText));

        }

    }
}