import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @Description TODO(����Spring��ע����ԣ�����֧��Spring3.1������) 
 * @author Ni Shengwu 
 * 
 */  
/* 
 * Spring3.1����˸�spring-test-4.2.4.RELEASE.jar�������jar��ר������֧��JUnit����ע��Ĳ��Եģ���jar����spring-4.2.4-core�� 
 * ��jar�����и�SpringJUnit4ClassRunner.class����@RunWithע��ӽ������� 
 *  
 * ע��@ContextConfiguration��ʾ��ApplicationContext����ע��������Ͳ��������������ڲ��Գ�������new�ˣ�ֱ��ʹ�� 
 */  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")  
public class SSHtest {  
      
    @Resource  
    private Date date;  
      
    @Test //����Spring IOC�Ŀ�������  
    public void springIoc() {  
        System.out.println(date);  
    }  
} 