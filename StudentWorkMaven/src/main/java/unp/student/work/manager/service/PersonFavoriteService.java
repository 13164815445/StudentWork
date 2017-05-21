package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonFavorite;
import unp.student.work.manager.domain.PersonLifeAccount;

@Component
public class PersonFavoriteService  //����������ʹ�õ�ʱ��SessionUtil�Ķ��������Springע�����ɣ�������Լ�new��������ô�õ���sessionFactory��null��
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonFavorite personFavorite)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personFavorite);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonFavorite where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonFavorite personFavorite)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personFavorite); 
	}
	
}
