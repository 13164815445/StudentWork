package unp.student.work.manager.dao;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonMailAccount;

@Component
public class PersonMailAccountDao
{

	@Resource
	private SessionFactory sessionFactory;

	public PersonMailAccountDao()  
	{
		//getCurrentSession���ܷŵ����췽���У� 
	}
	
	public List<PersonMailAccount> getAccounts(String studentid)  //����ָ��studentid��ø��û������������˺�
	{

		Session s = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked") //���߱���������ָ���ľ��棬���û����һ�䣬�������ᾯ��funds��unchecked��
		List<PersonMailAccount> personMailAccounts = s.createQuery("from PersonMailAccount where studentid=?").setParameter(0, studentid).list();
			
		return personMailAccounts;	
	
	}
	
	public PersonMailAccount getAccount(String address)
	{
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from PersonMailAccount where address = ?").setParameter(0, address);
		return (PersonMailAccount)q.uniqueResult();
	}
	
	
	
}