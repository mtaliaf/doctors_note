import {Injectable} from 'angular2/core';
import {Http, URLSearchParams} from 'angular2/http';
import 'rxjs/add/operator/map';

@Injectable()
export class Notes {
	constructor(private http: Http){}
	
	getPatientsList(org:string){
		return this.makeRequest(`orgs/${org}`);
	}
	
	getPatientNotes(org:string){
		return this.makeRequest(`orgs/${org}/repos`);
	}
	
	getDoctorsNote(org:string, repo:string){
		return this.makeRequest(`repos/${org}/${repo}`);
	}
	
	private makeRequest(path: string){
		let params = new URLSearchParams();
		params.set('per_page', '100');
		let url = `https://api.github.com/${path}`;
		return this.http.get(url, {search: params})
			.map((res) => res.json());
	}
}