import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MedicalFile} from '../model/medicalFile';
import {environment} from '../../environments/environment';

const URL_MEDICAL = `${environment.apiUrlMedical}`;

@Injectable({
  providedIn: 'root'
})
export class MedicalFileService {


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<MedicalFile[]> {
    return this.http.get<MedicalFile[]>(URL_MEDICAL + '/list');
  }

  save(library): Observable<MedicalFile> {
    return this.http.post<MedicalFile>(URL_MEDICAL + '/create', library);
  }

  findById(id: number): Observable<MedicalFile> {
    return this.http.get<MedicalFile>(URL_MEDICAL + '/' + id);
  }

  updateMedicalFile(id: number, medicalFile: MedicalFile): Observable<MedicalFile> {
    return this.http.patch<MedicalFile>(URL_MEDICAL + '/' + id, medicalFile);
  }

  delete(id: number): Observable<MedicalFile> {
    return this.http.delete<MedicalFile>(`${URL_MEDICAL}/delete/${id}`);
  }

}
