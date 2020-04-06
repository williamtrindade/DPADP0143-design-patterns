- Crie uma classe `banco` que armazene um conjunto de `contas` e forneça métodos que permitam que sejam feitos:
  - Criações de conta
  - Exclusão de contas.
  - Saques (uma conta corrente só pode fazer saques desde que o valor não exceda o limite de saque -limite + saldo-).
  - Depósitos.
  - Emissão de saldo.
  - Extrato.
  - Transferência entre contas.

- Uma conta possui:
  - um número.
  - Um saldo.
  - Um status que informa se ela é especial ou não.
  - Um limite.
  - Um conjunto de movimentações.
    - Uma movimentação possui uma descrição.
    - Um valor.
    - E uma informação se ela é uma movimentação:
      - De crédito.
      - Débito.
      - Rendimento financeiro. 

- Além disto as contas podem ser do tipo: 
  - Poupança.
  - Conta-corrente.
  - Fundos de Renda Fixa.
  - Fundos de Renda Variável.
  Dentre estes apenas os rendimentos de renda fixa e variável são tributados pelo IR, nestes casos deverá existir:
    - Um método que calcula o valor do imposto devido, com base no rendimento financeiro do mês e a alíquota de 27,5%.