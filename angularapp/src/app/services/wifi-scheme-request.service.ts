import { Injectable } from '@angular/core';
import { WifiSchemeRequest } from '../models/wifi-scheme-request.model';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WifiSchemeRequestService {
  public apiUrl = 'https://8080-cfcebdbedeabbbdebbefcafbdaaafdbbeddebecdf.project.examly.io/api/wifiSchemeRequest';
  constructor(private http:HttpClient) { }
  private getAuthHeader(){
    return {
      headers:new HttpHeaders({Authorization: `Bearer ${localStorage.getItem('token')}`})
    };
  }

  getAllWifiSchemeRequests():Observable<WifiSchemeRequest[]>{
    return this.http.get<WifiSchemeRequest[]>(this.apiUrl,this.getAuthHeader());
  }
  getWifiSchemeRequestsById(id:number):Observable<WifiSchemeRequest>{
    return this.http.get<WifiSchemeRequest>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  }
  addWifiSchemeRequest(data:WifiSchemeRequest):Observable<WifiSchemeRequest>{
    return this.http.post<WifiSchemeRequest>(this.apiUrl,data,this.getAuthHeader());
  } 
  updateWifiSchemeRequest(id:number, data:WifiSchemeRequest):Observable<WifiSchemeRequest>{
    return this.http.put<WifiSchemeRequest>(`${this.apiUrl}/${id}`,data, this.getAuthHeader());
  }
  deleteWifiSchemeRequestById(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  } 
}