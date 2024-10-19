Moved to https://github.com/william-cesar-santos1/billboard-songs-class

A Billboard precisa catalogar os hits dos seus artistas. Para isso, eles entraram em
contato conosco e pediram o desenvolvimento do seguinte sistema.
- Permitir o cadastro de astros da música.
- Permitir o cadastro de compositores.
- Permitir o cadastro de álbuns lançados, lembre-se que esses álbuns podem ter um ou mais artistas.
- Liste todos os albuns da companhia e também todos os artistas vinculados.

// Objeto que compões o modelo de dados
Pessoa
  -- nome(String)
  -- ativo(Boolean)
  - Compositor
    -- composicoes(Musica)
    -- generoMusical(String)
  - Musico
    -- musicas(Musica)
    -- exclusivo(Boolean)
    -- albuns(Album)
Artista(Representação de banda, ainda que de um músico só)
  -- nome(String)
  -- musicos(Musico)
  -- albuns(Album)
  -- exclusivo(Boolean)
  -- ativo(Boolean)
  -- type(String)
  -- generoMusical(String)
Album
  -- autor(Artista)
  -- dataLancamento(LocalDate)
  -- musicas(Musica)
  -- nome(String)
  -- participacoes(Artita)
Musica
  -- nome
  -- compositores(Compositor)
  -- interpretes(Musico)
  -- letra(String)
  -- duracao(Float)
Gravadora
  -- nome
  -- artistas(Artista)
  -- albuns(Album)

// Objetos lógicos
PessoaRepositorio
 - CompositorRepositorio
PessoaController

// Objeto de infra
Database
  -- [static]mapa(representa todos os objetos gravados no banco)


Lição de casa.
Criar repositório para as classes de modelo que ainda não os tenha.
Compositor.
 - Criar filtro por nome
Gravadora.
 - Criar filtro por nome
Musica
 - Criar filtro por nome
 - Criar filtro por compositores
Musico
 - Criar filtro por nome
Album
 - Criar filtro por data de lancamento

CRUD
C - Create(criar)
R - Read(listar)
U - Update(atualizar)
D - Delete(excluir)

Criar view para consulta de músico pelo nome.
