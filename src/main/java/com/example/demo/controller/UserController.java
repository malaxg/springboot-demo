package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/account") public class UserController {

	@Autowired private UserDao userDao;

	/**
	 * 查询所有的用户
	 * @return
	 */
	@GetMapping("/user") public List<User> user() {
		return userDao.findAll();
	}

	/**
	 * 添加用户
	 * @param name
	 * @param age
	 * @param address
	 * @return
	 */
	@PostMapping("/user") public User addUser(@RequestParam String name, @RequestParam(defaultValue = "18") int age, @RequestParam String address) {
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setAge(age);
		return userDao.save(user);
	}

	/**
	 * 根据ID删除用户
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/{id}") public Response<Object> delete(@PathVariable int id) {
		User one = userDao.getOne(id);
		if (one != null) {
			userDao.deleteById(id);
			return Response.ok("删除成功");
		}
		return Response.ok("删除失败");
	}

	@PutMapping("/user/{id}") public Response<Object> update(@PathVariable int id, @RequestParam String name, @RequestParam String address) {
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setId(id);
		return Response.ok("更新成功", userDao.save(user));
	}
}
