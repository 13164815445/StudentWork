package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_info")

public class Group{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //����������id
	private String name; //��������
	private String res; //���Ÿ�����
	private String description; //���ŵ�����
	private Date createTime; //��Ӹ���Ϣ��ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", desription=" + description + ", res=" + res + ", createTime=" + createTime
				+ "]";
	}
	public Group(Integer id, String name, String description, String res, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.res = res;
		this.createTime = createTime;
	}
	public Group(){
		super();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}