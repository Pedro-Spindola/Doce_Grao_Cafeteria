import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, catchError, forkJoin, Observable } from 'rxjs';
import { throwError } from 'rxjs/internal/observable/throwError';
import { ItensPedido } from '../models/ItensPedido';
import { PedidoIdResponse } from '../models/PedidoIdResponse';
import { PedidoSimples } from '../models/PedidoSimples';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  // Lista do pedidos pago, que está sendo feito.
  private pedidosPagosSubject = new BehaviorSubject<PedidoSimples[]>([]);
  pedidosPagosSubject$ = this.pedidosPagosSubject.asObservable();

  // Lista de pedidos prontos, que já está aguardando a retira no balcão.
  private pedidosRetiradaSubject = new BehaviorSubject<PedidoSimples[]>([]);
  pedidosRetirada$ = this.pedidosRetiradaSubject.asObservable();

  private readonly apiUrl = "http://192.168.1.157:8080/api/v1/pedido"

  constructor(private http: HttpClient) { }

  create(itensPedidos: ItensPedido): Observable<PedidoIdResponse> {
    return this.http.post<PedidoIdResponse>(this.apiUrl, itensPedidos).pipe(catchError(this.handleError));
  }

  atualizarStatus(id: number): Observable<boolean> {
    console.log(`${this.apiUrl}/status/${id}`);
    return this.http.put<boolean>(`${this.apiUrl}/status/${id}`, null)
      .pipe(catchError(this.handleError));
  }

  listarPedidosPagos(): Observable<PedidoSimples[]>{
    return this.http.get<PedidoSimples[]>(`${this.apiUrl}/listarPagos`);
  }

  listarPedidosRetirada(): Observable<PedidoSimples[]>{
    return this.http.get<PedidoSimples[]>(`${this.apiUrl}/listarRetirada`);
  }

  atualizarListas(): void {
    forkJoin({
      pagos: this.listarPedidosPagos(),
      retirada: this.listarPedidosRetirada()
    }).subscribe({
      next: (res) => {
        this.pedidosPagosSubject.next(res.pagos);
        this.pedidosRetiradaSubject.next(res.retirada);
      },
      error: (err) => console.error('Erro ao atualizar listas de pedidos:', err)
    });
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }
}
