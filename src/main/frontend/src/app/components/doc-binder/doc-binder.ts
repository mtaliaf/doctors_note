import {Component} from 'angular2/core';
import {DocNote} from './doc-note'


@Component({
  selector: 'doc-binder',
  templateUrl: 'app/components/doc-binder/doc-binder.html',
  styleUrls: ['app/components/doc-binder/doc-binder.css'],
  providers: [],
  directives: [],
  pipes: []
})
export class DocBinder {
  patient = new DocNote(1, 'John Smith', 'Doing Great');
  submitted = false;
  onSubmit() { this.submitted = true; }
  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
}