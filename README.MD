# README do Trabalho de LPOO

Qualquer alteração feita deixa avisado aqui, pra evitar qualquer discussão desnecessária
Por favor, isso é necessário

Não quero.
go fuck your self daviadão and maykuzinho_delicioso

## Principais funções de cada classe

1. Agência: Responsável por cadastrar e amazenar novas entidades.

2. Cilindro: Responsável por amazenar energia.

3. Criança: Responsável por gerar a energia, o monstro principal assusta ou faz a criança rir, essa energia gerada é manipulada pelo monstro de suporte que armazena em um cilindro de energia.

4. Gabinete: Responsável por gerenciar: O monstro principal, o monstro de suporte, a porta e o cilindro.

5. Main: Programa principal Responsável por manipular a agência. Nada nele deve possuir algo que manipule diretamente a Agência.

6. Monstro: Dividido em três tipos: Susto, Riso e Suporte. Responsáveis, respectivamente, por assustar ou fazer a criança rir ou amazenar a energia gerada. Um monstro pode trocar de Susto/Riso para Suporte, mas não de Susto para Riso ou ao contrário.

7. Porta: Responsável apenas por guardar qual a criança.

## O que cada classe manipula

### Agência

1. Cradastrar e armazenar novos: Cilindros, Crianças, Gabinetes, Monstros e Portas.
2. Mostrar e selecionar as entidades já cadastras: Listar e retornar a entidade da lista caso seja pedido.
3. Manipular as entidades já cadastras: Mudar váriaveis de cada entidade, como por exemplo o nome ou selecionar quem vai trabalhar em cada gabinete.
4. Trabalhar: Manda o gabinete, caso já esteje configurado, trabalhar. **#TODO**

### Cilindro

1. Possui um ID.
2. Armazenar energia.

### Criança

1. Possui um nome, energia de susto e energia de riso.
2. Gerar energia.

### Gabinete

1. Possui um ID.
2. Amazena os monstros, a porta e o cilindro que será usado no trabalho.
3. Gerencia todo o processo quanto a geração de energia, em qual porta o monstro vai entrar, o quanto de energia foi gerado e em qual cilindro o monstro de suporte irá armazená-la.

### Main

1. Menu iterátivo para chamar os métodos da agência.

### Monstro

1. Possui um nome, uma eficiência e um tipo(Susto/Riso/Suporte).
2. Assusta ou faz a criança rir para gerar energia.
3. Ou fica responsável apenas por amazenar a energia em um cilindro de energia.
4. O monstro de Riso/Susto pode alterar para monstro de Suporte. **#TODO**
