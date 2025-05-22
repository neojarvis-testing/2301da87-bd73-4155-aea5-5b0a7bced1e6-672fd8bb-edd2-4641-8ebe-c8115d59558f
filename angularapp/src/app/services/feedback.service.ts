import { Injectable } from '@angular/core';
import { Feedback } from '../models/feedback.model';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  public apiUrl = 'https://8080-cfcebdbedeabbbdebbefcafbdaaafdbbeddebecdf.project.examly.io/api/feedback';
  constructor(private http:HttpClient) { }
  private getAuthHeader(){
    return {
      headers:new HttpHeaders({Authorization: `Bearer ${localStorage.getItem('token')}`})
    };
  }

  getAllFeedback():Observable<Feedback[]>{
    return this.http.get<Feedback[]>(this.apiUrl,this.getAuthHeader());
  }
  getFeedbackById(id:number):Observable<Feedback>{
    return this.http.get<Feedback>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  }
  sendFeedback(data:Feedback):Observable<Feedback>{
    return this.http.post<Feedback>(this.apiUrl,data,this.getAuthHeader());
  } 
  updateFeedback(id:number, data:Feedback):Observable<Feedback>{
    return this.http.put<Feedback>(`${this.apiUrl}/${id}`,data, this.getAuthHeader());
  }
  deleteFeedbackById(id:number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`,this.getAuthHeader());
  } 
}