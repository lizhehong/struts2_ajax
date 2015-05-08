package cn.ITHong.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.ITHong.strutsajax.dao.PersonDao;
import cn.ITHong.strutsajax.domain.Person;

public class PersonDaoTest {

	@Test
	/**
	 * 利用hibernate创建表了
	 * */
	public void test() {
		PersonDao dao = new PersonDao();
		dao.createPerson();
	}
	@Test
	/**
	 * 利用hibernate能读取数据
	 * */
	public void test2(){
		PersonDao dao = new PersonDao();
		List<Person> plList = dao.getAllPerson();
		for(Person person:plList){
			System.out.println(person.getPname());
		}
	}

}
