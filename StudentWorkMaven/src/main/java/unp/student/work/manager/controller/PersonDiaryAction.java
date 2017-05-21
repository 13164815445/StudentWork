package unp.student.work.manager.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonDiary;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonDiaryService;


@Component
public class PersonDiaryAction extends ActionSupport {
	private String id;
	private String name;
	private String content;  //����˵������String��Ӧ���ݿ��text

	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private PersonDiary personDiary = new PersonDiary();
	
	@Resource
	private PersonDiaryService personDiaryService;

	public String add() throws Exception
	{
		Date d = new Date();
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		
		personDiary.setName(name);
		personDiary.setContent(content);
		personDiary.setCreatetime(d);
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personDiary.setPersonPersonInfo(personPersonInfo);
		
		
		personDiaryService.save(personDiary);
		
		return SUCCESS;
	}


	
	
	public String delete() throws Exception
	{
		personDiaryService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		Date d = new Date();
		personDiary.setId(Integer.parseInt(id));
		personDiary.setName(name);
		personDiary.setContent(content);
		personDiary.setCreatetime(d);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //�õ�session��Map��ʽ
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personDiary.setPersonPersonInfo(personPersonInfo);
		
		personDiaryService.modify(personDiary);
		
		return SUCCESS;
	}
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	
}
