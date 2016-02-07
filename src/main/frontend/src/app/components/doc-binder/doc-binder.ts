import {Component} from 'angular2/core';
import {Http} from 'angular2/http';


@Component({
  selector: 'doc-binder',
  templateUrl: 'app/components/doc-binder/doc-binder.html',
  styleUrls: ['app/components/doc-binder/doc-binder.css'],
  providers: [],
  directives: [],
  pipes: []
})
export class DocBinder {
	
  	constructor(
  		public id: number,
	    public name: string,
	    public note: string
	) {

  	}
}