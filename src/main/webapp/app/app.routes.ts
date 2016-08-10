import { provideRouter } from '@angular/router';

import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home.component';
import { LoginComponent } from './login.component';

export const routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent }
];

export const APP_ROUTES_PROVIDER = provideRouter(routes);