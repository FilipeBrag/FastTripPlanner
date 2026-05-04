# FastTripPlanner
O FastTripPlanner é um aplicativo Android desenvolvido em Kotlin com o objetivo de auxiliar no planejamento de viagens. O aplicativo permite que o usuário insira dados básicos de viagem, selecione o tipo de hospedagem e adicione serviços extras, apresentando, ao final, o resumo detalhado do planejamento.

# Funcionalidades
O aplicativo é composto por três telas (Activities) com navegação via Intents explícitas:

Tela 1 (Dados da Viagem): Coleta de informações básicas: destino, número de dias e orçamento diário.

Tela 2 (Opções da Viagem): Seleção do tipo de hospedagem (Econômica, Conforto, Luxo) e serviços extras (Transporte, Alimentação, Passeios).

Tela 3 (Resumo da Viagem): Exibição de todos os dados inseridos e o cálculo do valor total da viagem.

# Regras de Cálculo
O valor total do planejamento é calculado seguindo as diretrizes:

Base: custoBase = dias * orçamento

Multiplicador de Hospedagem: Econômica (1.0), Conforto (1.5) ou Luxo (2.2)

Serviços Extras:

Transporte: + R$ 300,00

Alimentação: + R$ 50,00/dia

Passeios: + R$ 120,00/dia

# Demonstração
Confira o vídeo de demonstração das funcionalidades do aplicativo:


# Tecnologias Utilizadas
Linguagem: Kotlin

Ambiente de Desenvolvimento: Android Studio

Compatibilidade: Android 8.0 ou superior

# Autor
Filipe Gioannini Braga - Sc3044807
