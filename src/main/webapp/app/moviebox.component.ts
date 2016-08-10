import { Component, Input } from '@angular/core';

export class Movie {
  id: string;
  title: string;
  imageUrl: string;
}

export class MovieBox {
  title: string;
  movies: Movie[];

  constructor(title: string, movies: Movie[]) {
    this.title = title;
    this.movies = movies;
  }
}

@Component({
  selector: 'movie-box',
  template:`
<!-- Box -->
<div class="box">
    <div class="head">
        <h2>{{box.title}}</h2>
        <p class="text-right"><a href="#">See all</a></p>
    </div>
    
    <!-- Movie -->
    <div *ngFor="let movie of box.movies; let last = last" class="movie{{last ? ' last': ''}}">
        <div class="movie-image">
            <a href="#movie{{movie.id}}"><span class="play"><span class="name">{{ movie.title }}</span></span><img src="{{ movie.imageUrl }}" alt="movie" /></a>
        </div>
        <div class="rating">
            <p>RATING</p>
            <div class="stars">
                <div class="stars-in">

                </div>
            </div>
            <span class="comments">12</span>
        </div>
    </div>
    <!-- end Movie -->
    <div class="cl">&nbsp;</div>
</div>
<!-- end Box -->  
  `
})
export class MovieBoxComponent {
  @Input() 
  box: MovieBox;  
}