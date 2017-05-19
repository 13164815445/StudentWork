package unp.student.work.manager.service.impl;

import static org.junit.Assert.*;

import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.service.CounsellorService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class CounsellorServiceImplTest {

	@Resource
	private CounsellorService counsellorService;
	@Test
	public void testFindCounsellorByStudent() {
		counsellorService.findCounsellorByStudent("221400405");
	}
	
	@Test
	public void testfindProplem() {
		//System.out.println(this.getClass().getClassLoader().getResource("/").getPath());
		System.out.println(getClass().getClassLoader().getResource(""));
		counsellorService.findProblem();
		File directory = new File("");//�趨Ϊ��ǰ�ļ���
		try{
		    System.out.println(directory.getCanonicalPath());//��ȡ��׼��·��
		    System.out.println(directory.getAbsolutePath());//��ȡ����·��
		}catch(Exception e){} 
	}
	
	@Test
	public void testfindResult(){

		counsellorService.findResult("221400405", 1);
		
	}
	@Test
	public void testaddRecord(){
		//counsellorService.findResult("221400401", 1);
		
	}
}
