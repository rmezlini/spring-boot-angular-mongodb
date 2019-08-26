package com.spring.boot.angular.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.angular.test.service.UserService;
import com.spring.boot.angular.test.vo.UserVo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    @Autowired
    private UserService service;
 
    @GetMapping("/user/{id}")
	public ResponseEntity<UserVo> getUser(@PathVariable String id) {
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserVo>> getUserList() {
		return new ResponseEntity<>(service.getUserList(), HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody UserVo UserVo) {
		service.saveUser(UserVo);
		return new ResponseEntity<>("New user successfully saved", HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<String> updateUser(@RequestBody UserVo UserVo) {
		service.updateUser(UserVo);
		return new ResponseEntity<>("User successfully updated", HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUser(@RequestBody UserVo userVo) {
		service.deleteUser(userVo);
		return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
	}

}
