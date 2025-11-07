# 💱 Conversor de Moedas

Projeto em Java que permite converter valores entre diferentes moedas usando a API **ExchangeRate** em tempo real.

---

## 🔹 Funcionalidades

- Conversão entre várias moedas:  
  - Dólar (USD) ↔ Real (BRL)  
  - Euro (EUR) ↔ Real (BRL)  
  - Libra (GBP) ↔ Dólar (USD)  
  - Dólar (USD) → Peso Argentino (ARS)  
- Interação via console, com menu de opções  
- Captura de erros para entradas inválidas  
- Atualização das taxas em tempo real através da API

---

## 🛠️ Tecnologias

- Java  
- API **ExchangeRate** para taxas de câmbio  
- Git & GitHub para versionamento de código

---

## 🛡️ Segurança

- **Não exponha sua chave da API no código.**  
- Use variáveis de ambiente para armazenar informações sensíveis:  

* No Windows

setx EXCHANGE_API_KEY "SUA_CHAVE_AQUI"

* No Linux / Mac

export EXCHANGE_API_KEY="SUA_CHAVE_AQUI"

---

 # 🚀 Como usar

1- Clone o repositório:

2- git clone https://github.com/melonatalia/conversor-de-moedas.git

3- Acesse a pasta do projeto:

4- conversor-de-moedas

5- Compile o código Java:

6- ConversorDeMoedas.java

Execute o programa:

Siga as instruções no console para escolher a moeda e digitar o valor.
