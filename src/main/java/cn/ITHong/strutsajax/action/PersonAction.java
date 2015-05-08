package cn.ITHong.strutsajax.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ITHong.strutsajax.dao.PersonDao;
import cn.ITHong.strutsajax.domain.Person;


public class PersonAction extends ActionSupport{
	private List<Person> pList ;
	private Person person ;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getpList() {
		return pList;
	}

	public void setpList(List<Person> pList) {
		this.pList = pList;
	}
	public String showPerson(){
		PersonDao pDao = new PersonDao();
		pList =  pDao.getAllPerson();
		ActionContext.getContext().put("pList", pList);
		return SUCCESS;
	}
	public String deletePerson(){
		PersonDao dao = new PersonDao();
		String pid = ServletActionContext.getRequest().getParameter("pid");
		dao.deletePerson(Long.parseLong(pid));
		return SUCCESS;
	}
	public String updatePerson(){
		PersonDao dao = new PersonDao();
		
		String pid = ServletActionContext.getRequest().getParameter("pid");
		String pname = ServletActionContext.getRequest().getParameter("pname");
		String psex = ServletActionContext.getRequest().getParameter("psex");
		
		Person person = dao.getPersonById(Long.parseLong(pid));
		
		if(pname!=null&&!pname.equals(""))
		person.setPname(pname);
		if(psex!=null&&!psex.equals(""))
		person.setPsex(psex);
		dao.updatePerson(person);
		return pid;
	}
}
