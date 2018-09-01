export default class FotoService {

  constructor(resource) {
      this._resource = resource('v1/fotos{/id}');
  }

  cadastra(foto) {

    if(foto._id){
        return this._resource.update({id: foto._id}, foto)
            .then(null, err => {
                console.log(err);
                throw new Error('Não foi possível atualizar a foto.')
            })
    }else{
        return this._resource.save(foto)
            .then(null, err => {
                console.log(err);
                throw new Error('Não foi possível cadastrar a foto.')
            });
    }
  }

  lista() {
      return this._resource
        .query()
        .then(res => res.json(), err => {
            console.log(err);
            throw new Error('Não foi possível obter as fotos, tente mais tarde.')
        });
  }

  apaga(id) {
      return this._resource.delete({ id })
        .then(null, err => {
            console.log(err)
            throw new Error('Não foi possível remover a foto')
        })
  }

  busca(id) {
      return this._resource.get({ id })
        .then(res => res.json(), err => {
            console.log(err)
            throw new Error(`Não foi recuperar a foto com id: ${id}`)
        })
  }
}