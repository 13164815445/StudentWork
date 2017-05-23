package unp.student.work.manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_student")
public class GStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer groupId;//���ű��
	private Integer id;//���ų�Ա�����������
	private String job;//ѧ��ְ��
	private String stuno;//ѧ��
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public GStudent(){
		super();
	}
	public GStudent(Integer id,Integer groupId,String job,String stuno){
		super();
		this.id = id;
		this.groupId = groupId;
		this.job = job;
		this.stuno = stuno;
	}
}
