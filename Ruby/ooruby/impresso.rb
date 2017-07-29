module Impresso
	def initialize(titulo, preco, ano_lancamento, editora, possui_reimpressao)
		super(titulo, preco, ano_lancamento, editora)
		@possui_reimpressao = possui_reimpressao
	end

	def possui_reimpressao?
		@possui_reimpressao
	end	
end	