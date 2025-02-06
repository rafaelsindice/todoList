# todoList
**Lista de Tarefas**
Esse é um repositório para auxílio na API todoList.


**Nota:** Qualquer erro ou sugestão, por favor nos contate.


Esta API raliza o CRUD de lista de Tarefas, tais como  **oportunidades e compromissos.** Veja as instruções de como realizar a integração abaixo
**URL de acesso**
http://localhost:8080/lists

Seguimos a estrutura padrão do estilo RESTful

    # GET: lista ou consulta dados
    # POST: criação de dados
    # PUT: atualização de dados
    # DELETE: remoção de dados
    
**Retorno**

Response (application/json)
![image](https://github.com/user-attachments/assets/6e939ea5-f7f8-4965-b6e1-0a65311e312a)


**Como autenticar**
É necessário passar o token privado de autenticação para conseguir realizar as operações. Para conseguir esse token, acesse o end point de login:
http://localhost:8080/login
informe o usuario e senha e faça a requisição, copie o token e envie para o serviço desejado conforme abaixo:
![image](https://github.com/user-attachments/assets/2bf97cb4-1998-4536-9bb5-79cc58e61d40)



# 200 (application/json)

  Sucesso

# 401 (text/json)

  Apesar de ser usualemnte problemas de credenciais pode acontecer de ser um erro de algum parâmetro enviado errado. (Sentimos muito pela confusão)

# 403 (text/json)

  Acesso negado

# 404 (text/json)

  Registro não encontrado

# 409 (text/json)

  Conflito, problema com alguma regra/restrição (contato já exite com o mesmo email/telefone,...)

# 500 (text/json)

  Erro do servidor


  **Padrão de endpoints**

Para listagem, use GET: /endpoint/
Para inserção, use POST: /endpoint/
Para visualização, use GET: /endpoint/{id}
Para atualização, use PUT: /endpoint/{id}
Para exclusão, use DELETE: /endpoint/{id}


**Seções (endpoints) disponíveis**

Segue as seções que você pode acessar pela API

Principais:

    /login
    /lists


  **Header**

A requisição deve conter:

    Content-Type: application/json
    Access-Token: SEU_TOKEN_AQUI




