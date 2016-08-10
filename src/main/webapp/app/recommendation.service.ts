import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Movie } from './moviebox.component';

@Injectable()
export class RecommendationService {
    private apiUrl = '/api/recommendations/';
    constructor(private http: Http) { }

    getRecommendations(user: string) {
        let headers = new Headers();
        headers.append('Authorization', 'Bearer ' + localStorage.getItem('auth_token'));

        return this.http.get(this.apiUrl + user + '?limit=6', { headers })
               .toPromise()
               .then(response => response.json() as Movie[])
               .catch(this.handleError);
    }

    handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}