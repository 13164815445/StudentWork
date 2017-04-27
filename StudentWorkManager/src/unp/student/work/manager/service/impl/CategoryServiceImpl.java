package unp.student.work.manager.service.impl;



import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import unp.student.work.manager.model.Category;
import unp.student.work.manager.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource
	 private SessionFactory sessionFactory;
	
	 protected Session getSession() {  
	        //�ӵ�ǰ�̻߳�ȡsession�����û���򴴽�һ���µ�session  
	        return sessionFactory.getCurrentSession();  
	    } 
	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
       getSession().save(category);
	}

}
