// import {Injectable} from 'angular2/core';
// import {Http, URLSearchParams} from 'angular2/http';
// import 'rxjs/add/operator/map';

// @Injectable()
// export class Notes {
// 	constructor(private http: Http){}
	
// 	getPatientsList(org:string){
// 		return this.makeRequest(`/doctors/${doctor_id}/patients`);
// 	}
	
// 	getPatientNotes(org:string){
// 		return this.makeRequest(`/patients/${patient_id}/notes/${note_id}`);
// 	}
	
// 	getDoctorsNote(org:string, repo:string){
// 		return this.makeRequest(`/doctors/${doctor_id}/patients/${patient_id}/notes/${note_id}`);
// 	}
// 	createDoctorsNote(org:string, repo:string){
// 		return this.makeRequest(`/doctors/${doctor_id}/patients/${patient_id}/notes/`);
// 	}
// 	private postRequest(path: string){
// 		let params = new 
// 	}
	
// 	private makeRequest(path: string){
// 		let params = new URLSearchParams();
// 		params.set('per_page', '100');
// 		let url = `https://api.github.com/${path}`;
// 		return this.http.get(url, {search: params})
// 			.map((res) => res.json());
// 	}
// }