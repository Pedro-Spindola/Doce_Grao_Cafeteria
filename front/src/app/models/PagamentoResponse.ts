import { StatusPagamento } from "./enums/StatusPagamento";
import { TipoPagamento } from "./enums/TipoPagamento";

export interface PagamentoResponse {
  id: number;
  valor: number;
  statusPagamento: StatusPagamento;
  tipoPagamento: TipoPagamento;
}