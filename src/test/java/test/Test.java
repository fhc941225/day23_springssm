package test;

import com.alibaba.fastjson.JSONObject;
import com.fhc.model.Product;
import com.fhc.service.IProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test {
    @Autowired
    IProductService service;
    @org.junit.Test
    public void test(){
        JSONObject json=new JSONObject();
        json.put("offset", 0);
        json.put("limit", 10);
        json.put("search", "金枕头");
        JSONObject findByPage = service.findByPage(json);
        System.out.println(findByPage.get("total"));
        List<Product> products =  (List<Product>) findByPage.get("rows");
        for(Product pro: products){
            System.out.println(pro.getPname());
            System.out.println(pro.getPdate());
        }
    }
    @org.junit.Test
    public void test2(){
        service.removeById(164);
    }
    @org.junit.Test
    public void test3(){
        Product product=new Product();
        product.setPname("bbbbbbb");
        product.setPid(163);
        service.modify(product);
    }
    @org.junit.Test
    public void test4(){
        Product product=new Product();
        product.setPname("xxxxxxx");
        product.setPid(164);
        service.save(product);
    }

}