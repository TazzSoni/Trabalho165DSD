<!-- Visualizador online: https://stackedit.io/ -->
 ![Logo da UDESC Alto Vale](http://www1.udesc.br/imagens/id_submenu/2019/marca_alto_vale_horizontal_assinatura_rgb_01.jpg)

---

# Classificador de tipo de cultivo de vinho

Atividade desenvolvida para a disciplina de Inteligência Computacional do [Centro de Educação Superior do Alto Vale do Itajaí (CEAVI/UDESC)](https://www.udesc.br/ceavi)

# Sumário
* [Equipe](#equipe)
* [Cenário Base](#problema)
* [Aplicação Cliente](#aplicacao cliente)
* [Vídeo](#video)

## [Equipe](#equipe)
 - [**Rodrigo Souza Tassoni**](mailto:tazzsoni@gmail.com) - [TazzSoni](https://github.com/tazzsoni)
 
## [Cenário Base](#problema)

A aplicação servidor mantém dados de pessoas, com cpf, nome, endereço, podendo ser do tipo "ColaboradorClt" com, função, mesAnoContratado (no formato MMAAAA) e tipo com uma String fixa "CLT" ou "ColaboradorTemporario" com, função, tempoDeContrato (no formato MM) e tipo com uma string fixa "TEMPORARIO", também tendo agregação com Setor possuindo os atributos nome e equipe, conforme diagrama diagrama de classes abaixo. A aplicação servidor deve oferecer operações para que os clientes manipulem estes dados remotamente. Os dados são mantidos apenas em memória.<br>
[Diagrama em branco](https://user-images.githubusercontent.com/45270751/120961607-85167380-c734-11eb-8efa-a9f49c72ecbc.png)

A manipulação dos dados é realizada a partir de mensagens recebidas do cliente, via Socket. A mensagem é uma String que é separada pelo caracter especial ";". Essa String contém, em posições específicas, a operação de manipulação e os dados requeridos, conforme esquema abaixo.

//"insertSetor;Mecanica;000111"

**INSERÇÃO DE REGISTRO DE SETOR**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  insertsetor |
|  1 |  nome |
|  1 |  equipe |
|Descroção|Insere o registro de setor|
| Retorno | Não há |

**EDIÇÃO DE REGISTRO DE SETOR**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  updatesetor |
|  1 |  nome |
|  1 |  equipe |
|Descroção|Atualiza o registro de setor|
| Retorno | Se o setor for atualizado, então retorna “Setor atualizado com sucesso”.<br> Se o setor não existir, então retorna “Seto não encontrado”. |

**OBTENÇÃO DE REGISTRO DE SETOR**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  getsetor |
|  1 |  nome |
|Descrição|Busca os dados do setor com o nome informado.|
| Retorno | Retorna uma String com os dados do setor no formato:<br> MECANICA<br> rodrigo<br>Se o setor não existir, então retorna “Setor não encontrado”.<br>Se não houver nenhum setor cadastrado, então retorna “Sem setores cadastrados”|
 
 **REMOÇÃO DE REGISTRO DE SETOR**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  deletesetor |
|  1 |  nome |
|Descrição| Remove o registro do setor com o nome informado.|
| Retorno | Se o setor for removido, então retorna ”Setor removido com sucesso”.<br>Se o setor não existir, então retorna “Setor não encontrado”.<br>Se não houver nenhum setor cadastrado, então retorna “Sem setores cadastrados”|
 
 **OBTENÇÃO DE TODOS OS REGISTRO DE SETOR**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  listsetor |
|Descrição| Busca todos os setores cadastrados para retornar.|
| Retorno | A String de retorno é formada pela quantidade de registros existentes seguido pelos<br>nomes dos setores cadastrados, com quebra de linha entre eles. Exemplos:<br>Se existissem 3 setores, o retorno seria:<br>Lista de setores:<br>03<br>mecanica<br>eletrica<br>operacao<br>Se não existirem setores cadastrados, o retorno seria apenas o valor 00 (zero zero).<br>Assumir que existirão no máximo 99 setores cadastrados.|
 
**INSERÇÃO DE REGISTRO DE PESSOA**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  insertpessoa |
|  1 |  cpf |
|  2 |  nome |
| 3 | endereco |
| 4 | tipo |
| 5 | mesAnoContratacao |
| 6 | funcao |
| 7 | setorIndex |
|Descrição|Insere o registro da pessoa|
| Retorno | Não há |

**ATUALIZAÇÃO DE REGISTRO DE PESSOA**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  insertpessoa |
|  1 |  cpf |
|  2 |  nome |
| 3 | endereco |
| 4 | tipo |
| 5 | mesAnoContratacao |
| 6 | funcao |
| 7 | setorIndex |
|Descrição|Atualiza o registro da pessoa|
| Retorno | Se a pessoa for atualizada, então retorna “Pessoa atualizada com sucesso”.<br>Se a pessoa não existir, então retorna “Pessoa não encontrada”. |

**OBTENÇÃO DE REGISTRO DE PESSOA**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  getpesoa |
|  1 |  cpf |
|Descrição|Busca os dados da pessoa com o CPF informado.|
| Retorno | Retorna uma String com os dados da pessoa no formato: cpf;nome;endereço.<br>Se a pessoa não existir, então retorna “Pessoa não encontrada”.<br>Se não houver nenhuma pessoa cadastrada, então retorna “Sem pessoas cadastradas”|

**REMOÇÃO DE REGISTRO DE PESSOA**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  deletepessoa |
|  1 |  cpf |
|Descrição| Remove o registro da pessoa com o CPF informado.|
| Retorno | Se a pessoa for removida, então retorna ”Pessoa removida com sucesso”.<br>Se a pessoa não existir, então retorna “Pessoa não encontrada”.<br>Se não houver nenhuma pessoa cadastrada, então retorna “Sem pessoas cadastradas”|

 **OBTENÇÃO DE TODOS OS REGISTRO DE PESSOA**
| Posições  |  conteúdo  |
| ------------------- | ------------------- |
|  0 |  listpessoa|
|Descrição| Busca todas as pessoas cadastradas para retornar.|
| Retorno | A String de retorno é formada pela quantidade de registros existentes seguido pelos<br>dados das pessoas cadastradas, com quebra de linha entre eles. Exemplos:<br>Se existissem 3 pessoas, o retorno seria:<br>Lista de Funcionarios:<br>03<br>01234567891;José;Rua X;mecanica;1<br>23456789012;Maria;Rua Y;eletrica;2<br>34567890123;Pedro;Rua Z;operacao;1<br>Se não existirem pessoas cadastradas, o retorno seria apenas o valor 00 (zero zero).<br>Assumir que existirão no máximo 99 pessoas cadastradas.|
 

## [Aplicação Cliente](#aplicacao cliente)



## [Vídeo](#video)

https://youtu.be/7i00HM8vaYI
