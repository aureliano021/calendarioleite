# 🐄 Controle Leiteiro

Sistema de registro de produção de leite desenvolvido em Java, criado para substituir o controle manual em caderno e facilitar o fechamento mensal com a empresa compradora.

## 💡 Contexto

Em propriedades rurais do interior do Brasil, o leite coletado é enviado diariamente ao transportador, que o leva ao resfriador e, posteriormente, à empresa de laticínios. No final do mês, o produtor precisa confrontar o seu total registrado com os dados da empresa para garantir o pagamento correto. 

Este sistema automatiza esse controle, substituindo o caderno físico por registros digitais, precisos e estruturados.

## ✅ Funcionalidades Atuais

- **Registro Diário:** Inserção da quantidade de leite produzida no dia.
- **Controle de Consumo:** Indicação se houve retirada de leite para consumo interno (`fora: true/false`).
- **Menu Interativo:** Navegação via terminal para adicionar registros, visualizar histórico e emitir relatórios.
- **Relatórios de Soma:** Cálculo do total de leite produzido, com filtros por mês ou ano.
- **Consulta Histórica:** Visualização de registros filtrados por uma data específica.
- **Validação de Data:** Suporte a datas retroativas com formatação automática (`dd/MM/yyyy`).
- **Persistência de Dados:** Salvamento local automático em arquivo `.json`.

## 🗂️ Estrutura do JSON Gerado

```json
[
  {
    "quantidadeleite": 180,
    "data": "19/05/2026",
    "fora": false
  },
  {
    "quantidadeleite": 120,
    "data": "20/05/2026",
    "fora": true
  }
]
```

## 🚧 Funcionalidades Planejadas

- [ ] Validação rigorosa de entrada de dados (ex: impedir o registro de datas futuras).
- [ ] Detecção e tratamento de registros duplicados para o mesmo dia.

## 🔮 Futuro do Projeto

- **API REST** com Spring Boot para disponibilizar os dados via HTTP.
- **Aplicativo Android** para facilitar o registro e a consulta direto do celular no curral/campo.

## 🛠️ Tecnologias Utilizadas

- **Java 26**
- **[Gson](https://github.com/google/gson):** Para serialização e desserialização de arquivos JSON.
- **Maven:** Gerenciamento de dependências.

## ▶️ Como Executar

1. Clone este repositório.
2. Abra o projeto no IntelliJ IDEA (ou na sua IDE de preferência).
3. Execute a classe `Main`.
4. Na primeira execução, o arquivo `arquivoan.json` será criado automaticamente no diretório raiz para armazenar os dados.

## 👨‍💻 Sobre o Projeto

Projeto desenvolvido durante o aprendizado de Java no curso de Engenharia de Software da Uniasselvi. O objetivo principal foi criar uma solução de software para um problema real do dia a dia em uma propriedade rural no interior da Bahia.

```