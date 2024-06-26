# Trabalho Prático – Empresa de Telefonia Celular

![image](https://github.com/EnzoWarner/Empresa-de-Telefonia-Celular/assets/140049622/dce68732-8eec-405e-a7c2-7b7eed10c137)


## Descrição do Sistema

O sistema deverá ser baseado em um menu com as seguintes opções:
- Cadastrar assinante: o sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago. Depois solicitar os dados do assinante específico;
- Listar assinantes: o sistema deverá listar os dados de todos os assinantes pré-pagos e pós-pagos cadastrados; 
- Fazer chamada: o sistema deverá solicitar o tipo de assinante e seu CPF. Depois 
solicitar os dados da chamada, data e duração; 
- Fazer recarga: o sistema deverá solicitar o CPF de um assinante pré-pago. 
Depois solicitar a data e o valor da recarga; 
- Imprimir faturas: o sistema deverá solicitar o mês e imprimir todas as faturas dos 
assinantes pré-pagos e pós-pagos; 
- Sair do programa: encerra a execução do programa.

## Descrição das Classes

A seguir serão descritas as classes do sistema.
    
### Assinante

A classe Assinante possui 5 atributos:
- cpf: CPF do assinante;
- nome: nome completo do assinante;
- numero: número do telefone celular do assinante.
- chamadas: vetor de referências a objetos da classe Chamada (vide seção 3.5), representa as chamadas feitas pelo assinante;
- numChamadas: número de chamadas feitas pelo assinante.

O construtor desta classe deve inicializar os seus atributos com os argumentos do construtor e instanciar o vetor chamadas.

Os métodos da classe Assinante são descritos a seguir:
- long getCpf(): devolve o CPF do assinante;
- String toString(): devolve uma representação textual dos atributos de um assinante.

### PrePago

A classe PrePago possui 5 atributos:
- recargas: vetor de referências a objetos da classe Recarga (vide seção 3.6), representa as recargas de crédito feitas pelo assinante;
- numRecargas: número de recargas feitas pelo assinante;
- creditos: representa o número de créditos do assinante;

O construtor desta classe deve inicializar o CPF, nome e número do telefone do assinante e instanciar o vetor recargas.

A seguir são descritos os métodos da classe PrePago:
- void fazerChamada(GregorianCalendar data, int duracao): este método é utilizado para registrar uma chamada de um assinante pré-­pago em uma data e com uma duração em minutos dadas por seus argumentos. O método deve verificar se ainda há espaço no vetor chamadas e se o assinante tem créditos suficientes para fazer a chamada. O custo de uma chamada pré­paga é de R$ 1,45 por minuto. Se a chamada for bem sucedida, ela deve ser armazenada no vetor chamadas, o número de chamadas (atributo numChamadas) e os créditos do assinante (atributo creditos) devem ser atualizados; caso não seja possível fazer a chamada, exiba mensagens apropriadas;
- void recarregar(GregorianCalendar data, float valor): este método é utilizado para registrar uma recarga de uma assinante pré­pago em uma data e com um valor dados por seus argumentos. O método deve verificar se ainda há espaço no vetor recargas, caso afirmativo, a recarga deve ser armazenada neste vetor e o número de recargas (atributo numRecargas) e os créditos do assinante (atributo creditos) devem ser atualizados; caso não haja mais espaço no vetor recargas, exibir mensagem apropriada.
- void imprimirFatura(int mes): este método deve ser utilizado para imprimir a fatura
de uma assinante pré­pago em um mês dado por seu argumento. O método deve imprimir os dados do assinante (CPF, nome e número do telefone), a data, duração e valor de suas chamadas feitas no mês, e a data e valor de suas recargas feitas no mês. Deve imprimir também o valor total de todas as ligações e recargas do mês e o seus créditos.

### PosPago

A classe PosPago possui 1 atributo:
- assinatura: valor da assinatura do serviço pós­pago.

O construtor desta classe deve inicializar todos os seus atributos com os argumentos do construtor.

A seguir são descritos os métodos da classe PosPago:
- void fazerChamada(GregorianCalendar data, int duracao): este método é utilizado para registrar uma chamada de um assinante pós­pago em uma data e com uma duração em minutos dadas por seus argumentos. O método deve verificar se ainda há espaço no vetor chamadas, caso afirmativo, a chamada deve ser armazenada neste vetor e atualizar o número de chamadas (atributo numChamadas). O custo de uma chamada pós­paga é de  R$ 1,04 por minuto. Caso não haja mais espaço no vetor chamadas, exiba uma mensagem apropriada;
- void imprimirFatura(int mes): este método deve ser utilizado para imprimir a fatura
de um assinante pós­pago em um mês dado por seu argumento. O método deve imprimir os dados do assinante (CPF, nome e número do telefone), a data, duração e valor de suas chamadas feitas no mês. Deve imprimir também o valor total da fatura, que é a soma da assinatura (atributo assinatur- com o custo de todas as ligações do mês. 

### Chamada

A classe Chamada possui 2 atributos:
- data: data da realização da chamada (objeto da classe GregorianCalendar);
- duracao: duração da chamada em minutos.

O construtor desta classe inicializa seus atributos com os argumentos do construtor.

A seguir são descritos os métodos da classe Chamada:
- GregorianCalendar getData(): devolve o atributo data;
- int getDuracao(): devolve o atributo duracao;
- String toString(): devolve uma representação textual dos atributos da classe. Recomenda­-se usar a classe SimpleDateFormat para formatar a data no formato dd/MM/yyyy.

### Recarga

A classe Recarga possui 2 atributos:
- data: data da realização da recarga (objeto da classe GregorianCalendar);
- valor: valor em reais da recarga.

O construtor desta classe inicializa seus atributos com os argumentos do construtor.

A seguir são descritos os métodos da classe Recarga:
- GregorianCalendar getData(): devolve o atributo data;
- float getValor(): devolve o atributo valor;
- String toString(): devolve uma representação textual dos atributos da classe. Recomenda­se   usar   a   classe  SimpleDateFormat  para   formatar   a   data   no   formato dd/MM/yyyy.

### Telefonia

A classe Telefonia possui 4 atributos:
- prePagos: um vetor de referências a objetos do tipo  PrePago. Representa os assinantes pré­pagos cadastrado pela empresa de telefonia celular;
- numPrePagos: representa a quantidade assinantes pré­pagos cadastrados.
- posPagos: vetor de referências a objetos do tipo PosPago. Representa os assinantes póspagos cadastrados pela empresa de telefonia celular;
- numPosPagos: representa a quantidade de assinantes pós­pagos cadastrados.

O construtor desta classe instancia os vetores prePagos e posPagos. A seguir são descritos métodos da classe Telefonia:

- void cadastrarAssinante(): este método é invocado quando a primeira opção do menu do sistema (Cadastrar assinant- for selecionada. Após solicitar o tipo do assinante (prépago ou pós­pago) este método deve solicitar as informações do assinante e armazenar um objeto   do  tipo  apropriado (PrePago ou PosPago) no vetor correspondente ao tipo de assinante (prePagos ou posPagos) e incrementar o número de assinantes cadastrados deste tipo (numPrePagos ou numPosPagos). Se não houver mais espaço no vetor, o sistema deve exibir uma mensagem;
- void listarAssinantes(): este método é invocado quando a segunda opção do menu do sistema (Listar assinantes) é selecionada. O método exibe no vídeo o CPF, nome e número do telefone de todos os assinantes pré­pagos e pós­pagos cadastrados;
- void fazerChamada(): este método é invocado quando a terceira opção do menu do sistema (Fazer chamad- é selecionada. O método solicita o tipo do assinante e seu CPF.

Caso o assinante seja localizado através da invocação ao método localizarPrePago() ou localizarPosPago() (vide os itens e e f), o sistema deve solicitar a duração e a data da chamada e registrar a chamada para o assinante através do método  fazerChamada() da
classe  PrePago  ou  PosPago. Se o assinante não for localizado, exibir uma mensagem apropriada;
- void   fazerRecarga(): este método  é  invocado quando a quarta opção do menu do sistema (Fazer recarg- é selecionada. O método solicita o CPF de um assinante do tipo prépago (esta opção só está disponível para esse tipo de assinante). Caso o assinante seja
localizado   através   da   invocação   ao   método  localizarPrePago()  (vide   o   item  e),   o sistema deve solicitar o valor e a data da recarga e registrar a recarga para o assinante prépago   através   do   método  recarregar()   da   classe  PrePago.   Se   o   assinante   não   for localizado, exibir uma mensagem apropriada;
- PrePago localizarPrePago(long cpf): este método devolve o assinante do tipo prépago registrado no vetor prePagos que possuir o CPF igual ao fornecido como argumento para este método. Caso o assinante não seja localizado, o método devolve null;
- PosPago localizarPosPago(long cpf): este método devolve o assinante do tipo póspago registrado no vetor posPagos que possuir o CPF igual ao fornecido como argumento para este método. Caso o assinante não seja localizado, o método devolve null;
- void imprimirFaturas(): este método é invocado quando a quinta opção do menu do sistema (Imprimir faturas) é selecionada. O sistema deve solicitar um mês e imprimir as faturas deste mês de todos os assinantes pré­pagos e pós­pagos cadastrados;
- static void main(String[] args): este método deve instanciar um objeto da classe Telefonia, exibir repetidamente o menu de opções e invocar os métodos apropriados a partir da seleção do usuário.
