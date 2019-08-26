import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

	users: User[] = [];

	constructor(private route: ActivatedRoute, private userService: UserService) { }

	ngOnInit() {
		this.getUsers();
	}

	getUsers(): void {
		this.userService.getUsers().subscribe(users => this.users = users);
	}
  
	delete(user: User): void {
		this.userService.deleteUser(user).subscribe(success=> {this.getUsers();});		
	}


}
