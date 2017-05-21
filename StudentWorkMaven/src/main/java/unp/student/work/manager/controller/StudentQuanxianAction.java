package unp.student.work.manager.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import unp.student.work.manager.domain.StudentQuanxian;
import unp.student.work.manager.service.StudentQuanXianService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("studentquanxianAction")
@Scope("prototype")
public class StudentQuanxianAction extends ActionSupport implements ModelDriven<StudentQuanxian>,RequestAware,SessionAware{

	private Map<String,Object> session=null;
	private Map<String,Object> request=null;
	private StudentQuanxian studentQuanxian=new StudentQuanxian();
	
	@Resource
	private StudentQuanXianService studentQuanXianService;
	
	private int page;
	private int rows;
	
	private Map<String, Object> pageMap=null;//json��ҳ��Ϣ
	
	private String ids;//����ɾ����id���ӵ��ַ���
	
	private InputStream inputStream;//����ɾ�����
	
	
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	public StudentQuanxian getModel() {
		// TODO Auto-generated method stub
		return studentQuanxian;
	}
	
	//��ȡѧ��Ȩ����Ϣ
	public String query(){
		pageMap=new HashMap<String, Object>();
		List<StudentQuanxian> studentQuanxians=studentQuanXianService.query(studentQuanxian.getStudentid(), page, rows);
		pageMap.put("rows", studentQuanxians);
		
		Long total=studentQuanXianService.findCount();
		
		pageMap.put("total", total);
		
		return "jsonMap";
	}

	public void save(){
		
		studentQuanXianService.save(studentQuanxian);
	}
	
	public void update(){
		
		studentQuanXianService.update(studentQuanxian);
	}
	
	public String deleteByIds() {
		studentQuanXianService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
}
