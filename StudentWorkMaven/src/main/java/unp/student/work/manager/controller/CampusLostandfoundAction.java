package unp.student.work.manager.controller;

import java.util.Date;


import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.CampusLostandfoundDao;
import unp.student.work.manager.domain.Lostandfound;
import unp.student.work.manager.service.CampusLostandfoundService;
import unp.student.work.manager.service.impl.CampusLostandfoundServiceImpl;
import unp.student.work.manager.utils.PageBean;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller
@Scope("prototype")
public class CampusLostandfoundAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private Lostandfound lostandfound;
	private List lostandfounds;
	private PageBean pageBean;
	//Ĭ��װ�䷽ʽΪbyType, Ҫȷ�������͵�beanΨһ
	@Autowired
	private CampusLostandfoundService  lostandfoundService;
    /**
     * �����������ύ����
     */
	public String add(){
		
		lostandfound.setReleasedate(new Date());
		
		System.out.println(lostandfound.toString());
		
		lostandfoundService.save(lostandfound);
		return SUCCESS;
	}
	
	 /**
     * �����ҳ��ʾ��������
     */
	public String show(){
		pageBean=lostandfoundService.findByPage(pageNo, 10);
		return "showLostandfounds";
	}
	
	 /**
     * ������ʾ����ҳ������
     */
	public String update(){
		lostandfound=lostandfoundService.findById(id);
		return "update";
	}

	/**
     * �����������Ϣ����
     */
	public String save(){
		lostandfoundService.update(lostandfound);
		return SUCCESS;
	}
	/**
     * ����ɾ��ҳ������
     */
	public String delete(){
		lostandfoundService.deleteById(id);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lostandfound getLostandfound() {
		return lostandfound;
	}

	public void setLostandfound(Lostandfound lostandfound) {
		this.lostandfound = lostandfound;
	}

	public List getLostandfounds() {
		return lostandfounds;
	}

	public void setLostandfounds(List lostandfounds) {
		this.lostandfounds = lostandfounds;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}

