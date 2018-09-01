require_relative 'livro'
require_relative 'revista'
require_relative 'ebook'
require_relative 'estoque'

class Array
	attr_reader :maximo_necessario

	# def <<(livro)
	# 	push(livro)

	# 	if @maximo_necessario.nil? || @maximo_necessario < size
	# 		@maximo_necessario = size
	# 	end	

	# 	self
	# end	
end	

class Conversor
   def string_para_alfanumerico(nome)
       nome.gsub /[^\w\s]/,''
   end
end

# livro_rails = Livro.new
# livro_rails.preco = 70
# livro_rails.titulo = "Agile Web Development with Rails"
# livro_rails.ano_lancamento = 2011
# livro_rails = Livro.new("Agile Web Development with Rails", 70, 2011, true)

# livro_ruby = Livro.new
# livro_ruby.preco = 60
# livro_ruby.titulo = "Programming Ruby 1.9"
# livro_ruby.ano_lancamento = 2010
# livro_ruby = Livro.new("Programming Ruby 1.9", 60, 2010, true)

def livros_para_newsletter(livro)
	if livro.ano_lancamento < 1999	
		puts "Newsletter/Liquidacao"
		puts livro.titulo
		puts livro.preco
		puts livro.possui_reimpressao?
	end	
end	

# def aplica_promocoes(livro)
# 	if livro.ano_lancamento < 2000
# 		livro.preco *= 0.7
# 	end	
# end	



algoritmos = Livro.new("Algoritmos", 100, 1998, true, "Casa do Codigo", false)
arquitetura = Livro.new("Introducao a Arquitetura e Design de Software", 70, 2011, true, "Casa do Codigo", false)
programmer = Livro.new("The Pragmatic Programmer", 100, 1999, true, "Casa do Programador", false)
ruby = Livro.new("Programming Ruby", 100, 2004, true, "Casa do Codigo", false)
revista1 = Revista.new("Revista Ruby", 100, 2004, true, "Casa do Codigo", 3)
online_arquitetura = EBook.new("Introducao a Arquitetura e Design de Software 2", 50, 2012, "Casa do Codigo")


# livros = [livro_rails, livro_ruby]
estoque = Estoque.new
# estoque.adiciona algoritmos 
# estoque.adiciona arquitetura
# estoque.adiciona Livro.new("The Pragmatic Programmer", 100, 1999, true)
# estoque.adiciona Livro.new("Programming Ruby", 100, 2004, true)
# estoque.adiciona nil
# estoque.exporta_csv
estoque << algoritmos << algoritmos
estoque << arquitetura << programmer
estoque << ruby << ruby << ruby
estoque << revista1 << revista1 << online_arquitetura

estoque.vende ruby
estoque.vende algoritmos
estoque.vende algoritmos
estoque.vende ruby
estoque.vende ruby
estoque.vende revista1
estoque.vende online_arquitetura

puts estoque.livro_que_mais_vendeu_por_titulo.titulo
puts estoque.revista_que_mais_vendeu_por_titulo.titulo
puts estoque.ebook_que_mais_vendeu_por_titulo.titulo

puts estoque.respond_to?(:ebook_que_mais_vendeu_por_titulo)
# puts estoque.maximo_necessario

# numbers = []
# numbers.extend Contador
# numbers << 13
# numbers << 15
# numbers << 17 << 19 << 21
# puts numbers.maximo_necessario

# conversor = Conversor.new
# puts conversor.string_para_alfanumerico("*Clean**Code!!!")


# baratos = estoque.mais_baratos_que(80)
# baratos.each do |livro|
# 	puts livro.titulo
# end	


# aplica_promocoes(algoritmos)
# livros_para_newsletter(algoritmos)

