import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  fg!: FormGroup;
  users: User[] = [];
  showUsers: boolean = false; // Flag to control display of registered users

  constructor(private service: UserService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.fg = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  postData(): void {
    const posting: User = { ...this.fg.value };
    this.service.onadd(posting).subscribe(() => {
      this.resetForm();
    });
  }

  getalldata(): void {
    this.service.getalldata().subscribe((data: User[]) => {
      this.users = data;
    });
  }

  resetForm(): void {
    this.fg.reset();
  }

  toggleUsersList(): void {
    this.showUsers = !this.showUsers;
    if (this.showUsers) {
      this.getalldata();
    } else {
      this.users = [];
    }
  }
}
