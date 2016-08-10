import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from './user.service';

@Component({
  selector: 'login',
  template: `
  <form action="#" class="login" (submit)="onSubmit(username.value, password.value)">
    <input type="text" #username id="username" placeholder="Username" name="username" class="field" />
    <input type="password" #password id="password" placeholder="Password" name="password" class="field" />
    <button type="submit">Login</button>
  </form>
  `
})
export class LoginComponent {
  constructor(private userService: UserService, private router: Router) {}

  onSubmit(username, password) {
    this.userService.login(username, password).subscribe((result) => {
      if (result) {
        this.router.navigate(['']);
      }
    });
  }
}