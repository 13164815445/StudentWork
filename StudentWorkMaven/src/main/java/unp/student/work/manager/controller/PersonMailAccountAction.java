package unp.student.work.manager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import com.sun.mail.smtp.SMTPTransport;

import unp.student.work.manager.domain.PersonMailAccount;
import unp.student.work.manager.domain.PersonPersonInfo;

import unp.student.work.manager.service.PersonMailAccountService;



import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.*;
import javax.servlet.*;


@Component
public class PersonMailAccountAction extends ActionSupport {
	private String studentid;
	private String id;
	private String address;
	private String account;
	private String password;
	private String remark;
	private PersonMailAccount personMailAccount = new PersonMailAccount();
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	
	
	private String from;
	private String to;
	private String subject;
	private String content;
	
	@Resource
	private PersonMailAccountService personMailAccountService;
	
	
	public String add() throws Exception
	{
		personPersonInfo.setStudentid(studentid);  //�����ǻ�ȡ��ǰsession�е��û����Ĵ���
		personMailAccount.setAddress(address);
		personMailAccount.setAccount(account);
		personMailAccount.setPassword(password);
		personMailAccount.setRemark(remark);
		personMailAccount.setPersonPersonInfo(personPersonInfo);
		
		personMailAccountService.save(personMailAccount);
		
		return SUCCESS;
	}

	
	
	public String delete() throws Exception
	{
		personMailAccountService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		personPersonInfo.setStudentid(studentid); 
		personMailAccount.setId(Integer.parseInt(id));
		personMailAccount.setAddress(address);
		personMailAccount.setAccount(account);
		personMailAccount.setPassword(password);
		personMailAccount.setRemark(remark);
		personMailAccount.setPersonPersonInfo(personPersonInfo);
		personMailAccountService.modify(personMailAccount);
		
		return SUCCESS;
	}
	
	public String send() throws Exception
	{
		
		PersonMailAccount personMailAccount = personMailAccountService.getAccount(from);
		final String username = personMailAccount.getAccount();
		final String passwd = personMailAccount.getPassword();
		String host=null;
		String address = personMailAccount.getAddress();
		if(address.contains("@163.com")) host = "smtp.163.com";  //����֧��163.com����
		else if(address.contains("@163.net"))host="smtp.163.net";//����֧��163.net����
		else if(address.contains("@126.com"))host="smtp.126.com";//����֧��126.com����
		else if(address.contains("@qq.com"))host="smtp.qq.com";	 //����֧��qq.com����
		else if(address.contains("@foxmail.com"))host="smtp.exmail.qq.com";  //����֧��foxmail.com����
		else if(address.contains("@yeah.net"))host="smtp.yeah.net";  //����֧��yeah.net����
		else if(address.contains("@sohu.com"))host="smtp.sohu.com";  //����֧��sohu.com����
		else if(address.contains("@sina.com"))host="smtp.sina.com.cn"; //����֧��sina.com����
		
		Properties props = System.getProperties();// ��ȡϵͳ���Զ���
		props.setProperty("mail.smtp.host",host); // ���÷��ŵ�����
		props.setProperty("mail.transport.protocol","smtp");
		props.setProperty("mail.smtp.auth","true"); 
		
		
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
	        protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username,passwd);}});// ��ȡĬ�ϵ�Jspҳ���Session����
		
		try
		{
		   //ֻ�����ı��ʼ��Ĵ��� 
		   MimeMessage message = new MimeMessage(session);// ����MimeMessage���󡾸ö���洢��һ���ʼ����������ݡ���    
		   
		   message.setFrom(new InternetAddress(from)); // ���÷�����
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));// ���ý�����
		   message.setSubject(subject);// �����ʼ�����Subject
		   message.setText(content); //�����ʼ���������
		   message.setSentDate(new Date()); //���÷�������
		   message.saveChanges();
		   
		   Transport.send(message);// ������Ϣ
		   return "success";//��������е�����˵���ʼ����ͳɹ�
		   
		}
		catch(MessagingException mex) 
		{
		   mex.printStackTrace();
		   return "failure";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

	
}
