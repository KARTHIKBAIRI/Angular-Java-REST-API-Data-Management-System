import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseurl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  onadd(user: User): Observable<any> {
    return this.http.post<any>(`${this.baseurl}/insertion`, user);
  }

  getalldata(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseurl}/multifetch`);
  }
}
