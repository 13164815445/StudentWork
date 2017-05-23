package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.late_person;

public interface WorkLatePersonDao extends BaseDao<late_person> {
	
	//��ҳ��Ȩ�޲���
	public List findPageByStudent(String studentid,int pageno);//ѧ���������߼�¼
	public List findPageByManager(String studentid,int pageno);//����Ա���б�����δ������ļ�¼
	
	//��ҳ�������Ϣ
	public List findPageByLateInfo(int lateinfoid,int pageno);//����δ��ͬ�⴦��ļ�¼

	//��¼��
	//��ҳ��Ȩ�޲���
		public long findCountByStudent(String studentid);//ѧ���������߼�¼
		public long findCountByManager(String studentid);//����Ա���б�����δ������ļ�¼
		
		//��ҳ�������Ϣ
		public long findCountByLateInfo(int lateinfoid);//����δ��ͬ�⴦��ļ�¼
	
}
