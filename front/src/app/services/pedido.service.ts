import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { throwError } from 'rxjs/internal/observable/throwError';
import { ItensPedido } from '../models/ItensPedido';
import { PedidoIdResponse } from '../models/PedidoIdResponse';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private readonly apiUrl = "http://localhost:8080/api/v1/pedido"

  constructor(private http: HttpClient) { }

  create(itensPedidos: ItensPedido): Observable<PedidoIdResponse> {
    return this.http.post<PedidoIdResponse>(this.apiUrl, itensPedidos).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }
}
