package unp.student.work.manager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.DormInfo;
import unp.student.work.manager.service.DormInfoService;
import unp.student.work.manager.utils.PageBean;

@Controller
@Scope("prototype")
public class DormInfoManageAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private DormInfo dorminfo;
	private List drominfos;
	private PageBean pageBean;
	
	@Autowired
	private DormInfoService  dorminfoService;
	
	public String add(){
		//Fund fund=new Fund(0, fundName, fundDes, fundPrice, fundStatus, new Date());
		
		dorminfoService.save(dorminfo);
		return SUCCESS;
	}
	
	 /**
     * �����ҳ��ʾ��������
     */
	public String show(){
		pageBean=dorminfoService.findByPage(pageNo, 10);
		return "showDorms";
	}
	
	 /**
     * ������ʾ���»���ҳ������
     */
	public String update(){
		dorminfo=dorminfoService.findById(id);
		return "update";
	}

	/**
     * ��������»�����Ϣ����
     */
	public String save(){
		dorminfoService.update(dorminfo);
		return SUCCESS;
	}
	/**
     * ����ɾ������ҳ������
     */
	public String delete(){
		dorminfoService.deleteById(id);
		return SUCCESS;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public DormInfo getDorminfo() {
		return dorminfo;
	}
	public void setDorminfo(DormInfo dorminfo) {
		this.dorminfo = dorminfo;
	}
	public List getDrominfos() {
		return drominfos;
	}
	public void setDrominfos(List drominfos) {
		this.drominfos = drominfos;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
}
