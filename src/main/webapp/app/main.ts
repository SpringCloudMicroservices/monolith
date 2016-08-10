import { bootstrap }    from '@angular/platform-browser-dynamic';
import { HTTP_PROVIDERS } from '@angular/http';

import { AppComponent } from './app.component';
import { UserService } from './user.service';
import { AuthGuard } from './auth.guard';
import { APP_ROUTES_PROVIDER } from './app.routes';

bootstrap(AppComponent, [
    UserService,
    AuthGuard,
    APP_ROUTES_PROVIDER,
    HTTP_PROVIDERS
]);