import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
const API_URL = 'http://localhost:3000/notification';
class Notifications {
}

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) {
  }
  findAll(): Observable<Notifications[]> {
    return this.http.get<Notifications[]>(API_URL);
  }

  save(notification): Observable<Notifications> {
    return this.http.post<Notifications>(API_URL, notification);
  }

}
