import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MovieBox, MovieBoxComponent } from './moviebox.component';

import { UserService } from './user.service';
import { MovieService } from './movie.service';
import { RecommendationService } from './recommendation.service';

const MOVIE_LISTS = ["Comedy", "Adventure", "Crime", "Drama"];

@Component({
  selector: 'movie-boxes',
  template: `
    <div><a href="" (click)="logout()">Logout</a></div>
    <template ngFor let-box [ngForOf]="boxes">
      <movie-box [box]="box"></movie-box>      
    </template>    
  `,
  directives: [ MovieBoxComponent ],
  providers: [ MovieService, RecommendationService ]
})
export class HomeComponent implements OnInit {
  boxes: MovieBox[];

  constructor(private userService: UserService,
              private movieService: MovieService, 
              private recommendationService: RecommendationService,
              private router: Router) {
  }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    var that = this;
    
    var promises = [];
    promises.push(this.recommendationService.getRecommendations("me").catch((error) => Promise.resolve([])));
    MOVIE_LISTS.forEach(list => {
      promises.push(that.movieService.getMovies(list, 6).catch((error) => Promise.resolve([])))  
    });

    Promise.all(promises)
    .then(lists => {
      var result = [];
      result.push(new MovieBox("RECOMMENDED", lists[0]));

      for (var i = 0; i < MOVIE_LISTS.length; i++) {
        result.push(new MovieBox(MOVIE_LISTS[i].toUpperCase(), lists[i + 1]));
      }
      that.boxes = result;
    });
  }

  logout() {    
    this.userService.logout();
    this.router.navigate(['login']);
    return false;
  }    
}