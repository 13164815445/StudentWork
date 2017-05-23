package unp.student.work.manager.controller;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PersonAuth extends AbstractInterceptor  //Ȩ�޼���������̳�AbstractInterceptor��
{
    public String intercept(ActionInvocation invocation)throws Exception
	{
		ActionContext ctx = invocation.getInvocationContext();  //ͨ��ActionInvocationȡ�õ�ǰ�����ActionContextʵ��
		Map<String, Object> session = ctx.getSession();
		String studentid = (String)session.get("studentid");  //ȡ��session������Ϊstudentid��ֵ
		if(studentid == null)  //���Ϊ�գ��򷵻�failure ��ת����½����
		{
			//System.out.println("�������з���user==null");
			return "failure";
		}
		else	//�����Ϊ�գ�����У�����UserAction��֤username
		{
			//System.out.println("�������з���studentid��Ϊ�գ�����������");
			return invocation.invoke();  //����
		}		
    }
}