Rails.application.routes.draw do
  resources :departamentos
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  	root "produtos#index"

  	# get "/produtos/new" => "produtos#new"
  	# post "/produtos" => "produtos#create"
  	# delete "/produtos/:id" => "produtos#destroy", as: :produto
	
	resources :produtos, only: [:new, :create, :destroy, :edit, :update] 

	get "/produtos/busca" => "produtos#busca", as: :busca_produto
end
