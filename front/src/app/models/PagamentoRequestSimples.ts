import { TipoPagamento } from "./enums/TipoPagamento";

export interface PagamentoRequestSimples {
    id_Pedido: number;
    tipoPagamento: TipoPagamento;
}