import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MedicalFile} from '../model/medicalFile';

const URL_PATIENT = `${environment.apiUrlPatient}`;

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<MedicalFile[]> {
    return this.http.get<MedicalFile[]>(URL_PATIENT + '/list');
  }
}
