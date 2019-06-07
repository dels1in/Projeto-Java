create database transportadora;
use transportadora;

-- INCLUSÕES PARA TESTE --

-- Transportadoras
insert into transportadora values(1,"Chico & Bento Transportadora");
insert into transportadora values(2,"Ornitorrinco's Transportadora");
insert into transportadora values(3,"Niemeyer Transportes");


-- Status do produto
insert into list_status values('1','Aguardando Pagamento');
insert into list_status values('2','Checando Compra');
insert into list_status values('3','Pedido Faturado');
insert into list_status values('4', 'Pedido Empacotado');
insert into list_status values('5', 'Produto Enviado');
insert into list_status values('6', 'Produto Entregue');