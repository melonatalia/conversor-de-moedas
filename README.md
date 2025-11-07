# 💱 Conversor de Moedas

Projeto em Java que permite converter valores entre diferentes moedas usando a API **Extended Rate** em tempo real.

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

- Java (puro)  
- API **Extended Rate** para taxas de câmbio  
- Git & GitHub para versionamento de código

---

## 🛡️ Segurança

- **Não exponha sua chave da API no código.**  
- Use variáveis de ambiente para armazenar informações sensíveis:  

```bash
# No Windows
setx EXCHANGE_API_KEY "SUA_CHAVE_AQUI"

# No Linux / Mac
export EXCHANGE_API_KEY="SUA_CHAVE_AQUI"

---

## 🚀 Como usar

Clone o repositório:

git clone https://github.com/melonatalia/conversor-de-moedas.git


Acesse a pasta do projeto:

cd conversor-de-moedas


Compile o código Java:

javac ConversorDeMoedas.java


Execute o programa:

java ConversorDeMoedas


Siga as instruções no console para escolher a moeda e digitar o valor.
