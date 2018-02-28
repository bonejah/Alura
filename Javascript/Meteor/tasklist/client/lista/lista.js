Template.lista.helpers({

  tarefas: function(){
    return Tarefas.find({});
  },

  formatDate: function(){
    return moment(this.data).format('DD/MM/YYYY HH:mm');
  }
});