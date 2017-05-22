package unp.student.work.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.DormRecord;
import unp.student.work.manager.service.DormRecordService;
import unp.student.work.manager.utils.PageBean;
@Controller
@Scope("prototype")
public class DormRecordManageAction extends ActionSupport {
	
	private Integer id;
	private Integer pageNo=1;
	private DormRecord dormrecord;
	private List dormrecords;
	private PageBean pageBean;
	
	@Autowired
	private DormRecordService dormrecordService;
	
	public String add(){
		//Fund fund=new Fund(0, fundName, fundDes, fundPrice, fundStatus, new Date());
		
		dormrecordService.save(dormrecord);
		return SUCCESS;
	}
	
	 /**
     * �����ҳ��ʾ��������
     */
	public String show(){
		pageBean=dormrecordService.findByPage(pageNo, 10);
		return "showRecords";
	}
	
	 /**
     * ������ʾ���»���ҳ������
     */
	public String update(){
		dormrecord=dormrecordService.findById(id);
		return "update";
	}

	/**
     * ��������»�����Ϣ����
     */
	public String save(){
		dormrecordService.update(dormrecord);
		return SUCCESS;
	}
	/**
     * ����ɾ������ҳ������
     */
	public String delete(){
		dormrecordService.deleteById(id);
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
	public DormRecord getDormrecord() {
		return dormrecord;
	}
	public void setDormrecord(DormRecord dormrecord) {
		this.dormrecord = dormrecord;
	}
	public List getDormrecords() {
		return dormrecords;
	}
	public void setDormrecords(List dormrecords) {
		this.dormrecords = dormrecords;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	

}
