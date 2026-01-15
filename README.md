![banner.png](images/banner.png)

Este é um sistema desenvolvido em Java que permite realizar conversões entre diferentes moedas de forma rápida através de um menu interativo no console. As taxas de câmbio são obtidas em tempo real utilizando a ExchangeRate API.

---
## 🔵 Funcionalidades

- Conversões em tempo real
- Menu interativo: interface simples e intuitiva no console
- 6 opções de conversão: pares de moedas pré-configurados
    * dólar (USD) ↔ peso argentino (ARS)
    * dólar (USD) ↔ real brasileiro (BRL)
    * dólar (USD) ↔ peso colombiano (COP)
- Validação de entrada, além de mensagens claras para entradas inválidas
- Flexibilidade no formato decimal: aceita vírgula ou ponto nos valores inseridos
- Múltiplas conversões sem reiniciar

---
## 🔵 Tecnologias utilizadas

- Java 25
- Maven
- Gson
- ExchangeRate API

---
## ▶️ Como usar

### Pré-requisitos

- Java 16+ 
- Conta na ExchangeRate API


### 1. Clone o repositório
````
git clone https://github.com/melwolff13/conversor-de-moedas-challenge.git
````

### 2. Obtenha sua API Key

Para adquirir a sua chave da ExchangeRate API, você deve:
1. acessar o site https://www.exchangerate-api.com/
2. clicar em "Get free key!"
3. criar a sua conta

Você receberá um e-mail com a sua própria API Key, semelhante a ````abc123def456ghi789```` .

>Todas as etapas desse processo são gratuitas. A API disponibiliza, sem custos, a chave e um limite mensal de requisições.


### 3. Configure a API Key

Este projeto utiliza uma API externa para realizar a conversão de moedas. Dessa forma, a chave da API não fica armazenada no código e deve ser configurada como uma variável de ambiente.

#### 3.1. Como configurar: Windows
No terminal:
````
setx EXCHANGE_RATE_API_KEY "sua_chave_aqui"
````
Para verificar:
````
echo $Env:EXCHANGE_RATE_API_KEY
````

#### 3.2. Como configurar: Linux/ MacOS
No terminal:
````
export EXCHANGE_RATE_API_KEY="sua_chave_aqui"
````
Para verificar:
````
echo $EXCHANGE_RATE_API_KEY
````

Por fim, reinicie a IDE e o sistema deve estar pronto para ser usado.

### 4. Exemplo de uso

Ao rodar a classe ````Main.java```` (src/main/java/br/com/melissa/Main.java), você verá o seguinte menu:

````
***************************************
BEM-VINDO(A) AO CONVERSOR DE MOEDA $-$

[1] Dólar -> Peso argentino
[2] Peso argentino -> Dólar
[3] Dólar -> Real brasileiro
[4] Real brasileiro -> Dólar
[5] Dólar -> Peso colombiano
[6] Peso colombiano -> Dólar
[0] Sair

Escolha uma opção válida:
***************************************
````

Para converter 100 dólares para real, assim deve ser feito: 

````
Escolha uma opção válida:
3
Digite o valor a ser convertido:
100

Valor 100.0 [USD] corresponde a >>> 567.89 [BRL]

***************************************
BEM-VINDO(A) AO CONVERSOR DE MOEDA $-$
[menu aparece novamente para nova conversão]
````
---

## 🍯 Autora
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/168154573?v=4" width=115><br><sub>Melissa Wolff</sub>](https://github.com/melwolff13) |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|

